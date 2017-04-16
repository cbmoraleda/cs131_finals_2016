/*
This class is almost direct translation of the octave script odeModEuler.
Please make sure that the ODE function in the class ODE is named ODE
and accepts exactly two float inputs.
*/

package dionne_peter_caiipan;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import org.junit.Test;

public class odeModEulerTest {
    odeModEuler odeModEulerFunc = new odeModEuler();

    public double[] convert_to_double_array(String[] stringArray) {
      double[] result = new double[stringArray.length];

      for(int i = 0; i < stringArray.length; i++) {
        result[i] = Double.parseDouble(stringArray[i]);
      }

      return result;
    }

    @Test
    public void testOdeModEulerExample() {
        try {
          String dir = new File( ".").getCanonicalPath();
      		File file = new File(dir + "/src/test/resources/test_files/dionne_peter_caiipan/odeModEuler.in");
          Scanner scanner = new Scanner(file);
          double a = Double.parseDouble(scanner.nextLine());
          double b = Double.parseDouble(scanner.nextLine());
          double h = Double.parseDouble(scanner.nextLine());
          double yINI = Double.parseDouble(scanner.nextLine());
          int N = (int)Math.round((b-a) / h);

          String expectedString = scanner.nextLine();
          expectedString = expectedString.substring(1, expectedString.length()-1);
          String[] expectedStringArray = expectedString.split(",");
          double[] expected = convert_to_double_array(expectedStringArray);

          odeModEulerFunc.odeModEuler(a, b, h, yINI);

          double[] actual = odeModEulerFunc.yArray;

          assertArrayEquals("Ode modified must pass simple example", expected, actual, 0.00001);
        } catch (Exception e) {
          e.printStackTrace();
          assertTrue(false);
        }
    }
}
