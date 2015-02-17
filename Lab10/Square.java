public class Square extends Shape implements Colorable,Areable
{
	private int length;
	private Color color;
	private double Area;
	
	public Square(int length,Color color)
	{
		super();
		this.length=length;
		setColor(color);
		setPerimeter(length);
		setArea(length);
	}
	
	@Override
	public void setPerimeter(int a,int b)
	{
	}
	
	@Override
	public void setPerimeter(int length)
	{	
		super.Perimeter=4*length;
	}
	
	@Override
	public void setColor(Color color)
	{
		this.color=color;
	}
	
	@Override
	public Color getColor()
	{
		return this.color;
	}
	
	@Override
	public void setArea(int length)
	{
		this.Area=length*length;
	}
	
	@Override
	public void setArea(int a, int b)
	{
	}
	
	@Override
	public double getArea()
	{
		return this.Area;
	}
}
