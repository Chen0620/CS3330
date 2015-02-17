public class Player implements Damageable, Comparable
{
	private int healthPoint;
	private static final int maxHealthPoint = 100;
	private double xCoordinate;
	private double yCoordinate;
	private String name;
	private Rifle weapon;
	
	Player(int hp, double x, double y, String playername, Rifle playerweapon) throws NullPointerException,ArithmeticException
	{
		if(playername==null)
			throw new NullPointerException("Player name can not be null!");
		if(playerweapon==null)
			throw new NullPointerException("weapon can not be null!");
		if(hp<=0)
			throw new ArithmeticException("Health Point must be non negative!");
		if(x>800||x<0||y<0||y>800)
			throw new ArithmeticException("Coordinate out of boundary");
		name = playername;
		healthPoint = hp;
		xCoordinate = x;
		yCoordinate = y;
		weapon = playerweapon;
		System.out.println("Player "+name+" was created, with weapon " + getWeapon() + " in hand");
	}
	
	private void beingShot(double x, double y, double accuracy)
	{
		double dist = MyMath.calDistance(x, y, xCoordinate, yCoordinate);
		double theta =  accuracy * (1/(Math.log(Math.pow(Math.sqrt(MyMath.alpha),Math.log(dist)))/Math.log(10)));
		int pointOfLoss = (int)(maxHealthPoint * theta);
        reduceHealth(pointOfLoss);

	}
	
	public void beingShot(Player shooter)
	{
		this.beingShot(shooter.xCoordinate, shooter.yCoordinate, shooter.getWeapon().getAccuracy());
	}
	
	//create reduce health method
	public void reduceHealth(int pointOfLoss)
	{
	    healthPoint = healthPoint - pointOfLoss;
			if(healthPoint <= 0){
				healthPoint = 0;
				die();
			}
	}
	
	//create die method
	protected void die()
	{
		System.out.println(name + " was killed");
	}
	
	//create get weapon method
	public Rifle getWeapon()
	{
		return weapon;
	}
	
	//get healthpoint
	public int getHealthPoint()
	{
		return healthPoint;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void getBombed(Grenade grenade) 
	{
		double dist = MyMath.calDistance(grenade.getX(), grenade.getY(), xCoordinate, yCoordinate);
		
		if(dist<=Grenade.DamageRange)
		{
		int pointOfLoss = (int)((dist/Grenade.DamageRange) * Grenade.MaximumDamage);
        reduceHealth(pointOfLoss);
        System.out.println(name+" loses "+pointOfLoss+" health points.");
		}
		else
		{
			System.out.println(name+" is out of grenade's damage range");
		}
		
	}

	public int compareTo(Object o1) 
	{
		if (this.healthPoint == ((Player) o1).healthPoint)
            return 0;
        else if ((this.healthPoint) > ((Player) o1).healthPoint)
            return 1;
        else
            return -1;
	}
}