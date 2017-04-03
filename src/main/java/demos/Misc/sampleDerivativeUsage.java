/*
This is a sample usage of the derivative function.
*/

package demos.Misc;

import java.util.Scanner;
import java.io.*;
import dionne_peter_caiipan.Derivative;

public class sampleDerivativeUsage {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        double x[], y[];
        String enter;

        // place the x array here
        x = new double[] {1,2,3,4,5};
        // place the y array here
        y = new double[] {2,4,6,8,10};

        Derivative D = new Derivative(x,y);
        printOutputGraphPlots(x, D.dx);
        makeCSV(x, D.dx);
    }

    public static void printOutputGraphPlots(double[] x, double[] y) {
        System.out.println("X\tY");
        int n = x.length;

        for(int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\n", x[i], y[i]);
        }
    }

    public static void makeCSV(double[] x, double[] y) {
        int n = x.length;
        try{
            PrintWriter writer = new PrintWriter("DerivativeOutput.csv", "UTF-8");
            writer.println("X,Y");
            for(int i = 0; i < n; i++) {
                writer.printf("%.2f,%.2f\n", x[i], y[i]);
            }
            writer.close();
        } catch (IOException e) {
           // do something
        }
    }
}
