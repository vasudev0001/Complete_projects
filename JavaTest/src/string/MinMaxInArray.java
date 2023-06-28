package string;

/*
 * minimum and maximum numbers in multidimentional array.
 */
public class MinMaxInArray {

	public static void main(String[] args) {
		int a[][] = { { 2, 5, 1 }, { 3, 6, 5 }, { 19, 7, 0 } };
		int min=a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				// for minimum value use > symbol
				// for maximum value use < symbol
				if(min>a[i][j]) {  
					min=a[i][j];
				}
			}
		}
		System.out.println(min);
	}
}
