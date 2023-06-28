package customizedTreeSetSorting;

public class EmployeeClass implements Comparable<Object> {
	String name;
	int id;

	public EmployeeClass(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String toString() {
		return name + " " + id;
	}

	public int compareTo(Object o) {
		int id1 = this.id;
		EmployeeClass e = (EmployeeClass) o;
		int id2 = e.id;
		if(id1<id2)
			return -1;
		else if(id1>id2)
			return 1;
		else
			return 0;
	}

}
