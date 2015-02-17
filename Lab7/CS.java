import java.util.Random;

public class CS
{
  public static void main(String[] args) 
  {
        // Create a Random object;
        Random myRandom = new Random();
 
        Player all[];
        all=new Player[6];
        Damageable damageable[];
        damageable=new Damageable[8];
       
        // Create 3 Terrorist player and 3 CounterTerrorist player, and set the health point,set the initial location as (x, y),
        // set player name in game, and weapon in hand
        Terrorist T1 = new Terrorist(100, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "BoyInHell", "AK47");
        Terrorist T2 = new Terrorist(99, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "HisBrother", "AK47");
        Terrorist T3 = new Terrorist(98, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Vincent", "AK47");
       
        CounterTerrorist CT1 = new CounterTerrorist(97, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Bingo", "AK47");
        CounterTerrorist CT2 = new CounterTerrorist(96, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Cops", "AK47");
        CounterTerrorist CT3 = new CounterTerrorist(95, 800 * myRandom.nextDouble(), 800 * myRandom.nextDouble(), "Terry", "AK47");
     
         Box box1 = new Box(250,250);
         Box box2 = new Box(100,100); 
         
        //Initialize Lists;
         all[0]=T1;
         all[1]=CT2;
         all[2]=T3;
         all[3]=CT1;
         all[4]=T2;
         all[5]=CT3;       
         damageable[0]=T1;
         damageable[1]=T2;
         damageable[2]=T3;   
         damageable[3]=CT1;
         damageable[4]=CT2;
         damageable[5]=CT3;
         damageable[6]=box1;
         damageable[7]=box2;
         
        System.out.println(); 
        Grenade grenade = new Grenade(400,400);
        grenade.explode(damageable);       
 
        //(Sort the array, using Comparable interface to compare two objects)
        System.out.println();
        System.out.println("Print in ascending order...");
 
        Player sorted[];
        sorted=new Player[1];
        for(int i=0;i<6;i++)
        {
        	for(int j=i+1;j<6;j++)
        	{
        		if(all[i].compareTo(all[j])==1)
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
     

