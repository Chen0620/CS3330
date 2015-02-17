public class Rectangle extends Shape implements Colorable,Areable
{
	private int length;
	private int width;
	private Color color;
	private double Area;
	
	public Rectangle(int length,int width,Color color)
	{
		super();
		this.length=length;
		this.width=width;
		setColor(color);
		setPerimeter(length,width);
		setArea(length,width);
	}
	
	@Override
	public void setPerimeter(int length,int width)
	{
		super.Perimeter=2*(length+width);
	}
	
	@Override
	public void setPerimeter(int a)
	{	
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
	public void setArea(int length,int width)
	{
		this.Area=length*width;
	}
	
	@Override
	public void setArea(int a)
	{
	}
	
	@Override
	public double getArea()
	{
		return this.Area;
	}
}
