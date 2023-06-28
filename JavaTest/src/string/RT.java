package string;
/*
        * 
      * * 
    * * * 
  * * * * 
* * * * * 

 */
public class RT {

	public static void main(String[] args) {

		int row = 9;
		for (int i = 1; i <= row; i++) {

			int rw = 0;
			rw = row - i;
			int k = 1;
			while (k <= rw) {
				System.out.print("  "); // double space
				k++;
			}
			while (rw < row) {
				System.out.print("*" + " "); // single space
				rw++;
			}
			System.out.println();
		}
	}
}
