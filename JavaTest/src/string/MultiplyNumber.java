package string;
// multiply numbers without multipliers.
public class MultiplyNumber {

	private static void sum(int i, int j) {
		int k = 1;
		int sum = 0;
		while (k <= j) {
			sum = sum + i;
			k++;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		sum(2, 10);
	}
}
