package faneallrich_yao;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.mariuszgromada.math.mxparser.*;
import org.math.plot.utils.Array;

import gerard_arel_latoga.Sec;

public class Sys2ODEsRK2Test {
	/* correctRK2Formula: using another set of values to ensure that the RK2
	 * code is correct after refactoring */
	@Test
	public void correctRK2Formula(){
		Scanner scanner;
		Sys2ODEsRK2 sys2 = new Sys2ODEsRK2();
		File file = new File("src/test/resources/Sys2ODEsRK2TestInput.in");
		try {
        	scanner = new Scanner(file);
        	int numberOfTestCases = scanner.nextInt();
        	scanner.nextLine();
        	for (int i = 1 ; i <= numberOfTestCases ; i++){
        		String fun1 = String.format(scanner.nextLine());
        	    String fun2 = String.format(scanner.nextLine());
        	    
        	    double lowerBound =scanner.nextDouble();
          		double upperBound = scanner.nextDouble();
          		double y0 = scanner.nextDouble();
          		double z0 = scanner.nextDouble();
          		double h = scanner.nextDouble();
        	    scanner.nextLine();
        	    String desiredMatrixX = scanner.nextLine();
        	    
    			String desiredMatrixY = scanner.nextLine();
    		
     			String desiredMatrixZ = scanner.nextLine();
          		
        		Double[][] actualResult = sys2.calculate(fun1,fun2,y0,z0,lowerBound,upperBound,h);

        		assertTrue(desiredMatrixX.equals(Arrays.toString(actualResult[0])));
        		assertTrue(desiredMatrixY.equals(Arrays.toString(actualResult[1])));
        		assertTrue(desiredMatrixZ.equals(Arrays.toString(actualResult[2])));
        		System.out.println("Test Case " + (int)(i) + " Successful.");
        	}

	    } catch (FileNotFoundException e1) {
	    	    System.out.println("The test input file for Sys2ODEsRK2Test.java could not be found/opened");
	    	    assertTrue(false);
	            e1.printStackTrace();
	    }
	}
}	
