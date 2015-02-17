public class Line extends Shape
{
	private int length;
	
	public Line(int length)
	{
		super();
		this.length=length;
		setPerimeter(length);
	}
	
	@Override
	public void setPerimeter(int length)
	{
		super.Perimeter=length;
	}
	@Override
	public void setPerimeter(int a, int b)
	{
	}
}

