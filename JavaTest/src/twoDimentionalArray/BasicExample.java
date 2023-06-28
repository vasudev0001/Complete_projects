package twoDimentionalArray;

public class BasicExample {

	public static void main(String[] args) {
		String[][] data = new String[2][2];
		data[0][0] = "hello";
		data[0][1] = "Good morning";
		data[1][0] = "have a nice day";
		data[1][1] = "Good afternoon";

		System.out.println("Reverse printing two dimentional array:" + "\n" + "--------------------------");
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = data[i].length - 1; j >= 0; j--) {
				System.out.println(data[i][j]);
			}
		}
		System.out.println("__________________________________");
		
		System.out.println("printing two dimentional array:"+"\n"+"------------------------");

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println(data[i][j]);
			}
		}
	} 

}

