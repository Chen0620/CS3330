import java.util.Random;

public enum Rifle 
{
	M4A1("Colt M4A1 Carbine", 0.45),
	AUG("Steyr AUG", 0.4),
	AK47("AK-47", 0.3),
	SG552("Sauer SG-552 Commando", 0.35);
	
	private final double minAccuracy;
	private final String name;
	
	//constructor
	private Rifle(String Name, double accuracy)
	{
		this.minAccuracy=accuracy;
		this.name=Name;
	}

	public double getAccuracy()
	{
		Random myRandy = new Random();
		double acc = ((myRandy.nextDouble()) *(1-minAccuracy))+minAccuracy;
		return acc;
	}
}