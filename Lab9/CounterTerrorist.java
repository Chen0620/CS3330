//Anthony Verslues
//AJVXV3
//12276595

import java.lang.Math;

public class CounterTerrorist extends Player
{
	private static int numOfAlive = 0;
	
	//constructor
	CounterTerrorist(int hp, double x, double y, String playername, Rifle playerweapon)
	{
		super(hp, x, y, playername, playerweapon);
		addOnePlayer();	
	}
	
	//create add one player method
	public void addOnePlayer()
	{
		numOfAlive++;
	}
	
	//create remove one player 
	public void removeOnePlayer()
	{
		numOfAlive--;
	}
	
	//create die method
	@Override
	protected void die()
	{
		super.die();
		removeOnePlayer();
	}
	
	//create get number of alive method
	public static int getNumOfAlive()
	{
		return numOfAlive;
	}
}