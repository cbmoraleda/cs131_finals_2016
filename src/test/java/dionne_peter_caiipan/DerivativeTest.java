package dionne_peter_caiipan;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.mariuszgromada.math.mxparser.*;

public class DerivativeTest {
    @Test
    public void testDerivativeExample() {
        double[] x = {1,1.1,1.2,1.3,1.4};
        Function derFunc = new Function("f(x)=2*x + 1");
        Function func = new Function("f(x) = x^2 + x");

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
    }

}
