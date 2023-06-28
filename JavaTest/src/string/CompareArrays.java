package string;

import java.util.ArrayList;

public class CompareArrays {

	public static void main(String[] args) {
		int a[] = { 12, 2, 1, 9 };
		int b[] = { 1, 2, 0, 9 };
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i]) {
				al.add(a[i]);
			}
		}
		Object[] c =al.toArray();
		System.out.println("Elements that are same in arrays: ");
		for(Object i:c) {
			System.out.println(i);
		}
	}
}
