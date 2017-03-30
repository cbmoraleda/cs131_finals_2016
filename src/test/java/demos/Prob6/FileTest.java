/*
 * Copyright (c) 2017 CS 131 IPSE NKIA. All rights reserved.
 */

import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

/*
 * Please read the readme file in the resources folder on how to use this unit tester.
 */

public class FileTest {
	Scanner scan;
	static final double TOLERANCE = 0.001;
	
	@Test
	public void fileTester(){
		try{
		File in = new File(FileTest.class.getResource("test.in").getFile());
		scan = new Scanner(in);
		String line = scan.nextLine();
		int cases = Integer.parseInt(line.replaceAll("\\s", ""));
		for (int i = 0; i < cases; i++){
			runTest();
			System.out.println("Test Case " + (int)(i+1) + " Successful.");
		}
		scan.close();
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	public boolean compareValues(double[] A, double[] B, double tolerance){
		//To be implemented
		return true;
	}
	
	public boolean compareValues(double[][] A, double[][] B, double tolerance) {
		//To be implemented
		return true;
	}
	
	public boolean compareValues(double[][][] A, double[][][] B, double tolerance){
		//To be implemented
		return true;
	}
	
	public void runTest(){
		Main tester = new Main();
		int checkType = Integer.parseInt(scan.nextLine().replaceAll("\\s", ""));
		double length = scan.nextDouble();
		double temp_zero = scan.nextDouble();
		double temp_point_one = scan.nextDouble();
		double ambient_temp = scan.nextDouble();
		double convective_heat_coeff = scan.nextDouble();
		double perimeter = scan.nextDouble();
		double thermal_conductivity = scan.nextDouble();
		double surface_area = scan.nextDouble();
		double intervals = Double.parseDouble(scan.nextLine().replaceAll("\\s", ""));
		if (checkType == 1) {
			String matrixY = scan.nextLine();
			String matrixX = scan.nextLine();
			String matrixT = scan.nextLine();
			matrixY = matrixY.replaceAll("\\s", "");
			matrixX = matrixX.replaceAll("\\s", "");
			matrixT = matrixT.replaceAll("\\s", "");
			tester.initializeValues(length, temp_zero, temp_point_one, ambient_temp, convective_heat_coeff, perimeter, thermal_conductivity, surface_area, intervals);
			tester.computePinFinTemp();
			assertTrue(matrixY.equals(tester.getMatrixY().replaceAll("\\s", "")));
			assertTrue(matrixX.equals(tester.getMatrixX().replaceAll("\\s", "")));
			assertTrue(matrixT.equals(tester.getMatrixT().replaceAll("\\s", "")));
		} else if (checkType == 2) {
			tester.initializeValues(length, temp_zero, temp_point_one, ambient_temp, convective_heat_coeff, perimeter, thermal_conductivity, surface_area, intervals);
			tester.computePinFinTemp();
			String matrixY = tester.getMatrixY().replaceAll("\\s", "");
			String matrixX = tester.getMatrixX().replaceAll("\\s", "");
			String matrixT = tester.getMatrixT().replaceAll("\\s", "");
			double[][] matrixA = tester.getMatrixA();
			double[][] LU = new double[matrixA.length][matrixA[0].length];
			double[][][] standardMatrix = LUdecompCrout_Standard.Crout(matrixA.length, matrixA, LU);
			tester.initializeValues(length, temp_zero, temp_point_one, ambient_temp, convective_heat_coeff, perimeter, thermal_conductivity, surface_area, intervals);
			tester.computePinFinTemp(standardMatrix);
			assertTrue(matrixY.equals(tester.getMatrixY().replaceAll("\\s", "")));
			assertTrue(matrixX.equals(tester.getMatrixX().replaceAll("\\s", "")));
			assertTrue(matrixT.equals(tester.getMatrixT().replaceAll("\\s", "")));
		} else if (checkType == 3) {
			tester.initializeValues(length, temp_zero, temp_point_one, ambient_temp, convective_heat_coeff, perimeter, thermal_conductivity, surface_area, intervals);
			tester.computePinFinTemp();
			double[][] matrixA = tester.getMatrixA();
			double[][] LU = new double[matrixA[0].length][matrixA[0].length];
			double[][][] standardMatrix = LUdecompCrout_Standard.Crout(matrixA.length, matrixA, LU);
			double[][][] LUoutput = tester.getMatrixLUOutput();
			for(int i = 0; i < standardMatrix.length; i++){
				for (int j = 0; j < standardMatrix[0].length; j++){
					assertTrue(java.util.Arrays.toString(standardMatrix[i][j]).replaceAll("\\s", "").equals(java.util.Arrays.toString(LUoutput[i][j]).replaceAll("\\s", "")));
				}
			}
		} else {
			System.out.println("ERROR: INVALID TEST CASE. PLEASE CHECK YOUR CASE FILE AND TRY AGAIN.");
			assert(false);
		}
	}

}
