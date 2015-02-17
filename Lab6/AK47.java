import java.util.Random;

public class AK47 
{
	private static final double minAccuracy=0.3;
	
	public static double getAccuracy()
	{
		Random rand = new Random();
		double randNum = rand.nextDouble();
		
		// generate an random number from [minAccuracy, 1)
		double accuracy = (1 - randNum * (1 - minAccuracy));
		return accuracy;
	}
}
