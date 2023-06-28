package string;

public class SwapingNumbers {

	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		swapWithTemp(a,b);
		swapWithoutTemp(a,b);
	}
	
	private static void swapWithTemp(int a,int b) {
		int temp;
		System.out.println("values before swaping:");
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("values after swaping:");
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
	
	private static void swapWithoutTemp(int a,int b) {
		System.out.println("values before swaping:");
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		a=a+b; //9
		b=a-b; //     3=9-6
		a=a-b;  //     6=9-3
		System.out.println("values after  swaping without the temp variable:");
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
}
