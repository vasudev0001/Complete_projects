package setExamples;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSorting {

	public static void main(String[] args) {
		descendingOrder();
	}

	private static void descendingOrder() {
		TreeSet<Integer> i = new TreeSet<Integer>(new mycomparator());
		i.add(10);
		i.add(12);
		i.add(15);
		i.add(22);
		i.add(0);

		System.out.println(i);
	}
}

class mycomparator implements Comparator<Object> {

	public int compare(Object obj1, Object obj2) {
		Integer I1 = (Integer) obj1;
		Integer I2 = (Integer) obj2;

		if (I1 < I2)
			return +1;
		if (I1 > I2)
			return -1;
		else
			return 0;
	}
}
