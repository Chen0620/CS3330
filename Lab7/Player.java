import java.lang.Comparable;

public class Player implements Damageable,Comparable 
{
	private int healthPoint;
	private static final int maxHealthPoint=100;
	private double xCoordinate;
	private double yCoordinate;
	private String name;
	private String weapon;
	
	Player(int health, double x, double y,String nameArg,String weaponArg)
	{
		healthPoint=health;
		xCoordinate=x;
		yCoordinate=y;
		name=nameArg;
		weapon=weaponArg;
	}
	
	public void beingShot(double x,double y,double accuracy)
	{
		double dist = MyMath.calDistance(x, y, xCoordinate, yCoordinate);
        double theta = accuracy/Math.log10(Math.sqrt(MyMath.alpha*Math.log(dist)));
        int pointOfLoss = (int) (this.getHealthPoint()*theta);
        reduceHealth(pointOfLoss);
	}
	
	public void reduceHealth(int pointOfLoss)
	{
		healthPoint =this.getHealthPoint() - pointOfLoss;
        if(healthPoint <= 0)
        {
            healthPoint=0;
        	die();
        }
        
	}
	
	protected void die()
	{
		System.out.print(this.getName()+" was killed!!!");
	}
	
	public String getWeapon()
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
	
	@Override
	public void getBombed(Grenade grenade)
	{
		double distPlayer=MyMath.calDistance(this.xCoordinate,this.yCoordinate,grenade.getX(),grenade.getY());
		if(distPlayer<grenade.DamageRange)
		{
			double HPLoss=(distPlayer/grenade.DamageRange)*grenade.MaximumDamage;
			reduceHealth((int)HPLoss);
			System.out.println(name+" loses "+(int)HPLoss+" health points.");
		}
		else
			System.out.println(name+" is out of grenade's damage range");
		
	}
	
	@Override
	public int compareTo(Object o)
	{
		double thisValue=this.getHealthPoint();
		double thatValue=((Player)o).getHealthPoint();
		
		if(thisValue>thatValue)
			return 1;
		else if(thisValue==thatValue)
			return 0;
		else return -1;
	}
}
