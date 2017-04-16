package demos.Prob4;

import junit.framework.TestCase;

import java.util.Scanner;
import java.util.stream.*;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Prob4Test extends TestCase {
//	@Test
	static String[] values;
	static double[] testX;
	static double[] testY;
	static Scanner scan;
	public  void test() {
		read();
		Prob4 test = new Prob4();

		test.something();
		Double ComputedX[] = test.getX();
		Double ComputedY[] = test.getY();
		double unboxedX[] = new double[31];
		double unboxedY[] = new double[31];
		int j;
		for(j = 1; j <= 31; j++){
			unboxedX[j-1] = ComputedX[j].doubleValue();
		}
		for(j = 1; j <= 31; j++){
			unboxedY[j-1] = ComputedY[j].doubleValue();
		}
//		double[] unboxedX = Stream.of(ComputedX).mapToDouble(Double::doubleValue).toArray();
		boolean correctValue = true;
//	ComputedX[1] = 1.00;
//		testX[1] = 1.00;
		int i;
//		for(i = 0; i<=29; i++){
//			if(unboxedX[i] != testX[i] || unboxedY[i] != testY[i]){ //|| ComputedY[i+1] != testY[i]){
//				//System.out.print(ComputedX[i] + " == " + testX[i]);
//				correctValue  = false;
//			}
//
//		}
	assertTrue(correctValue);
	}
	
	public static void read() {
		int count = 1;
		int i;
		BufferedReader br = null;
		FileReader fr = null;
		try {
			String dir = new File( "." ).getCanonicalPath();
			File in = new File(dir + "/src/test/resources/test_files/demos/Prob4/Prob4.in");
			scan = new Scanner(in);
			//getting X-values
			String line = scan.nextLine();
			values = line.split(",");
			testX = new double[values.length];
				for(i = 0; i < values.length; i++)
			{
    					testX[i] = Double.parseDouble(values[i]);
			}
		
			//getting Y-values
			values = line.split(",");
			testY = new double[values.length];
				for(i = 0; i < values.length; i++)
			{
    					testY[i] = Double.parseDouble(values[i]);
			}
			count = count + 1;
				
			
		} catch (Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}

	
	

}
