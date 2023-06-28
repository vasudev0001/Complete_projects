package customizedTreeSetSorting;

import java.util.Comparator;

public class ComparatorImplement implements Comparator<Object> {
	
	public int compare(Object obj1, Object obj2) {
		EmployeeClass ec = (EmployeeClass) obj1;
		EmployeeClass ec2 = (EmployeeClass) obj2;
		String s1 = ec.name;
		String s2 = ec2.name;

		return s1.compareTo(s2);
	}
}
