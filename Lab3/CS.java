import java.util.Random;

public class CS
{
	 public static void main(String[] args) 
	 {
	        // Create a Random object;
	        Random myRandom = new Random();
	        
	        // Generate two random numbers as the (x, y) coordinates of the location of the player
	        double x1 = 800 * myRandom.nextDouble();
	        double y1 = 800 * myRandom.nextDouble();
	        // Create a Terrorist player, and set the health point as 100, set the initial location as (x, y), 
	        // set player name in game, and weapon in hand
	        Terrorist T1 = new Terrorist(100, x1, y1, "BoyInHell", "AK47");
	        
	        // Create a Terrorist object T2;
	        double x2 = 800 * myRandom.nextDouble();
	        double y2 = 800 * myRandom.nextDouble();
	        Terrorist T2 = new Terrorist(100, x2, y2, "HisBrother", "AK47");
	        
	        // Create a CounterTerrorist object CT1;
	        double x3 = 800 * myRandom.nextDouble();
	        double y3 = 800 * myRandom.nextDouble();
	        CounterTerrorist CT1 = new CounterTerrorist(100, x3, y3, "Bingo", "AK47");
	        
	        // Create a CounterTerrorist object CT2;
	        double x4 = 800 * myRandom.nextDouble();
	        double y4 = 800 * myRandom.nextDouble();
	        CounterTerrorist CT2 = new CounterTerrorist(100, x4, y4, "Cops", "AK47");
	        
	        System.out.print("\n");
	        System.out.println("Total number of Terrorist players is " + Terrorist.getNumOfAlive());
	        System.out.println("Total number of CounterTerrorist players is " + CounterTerrorist.getNumOfAlive());
	        System.out.print("\n");
	        
	        // T1 shoots CT2
	        System.out.println("Before shooting, CT2 has " + CT2.getHealthPoint() + " health points.\n");
	        for(int i = 0; i <= 5; i++){
	            if(T1.getWeapon().equals("AK47") && CT2.getHealthPoint() >= 0){
	                // Parse the T1's (x, y) coordinates to the beingShot method of CT2
	                CT2.beingShot(x1, x2, AK47.getAccuracy());
	                System.out.println("After being shot, CT2 has " + CT2.getHealthPoint() + " health points.");
	                System.out.print("\n");
	            }
	        }
	        
	        System.out.println("Total number of Terrorist players is " + Terrorist.getNumOfAlive());
	        System.out.println("Total number of CounterTerrorist players is " + CounterTerrorist.getNumOfAlive());
	        
	 }

}
