package dionne_peter_caiipan;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import org.mariuszgromada.math.mxparser.*;

public class DerivativeTest {
    Derivative derivativeClass = new Derivative();

    @Test
    public void testDerivativeExample() {
        double[] x = {1,2,3,4,5};
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

        double[] actualY = derivativeClass.Derivative(x,y);

        assertArrayEquals("Test derivative must past simple example",
                            expectedY, actualY, 0.001);
    }

}
