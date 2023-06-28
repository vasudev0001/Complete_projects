package setExamples;

import java.util.HashSet;

public class Hashset {
	public static void main(String[] args) {
		HashSet<Object> h = new HashSet<>();
		System.out.println("check set is empty: "+h.isEmpty());
		// add() method return true if it add value to the HashSet.
		h.add("java");
		h.add("c language");
		h.add("python");
		h.add(500);
		h.add(25);
		h.add(1.4);
		h.add(10);

		System.out.println("Add new element to set: "+h.add(100.0));
		System.out.println(h);
		System.out.println("Number of objects: "+h.size());
		System.out.println("contains method: "+h.contains("java"));
		System.out.println("remove element: "+h.remove(100.0));
		System.out.println(h);
		System.out.println("Number of objects: "+h.size());
		System.out.println("Add duplicate element: "+h.add("java"));
		h.clear();
		System.out.println("After clear: "+h);
		System.out.println("remove an element it is not present in set: "+h.remove("java"));
		System.out.println("check for the object that are not present in set: "+h.contains("java"));
		
		
	}
}
