package string;

public class FibanocciSeries {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int sum;
		int k = 1;
		while (k <= 5) {
			sum = a + b;
			System.out.println(sum);
			a = b;
			b = sum;

			k++;
		}

	}

}
