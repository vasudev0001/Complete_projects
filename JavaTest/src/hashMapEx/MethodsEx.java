package hashMapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MethodsEx {

	public static void main(String[] args) {
		String a_month = "December";
		String e_month ="August";
		int am=getMonthNumber(a_month);
		int em=getMonthNumber(e_month);
		System.out.println(am);
		System.out.println(em);
		selectMonth(em,am);
	}
	
	private static void selectMonth(int actualMonthNumber,int expectedMonthNumber) {
		
		System.out.println(expectedMonthNumber);
		System.out.println(actualMonthNumber);
		while (true) {
			if (expectedMonthNumber >= actualMonthNumber) {
				System.out.println("click on left side");
				expectedMonthNumber--;
			} else if (expectedMonthNumber <= actualMonthNumber) {
				System.out.println("click on right side");
				expectedMonthNumber++;
			} if (expectedMonthNumber == actualMonthNumber)
				break;
		} 
	}

	private static int getMonthNumber(String month) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "January");
		map.put(2, "February");
		map.put(3, "March");
		map.put(4, "April");
		map.put(5, "May");
		map.put(6, "June");
		map.put(7, "July");
		map.put(8, "August");
		map.put(9, "September");
		map.put(10, "October");
		map.put(11, "November");
		map.put(12, "December");
		int monthIndex = 0;
		Set<Entry<Integer, String>> s1 = map.entrySet();
		Iterator<Entry<Integer, String>> itr = s1.iterator();
		while (itr.hasNext()) {
			Entry<Integer, String> m1 = itr.next();
			if (month.equals(m1.getValue()))
				monthIndex = m1.getKey();
		}
		return monthIndex;
	}
}
