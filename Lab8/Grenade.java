import java.util.NoSuchElementException;

public class Grenade 
{
      private double xCoordinate;
      private double yCoordinate;
      public static int MaximumDamage = 150;
      public static int DamageRange = 250;

      public Grenade(double x, double y)
      {
    	  if(x<0||y<0)
    	  {
    		  throw new ArithmeticException("Coordinate out of boundary");
    	  }
    	  this.xCoordinate=x;
          this.yCoordinate=y;
      }

      public void explode(Damageable[] damageable)
      {
    	  //Iteratively call getBombed() of each implemented interface.
    	  for(int i=0;i<8;i++)
    	  {
    		  if(damageable[i]==null)
    		  {
    			  throw new NoSuchElementException("damaeagle interface at index "+i+" doesn't exist!");
    		  }
    		  
    		  damageable[i].getBombed(this);
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

