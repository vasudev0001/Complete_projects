package setExamples;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCompareMethods {
	public static void main(String[] args) {
		descendingOrder();
	}

	private static void descendingOrder() {
		TreeSet<Object> i = new TreeSet<Object>(new mycomparator1());
		i.add(10);
		i.add(12);
		i.add(15);
		i.add(22);
		i.add(0);

		System.out.println(i);
	}
}

class mycomparator1 implements Comparator<Object> {

	public int compare(Object obj1, Object obj2) {

		Integer I1 = (Integer) obj1;
		Integer I2 = (Integer) obj2;

		// return -I1.compareTo(I2);
		return I2.compareTo(I1);
	}
}
