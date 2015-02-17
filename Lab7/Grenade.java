public class Grenade 
{
      private double xCoordinate;
      private double yCoordinate;
      public static int MaximumDamage = 150;
      public static int DamageRange = 250;

      public Grenade(double x, double y)
      {
            this.xCoordinate=x;
            this.yCoordinate=y;
      }

      public void explode(Damageable[] damageable)
      {
    	  //Iteratively call getBombed() of each implemented interface.
    	  for(int i=0;i<8;i++)
    	  {
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

