//Anthony Verslues
//AJVXV3
//12276595

import java.lang.Math;

public class MyMath
{

	public static final double alpha = 5.87;
	
	//constructor
	MyMath()
	{
	
	}

	public static double calDistance(double x1, double y1, double x2, double y2)
	{
		double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		return distance;
	}



}