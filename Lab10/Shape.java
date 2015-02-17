public abstract class Shape implements Comparable
{
	protected double Perimeter;
	
	public abstract void setPerimeter(int p);
	public abstract void setPerimeter(int a, int b);
	
	public double getPerimeter()
	{
		return Perimeter;
	}
	
	public int compareTo(Object o1)
	{
		if(this.Perimeter==((Shape)o1).Perimeter)
			return 0;
		else if (this.Perimeter>((Shape)o1).Perimeter)
			return 1;
		else
			return -1;
	}
}
