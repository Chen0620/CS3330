import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class CreateTextFile 
{
	private Formatter output;
	public void openFile()
	{
		try
		{
			output=new Formatter("output.txt");
		}
		catch(SecurityException e)
		{
			System.err.println("You don't have"+" write accress to this file");
			System.exit(1);
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Error opening or"+" creating file.");
			System.exit(1);
		}
	}
}
