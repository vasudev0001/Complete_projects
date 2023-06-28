package setExamples;

import java.util.LinkedHashSet;

public class LinkedHashSetMethod {

	public static void main(String[] args) {
		holdLinkedHashSetObject();
		addAllMethod();
	}

	private static void holdLinkedHashSetObject() {
		LinkedHashSet<String> a = new LinkedHashSet<>();
		a.add("c language");
		a.add("java");
		a.add("python");

		LinkedHashSet<Object> a1 = new LinkedHashSet<>(a);
		System.out.println("origional values: " + a);
		System.out.println("copied values(): " + a1);
	}

	private static void addAllMethod() {
		LinkedHashSet<String> a = new LinkedHashSet<>();
		a.add("c language");
		a.add("java");
		a.add("python");

		LinkedHashSet<Object> a1 = new LinkedHashSet<>();
		a1.add(a);
		System.out.println("origional values: " + a);
		System.out.println("copied values(): " + a1);
	}
}
