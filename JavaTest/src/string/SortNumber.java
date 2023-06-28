package string;

public class SortNumber {

	public static void main(String[] args) {
		int temp = 0;
		int arr[] = { 1, 3, 2, 9, 3, 6 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int a:arr) {
			System.out.print(a);
		}
	}
}
