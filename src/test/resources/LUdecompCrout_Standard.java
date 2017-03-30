/*
 * code obtained from http://www.sci.utah.edu/~wallstedt/LU.htm
 */
public class LUdecompCrout_Standard {
	public static double [][][] formatCrout(double[][] D){
		double [][] L = new double[D.length][D[0].length];
		double [][] U = new double[D.length][D[0].length];
		
		for (int i = 0; i < L.length; i++){
			for (int j = 0; j < i+1; j++){
				L[i][j] = D[i][j];
				U[U.length-1-i][U[0].length-1-j] = D[U.length-1-i][U[0].length-1-j];
			}
			U[U.length-1-i][U[0].length-1-i] = 1.0;
		}
		
		/*
		System.out.println("Gold Standard: ");
		   System.out.println("Matrix L: ");
		   for (int i = 0; i < L.length; i++){
			   System.out.println(java.util.Arrays.toString(L[i]));
		   }
		   System.out.println("Matrix U: ");
		   for (int i = 0; i < U.length; i++){
			   System.out.println(java.util.Arrays.toString(U[i]));
		   }
		*/
		
		double [][][] LU = {L, U};
		return LU;
	}
	public static double[][][] Crout(int d, double[][] S,double[][] D){
	   for(int k=0;k<d;++k){
	      for(int i=k;i<d;++i){
	         double sum=0.;
	         for(int p=0;p<k;++p)sum+=D[i][p]*D[p][k];
	         D[i][k]=S[i][k]-sum; // not dividing by diagonals
	      }
	      for(int j=k+1;j<d;++j){
	         double sum=0.;
	         for(int p=0;p<k;++p)sum+=D[k][p]*D[p][j];
	         D[k][j]=(S[k][j]-sum)/D[k][k];
	      }
	   }
	   return formatCrout(D);
	}
	public static double[] solveCrout(int d,double[][] LU,double[] b,double[] x){
	   double y[] = new double[d];
	   for(int i=0;i<d;++i){
	      double sum=0.;
	      for(int k=0;k<i;++k)sum+=LU[i][k]*y[k];
	      y[i]=(b[i]-sum)/LU[i][i];
	   }
	   for(int i=d-1;i>=0;--i){
	      double sum=0.;
	      for(int k=i+1;k<d;++k)sum+=LU[i][k]*x[k];
	      x[i]=(y[i]-sum); // not dividing by diagonals
	   }
	   return x;
	}
	
}
