package demos.Prob2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

public class FinalsTest {
	static Scanner scan;
	static String[] values;
	static double[] expectedX;
	static double[] expectedY;
	int i;
	Double a = 0d;
	  Double b = 18d;
	  Double h = 0.25d;
	  Double x1 = Math.PI/2d;
	  Double y1 = 0d;
	  Double [][] rk4Answers = Finals.getRK4();

	  @Test
	  public void testCheckInitialVal() {
			assertEquals(a,rk4Answers[0][0]);
			assertEquals(b,rk4Answers[0][72]);
			assertEquals(x1,rk4Answers[1][0]);
			assertEquals(y1,rk4Answers[2][0]);
		}

	  @Test
		public void testStepSize() {
			assertEquals(rk4Answers[0][5]-rk4Answers[0][4], 0.25, 0.01);
		}

	  @Test
		public void testAnswers() {
		  try {
				String dir = new File( "." ).getCanonicalPath();
				File in = new File(dir + "/src/test/resources/test_files/demos/Prob2/Prob2.in");
				scan = new Scanner(in);
				//getting X-values
				String line = scan.nextLine();
				values = line.split(",");
				expectedX = new double[values.length];
					for(i = 0; i < values.length; i++)
				{
	    					expectedX[i] = Double.parseDouble(values[i]);
				}
			
				//getting Y-values
				line = scan.nextLine();
				values = line.split(",");
				expectedY = new double[values.length];
					for(i = 0; i < values.length; i++)
				{
	    					expectedY[i] = Double.parseDouble(values[i]);
				}

					
				
			} catch (Exception e){
				e.printStackTrace();
				assertTrue(false);
			}

	    for (int i = 0; i < expectedX.length; i++)
				assertEquals(rk4Answers[1][i], expectedX[i], 0.00000000001);


			for (int i = 0; i < expectedY.length; i++)
				assertEquals(rk4Answers[2][i], expectedY[i], 0.00000000001);

		}

	}