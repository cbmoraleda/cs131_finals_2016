/*
This class is almost direct translation of the octave script odeModEuler.
Please make sure that the ODE function in the class ODE is named ODE
and accepts exactly two float inputs.
*/

package dionne_peter_caiipan;

public class odeModEulerTest {
    public float xArray[];
    public float yArray[];
    public float SlopeEu, yEu, SlopeEnd;
    public void odeModEuler(float a, float b, float h, float yINI) {
        ODE O = new ODE();
        int N = Math.round((b-a) / h);
        xArray = new float[N];
        yArray = new float[N];

        xArray[0] = a;
        yArray[0] = yINI;

        for(int i = 0; i < N-1; i++) {
            xArray[i+1] = xArray[i] + h;
            //SlopeEu = O.func(xArray[i], yArray[i]);
            SlopeEu = xArray[i] * yArray[i];
            yEu = yArray[i] + SlopeEu * h;
            //SlopeEnd = O.func(xArray[i+1], yEu);
            SlopeEnd = xArray[i+1] * yEu;
            yArray[i+1] = yArray[i] + (SlopeEu+SlopeEnd) * h/2;
        }
    }
}
