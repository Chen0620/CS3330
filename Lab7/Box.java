public class Box implements Damageable
{
      private double xCoordinate;
      private double yCoordinate;   

      public Box(int x,int y)
      {
            this.xCoordinate=x;
            this.yCoordinate=y;
      }

      public void getBombed(Grenade grenade) 
      {
            double distBox=MyMath.calDistance(this.xCoordinate,this.yCoordinate,grenade.getX(),grenade.getY());
            if(distBox<=grenade.DamageRange)
            {
            	this.destroyed();
            }
            else
            {
            	System.out.println("Box is out of grenade's damage range");
            }
      }

      private void destroyed()
      {
            System.out.println("A box is destroyed!");
      }
}