package setExamples;

import java.util.LinkedHashSet;

class Student {

	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "[" + this.id + " -> " + this.name + "]";
	}

//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}

//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
	
}

public class CopyMergeCloneLinkedHashSet {

	public static void main(String[] args) throws InterruptedException {

		LinkedHashSet<Student> lhSetStudents = new LinkedHashSet<Student>();

		Student student1 = new Student(1, "Emily");
		Student student2 = new Student(2, "Raj");
		Student student3 = new Student(3, "John");

		lhSetStudents.add(student1);
		lhSetStudents.add(student2);
		lhSetStudents.add(student3);

		// copy to another
		@SuppressWarnings("unchecked")
		LinkedHashSet<Student> lhSetStudentsCloned = (LinkedHashSet<Student>) lhSetStudents
				.clone();

		System.out.println("Original: " + lhSetStudents);
		System.out.println("Cloned: " + lhSetStudentsCloned);

		/*
		 * Adding or removing elements to either of the objects does not change the
		 * other
		 */

		// adding an element to original
		lhSetStudents.add(new Student(4, "Ryan"));

		// removing an element from the clone
		lhSetStudentsCloned.remove(student1);

		System.out.println("After adding, removing elements");
		System.out.println("Original: " + lhSetStudents);
		System.out.println("Cloned: " + lhSetStudentsCloned);

		/*
		 * But when you change the original element object, the change will be reflected
		 * in both.
		 * 
		 * That is because only the reference to the original object is copied, not the
		 * actual element object
		 */
		
		// change element object
//		student2.setName("AAAAAAAA");

		System.out.println("After changing element object");
		System.out.println("Original: " + lhSetStudents);
		System.out.println("Cloned: " + lhSetStudentsCloned);
	}
}
