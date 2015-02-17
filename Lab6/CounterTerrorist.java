
public class CounterTerrorist extends Player
{
	private int healthPoint;
	private double xCoordinate;
	private double yCoordinate;
	private String weapon;
	private static int numOfAlive=0;
	
	public CounterTerrorist(int healthArg, double xArg, double yArg, String nameArg, String weaponArg)
	{
		super(healthArg,xArg,yArg,nameArg);
		setWeapon(weaponArg);
		addOnePlayer();
		
		System.out.println(getName()+" player was created, with weapon "+getWeapon()+" in hand.");
	}
	
	public void addOnePlayer()
	{
		numOfAlive++;
	}
	
	public void removeOnePlayer()
	{
		numOfAlive--;
	}
	
	@Override
	public void beingShot(double x, double y, double accuracy)
	{
        double dist = MyMath.calDistance(x, y, xCoordinate, yCoordinate);
        double theta = accuracy/Math.log10(Math.sqrt(MyMath.alpha*Math.log(dist)));
        int pointOfLoss = (int) (super.getHealthPoint()*theta);
        reduceHealth(pointOfLoss);
    }
	
	public void reduceHealth(int pointOfLoss)
	{
        healthPoint =super.getHealthPoint() - pointOfLoss;
        super.setHealthPoint(healthPoint);
        if(healthPoint <= 0)
        {
            die();
        }
    }
	
	public void die()
	{
		removeOnePlayer();
		System.out.print(this.getName()+" was killed! ");
		super.setHealthPoint(0);
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
}
