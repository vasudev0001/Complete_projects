package setExamples;

import java.util.TreeSet;

public class TreeSetExamples {

	public static void main(String[] args) {
		stringBuffer();
		   compareTo();

	}

	private static void stringBuffer() {
		TreeSet<StringBuffer> t = new TreeSet<>();
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("Z"));
		t.add(new StringBuffer("B"));
		System.out.println(t);
	}

	private static void compareTo() { // method is avaiable in comparable interface
		System.out.println("A".compareTo("B"));
		System.out.println("c".compareTo("C"));
		System.out.println("Z".compareTo("A"));
		System.out.println("A".compareTo("A"));
	}

}
