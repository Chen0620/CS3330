public class Terrorist 
{
	private int healthPoint;
	private static final int maxHealthPoint=100;
	private double xCoordinate;
	private double yCoordinate;
	private String name;
	private String weapon;
	private static int numOfAlive=0;
	
	public Terrorist(int healthArg, double xArg, double yArg, String nameArg, String weaponArg)
	{
		setName(nameArg);
		setWeapon(weaponArg);
		healthPoint=healthArg;
		xCoordinate=xArg;
		yCoordinate=yArg;
		addOnePlayer();
		
		System.out.println(getName()+" player was created, with weapon "+getWeapon()+" in hand.");
	}
	
	public void setName(String nameArg)
	{
		name=nameArg;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addOnePlayer()
	{
		numOfAlive++;
	}
	
	public void removeOnePlayer()
	{
		numOfAlive--;
	}
	
	public void beingShot(double x, double y, double accuracy)
	{
        // call the calDistance method defined in class MyMath. 
        // x and y are the coordinates of the people who open fire
        // xCoordinate and yCoordinate are the location of this object
        double dist = MyMath.calDistance(x, y, xCoordinate, yCoordinate);
        System.out.println("Distance between shooter and victim is " + dist);
        // theta should be calculated based on the formula described 
        // in lab description. It can be calculated using Java's Math class and MyMath class
        // Check Java Math class API for how to use it
        double theta = accuracy/Math.log10(Math.sqrt(MyMath.getAlpha()*Math.log(dist)));
        System.out.println("theta is " + theta);
        int pointOfLoss = (int) (maxHealthPoint*theta);
        System.out.println("health point lost is " + pointOfLoss);
        reduceHealth(pointOfLoss);
    }
	
	public void reduceHealth(int pointOfLoss)
	{
        healthPoint = healthPoint - pointOfLoss;
        if(healthPoint <= 0)
        {
            die();
        }
    }
	
	public void die()
	{
		removeOnePlayer();
		System.out.println("Terrorist was killed");
	}
	
	public static int getNumOfAlive()
	{
		return numOfAlive;
	}
	
	public void setWeapon(String weaponArg)
	{
		weapon=weaponArg;
	}
	
	public String getWeapon()
	{
		return weapon;
	}
	
	public int getHealthPoint()
	{
		return healthPoint;
	}
}
