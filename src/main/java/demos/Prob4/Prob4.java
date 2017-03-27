package demos.Prob4;
import jerick_callado.*;
public class Prob4 {
	 private static Double[] theXValues, theYValues, theTimeValues;
	 private static double theNumTimeIntervals;
	 public static void main(String args[]){
		something();
	        
	 }
	 
	public static void something(){
		 int i=0;
	        Double xInitial = 500.00;
	        Double yInitial = 3000.00;
	        Double timeInitial = 0.00;
	        Double timeFinal = 25.00;
	        Double stepSize = 0.0025;
	        
	        theNumTimeIntervals = (timeFinal-timeInitial)/stepSize;
	        
	        driverRK4 rkSolver = new driverRK4();
	        rkSolver.setXYTs(timeInitial, timeFinal, stepSize, xInitial, yInitial);
	        theXValues = rkSolver.getXValues();
	        theYValues = rkSolver.getYValues();
	        theTimeValues = rkSolver.getTimeValues();
//	        for(i=1; i<=30; i++){
//	        	System.out.println(theYValues[i] + ", ");
//	        }
	}
	 
	public Double[] getX(){
		return theXValues;
	}
	
	public Double[] getY(){
		return theYValues;
	}
}
