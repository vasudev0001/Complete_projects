package setExamples;

import java.util.TreeSet;

public class TreeSetMethods {
	
	public static void main(String[] args) {
		
		TreeSet<String> ts= new TreeSet<String>();
		System.out.println("Check whether  tree set is empty: "+ts.isEmpty());
		ts.add("python");
		ts.add("c language");
		ts.add("c++");
		ts.add("java");
		
		System.out.println(ts);
		System.out.println("Check whether  tree set is empty: "+ts.isEmpty());
		
		System.out.println("Add an element that is not in the set: "+ts.add("program language"));
		System.out.println("Add existing element: "+ts.add("java"));
		
		System.out.println("Remove existing object: "+ts.remove("program language"));
		System.out.println("Remove object that is not in set: "+ts.remove("element not available"));
		
		System.out.println("check the element in available: "+ts.contains("java"));
		System.out.println("Check for the element it is not existing in tree: "+ts.contains("java"));
		
		System.out.println("size of the tree: "+ts.size());
		
		System.out.println("tailset method: "+ts.tailSet("java"));
		System.out.println("headset method: "+ts.headSet("java"));
		
		System.out.println(ts.subSet("c language", "python"));
		
		
		ts.clear();
		System.out.println(ts);
		
		
		
	}

}
