package string;

public class SortString {
	public static void main(String[] args) {
		String a[] = { "x","a","z","b" };
		String temp = "";
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length; j++) {
				/*
				 *  // >0 is sort in ascending
				 *  // <0 is sort in descending
				 */
				if (a[i].compareTo(a[j]) < 0) { 
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for (String aa : a) {
			System.out.println(aa);
		}
	}

}
