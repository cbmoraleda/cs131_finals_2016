package gerard_arel_latoga;

import static org.junit.Assert.*;
import java.lang.Math;
import org.junit.Test;
import java.util.Scanner; 
import java.io.*; 

public class SecTest {
	@Test
	public void correctSecFormula1(){
		Scanner scanner;
		File file = new File("src/test/resources/SecTestInput.in");
		try {
        	scanner = new Scanner(file);
        	
        	int numberOfTestCases = scanner.nextInt();
        	for (int i = 1 ; i <= numberOfTestCases ; i++){
        		double lowerBound = scanner.nextDouble();
        		double upperBound = scanner.nextDouble();	
        		scanner.nextLine();
        		String func = scanner.nextLine();
        		double err=scanner.nextDouble();
        		int imax = scanner.nextInt();
        		double desired = scanner.nextDouble();
        		double tolerance = scanner.nextDouble();
        		Sec secantSolver = new Sec(String.format(func),String.format("Xa = %f", lowerBound),String.format("Xb = %f", upperBound),String.format("err = %f", err),String.format("imax = %d", imax));
        		double actual = secantSolver.Answer();
        		assertTrue(Math.abs(actual-desired)<= tolerance);
        		System.out.println("Test Case " + (int)(i) + " Successful.");
        	}

	    } catch (FileNotFoundException e1) {
	    	    System.out.println("The test input file for SecTest.java could not be found/opened");
	    	    assertTrue(false);
	            e1.printStackTrace();
	    }
					
	  }
	
}
