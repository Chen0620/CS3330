import java.util.List;
import java.util.NoSuchElementException;


public class Grenade 
{
	private double xCoordinate;
	private double yCoordinate;
	public static int MaximumDamage = 150;
	public static int DamageRange = 250;
	
	public Grenade(double x, double y)throws ArithmeticException
	{
		if(x>800||x<0||y<0||y>800)
			throw new ArithmeticException("Coordinate out of boundary");
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	
	public void explode(Damageable[] damageable)throws NoSuchElementException
	{
		for(int k=0;k<damageable.length;k++)
		{
			if(damageable[k]==null)
				throw new NoSuchElementException("damaeagle interface at index "+k+" doesn't exist!");
			Damageable temp = damageable[k];
			temp.getBombed(this);
		}
	}
	
	public double getX()
	{
		return this.xCoordinate;
	}
	
	public double getY()
	{
		return this.yCoordinate;
	}
}