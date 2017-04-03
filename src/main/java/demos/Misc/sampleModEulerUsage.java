/*
This is a sample usage of the modified euler function
*/

package demos.Misc;

import dionne_peter_caiipan.odeModEuler;

import java.util.Scanner;
import java.io.*;

public class sampleModEulerUsage {
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        double a, b, h, yINI;
        String enter;

        System.out.print("Enter a : ");
        a = Double.parseDouble(in.nextLine());
        System.out.print("Enter b : ");
        b = Double.parseDouble(in.nextLine());
        System.out.print("Enter h : ");
        h = Double.parseDouble(in.nextLine());
        System.out.print("Enter yINI : ");
        yINI = Double.parseDouble(in.nextLine());

        System.out.print("Please make sure that the ODE function in the class \nODE is named ODE. Press enter to continue.");
        enter = in.nextLine();

        odeModEuler M = new odeModEuler(a, b, h, yINI);
        printOutputGraphPlots(M.xArray, M.yArray);
        makeCSV(M.xArray, M.yArray);
    }

    public static void printOutputGraphPlots(double[] x, double[] y) {
        System.out.println("X\tdX");
        int n = x.length;

        for(int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\n", x[i], y[i]);
        }
    }

    public static void makeCSV(double[] x, double[] y) {
        int n = x.length;
        try{
            PrintWriter writer = new PrintWriter("ModEulerOutput.csv", "UTF-8");
            writer.println("X,dX");
            for(int i = 0; i < n; i++) {
                writer.printf("%.2f,%.2f\n", x[i], y[i]);
            }
            writer.close();
        } catch (IOException e) {
           // do something
        }
    }
}
