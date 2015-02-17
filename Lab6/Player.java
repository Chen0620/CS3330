public class Player 
{
	private double xCoordinate;
	private double yCoordinate;
	private int healthPoint;
	private String name;
	
	public Player(int health, double x, double y,String nameArg)
	{
		this.setX(x);
		this.setY(y);
		this.setName(nameArg);
		this.setHealthPoint(health);
	}
	
	protected double getX()
	{
		return xCoordinate;		
	}
	
	protected double getY()
	{
		return yCoordinate;		
	}
	
	protected String getName()
	{
		return name;
	}
	
	public int getHealthPoint()
	{
		return healthPoint;
	}
	
	public void setX(double xArg)
	{
		xCoordinate=xArg;
	}
	
	public void setY(double yArg)
	{
		yCoordinate=yArg;
	}
	
	public void setHealthPoint(int healthArg)
	{
		healthPoint=healthArg;
	}
	
	public void setName(String newName)
	{
		name=newName;
	}
	
	public void beingShot(double x, double y, double accuracy)
	{
		System.out.println(this.getName()+" was shot!!!!!\n");
	}	
}
