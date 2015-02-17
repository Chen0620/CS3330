public class MyMath 
{
	public final static double alpha = 5.87;
	public static double calDistance(double x1, double y1, double x2, double y2)
	{
		double dist = Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) );
		return dist;
	}
}