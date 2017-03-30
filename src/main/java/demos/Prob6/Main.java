/*
 * Copyright (c) 2017 CS 131 IPSE NKIA. All rights reserved.
 * Authors:
 * Juan Gabriel C. Tamayo
 * Juan Benedicto L. Aceron
 * This script is for testing purposes only.*
 */

package demos.Prob6;

public class Main {
	
	// OVERRIDE VALUES
	protected static final double DEFAULT_LENGTH = 0.1;
	protected static final double DEFAULT_TEMP_ZERO = 473;
	protected static final double DEFAULT_TEMP_POINT_ONE = 293;
	protected static final double DEFAULT_AMBIENT_TEMP = 293;
	protected static final double DEFAULT_CONVECTIVE_HEAT_COEFF = 40;
	protected static final double DEFAULT_PERIMETER = 0.016;
	protected static final double DEFAULT_THERMAL_CONDUCTIVITY = 240;
	protected static final double DEFAULT_SURFACE_AREA = 0.000016;
	protected static final double DEFAULT_INTERVALS = 5;
		
	protected double[] myMatrixT = new double[6];
	protected double[][] myMatrixA = new double[4][4];
	protected double[] myMatrixB = new double[4];
	protected double[] myMatrixY = new double[4];
	protected double[] myMatrixX = new double[4];
	protected double[][][] matrixLUOutput = new double[2][4][4];
	protected double[][] myLowerTriangle = new double[4][4];
	protected double[][] myUpperTriangle = new double[4][4];
	
	protected double step_size;
	protected double beta;
	protected double initial_diagonal_a;
	protected double initial_matrix_b;
	
	protected void computeInitialValues(double length, double intervals, double convective_heat_coeff, double perimeter, double thermal_conductivity, double surface_area, double ambient_temp){
		step_size = length / intervals;
		beta = convective_heat_coeff * perimeter / (thermal_conductivity * surface_area);
		initial_diagonal_a = -(2 + Math.pow(step_size, 2) * beta);
		initial_matrix_b = Math.pow(step_size, 2) * beta * ambient_temp;
	}
	
	protected void initializeMatrix(double temp_zero, double temp_point_one, double initial_diagonal_a){
		java.util.Arrays.fill(myMatrixB, 0.0);
		java.util.Arrays.fill(myMatrixY, 0.0);
		java.util.Arrays.fill(myMatrixX, 0.0);
		java.util.Arrays.fill(myMatrixT, 0.0);
		
		myMatrixT[0] = temp_zero;
		myMatrixT[5] = temp_point_one;

		myMatrixA[0][0] = initial_diagonal_a;
		myMatrixA[1][1] = initial_diagonal_a;
		myMatrixA[2][2] = initial_diagonal_a;
		myMatrixA[3][3] = initial_diagonal_a;
		myMatrixA[0][1] = 1;
		myMatrixA[1][0] = 1;
		myMatrixA[1][2] = 1;
		myMatrixA[2][1] = 1;
		myMatrixA[2][3] = 1;
		myMatrixA[3][2] = 1;
		
		myMatrixB[0] = -(initial_matrix_b + myMatrixT[0]);
		myMatrixB[1] = -initial_matrix_b;
		myMatrixB[2] = -initial_matrix_b;
		myMatrixB[3] = -(initial_matrix_b + myMatrixT[5]);
	}

	
	protected void initializeValues(){
		initializeValues(DEFAULT_LENGTH, DEFAULT_TEMP_ZERO, DEFAULT_TEMP_POINT_ONE, DEFAULT_AMBIENT_TEMP, DEFAULT_CONVECTIVE_HEAT_COEFF, DEFAULT_PERIMETER, DEFAULT_THERMAL_CONDUCTIVITY, DEFAULT_SURFACE_AREA, DEFAULT_INTERVALS);
	}

	
	protected void initializeValues(double length, double temp_zero, double temp_point_one, double ambient_temp, double convective_heat_coeff, double perimeter, double thermal_conductivity, double surface_area, double intervals){
		computeInitialValues(length, intervals, convective_heat_coeff, perimeter, thermal_conductivity, surface_area, ambient_temp);
		initializeMatrix(temp_zero, temp_point_one, initial_diagonal_a);
		matrixLUOutput = LU.LUdecompCrout.LU(myMatrixA);
		}
	
	public void computePinFinTemp(){
		myLowerTriangle = matrixLUOutput[0];
		myUpperTriangle = matrixLUOutput[1];

		myMatrixY[0] = myMatrixB[0] / myLowerTriangle[0][0];

		for (int i = 1; i < 4; i++) {
			myMatrixY[i] = (myMatrixB[i] - LU.Mult.Mult(myLowerTriangle[i], myMatrixY)) / myLowerTriangle[i][i];
		}

		myMatrixX[3] = myMatrixY[3] / myUpperTriangle[3][3];

		for (int i = 2; i >= 0; i--) {
			myMatrixX[i] = (myMatrixY[i] - LU.Mult.Mult(myMatrixX, myUpperTriangle[i])) / myUpperTriangle[i][i];
		}

		for (int i = 1; i < 5; i++) {
			myMatrixT[i] = myMatrixX[i - 1];
		}
	}
	
	public void computePinFinTemp(double[][][] externalLU){
		matrixLUOutput = externalLU;
		computePinFinTemp();
	}
	
	protected void printMatrix() {
		System.out.println(java.util.Arrays.toString(myMatrixY));
		System.out.println(java.util.Arrays.toString(myMatrixX));
		System.out.println(java.util.Arrays.toString(myMatrixT));
	}
	
	public String getMatrixY(){
		//System.out.println(java.util.Arrays.toString(myMatrixY));
		return java.util.Arrays.toString(myMatrixY);
	}
	
	public String getMatrixX(){
		//System.out.println(java.util.Arrays.toString(myMatrixX));
		return java.util.Arrays.toString(myMatrixX);
	}
	
	public String getMatrixT(){
		//System.out.println(java.util.Arrays.toString(myMatrixT));
		return java.util.Arrays.toString(myMatrixT);
	}
	
	public double[][] getMatrixA(){
		/*
		System.out.println("Matrix A:");
		for (int i = 0; i < myMatrixA.length; i++){
			System.out.println(java.util.Arrays.toString(myMatrixA[i]));
		}
		*/
		return myMatrixA;
	}
	
	public double[][][] getMatrixLUOutput(){
		return matrixLUOutput;
	}
	
	public void main(String[] args){
		initializeValues();
		computePinFinTemp();
		printMatrix();
	}
}
