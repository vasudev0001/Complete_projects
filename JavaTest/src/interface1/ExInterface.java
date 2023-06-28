package interface1; 

interface one
{
  void draw();		
}

class Rectangle implements one {
	public void draw() {
		System.out.println("draw rectangle");
	}
}

class circle implements one {
	public void draw() {
		System.out.println("draw circle");
	}
	public void testing()
	{
		System.out.println("automation testing completed");
	}
}

public class ExInterface
{
	public static void main(String[] args) 
	{
		one a;
		a=new Rectangle();
		one a1=new circle();
		
		a.draw();
		a1.draw();
	//	a1.testing(); // The method testing() is undefined for the type one
	}
}
