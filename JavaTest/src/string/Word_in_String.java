package string;

public class Word_in_String {

	static String s = "cartoon_Network nick disney_xd discovey_kids sonic_nicklodian jetex sony_yay kushi_tv baby_tv";
	static int charCount = 0;
	static int wordCount = 0;

	public static void main(String[] args) {

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ' ') {
				charCount++;
			}
			if ((s.charAt(i) == ' ') || (i == s.length() - 1)) {
				if (charCount >= 2) {
					wordCount++;
					charCount = 0;
				}
			}
		}
		System.out.println("String word count: " + wordCount);
	}
}
