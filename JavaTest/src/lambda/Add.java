package lambda;

interface calculator
{
	int add(int a, int b);
}

public class Add 
{
	public static void main(String[] args)
	{
		calculator ad = (a,b)->(a+b);
		System.out.println(ad.add(10, 51));
		
		calculator m = (a,b)->(a*b);		
		System.out.println(m.add(10, 10));
		        		
	}

}
