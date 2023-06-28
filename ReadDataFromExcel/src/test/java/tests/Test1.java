package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusable.ReadDataFromExcel;

public class Test1 {

	@Test(dataProvider = "hello")
	public void testDataProvider(Object un, Object pw,Object msg) {
		System.out.print(un.toString());
		System.out.println(" " + pw.toString()+" "+msg);
	}

	@DataProvider(name = "hello")
	public Object[][] getData() {
		Object[][] obj = ReadDataFromExcel.getExcelData();
		System.out.println(obj.length);
		return obj;
	}
}
