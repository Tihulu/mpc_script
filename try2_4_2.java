/*
 * try2_4_2.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Aug 17 2023, 05:07 by COMSOL 6.0.0.405. */
public class try2_4_2 {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/Users/cagilbenibol/Library/CloudStorage/OneDrive-TUM/TUM/IDP");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("mf", "InductionCurrents", "geom1");
    model.component("comp1").physics().create("ecis", "ElectricCurrentsShell", "geom1");

    model.study().create("std1");
    model.study("std1").create("stat", "Stationary");
    model.study("std1").feature("stat").setSolveFor("/physics/mf", true);
    model.study("std1").feature("stat").setSolveFor("/physics/ecis", true);

    model.component("comp1").geom("geom1").run();
    model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
    model.component("comp1").geom("geom1").create("wp1", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp1").geom().create("imp1", "Import");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("imp1")
         .set("filename", "/Users/cagilbenibol/Library/CloudStorage/OneDrive-TUM/TUM/IDP/output.dxf");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("imp1").importData();
    model.component("comp1").geom("geom1").feature("wp1").geom().run("imp1");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("imp1").importData();
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("imp1").importData();
    model.component("comp1").geom("geom1").run("wp1");
    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").set("base", "center");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new int[]{500, 500, 500});
    model.component("comp1").geom("geom1").runPre("fin");

    model.component("comp1").view("view1").set("transparency", true);

    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat1").propertyGroup().create("linzRes", "Linearized resistivity");
    model.component("comp1").material("mat1").propertyGroup().create("shell", "Shell");
    model.component("comp1").material("mat1").label("Copper2");
    model.component("comp1").material("mat1").set("family", "copper");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "385[J/(kg*K)]");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").set("emissivity", "0.5");
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "8940[kg/m^3]");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]"});
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "126e9[Pa]");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "0.34");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("rho0", "1.667e-8[ohm*m]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("alpha", "3.862e-3[1/K]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").set("Tref", "293.15[K]");
    model.component("comp1").material("mat1").propertyGroup("linzRes").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lth", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lrot", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lne", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lth", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lrot", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lne", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lth", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lrot", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lne", "");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lth", "0.0000001");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lrot", "0.0");
    model.component("comp1").material("mat1").propertyGroup("shell").set("lne", "2");
    model.component("comp1").material("mat1").set("family", "copper");
    model.component("comp1").material("mat1").selection().set();
    model.component("comp1").material("mat1").selection().geom("geom1", 2);
    model.component("comp1").material("mat1").set("bndType", "shell");
    model.component("comp1").material("mat1").selection().set(6);

    model.label("try2_3.mph");

    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat2").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").propertyGroup().create("NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat2").propertyGroup().create("idealGas", "Ideal gas");
    model.component("comp1").material("mat2").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat2").label("Air1");
    model.component("comp1").material("mat2").set("family", "air");
    model.component("comp1").material("mat2").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat2").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat2").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat2").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat2").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat2").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat2").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat2").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat2").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat2").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat2").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat2").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat2").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat2").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat2").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat2").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat2").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat2").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat2").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat2").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat2").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat2").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat2").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat2").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat2").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat2").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat2").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat2").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat2").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat2").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat2").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat2").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat2").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat2").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat2").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat2").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat2").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat2").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat2").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat2").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    model.component("comp1").material("mat2").propertyGroup("NonlinearModel").set("BA", "(def.gamma+1)/2");
    model.component("comp1").material("mat2").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat2").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat2").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat2").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat2").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat2").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat2").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat2").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat2").propertyGroup("idealGas").set("molarmass", "0.02897");
    model.component("comp1").material("mat2").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat2").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat2").materialType("nonSolid");
    model.component("comp1").material("mat2").set("family", "air");
    model.component("comp1").material("mat2").selection().set(1);
    model.component("comp1").material("mat1").propertyGroup("shell").set("lne", "2");
    model.component("comp1").material("mat2").selection().set(1);
    model.component("comp1").material("mat2").selection().all();
    model.component("comp1").material("mat2").selection().geom("geom1", 2);
    model.component("comp1").material("mat2").selection().set(1, 2, 3, 4, 5, 6, 7);
    model.component("comp1").material("mat2").selection().all();
    model.component("comp1").material("mat2").selection().geom("geom1", 3);
    model.component("comp1").material("mat2").selection().all();
    model.component("comp1").material("mat2").selection().set(1);

    model.component("comp1").geom("geom1").run("fin");
    model.component("comp1").geom("geom1").run("fin");
    model.component("comp1").geom("geom1").run("blk1");
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").material().create("mat3", "Common");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat3").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat3").propertyGroup().create("NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat3").propertyGroup().create("idealGas", "Ideal gas");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").label("Air1.1");
    model.component("comp1").material("mat3").set("family", "air");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat3").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat3").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("n", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex").set("ki", "");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex")
         .set("ki", new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0"});
    model.component("comp1").material("mat3").propertyGroup("NonlinearModel").set("BA", "(def.gamma+1)/2");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("molarmass", "0.02897");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat3").materialType("nonSolid");
    model.component("comp1").material("mat3").set("family", "air");
    model.component("comp1").material("mat3").selection().geom("geom1", 2);
    model.component("comp1").material("mat3").selection().set(1, 2, 3, 4, 5, 6, 7);

    model.component("comp1").physics("ecis").selection().set(6);
    model.component("comp1").physics("ecis").feature("csh1").create("bgnd1", "BoundaryGround", 1);
    model.component("comp1").physics("ecis").feature("csh1").create("bterm1", "BoundaryTerminal", 1);
    model.component("comp1").physics("ecis").feature("csh1").feature("bterm1").selection().set(11);
    model.component("comp1").physics("ecis").feature("csh1").feature("bterm1").set("TerminalType", "Voltage");
    model.component("comp1").physics("ecis").feature("csh1").feature("bterm1").set("V0", "Voltage");

    model.param().set("Voltage", "10[V]");

    model.component("comp1").physics("ecis").feature("csh1").feature("bgnd1").selection().set(17);
    model.component("comp1").physics("mf").create("scu1", "SurfaceCurrent", 2);
    model.component("comp1").physics("mf").feature("scu1")
         .set("Js0", new String[]{"ecis.JsX", "ecis.JsY", "ecis.JsZ"});
    model.component("comp1").physics("mf").feature("scu1").selection().set(6);

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "auto");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "auto");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature("aDef").set("complexfun", false);
    model.sol("sol1").feature("s1").feature("aDef").set("cachepattern", true);
    model.sol("sol1").feature("s1").feature("aDef").set("matherr", true);
    model.sol("sol1").feature("s1").feature("aDef").set("blocksizeactive", false);
    model.sol("sol1").feature("s1").create("se1", "Segregated");

    return model;
  }

  public static Model run2(Model model) {
    model.sol("sol1").feature("s1").feature("se1").feature().remove("ssDef");
    model.sol("sol1").feature("s1").feature("se1").create("ss1", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("segvar", new String[]{"comp1_ecis_Vc"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("linsolver", "dDef");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").label("Electric Currents in Shells");
    model.sol("sol1").feature("s1").feature("se1").create("ss2", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("segvar", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1").set("linsolver", "fgmres");
    model.sol("sol1").feature("s1").feature("i1").set("nlinnormuse", true);
    model.sol("sol1").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").create("ams1", "AMS");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1").set("prefun", "ams");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1")
         .set("sorvecdof", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("linsolver", "i1");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").label("Magnetic Fields");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("Magnetic Flux Density Norm (mf)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("solutionparams", "parent");
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("mslc1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("mslc1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("mslc1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("mslc1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("mslc1").set("colortable", "Prism");
    model.result("pg1").feature("mslc1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("mslc1").set("colorcalibration", -0.8);
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature().create("strmsl1", "StreamlineMultislice");
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("solutionparams", "parent");
    model.result("pg1").feature("strmsl1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("strmsl1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("strmsl1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("strmsl1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("strmsl1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("strmsl1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("strmsl1").set("titletype", "none");
    model.result("pg1").feature("strmsl1").set("posmethod", "uniform");
    model.result("pg1").feature("strmsl1").set("udist", 0.02);
    model.result("pg1").feature("strmsl1").set("maxlen", 0.4);
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("inheritcolor", false);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("data", "parent");
    model.result("pg1").feature("strmsl1").set("inheritplot", "mslc1");
    model.result("pg1").feature("strmsl1").feature().create("col1", "Color");
    model.result("pg1").feature("strmsl1").feature("col1").set("colortable", "PrismDark");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorlegend", false);
    model.result("pg1").feature("strmsl1").feature("col1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorcalibration", -0.8);
    model.result("pg1").feature("strmsl1").feature().create("filt1", "Filter");
    model.result("pg1").feature("strmsl1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("Electric Potential (ecis)");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset1");
    model.result("pg2").feature().create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("solutionparams", "parent");
    model.result("pg2").feature("surf1").set("expr", "V");
    model.result("pg2").feature("surf1").set("colortable", "Dipole");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("data", "parent");
    model.result("pg2").feature("surf1").feature().create("def1", "Deform");
    model.result("pg2").feature("surf1").feature("def1")
         .set("expr", new String[]{"0.5*ecis.ds*ecis.nX", "0.5*ecis.ds*ecis.nY", "0.5*ecis.ds*ecis.nZ"});
    model.result("pg2").feature("surf1").feature("def1").set("scaleactive", true);
    model.result("pg2").feature().create("surf2", "Surface");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("solutionparams", "parent");
    model.result("pg2").feature("surf2").set("expr", "V");
    model.result("pg2").feature("surf2").set("titletype", "none");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("data", "parent");
    model.result("pg2").feature("surf2").set("inheritplot", "surf1");
    model.result("pg2").feature("surf2").feature().create("def1", "Deform");
    model.result("pg2").feature("surf2").feature("def1")
         .set("expr", new String[]{"-0.5*ecis.ds*ecis.nX", "-0.5*ecis.ds*ecis.nY", "-0.5*ecis.ds*ecis.nZ"});
    model.result().remove("pg2");
    model.result().remove("pg1");
    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("Magnetic Flux Density Norm (mf)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("solutionparams", "parent");
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("mslc1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("mslc1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("mslc1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("mslc1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("mslc1").set("colortable", "Prism");
    model.result("pg1").feature("mslc1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("mslc1").set("colorcalibration", -0.8);
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature().create("strmsl1", "StreamlineMultislice");
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("solutionparams", "parent");
    model.result("pg1").feature("strmsl1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("strmsl1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("strmsl1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("strmsl1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("strmsl1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("strmsl1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("strmsl1").set("titletype", "none");
    model.result("pg1").feature("strmsl1").set("posmethod", "uniform");
    model.result("pg1").feature("strmsl1").set("udist", 0.02);
    model.result("pg1").feature("strmsl1").set("maxlen", 0.4);
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("inheritcolor", false);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("data", "parent");
    model.result("pg1").feature("strmsl1").set("inheritplot", "mslc1");
    model.result("pg1").feature("strmsl1").feature().create("col1", "Color");
    model.result("pg1").feature("strmsl1").feature("col1").set("colortable", "PrismDark");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorlegend", false);
    model.result("pg1").feature("strmsl1").feature("col1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorcalibration", -0.8);
    model.result("pg1").feature("strmsl1").feature().create("filt1", "Filter");
    model.result("pg1").feature("strmsl1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("Electric Potential (ecis)");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset1");
    model.result("pg2").feature().create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("solutionparams", "parent");
    model.result("pg2").feature("surf1").set("expr", "V");
    model.result("pg2").feature("surf1").set("colortable", "Dipole");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("data", "parent");
    model.result("pg2").feature("surf1").feature().create("def1", "Deform");
    model.result("pg2").feature("surf1").feature("def1")
         .set("expr", new String[]{"0.5*ecis.ds*ecis.nX", "0.5*ecis.ds*ecis.nY", "0.5*ecis.ds*ecis.nZ"});
    model.result("pg2").feature("surf1").feature("def1").set("scaleactive", true);
    model.result("pg2").feature().create("surf2", "Surface");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("solutionparams", "parent");
    model.result("pg2").feature("surf2").set("expr", "V");
    model.result("pg2").feature("surf2").set("titletype", "none");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("data", "parent");
    model.result("pg2").feature("surf2").set("inheritplot", "surf1");
    model.result("pg2").feature("surf2").feature().create("def1", "Deform");
    model.result("pg2").feature("surf2").feature("def1")
         .set("expr", new String[]{"-0.5*ecis.ds*ecis.nX", "-0.5*ecis.ds*ecis.nY", "-0.5*ecis.ds*ecis.nZ"});
    model.result().remove("pg2");
    model.result().remove("pg1");

    model.component("comp1").physics("mf").feature("scu1").set("coordinateSystem", "GlobalSystem");

    model.param().set("Voltage", "20[V]");

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").run();

    model.sol("sol1").updateSolution();
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "auto");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "auto");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature("aDef").set("complexfun", false);
    model.sol("sol1").feature("s1").feature("aDef").set("cachepattern", true);
    model.sol("sol1").feature("s1").feature("aDef").set("matherr", true);
    model.sol("sol1").feature("s1").feature("aDef").set("blocksizeactive", false);
    model.sol("sol1").feature("s1").create("se1", "Segregated");
    model.sol("sol1").feature("s1").feature("se1").feature().remove("ssDef");
    model.sol("sol1").feature("s1").feature("se1").create("ss1", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("segvar", new String[]{"comp1_ecis_Vc"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("linsolver", "dDef");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").label("Electric Currents in Shells");
    model.sol("sol1").feature("s1").feature("se1").create("ss2", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("segvar", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1").set("linsolver", "fgmres");
    model.sol("sol1").feature("s1").feature("i1").set("nlinnormuse", true);
    model.sol("sol1").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").create("ams1", "AMS");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1").set("prefun", "ams");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1")
         .set("sorvecdof", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("linsolver", "i1");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").label("Magnetic Fields");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("Magnetic Flux Density Norm (mf)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("solutionparams", "parent");
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("mslc1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("mslc1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("mslc1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("mslc1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("mslc1").set("colortable", "Prism");
    model.result("pg1").feature("mslc1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("mslc1").set("colorcalibration", -0.8);
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature().create("strmsl1", "StreamlineMultislice");
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("solutionparams", "parent");
    model.result("pg1").feature("strmsl1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("strmsl1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("strmsl1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("strmsl1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("strmsl1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("strmsl1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("strmsl1").set("titletype", "none");
    model.result("pg1").feature("strmsl1").set("posmethod", "uniform");
    model.result("pg1").feature("strmsl1").set("udist", 0.02);
    model.result("pg1").feature("strmsl1").set("maxlen", 0.4);
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("inheritcolor", false);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("data", "parent");
    model.result("pg1").feature("strmsl1").set("inheritplot", "mslc1");
    model.result("pg1").feature("strmsl1").feature().create("col1", "Color");
    model.result("pg1").feature("strmsl1").feature("col1").set("colortable", "PrismDark");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorlegend", false);
    model.result("pg1").feature("strmsl1").feature("col1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorcalibration", -0.8);
    model.result("pg1").feature("strmsl1").feature().create("filt1", "Filter");
    model.result("pg1").feature("strmsl1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("Electric Potential (ecis)");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset1");
    model.result("pg2").feature().create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("solutionparams", "parent");
    model.result("pg2").feature("surf1").set("expr", "V");
    model.result("pg2").feature("surf1").set("colortable", "Dipole");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("data", "parent");
    model.result("pg2").feature("surf1").feature().create("def1", "Deform");
    model.result("pg2").feature("surf1").feature("def1")
         .set("expr", new String[]{"0.5*ecis.ds*ecis.nX", "0.5*ecis.ds*ecis.nY", "0.5*ecis.ds*ecis.nZ"});
    model.result("pg2").feature("surf1").feature("def1").set("scaleactive", true);
    model.result("pg2").feature().create("surf2", "Surface");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("solutionparams", "parent");
    model.result("pg2").feature("surf2").set("expr", "V");
    model.result("pg2").feature("surf2").set("titletype", "none");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("data", "parent");
    model.result("pg2").feature("surf2").set("inheritplot", "surf1");
    model.result("pg2").feature("surf2").feature().create("def1", "Deform");
    model.result("pg2").feature("surf2").feature("def1")
         .set("expr", new String[]{"-0.5*ecis.ds*ecis.nX", "-0.5*ecis.ds*ecis.nY", "-0.5*ecis.ds*ecis.nZ"});
    model.result().remove("pg2");
    model.result().remove("pg1");

    model.component("comp1").physics("mf").feature("al1").setIndex("materialType", "solid", 0);
    model.component("comp1").physics("mf").feature("al1").setIndex("materialType", "nonSolid", 0);

    model.component("comp1").material("mat3").selection().set(1, 2, 3, 4, 5, 7);

    model.sol("sol1").updateSolution();
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "auto");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "auto");

    model.sol("sol1").feature().remove("s1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature("aDef").set("complexfun", false);
    model.sol("sol1").feature("s1").feature("aDef").set("cachepattern", true);
    model.sol("sol1").feature("s1").feature("aDef").set("matherr", true);
    model.sol("sol1").feature("s1").feature("aDef").set("blocksizeactive", false);
    model.sol("sol1").feature("s1").create("se1", "Segregated");
    model.sol("sol1").feature("s1").feature("se1").feature().remove("ssDef");
    model.sol("sol1").feature("s1").feature("se1").create("ss1", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("segvar", new String[]{"comp1_ecis_Vc"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").set("linsolver", "dDef");
    model.sol("sol1").feature("s1").feature("se1").feature("ss1").label("Electric Currents in Shells");
    model.sol("sol1").feature("s1").feature("se1").create("ss2", "SegregatedStep");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("segvar", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1").set("linsolver", "fgmres");
    model.sol("sol1").feature("s1").feature("i1").set("nlinnormuse", true);
    model.sol("sol1").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("pr").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("po").create("so1", "SOR");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").create("ams1", "AMS");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1").set("prefun", "ams");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1").feature("cs").feature("ams1")
         .set("sorvecdof", new String[]{"comp1_A"});
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").set("linsolver", "i1");
    model.sol("sol1").feature("s1").feature("se1").feature("ss2").label("Magnetic Fields");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("Magnetic Flux Density Norm (mf)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("solutionparams", "parent");
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("mslc1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("mslc1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("mslc1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("mslc1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("mslc1").set("colortable", "Prism");
    model.result("pg1").feature("mslc1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("mslc1").set("colorcalibration", -0.8);
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature().create("strmsl1", "StreamlineMultislice");
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("solutionparams", "parent");
    model.result("pg1").feature("strmsl1").set("multiplanexmethod", "coord");
    model.result("pg1").feature("strmsl1").set("xcoord", "mf.CPx");
    model.result("pg1").feature("strmsl1").set("multiplaneymethod", "coord");
    model.result("pg1").feature("strmsl1").set("ycoord", "mf.CPy");
    model.result("pg1").feature("strmsl1").set("multiplanezmethod", "coord");
    model.result("pg1").feature("strmsl1").set("zcoord", "mf.CPz");
    model.result("pg1").feature("strmsl1").set("titletype", "none");
    model.result("pg1").feature("strmsl1").set("posmethod", "uniform");
    model.result("pg1").feature("strmsl1").set("udist", 0.02);
    model.result("pg1").feature("strmsl1").set("maxlen", 0.4);
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("inheritcolor", false);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("showsolutionparams", "on");
    model.result("pg1").feature("strmsl1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("strmsl1").set("data", "parent");
    model.result("pg1").feature("strmsl1").set("inheritplot", "mslc1");
    model.result("pg1").feature("strmsl1").feature().create("col1", "Color");
    model.result("pg1").feature("strmsl1").feature("col1").set("colortable", "PrismDark");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorlegend", false);
    model.result("pg1").feature("strmsl1").feature("col1").set("colortabletrans", "nonlinear");
    model.result("pg1").feature("strmsl1").feature("col1").set("colorcalibration", -0.8);
    model.result("pg1").feature("strmsl1").feature().create("filt1", "Filter");
    model.result("pg1").feature("strmsl1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("Electric Potential (ecis)");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset1");
    model.result("pg2").feature().create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("solutionparams", "parent");
    model.result("pg2").feature("surf1").set("expr", "V");
    model.result("pg2").feature("surf1").set("colortable", "Dipole");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("data", "parent");
    model.result("pg2").feature("surf1").feature().create("def1", "Deform");
    model.result("pg2").feature("surf1").feature("def1")
         .set("expr", new String[]{"0.5*ecis.ds*ecis.nX", "0.5*ecis.ds*ecis.nY", "0.5*ecis.ds*ecis.nZ"});
    model.result("pg2").feature("surf1").feature("def1").set("scaleactive", true);
    model.result("pg2").feature().create("surf2", "Surface");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("solutionparams", "parent");
    model.result("pg2").feature("surf2").set("expr", "V");
    model.result("pg2").feature("surf2").set("titletype", "none");
    model.result("pg2").feature("surf2").set("showsolutionparams", "on");
    model.result("pg2").feature("surf2").set("data", "parent");
    model.result("pg2").feature("surf2").set("inheritplot", "surf1");
    model.result("pg2").feature("surf2").feature().create("def1", "Deform");
    model.result("pg2").feature("surf2").feature("def1")
         .set("expr", new String[]{"-0.5*ecis.ds*ecis.nX", "-0.5*ecis.ds*ecis.nY", "-0.5*ecis.ds*ecis.nZ"});

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg2").feature("surf1").set("data", "dset1");
    model.result("pg2").run();
    model.result("pg2").create("surf3", "Surface");
    model.result("pg2").feature("surf3").set("expr", "mf.Bx");
    model.result("pg2").run();
    model.result("pg2").feature("surf3").set("expr", "mf.Bx");
    model.result("pg2").run();
    model.result("pg2").feature("surf3").set("data", "dset1");
    model.result("pg2").run();
    model.result().table().create("evl3", "Table");
    model.result().table("evl3").comments("Interactive 3D values");
    model.result().table("evl3").label("Evaluation 3D");
    model.result().table("evl3")
         .addRow(new double[]{-9.000000000000007, -7.612337101131474, 3.942460220634131, 2.7280023530543382E-15}, new double[]{0, 0, 0, 0});
    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg2").feature().remove("surf1");
    model.result("pg2").feature().remove("surf2");

    return model;
  }

  public static Model run3(Model model) {
    model.result("pg2").run();
    model.result().table("evl3")
         .addRow(new double[]{-2.449752011089931, 3.5442889209224786, -9, -20.486835879375953}, new double[]{0, 0, 0, 0});

    model.component("comp1").view("view1").set("transparency", true);

    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "mf.Bx");
    model.result("pg2").run();
    model.result("pg2").feature("surf3").set("expr", "V");
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("xcoord", 0);
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "number");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "number");
    model.result("pg1").feature("mslc1").set("ycoord", 0);
    model.result("pg1").feature("mslc1").set("zcoord", "atz");

    model.param().set("atx", "0.03[\u00b5m]");
    model.param().descr("atx", "");
    model.param().set("aty", "0.03[\u00b5m]");
    model.param().descr("aty", "");
    model.param().set("atz", "0.03[\u00b5m]");
    model.param().descr("atz", "");

    model.sol("sol1").updateSolution();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("xnumber", "0");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "coord");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature().remove("strmsl1");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").label("Multislice Bx");
    model.result("pg1").feature().duplicate("mslc2", "mslc1");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature().duplicate("mslc3", "mslc1");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc2").label("Multislice By");
    model.result("pg1").feature("mslc2").set("expr", "mf.By");
    model.result("pg1").feature("mslc2").set("zcoord", "aty");
    model.result("pg1").run();
    model.result("pg1").feature("mslc3").set("expr", "mf.Bz");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("zcoord", "atx");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc3").label("Multislice Bz");
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();

    model.sol("sol1").updateSolution();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("multiplanexmethod", "number");
    model.result("pg1").feature("mslc1").set("multiplaneymethod", "number");
    model.result("pg1").run();
    model.result("pg1").feature("mslc2").set("multiplanexmethod", "number");
    model.result("pg1").feature("mslc2").set("multiplaneymethod", "number");
    model.result("pg1").run();
    model.result("pg1").feature("mslc3").set("multiplanexmethod", "number");
    model.result("pg1").feature("mslc3").set("multiplaneymethod", "number");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc2").set("ynumber", "0");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("ynumber", "0");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc3").set("ynumber", "0");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").create("arws1", "ArrowSurface");
    model.result("pg1").feature("arws1").set("expr", new String[]{"mf.scu1.Js0x", "mf.By", "mf.Bz"});
    model.result("pg1").feature("arws1").setIndex("expr", "mf.scu1.Js0y", 1);
    model.result("pg1").feature("arws1").setIndex("expr", "mf.scu1.Js0z", 2);
    model.result("pg1").run();
    model.result("pg1").feature("arws1").set("scale", 1.5E-10);
    model.result("pg1").feature("arws1").set("arrowcount", 2000);
    model.result("pg1").run();
    model.result("pg1").feature("arws1").set("arrowcount", 20000);
    model.result("pg1").run();
    model.result("pg1").feature("arws1").set("arrowcount", 2000);
    model.result("pg1").run();

    model.sol("sol1").updateSolution();

    model.result("pg1").run();

    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg1").run();
    model.result().export().create("plot1", "Plot");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export("plot1").label("Plot Bx");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export().duplicate("plot2", "plot1");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export().duplicate("plot3", "plot2");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export().duplicate("plot4", "plot3");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export("plot2").set("plot", "mslc2");
    model.result().export("plot2").label("Plot By");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export("plot3").set("plot", "mslc3");
    model.result().export("plot3").label("Plot Bz");
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result().export("plot4").set("plot", "arws1");
    model.result().export("plot4").label("J");
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("arws1").active(true);
    model.result("pg1").feature("mslc2").active(false);
    model.result("pg1").feature("mslc3").active(false);
    model.result("pg1").feature("arws1").active(false);
    model.result("pg1").feature("mslc2").active(true);
    model.result("pg1").feature("mslc3").active(true);
    model.result("pg1").feature("arws1").active(true);

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    model = run2(model);
    run3(model);
  }

}
