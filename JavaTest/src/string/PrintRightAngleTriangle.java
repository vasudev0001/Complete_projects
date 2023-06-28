package string;
// print right angle triangle.
public class PrintRightAngleTriangle {
	public static void main(String[] args) {
		int rows=5;
		rightAngleTriangle(rows);
	}
	
	private static void rightAngleTriangle(int rows) {
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*"+"\t");
			}
			System.out.println();
		}
	}

}
