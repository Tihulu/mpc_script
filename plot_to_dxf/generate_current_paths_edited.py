#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 10 19:31:28 2023

@author: cagilbenibol
"""

import PIL.Image
import numpy as np
import matplotlib.pyplot as plt
import torch
from PIL import ImageDraw

from data_generation.biot_savart import biot_savart_forward
import data_generation.constants as constants

def normalized(a, axis=-1, order=2):
    l2 = np.atleast_1d(np.linalg.norm(a, order, axis))
    l2[l2==0] = 1
    return a / np.expand_dims(l2, axis)


def position_after_step(direction, step, current_position):
    current_x, current_y = current_position

    if direction == "up":
        return current_x - step, current_y

    elif direction == "down":
        return current_x + step, current_y

    elif direction == "left":
        return current_x, current_y - step

    elif direction == "right":
        return current_x, current_y + step

    else:
        raise AttributeError


def slice_range(current, new):
    if current == new:
        return current
    elif current < new:
        return np.s_[current:new]
    else:
        return np.s_[new + 1:current + 1]

def slice_segment(current_x, current_y, new_x, new_y):
    return slice_range(current_x, new_x), slice_range(current_y, new_y)

def range_with_buffer(current, new, buffer_thickness):
    if current == new:
        return np.s_[current-buffer_thickness:current+buffer_thickness+1]
    elif current < new:
        return np.s_[current + 1:new + buffer_thickness]
    elif current > new:
        return np.s_[new + 1 - buffer_thickness:current]

def slice_segment_with_buffer(current_x, current_y, new_x, new_y, buffer_thickness):
    return range_with_buffer(current_x, new_x, buffer_thickness),\
        range_with_buffer(current_y, new_y, buffer_thickness)


def get_image_from_points(points, width, starting_from):
    image = PIL.Image.fromarray(np.zeros_like(starting_from), mode="F")
    draw = ImageDraw.Draw(image)
    draw.line(list(map(lambda p: (p[1], p[0]), points)), width=width)
    # image.show()

    ar = np.asarray(image) + starting_from
    # plt.imshow(ar)
    # plt.show()
    return ar


def get_current_from_points(points, width, current, starting_from):
    result = starting_from

    for i in range(1, len(points)):
        previous = points[:i]
        now = points[:i+1]

        im_previous = get_image_from_points(previous, width, np.zeros(starting_from.shape[:-1]))
        im_now = get_image_from_points(now, width, np.zeros(starting_from.shape[:-1]))

        new_segment = im_now - im_previous
        new_segment_current = np.zeros_like(starting_from) \
                              + new_segment[..., None] * normalized(points[i] - points[i - 1]) * current

        result += new_segment_current

    return result

def draw_random_walk_current_path(starting_current, start_position, CURRENT, wire_width_pixels, form="square", buffer=2):
    rng = np.random.default_rng()

    RES = starting_current.shape[0]

    starting_image_2d = np.linalg.norm(starting_current, axis=-1)

    points = [start_position]
    steps = 0
    tries = 0
    previous_direction = np.array([1, 0])
    previous_turn = "right"
    same_turn_number = 0
    while steps <= 100:
        tries += 1
        if tries > 20:
            break
        if form == "square":
            choice_set = np.array([[1, 0], [-1, 0], [0, 1], [0, -1]])
        elif form == "horizontal":
            choice_set = np.array([[1, 0], [-1, 0], [0, 1]])
        choice_set = choice_set[
            (np.logical_and(choice_set != previous_direction, choice_set != -previous_direction)).any(axis=1)]
        next_direction = rng.choice(choice_set)
        next_step = np.random.randint(low=RES // 200 + buffer + wire_width_pixels + 1, high=RES // 5 + 1)

        current_position = points[-1]

        current_x, current_y = current_position
        new_x, new_y = current_position + next_step * next_direction
        new_x_overshoot, new_y_overshoot = current_position + (next_step + buffer) * next_direction

        if form == "horizontal" and new_y not in range(0, RES):
            new_y = RES - 1

        if new_x not in range(0, RES) or new_y not in range(0, RES):
            if steps > 5 and tries > 5:
                new_x, new_y = np.clip(new_x, 0, RES), np.clip(new_y, 0, RES)
                steps = np.inf
            else:
                continue

        right_turn_combinations = np.array([[[0, 1], [1, 0]], [[1, 0], [0, -1]], [[0, -1], [-1, 0]], [[-1, 0], [0, 1]]])

        turn = "right" if np.any(
            (np.array([previous_direction, next_direction]) == right_turn_combinations).all(axis=(1, 2))) else "left"

        if same_turn_number >= 1 and turn == previous_turn:
            continue

        ## Check collisions

        previous_im = get_image_from_points(points[:-1], width=wire_width_pixels, starting_from=starting_image_2d)
        this_line = get_image_from_points([np.array([current_x, current_y]), np.array([new_x_overshoot, new_y_overshoot])], width=wire_width_pixels+buffer*2, starting_from=np.zeros_like(starting_image_2d))

        if np.any(previous_im[this_line != 0] != 0):
            continue

        steps += 1
        tries = 0

        # J[slice_segment(current_x, current_y, new_x, new_y)] += CURRENT * next_direction

        points.append(np.array([new_x, new_y]))

        if previous_turn == turn:
            same_turn_number += 1
        else:
            same_turn_number = 0
        previous_turn = turn

        previous_direction = next_direction

        # plt.imshow(J[..., 1] + J[..., 0])
        # plt.show()
    return get_current_from_points(points, wire_width_pixels, CURRENT, starting_current)


def get_random_walk_current_path(RES, CURRENT, wire_width_pixels, form="square"):
    J = np.zeros((RES, RES, 2))
    # J[RES // 2:RES // 2 + WIRE_WIDTH_PIXELS, :, 1] = CURRENT / (WIRE_WIDTH*THICKNESS)

    J = draw_random_walk_current_path(J, start_position=(RES // 3, 0), CURRENT=CURRENT, wire_width_pixels=wire_width_pixels, form="square")
    plt.show()

    return J

def to_current_density(I, WIRE_WIDTH, THICKNESS):
    return I / (WIRE_WIDTH*THICKNESS)


def generate_datapoint(RES, FOV_SIZE, THICKNESS, STANDOFF_DISTANCE, CURRENT, FORM, WIRE_WIDTH=None):
    sampling_space = FOV_SIZE / RES

    if WIRE_WIDTH is None:
        WIRE_WIDTH = sampling_space

    wire_width_pixels = int(WIRE_WIDTH // sampling_space) + 1

    if not np.isclose(WIRE_WIDTH // sampling_space, WIRE_WIDTH / sampling_space):
        print(f"Warning: correcting wire width from {WIRE_WIDTH} to {wire_width_pixels * sampling_space} due to resolution")
    wire_width_corrected = wire_width_pixels * sampling_space

    J = get_random_walk_current_path(RES, CURRENT, wire_width_pixels=wire_width_pixels, form=FORM)
    J = to_current_density(J, wire_width_corrected, THICKNESS)

    ### Upsample
    # J = J.repeat(RES / 128, axis=0).repeat(RES / 128, axis=1)

    J = torch.tensor(J)

    Bx, By, Bz = biot_savart_forward(FOV_SIZE, RES, THICKNESS, STANDOFF_DISTANCE, J, show_plots=False)

    B = np.stack((Bx, By, Bz), axis=-1)
    B = np.real(B)


    return J, B


if __name__ == "__main__":
    RES = 512

    FOV_SIZE = constants.FOV_SIZE
    THICKNESS = constants.THICKNESS
    STANDOFF_DISTANCE = constants.STANDOFF_DISTANCE
    CURRENT = constants.CURRENT
    WIRE_WIDTH = constants.WIRE_WIDTH

    FORM = "square"

    J, B = generate_datapoint(RES, FOV_SIZE, THICKNESS, STANDOFF_DISTANCE, CURRENT, FORM, WIRE_WIDTH=WIRE_WIDTH)

    plt.imshow(J[..., 1] + J[..., 0])
    plt.colorbar()
    plt.savefig('1.png')
    plt.show()
    

    #
    plt.imshow(np.real(B[..., 2]))
    plt.title("B_z")
    plt.colorbar()
    plt.show()