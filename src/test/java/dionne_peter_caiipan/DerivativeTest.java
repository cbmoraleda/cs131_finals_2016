package dionne_peter_caiipan;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import java.io.*;
import org.mariuszgromada.math.mxparser.*;

public class DerivativeTest {

    public double[] convert_to_double_array(String[] stringArray) {
      double[] result = new double[stringArray.length];

      for(int i = 0; i < stringArray.length; i++) {
        result[i] = Double.parseDouble(stringArray[i]);
      }

      return result;
    }

    @Test
    public void testDerivativeExample() {
        try {
          String dir = new File( ".").getCanonicalPath();
      		File file = new File(dir + "/src/test/resources/test_files/dionne_peter_caiipan/Derivative.in");
          Scanner scanner = new Scanner(file);
          String xString = scanner.nextLine();
          String derFuncString = scanner.nextLine();
          String funcString = scanner.nextLine();
          xString = xString.substring(1, xString.length() -1);
          String[] xStringArray = xString.split(",");
          double[] x = convert_to_double_array(xStringArray);

          Function derFunc = new Function(derFuncString);
          Function func = new Function(funcString);

          double[] expectedY = new double[5];

          for(int i = 0; i < 5; i++) {
              expectedY[i] = derFunc.calculate(x[i]);
          }

          double[] y = new double[5];

          for(int i = 0; i < 5; i++) {
              y[i] = func.calculate(x[i]);
          }

          Derivative derivatives = new Derivative(x,y);
          double[] actualY = derivatives.dx;

          assertArrayEquals("Test derivative must past simple example",
                              expectedY, actualY, 0.1);
        } catch (Exception e) {
          e.printStackTrace();
          assertTrue(false);
        }
    }

}
