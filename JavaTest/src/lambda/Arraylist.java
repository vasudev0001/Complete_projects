package lambda;

import java.util.ArrayList;
import java.util.List;

public class Arraylist 
{
	public static void main(String[] args)
	{
		List<Object> li = new ArrayList<Object>();
		li.add("Sunday");
		li.add("Monday");
		li.add("Tuesday");
		li.add("Wednesday");
		li.add("Thursday");
		li.add("Friday");
		li.add("Saturday");
		li.add(123);
		
		System.out.println("Elements: "+li);
		System.out.println("------------------------------------");
		
		li.forEach((n)->System.out.println(n));
		
	}

}
