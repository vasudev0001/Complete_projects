package com.TestNgExtentReport;

import org.testng.annotations.DataProvider;

public class DataSupplier1 {

	@DataProvider
	public String[][] dp1() 
	{
		String[][] data = {{"valid","Hello","Dreams"},{"invalid","Hello","Dream"}
		,{"invalid","username","Dreams"},{"invalid","Asus","1234"},{"invalid","hELLO","dREAMS"},{"invalid","Lenovo",""},{"invalid","","Ideapad"}};	
		return data;
	}
}
