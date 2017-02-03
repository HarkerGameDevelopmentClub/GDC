package main;

public class Util {
	
	public static double[] rotate(double x, double y, double theta){
		double rang = Math.atan(((double)y)/x) + (x < 0 ? Math.PI : 0);
		double ang = rang - theta * Math.PI/180;
		double hyp = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double[] newCoords = {Math.cos(ang) * hyp, Math.sin(ang) * hyp};
		return newCoords;
	}

}
