/*
This class is almost direct translation of the octave script odeModEuler.
Please make sure that the ODE function in the class ODE is named ODE
and accepts exactly two float inputs.
*/

package dionne_peter_caiipan;
import static org.junit.Assert.*;
import org.junit.Test;

public class odeModEulerTest {
    odeModEuler odeModEulerFunc = new odeModEuler();

    @Test
    public void testOdeModEulerExample() {
        double a = 0;
        double b = 1;
        double h = 0.1;
        double yINI = 1;
        int N = (int)Math.round((b-a) / h);

        double[] expected = new double[N];
        expected[0] = 1.00000;
        expected[1] = 1.00500;
        expected[2] = 1.02018;
        expected[3] = 1.04599;
        expected[4] = 1.08322;
        expected[5] = 1.13305;
        expected[6] = 1.19707;
        expected[7] = 1.27739;
        expected[8] = 1.37677;
        expected[9] = 1.49876;

        odeModEulerFunc.odeModEuler(a, b, h, yINI);

        double[] actual = odeModEulerFunc.yArray;

        assertArrayEquals("Ode modified must pass simple example", expected, actual, 0.00001);
    }
}
