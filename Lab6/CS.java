import java.util.Random;

public class CS
{
  public static void main(String[] args) 
  {
        // Create a Random object;
        Random myRandom = new Random();

        //Create an array named “all”, size 6, type? you decide
        Player all[];
        all=new Player[6];
        
        // Create 3 Terrorist player and 3 CounterTerrorist player with health point, initial location coordinates, player name, and weapon.
        Terrorist T1 = new Terrorist(100, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "BoyInHell", "AK47");
        Terrorist T2 = new Terrorist(99, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "HisBrother", "AK47");
        Terrorist T3 = new Terrorist(98, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Vincent", "AK47");
        CounterTerrorist CT1 = new CounterTerrorist(97, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Bingo", "AK47");
        CounterTerrorist CT2 = new CounterTerrorist(96, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Cops", "AK47");
        CounterTerrorist CT3 = new CounterTerrorist(95, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Terry", "AK47");

       //Put the references of your objects into the array you created
        all[0]=T1;
        all[1]=CT2;
        all[2]=T3;
        all[3]=CT1;
        all[4]=T2;
        all[5]=CT3;
        
        System.out.println();

        for(int i = 0; i < 6; i++)
        {
        	all[i].beingShot(all[i].getX(), all[i].getY(), AK47.getAccuracy());
        	System.out.println("After being shot, "+all[i].getName()+" has "+all[i].getHealthPoint()+" health points.");

        }

        //Sort the array
        System.out.println();
        System.out.println("Print in ascending order...");
        
        Player sorted[];
        sorted=new Player[1];
        for(int i=0;i<6;i++)
        {
        	for(int j=i+1;j<6;j++)
        	{
        		if(all[i].getHealthPoint()>all[j].getHealthPoint())
        		{
        			sorted[0]=all[j];
        			all[j]=all[i];
        			all[i]=sorted[0];
        		}
        	}
        	System.out.println(all[i].getClass().getName()+" "+all[i].getName()+": "+all[i].getHealthPoint()+" health points.");
        }
    }
}