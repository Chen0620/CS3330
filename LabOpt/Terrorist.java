import java.io.Serializable;

public class Terrorist implements Serializable
{
	private int healthPoint;
	private static final int maxHealthPoint=100;
	private double xCoordinate;
	private double yCoordinate;
	private String name;
	private Rifle weapon;
	
	Terrorist(int healthArg, double xArg, double yArg, String nameArg, Rifle weaponArg)
	{
		this.healthPoint=healthArg;
		this.xCoordinate=xArg;
		this.yCoordinate=yArg;
		this.name=nameArg;
		this.weapon=weaponArg;
		System.out.println("Player "+getName()+" was created, with weapon "+getWeapon()+" in hand.");
	}
	
	public Rifle getWeapon()
	{
		return weapon;
	}
	
	public int getHealthPoint()
	{
		return healthPoint;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getX()
	{
		return xCoordinate;
	}
	
	public double getY()
	{
		return yCoordinate;
	}
}
