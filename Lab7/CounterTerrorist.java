public class CounterTerrorist extends Player
{
	private static int numOfAlive=0;
	
	CounterTerrorist(int healthArg, double xArg, double yArg, String nameArg, String weaponArg)
	{
		super(healthArg,xArg,yArg,nameArg,weaponArg);
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
	protected void die()
	{
		removeOnePlayer();
		System.out.println(this.getName()+" was killed!");
	}
	
	public static int getNumOfAlive()
	{
		return numOfAlive;
	}
	
}
