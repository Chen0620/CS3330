import java.lang.Math;

public class Circle extends Shape implements Colorable,Areable
{
	private int radius;
	private Color color;
	private double Area;
	
	public Circle (int radius,Color color)
	{
		super();
		this.radius=radius;
		setColor(color);
		setPerimeter(radius);
		setArea(radius);

	}
	
	@Override
	public void setPerimeter(int radius)
	{
		super.Perimeter=2*Math.PI*radius;
	}
	
	@Override
	public void setPerimeter(int a, int b)
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
	public void setArea(int radius)
	{
		this.Area=radius*radius*Math.PI;
	}
	
	@Override
	public void setArea(int a,int b)
	{
	}
	
	@Override
	public double getArea()
	{
		return this.Area;
	}
}
