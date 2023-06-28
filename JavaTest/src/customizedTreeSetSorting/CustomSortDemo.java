package customizedTreeSetSorting;

import java.util.TreeSet;

public class CustomSortDemo {
	
	public static void main(String[] args) {
		EmployeeClass e1 = new EmployeeClass("java",40);
		EmployeeClass e2 = new EmployeeClass("c language",44);
		EmployeeClass e3 = new EmployeeClass("python",42);
		EmployeeClass e4 = new EmployeeClass("c++",21);
		
		// sorting based on id
		TreeSet<EmployeeClass> ts = new TreeSet<EmployeeClass>();
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		ts.add(new EmployeeClass("hello",10));
		System.out.println(ts);
		
		// sorting based on name
		TreeSet<EmployeeClass> ts1 = new TreeSet<EmployeeClass>(new ComparatorImplement());
		ts1.add(e1);
		ts1.add(e2);
		ts1.add(e3);
		ts1.add(e4);
		ts1.add(new EmployeeClass("hello",10));
		System.out.println(ts1);
	
		
	}

}
