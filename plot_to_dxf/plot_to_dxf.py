#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 10 20:27:21 2023

@author: cagilbenibol
"""

import ezdxf
from PIL import Image, ImageFilter
import cv2
import numpy as np

def fill_connection_points(input_path, output_path, kernel_size=3):
    # Read the image
    img = cv2.imread(input_path, cv2.IMREAD_GRAYSCALE)
    
    # Threshold the image to create a binary image
    _, binary = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY_INV)

    # Define a kernel for the dilation operation.
    kernel = np.ones((kernel_size, kernel_size), np.uint8)

    # Use dilation to connect the lines.
    dilated = cv2.dilate(binary, kernel, iterations=1)

    # Find contours in the dilated image
    contours, _ = cv2.findContours(dilated, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    
    # Fill the contours
    cv2.drawContours(dilated, contours, -1, (255), thickness=cv2.FILLED)
    cv2.imwrite(output_path, 255 - dilated)  # We invert again to get the original color scheme





def remove_background(input_path, output_path, bg_color, tolerance=60):
    # Open the image
    img = Image.open(input_path)
    img = img.convert("RGBA")
    datas = img.getdata()
    new_data = []
    for item in datas:
        # Change all white (also shades that are close to white)
        # pixels to transparent
        if all(abs(item[i] - bg_color[i]) < tolerance for i in range(3)):
            new_data.append((255, 255, 255, 0))
        else:
            new_data.append(item)

    img.putdata(new_data)
    img.save(output_path, "PNG")

# Need to define the RGB value of your background color.
bg_color = (0, 170, 170)  # You might need to adjust this based on the exact color you want to remove



def crop(path_to_your_image, path_to_save_cropped_image,a):
    # Open the image file
    img = Image.open(path_to_your_image)
    
    # Define the region to be cropped
    # (left, upper, right, lower) or (x1, y1, x2, y2)
    # For example: (100, 100, 300, 300) will crop a 200x200 pixel rectangle from the original image,
    # starting at (100, 100) and ending at (300, 300) cropped_img = img.crop((100, 100, 300, 300))
    cropped_img = img.crop(a)
    cropped_img.save(path_to_save_cropped_image)


def image_to_dxf_planes(image_path, output_path):
    # Load the image in grayscale
    img = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
    
    # Create a new DXF document
    doc = ezdxf.new()
    msp = doc.modelspace()
    
    # Dimensions of the image
    height, width = img.shape

    # Iterate over every pixel
    for y in range(height):
        for x in range(width):
            # If the pixel is black (or nearly black)
            if img[y, x] < 50:  # 50 is an arbitrary threshold, you can adjust
                # Create a small square (plane) at (x,y) in the DXF document
                msp.add_solid([(x, y, 0), 
                               (x+1, y, 0), 
                               (x+1, y+1, 0), 
                               (x, y+1, 0)])

    # Save the DXF document
    doc.saveas(output_path)


def png_to_dxf(png_path, dxf_path, threshold=128):
    # Open and convert the image to grayscale
    img = Image.open(png_path).convert('L')
    
    # Threshold the image
    binary = img.point(lambda p: p > threshold and 255)
    
    # Create a new DXF document
    doc = ezdxf.new()
    msp = doc.modelspace()
    
    # Using the edge detection to get the contours
    edges = binary.filter(ImageFilter.FIND_EDGES)
    width, height = edges.size

    # Loop to find and draw edges, can be optimized
    for y in range(height):
        for x in range(width):
            if edges.getpixel((x, y)) > threshold:
                # Drawing a point for every pixel might not be efficient for larger images
                # This is a naive way, a more efficient way would be to trace a line path.
                msp.add_point((x, -y))  # Note: Inverting y for proper DXF orientation

    doc.saveas(dxf_path)


def make_all_colors_black(input_path, output_path):
    # Open the image
    img = Image.open(input_path)
    img = img.convert("RGBA")

    datas = img.getdata()
    new_data = []

    for item in datas:
        # If the pixel is not transparent, change it to black
        if item[3] > 0:
            new_data.append((0, 0, 0, item[3]))
        else:
            new_data.append(item)

    img.putdata(new_data)
    img.save(output_path, "PNG")



def image_to_dxf_plane(image_path, output_path):
    # Load the image in grayscale
    img = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
    
    # Threshold the image to get the contours
    _, binary = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY_INV)
    contours, _ = cv2.findContours(binary, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # Create a new DXF document
    doc = ezdxf.new()
    msp = doc.modelspace()

    # Convert the contours to polylines and add to the DXF
    for contour in contours:
        points = contour.squeeze().tolist()
        # If the points are not in a list format, convert them
        points = [(p[0], p[1]) for p in points]
        # Close the loop by adding the first point at the end
        points.append(points[0])
        msp.add_lwpolyline(points)

    # Save the DXF document
    doc.saveas(output_path)



if __name__ == '__main__':
    crop('1.png', '2.png',a = (105, 36, 322, 252))
    #bg_color = (0, 170, 170)
    remove_background('2.png','3.png',  bg_color   = (0, 170, 170), tolerance=60)
    make_all_colors_black('3.png', '4.png')
    fill_connection_points('4.png', '5.png')
    remove_background('5.png','6.png',  bg_color = (255,255,255), tolerance=60)
    image_to_dxf_plane('6.png', 'output.dxf')
