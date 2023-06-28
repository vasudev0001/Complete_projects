package string;

public class NumberInverseTriangle {

	public static void main(String[] args) {

		int k = 20;
		int n = 1;
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= 6; j++) {

				if (n <= 9) {
					System.out.print("0" + n + " ");
				} else
					System.out.print(n + " ");
				n++;
//				System.out.print(n + "  ");
//				n++;
			}
			System.out.println();
		}
	}

}
