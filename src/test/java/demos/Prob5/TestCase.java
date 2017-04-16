package demos.Prob5;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import faneallrich_yao.Sys2ODEsRK2;

public class TestCase {
	
	/* writeCSVFile: ensure that CSV file is still produced regardless of values */
	@Test
	public void writeCSVFile(){
		String[] stubStringArray= new String[10];
		Double[][] stubDoubleArray= new Double[10][10];
		assertTrue(Prob5.printCSV("Prob5.csv", stubStringArray, stubDoubleArray));
	}
	
	/* outputUnchanged: nothing changed after refactoring */
	@Test
	public void outputUnchanged(){
		Prob5 problem5 = new Prob5();
		problem5.setProblemParameters();
		Scanner scanner;
		String dir = new File( "." ).getCanonicalPath();
		File in = new File(dir + "/src/test/resources/test_files/demos/Prob5/Prob5TestInput.in");
		try {
        	scanner = new Scanner(file);
        	double tolerance = 0.0000001;
        	
        	String[] desiredMatrixS = new String[4];
        	
    	    desiredMatrixS[0] = scanner.nextLine();
    	    desiredMatrixS[1] = scanner.nextLine();
    	    desiredMatrixS[2] = scanner.nextLine();
    	    desiredMatrixS[3] = scanner.nextLine();
    	    
 			Double [][] actualOutput =problem5.calculate(-1000.0, -3500.0);
 			Double [][] desiredOutput = new Double[4][11];

 			for (int i = 0; i < 4; i++) {
 				String[] temp = desiredMatrixS[i].replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
 				for (int j=0 ; j<11 ; j++){
 			    	try {
 			    		desiredOutput[i][j] = Double.parseDouble(temp[j]);
 			    	} catch (NumberFormatException nfe) {
 			    		System.out.println("Parsing Error");
 			    		assertTrue(false);
 			    	};
 			
 			    }
 			}    
 			int error = 0;

 			for (int i = 0; i < 3; i++) {
 				for (int j = 0; j < 11; j++) {
 					if (Math.abs(desiredOutput[i][j] - actualOutput[i][j]) > tolerance) {
 						error = 1;
 						break;
 					}
 				}
 			}

 			assertTrue(error == 0);
 		
    		

	    } catch (FileNotFoundException e1) {
	    	    System.out.println("The test input file for Prob5.java could not be found/opened");
	    	    assertTrue(false);
	            e1.printStackTrace();
	    }
	}
}

