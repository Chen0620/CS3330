import java.util.Random;
import java.util.NoSuchElementException;

public class CS 
{
	public static void main(String[] args) 
	{
	        // Create a Random object;
	       Random myRandom = new Random();
	       Player[] all = new Player[6];
	       Damageable[] damageable = new Damageable[8];
	       Terrorist T1 = null, T2 = null, T3 = null;
	       CounterTerrorist CT1 = null, CT2 = null, CT3 = null;
	       Box box1 = null, box2 = null;
	       Grenade grenade = null;
	       
	       // Create 3 Terrorist player and 3 CounterTerrorist player, and set the
	       // health point,set the initial location as (x, y),
	       // set player name in game, and weapon in hand
	       try 
	       {
	              T1 = new Terrorist(100, 800 * myRandom.nextDouble(),
	                     800 * myRandom.nextDouble(), "BoyInHell", "AK47");
	              T2 = new Terrorist(99, 800 * myRandom.nextDouble(),
	                     800 * myRandom.nextDouble(), "HisBrother", "AK47");
	              T3 = new Terrorist(98, 800 * myRandom.nextDouble(),
	                     800 * myRandom.nextDouble(), null, "AK47");
	       } 
	       catch (NullPointerException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[1].getClassName()+" :"+e.getMessage());
	       } 
	       catch (ArithmeticException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[1].getClassName()+" :"+e.getMessage());
	       }
	
	       try 
	       {
	    	   CT1 = new CounterTerrorist(97, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Bingo", "AK47");
	           CT2 = new CounterTerrorist(96, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Cops", "AK47");
	           CT3 = new CounterTerrorist(0, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Terry", "AK47");
	       } //Missing
	       catch (NullPointerException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[1].getClassName()+" :"+e.getMessage());
	       } 
	       catch (ArithmeticException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[1].getClassName()+" :"+e.getMessage());
	       }
	       
	       try 
	       {
	    	   box1 = new Box(250, 250);
	           box2 = new Box(-1, 100);
	       } //Missing
	       catch (ArithmeticException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[0].getClassName()+" :"+e.getMessage());
	       }
	       
	       all[0] = T1;
	       all[1] = CT2;
	       all[2] = T3;
	       all[3] = CT1;
	       all[4] = T2;
	       all[5] = CT3;
	       damageable[0] = T1;
	       damageable[1] = T2;
	       damageable[2] = T3;
	       damageable[3] = CT1;
	       damageable[4] = CT2;
	       damageable[5] = CT3;
	       damageable[6] = box1;
	       damageable[7] = box2;
	
	       try 
	       {
	    	   grenade = new Grenade(400, 400);
	       } //Missing
	       catch (ArithmeticException e) 
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when creating "+array[0].getClassName()+" :"+e.getMessage());
	       }
	       	       
	       try 
	       {
	    	   grenade.explode(damageable);
	       } //Missing
	       catch(NoSuchElementException e)
	       {
	    	   StackTraceElement[] array=e.getStackTrace();
	    	   System.out.println(e.getClass().getName()+" was thrown when "+array[0].getClassName()+" explodes :"+e.getMessage());
	       }
	       
	       finally
	       {
	    	   
	       }
	       
	}
}