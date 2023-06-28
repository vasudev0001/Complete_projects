package setExamples;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetAlphabeticalOrder {
	public static void main(String[] args) {
		descendingOrder();
	}

// ---------------------------- descending order --------------------
	private static void descendingOrder() {
		TreeSet<String> i = new TreeSet<String>(new mycomparator2());
		i.add("apple");
		i.add("banana");
		i.add("grapes");
		i.add("popaya");
		i.add("orange");

		System.out.println(i);
	}
}

class mycomparator2 implements Comparator<Object> {

	public int compare(Object obj1, Object obj2) {

		String I1 = (String) obj1;
		String I2 = (String) obj2;

		return -I1.compareTo(I2);
		// return I2.compareTo(I1);
	} 
}
