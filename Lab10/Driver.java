import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.IdentityHashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Driver 
{
	private static IdentityHashMap<Integer, Shape> shape = new IdentityHashMap<Integer, Shape>();
	
	public static void main(String[] args) throws IOException
	{
		//create file: output.txt  
        File file = new File("output.txt");  
        if (file.exists()) 
        {     
            file.delete();  
        }                 
        file.createNewFile();  
        BufferedWriter output = new BufferedWriter(new FileWriter(file)); 
		
		System.out.println("Enter your Command: (Be sure to enter end-of-line indicator when you're done with the program. Window:ctrl+z UNIX/Mac:Enter+Ctrl+d)");
		output.write("Enter your Command: (Be sure to enter end-of-line indicator when you're done with the program. Window:ctrl+z UNIX/Mac:Enter+Ctrl+d)");
		output.newLine();
		output.newLine();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try 
		{
			line = reader.readLine();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		while (line != null) 
		{
			Scanner scanner = new Scanner(line);
			output.write(line);
			output.newLine();
			String command = scanner.next();
			if (command.equalsIgnoreCase("create")) 
			{
				String type=scanner.next();
				if(type.equalsIgnoreCase("Line"))
				{
					int length=scanner.nextInt();
					Line lineshape=new Line(length);
					System.out.println("Shape Line was created, Length "+length);
					output.write("Shape Line was created, Length "+length);
					shape.put(new Integer(length),lineshape);
				}
				else if(type.equalsIgnoreCase("Rectangle"))
				{
					int length=scanner.nextInt();
					int width=scanner.nextInt();
					String color=scanner.next();
					Rectangle rectangle=new Rectangle(length,width,Color.valueOf(color));
					System.out.println("Shape Rectangle was created, Length "+length+" Width "+width+" Color "+color);
					output.write("Shape Rectangle was created, Length "+length+" Width "+width+" Color "+color);
					shape.put(new Integer(length), rectangle);
				}
				else if(type.equalsIgnoreCase("Circle"))
				{
					int radius=scanner.nextInt();
					String color=scanner.next();
					Circle circle=new Circle(radius,Color.valueOf(color));
					System.out.println("Shape Rectangle was created, Radius "+radius+" Color "+color);
					output.write("Shape Rectangle was created, Radius "+radius+" Color "+color);
					shape.put(new Integer(radius), circle);
				}
				else if(type.equalsIgnoreCase("Square"))
				{
					int length=scanner.nextInt();
					String color=scanner.next();
					Square square=new Square(length,Color.valueOf(color));
					System.out.println("Shape Rectangle was created, Length "+length+" Color "+color);
					output.write("Shape Rectangle was created, Length "+length+" Color "+color);
					shape.put(new Integer(length), square);
				}
				output.newLine();
				output.newLine();
			}
			else if(command.equalsIgnoreCase("PrintByPerimeter"))
			{
				System.out.println("Print in ascending order...");
				output.write("Print in ascending order...");
				output.newLine();
				Object[] arr=shape.values().toArray();
				Arrays.sort(arr);
				
				for(int j=0;j<arr.length;j++)
				{
					if(arr[j] instanceof Line)
					{
						Line temp=(Line)arr[j];
						System.out.println("Shape: "+temp.getClass().getName()+", Perimeter: "+temp.getPerimeter());
						output.write("Shape: "+temp.getClass().getName()+", Perimeter: "+temp.getPerimeter());
					}
					else if(arr[j] instanceof Circle)
					{
						Circle temp=(Circle)arr[j];
						System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
						output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
					}
					else if(arr[j] instanceof Rectangle)
					{
						Rectangle temp=(Rectangle)arr[j];
						System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
						output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
					}
					else if(arr[j] instanceof Square)
					{
						Square temp=(Square)arr[j];
						System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
						output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Perimeter: "+temp.getPerimeter());
					}
					output.newLine();
				}
				output.newLine();
				output.newLine();
			}
			else if (command.equalsIgnoreCase("PrintByArea"))
			{
				System.out.println("Print in random order...");
				output.write("Print in random order...");
				output.newLine();
				Object[] arr=shape.values().toArray();
				Random random=new Random();
				int result[]=new int[arr.length];
				for(int i=0;i<arr.length;i++)
					result[i]=arr.length+1;
				int flag=0,count=0;
				while(count<=arr.length-1)
				{
					int k=random.nextInt(arr.length);
					for(int i=0;i<arr.length;i++)
					{
						if(k==result[i])
						{
							flag=1;
							break;
						}
					}
					if(flag!=1)
					{
						result[count]=k;
						if(arr[k] instanceof Circle)
						{
							Circle temp=(Circle)arr[k];
							System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.newLine();
						}
						else if(arr[k] instanceof Rectangle)
						{
							Rectangle temp=(Rectangle)arr[k];
							System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.newLine();
						}
						else if(arr[k] instanceof Square)
						{
							Square temp=(Square)arr[k];
							System.out.println("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.write("Shape: "+temp.getClass().getName()+", Color: "+temp.getColor()+", Area: "+temp.getArea());
							output.newLine();
						}
						count++;
					}
					else
						flag=0;
				}
				
			}
			else
			{
				System.out.println("Your command is invalid, please input again.");
				output.write("Your command is invalid, please input again.");
				output.newLine();
			}
			try 
			{
				line = reader.readLine();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		output.close();
	}
}
