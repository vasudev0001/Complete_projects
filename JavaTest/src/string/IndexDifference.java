package string;

public class IndexDifference {
	public static void main(String[] args) {
		int a[] = { 8, 4, 5, 6,10};
		int diff = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i + 1] - a[i] > diff)
				diff = a[i + 1] - a[i];
		}
		System.out.println(diff);
	}
}
