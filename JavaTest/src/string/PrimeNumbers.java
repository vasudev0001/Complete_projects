package string;

public class PrimeNumbers {

	public static void main(String[] args) {
		int a = 42;
		checkItIsPrimeNumber(a);
	}

	private static void checkItIsPrimeNumber(int a) {
		int count = 0;
		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			System.out.println("it is prime number");
		} else
			System.out.println("It is not a prime number");
	}
}
