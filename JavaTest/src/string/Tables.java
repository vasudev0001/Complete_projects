package string;

public class Tables {

	public static void main(String[] args) {
		int table = 5;

		for (int i = 1; i <= 10; i++) {
			int j = 1;
			int m = 0;
			while (j <= i) {
				m = m + table;
				j++;
			}
			System.out.println(table + "*" + i + "=" + m);
		}
	}
}
