import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;

public class MyDeSerialization 
{
	private ObjectInputStream input;
	
	public MyDeSerialization()
	{
		
	}
	
	public Terrorist deSerializeT(String a)
	{
		Terrorist t;
		this.openFile(a);
		t=this.readFromFile();
		this.closeFile();
		return t;
	}
	
	public void openFile(String a)
	{
		try
		{
			input=new ObjectInputStream(new FileInputStream(a));
		}
		catch (IOException e)
		{
			System.err.println("Error open file!");
		}
	}
	
	public Terrorist readFromFile()
	{
		Terrorist temp = new Terrorist(0, 0, 0,"", null);
		try
		{
			while(true)
			{
				temp=(Terrorist)input.readObject();
			}
		}
		catch(EOFException e)
		{
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("Unable to create object.");
		}
		catch(IOException e)
		{
			System.err.println("Error during read from file.");
		}
		return temp;
	}
	
	public void closeFile()
	{
		try
		{
			if(input!=null)
				input.close();
		}
		catch(IOException e)
		{
			System.err.println("Error closing file!");
			System.exit(1);
		}
	}
}
