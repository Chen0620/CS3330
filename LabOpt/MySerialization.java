import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MySerialization 
{
	private ObjectOutputStream output;
	
	public MySerialization()
	{
		
	}
	
	public void serializeT(Terrorist t,String a)
	{
		this.openFile(a);
		this.writeIntoFile(t);
		System.out.println("Writing to file finished");
		this.closeFile();
	}
	
	private void openFile(String a)
	{
		try
		{
			output=new ObjectOutputStream(new FileOutputStream(a));
		}
		catch(IOException e)
		{
			System.err.println("Error opening file.");
		}
	}
	
	private void writeIntoFile(Terrorist t)
	{
		try
		{
			output.writeObject(t);
		}
		catch(IOException e)
		{
			System.err.println("Error writing to file.");
		}
	}
	
	private void closeFile()
	{
		try
		{
			if(output!=null)
					output.close();
		}
		catch (IOException e)
		{
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
}
