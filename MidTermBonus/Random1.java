import java.util.Random;
public class Random1 
{
	public static void main(String[] args)
	{
		Random generator=new Random();
		double rand1;
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,j=0,k=0,l=0,m=0,n=0,o=0;
		
		for(int i=0;i<10000;i++)
		{
			rand1=generator.nextDouble();
			if (rand1<0.3)
			{
				rand1=rand1+0.3;
				
			}
			if(rand1>0.3&&rand1<0.35)
				a++;
			if(rand1>=0.35&&rand1<0.4)
				b++;
			if(rand1>=0.4&&rand1<0.45)
				c++;
			if(rand1>=0.45&&rand1<0.5)
				d++;
			if(rand1>=0.5&&rand1<0.55)
				e++;
			if(rand1>=0.55&&rand1<0.6)
				f++;
			if(rand1>=0.6&&rand1<0.65)
				g++;
			if(rand1>=0.65&&rand1<0.7)
				h++;
			if(rand1>=0.7&&rand1<0.75)
				j++;
			if(rand1>=0.75&&rand1<0.8)
				k++;
			if(rand1>=0.8&&rand1<0.85)
				l++;
			if(rand1>=0.85&&rand1<0.9)
				m++;
			if(rand1>=0.9&&rand1<0.95)
				n++;
			if(rand1>=0.95&&rand1<1)
				o++;
		}
		System.out.println("(0.3,0.35):"+a);
		System.out.println("[0.35,0.4):"+b);
		System.out.println("[0.4,0.45):"+c);
		System.out.println("[0.45,0.5):"+d);
		System.out.println("[0.5,0.55):"+e);
		System.out.println("[0.55,0.6):"+f);
		System.out.println("[0.6,0.65):"+g);
		System.out.println("[0.65,0.7):"+h);
		System.out.println("[0.7,0.75):"+j);
		System.out.println("[0.75,0.8):"+k);
		System.out.println("[0.8,0.85):"+l);
		System.out.println("[0.85,0.9):"+m);
		System.out.println("[0.9,0.95):"+n);
		System.out.println("[0.95,1):"+o);
	}
}
