/*
This class is almost direct translation of the octave script odeModEuler.
Please make sure that the ODE function in the class ODE is named ODE
and accepts exactly two double inputs.
*/

package dionne_peter_caiipan;

public class odeModEuler {
    public double xArray[];
    public double yArray[];
    public double SlopeEu, yEu, SlopeEnd;
    public odeModEuler(double a, double b, double h, double yINI) {
        ODE O = new ODE();
        int N = (int)Math.round((b-a) / h);
        xArray = new double[N];
        yArray = new double[N];

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
