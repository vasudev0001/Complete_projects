package interface1;
interface fun{
	static int cube(int x)
	{
		return x*x*x;
	}
	public abstract void draw();
}

class ClassA implements fun{
 public void draw() {
	 System.out.println("draw cube");
 }
}

public class StaticInterface 
{
	public static void main(String[] args) {
		fun f = new ClassA();
		f.draw();
		System.out.println(fun.cube(2));
	//	System.out.println(f.cube(3)); // This static method of interface fun can only be accessed as fun.cube (compile time error)
	}

}
