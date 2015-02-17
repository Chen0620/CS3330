import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CS 
{
	private static HashMap<String, Player> player = new HashMap<String , Player >(); //Construct a HashMap to store created players.

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Enter your Command: ");
		
		InputStreamReader inStream = new InputStreamReader(System.in) ; 
		BufferedReader reader = new BufferedReader(inStream);// Construct a BufferedReader to read from Stdin.
		String line = null;                            
	    
		line=reader.readLine();//Read the first line.
		System.out.println(line);
		
		/*Keep reading lines from stdin*/
		while(line!=null) 
		{	
			Scanner scanner = new Scanner(line); //Construct a scanner object.
			//scanner.close();
			String command = scanner.next(); //Read the command word first.
			
			/*Handle Create Command*/			
			if (command.equalsIgnoreCase("create")) 
			{
				String type = scanner.next();// Get all the required parameters for creating a Player.
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				String name = scanner.next();
				String weapon = scanner.next();
				int hp = scanner.nextInt();
							
				if (type.equalsIgnoreCase("CounterTerrorist")) 
				{
					try 
					{
						double xx=x;
						double yy=y;
						
						if(!weapon.equals(Rifle.AK47.name())&&!weapon.equals(Rifle.M4A1.name())&&!weapon.equals(Rifle.AUG.name())&&!weapon.equals(Rifle.SG552.name()))
						{
							throw new IllegalArgumentException("No enum const class "+weapon);
						}
						else
						{
							Rifle myRifle=Rifle.valueOf(weapon);
							CounterTerrorist ct = new CounterTerrorist(hp,xx,yy,name,myRifle);
							player.put(name, ct);
						}
					} 
					catch (NullPointerException e) 
					{
						System.out.println(e.getClass().getName()+ " was thrown when creating CounterTerrorist :"+ e.getMessage());
					} 
					catch (ArithmeticException e) 
					{
						System.out.println(e.getClass().getName()+ " was thrown when creating CounterTerrorist :"+ e.getMessage());
					} 
					catch (IllegalArgumentException e) 
					{
						System.out.println(e.getClass().getName()+"was thrown when creating CounterTerrorist :"+e.getMessage());
					}
				}

				if (type.equalsIgnoreCase("Terrorist")) 
				{
					try 
					{
						double xx=x;
						double yy=y;
						
						if(!weapon.equals(Rifle.AK47.name())&&!weapon.equals(Rifle.M4A1.name())&&!weapon.equals(Rifle.AUG.name())&&!weapon.equals(Rifle.SG552.name()))
						{
							throw new IllegalArgumentException("No enum const class Rifle."+weapon);
						}
						else
						{
							Rifle myRifle=Rifle.valueOf(weapon);
							Terrorist t = new Terrorist(hp,xx,yy,name,myRifle);
							player.put(name, t);
						}
					} 
					catch (NullPointerException e) 
					{
						System.out.println(e.getClass().getName()+ " was thrown when creating Terrorist :"+ e.getMessage());
					} 
					catch (ArithmeticException e) 
					{
						System.out.println(e.getClass().getName()+ " was thrown when creating Terrorist :"+ e.getMessage());
					} 
					catch (IllegalArgumentException e) 
					{
						System.out.println(e.getClass().getName()+"was thrown when creating Terrorist :"+e.getMessage());
					}
				}
			}
			
			/*Handle Shoot Command*/
			else if (command.equalsIgnoreCase("shoot")) 
			{
				Player shooter=player.get(scanner.next());
				Player getShot=player.get(scanner.next());
				if (shooter!=null&&getShot!=null) 
				{
					if (shooter.getClass().getName()==getShot.getClass().getName())
						System.out.println("Cannot shoot the player in the same team!");
					else 
					{
						getShot.beingShot(shooter);
						System.out.println(getShot.getName() + " has "+ getShot.getHealthPoint()+ " left after shot by " + shooter.getName());
					}
				} 
				else
					System.out.println("At least one of the player name you specified doesn't exist!");
			}

			/*Handle ExplodeGrenade Command*/
			else if (command.equalsIgnoreCase("ExplodeGrenade")) 
			{
				int x=scanner.nextInt();
				int y=scanner.nextInt();

				try{
						double xx=x;
						double yy=y;					
						Grenade grenade = new Grenade(xx,yy);
						
						Damageable[] damageable=new Damageable[player.size()];
						Set <String> keys=player.keySet();
						int i=0;
						for(String s:keys)
						{
							damageable[i]=player.get(s);
							i++;
						}
						
						grenade.explode(damageable);
					} 
				catch (ArithmeticException e) 
				{
					System.out.println(e.getClass().getName()+ " was thrown when creating Grenade :"+ e.getMessage());
				}
			}

			/*Handle Print Command*/
			else if (command.equalsIgnoreCase("print")) 
			{
				Player[] all=new Player[player.size()];
				Set <String> keys=player.keySet();
				int i=0;
				for(String s:keys)
				{
					all[i]=player.get(s);
					i++;
				}
				Arrays.sort(all);

				System.out.println("Print in ascending order...");
				for (int j=0;j<player.size();j++) 
				{
					System.out.println(all[j].getClass().getName()+" "+all[j].getName()+": "+all[j].getHealthPoint()+" health points.");
				}
			}
			else
			{
				System.out.println("Your command is invalid. Please input again.");
			}
			String next;
			next=reader.readLine();
			line=next;
		}
		if (reader != null) 
		{	try
			{ 
				reader.close(); 
			} 
			catch(IOException logOrIgnore)
			{
			}
		}
	}
}