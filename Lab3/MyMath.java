public class MyMath 
{
	private static final double alpha=5.87;
		
	public static double calDistance(double x1, double y1, double x2, double y2)
	{
		double dist=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));//calculate the distance between point (x1, y1) and point (x2, y2);
        return dist;
	}
	
	public static double getAlpha()
	{
		return alpha;
	}
}

