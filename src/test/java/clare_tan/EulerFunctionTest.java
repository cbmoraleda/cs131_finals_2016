package clare_tan;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import java.io.*;
import org.mariuszgromada.math.mxparser.*;

/**
 * Created by jerryleegeronimo on 21/02/2017.
 */
public class EulerFunctionTest {
    EulerFunction eulerFunc = new EulerFunction();

    public double[] convert_to_double_array(String[] stringArray) {
      double[] result = new double[stringArray.length];

      for(int i = 0; i < stringArray.length; i++) {
        result[i] = Double.parseDouble(stringArray[i]);
      }

      return result;
    }

    @Test
    public void testOdeEulerExample() {
      try {
    		String dir = new File( "." ).getCanonicalPath();
    		File file = new File(dir + "/src/test/resources/test_files/clare_tan/EulerFunction.in");
        Scanner scanner = new Scanner(file);
        String checker = "";
        do{
          checker = scanner.nextLine();
        } while(checker.charAt(0) == '#');
        int testCases = Integer.parseInt(checker);
        for(int k = 0; k < testCases; k++) {
          System.out.println("Test Case: " + (int)(k+1));

          double t0 = Double.parseDouble(scanner.nextLine());
          double t1 = Double.parseDouble(scanner.nextLine());
          double stepSize = Double.parseDouble(scanner.nextLine());
          double y0 = Double.parseDouble(scanner.nextLine());
          double threshold = Double.parseDouble(scanner.nextLine());
          String odeString = scanner.nextLine();
          String expectedString = scanner.nextLine();
          int n = ((int) Math.ceil((t1-t0)/stepSize)) + 1;

          Function ode = new Function(odeString);
          expectedString = expectedString.substring(1, expectedString.length() -1);
          String[] expectedStringArray = expectedString.split(",");
          double[] expected = convert_to_double_array(expectedStringArray);

          eulerFunc.odeEuler(ode, t0, t1, stepSize, y0);
          double[] result = eulerFunc.getyValues();

          double[] actual = new double[expected.length];
          if (result.length == expected.length) {
            actual = result;
          } else {
            for (int i = 0; i <= 10; i ++) {
                actual[i] =  result[result.length/10*i];
            }
          }

          assertArrayEquals("Ode must past example", expected, actual, threshold);
        }
      } catch (Exception e) {
        e.printStackTrace();
        assertTrue(false);
      }
    }
}
