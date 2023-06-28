package lambda;

/*
 *           		It is simple lambda example.
 *    
 *    lambda expression is used to implement interface methods
 * 
 */


interface say
{
	String hi();
}
public class Example1
{
	public static void main(String[] args)
	{
		
		say s =()->{ return "hello lambda";};
		
		System.out.println(s.hi());
	}
}
