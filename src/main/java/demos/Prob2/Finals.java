/*
* Copyright (c) 2016 CS 131 1st Semester. All rights reserved.
*/

package webarebears.prob2branch;

/**
 * CS 131 Finals
 * Faith Therese Pena
 * Gerard Arel Latoga
 *
 *
 * To run:
 * $ javac -cp ":mxparser.jar" Finals.java RK4Class.java Graph.java
 * $ java -cp ":mxparser.jar" Finals
 *
 * Results are stored in text.csv
 *
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.*;
import javax.swing.*;

public class Finals {
	
	static Double [][] rk4Answers;
	static Double[] tValues;
	static Double[] xValues;
	static Double[] yValues; 
	
	static int didItGraph = 0;
	static int didItExport = 0;

	static Double a = 0d;
	static Double b = 18d;
	static Double h = 0.25d;
	static Double x1 = Math.PI/2d;
	static Double y1 = 0d;
	
	
	public static void main(String[] args) {
		getRK4();
		showGraph();
		exportToCSV();
	}
	
    public static void getRK4(){
    	 rk4Answers = RK4Class.RK4("y", "-(0.16/0.5)*y - (9.81/1.2)*sin(x)", a, b, h, x1, y1);
    	 tValues = rk4Answers[0];
         xValues = rk4Answers[1];
         yValues = rk4Answers[2];
    }
    
    public static void showGraph(){
    	Frame frm = new Graph(tValues, xValues);
        frm.show();
        didItGraph = 1;
    }
    
    public static void exportToCSV(){
    	FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("text.csv");
            bw = new BufferedWriter(fw);

            bw.write("t,x,y" + '\n');

            for (int i = 0; i < tValues.length; i++) {
                bw.write(tValues[i] + ", " + xValues[i] + ", " + yValues[i]+ '\n');
            }
            didItExport = 1;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bw.close();
                fw.close();
            }
            catch (IOException f) {
            }
        }
    }
      
    public static int checkExport() {
    	return didItExport;
    }
    
    public static int checkGraph() {
    	return didItGraph;
    }
}