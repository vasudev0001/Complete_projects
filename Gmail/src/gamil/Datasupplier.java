package gamil;

import org.testng.annotations.DataProvider;

public class Datasupplier
{
	@DataProvider
	private String[][] testdata() {
		String[][] data = new String[4][4];
		data[0][0] = "k";
		data[0][1] = "vd";
		data[0][2] = "seleniumTool.test";
		data[0][3] = "password@1234";
		
		data[1][0] = "";
		data[1][1] = "";
		data[1][2] = "";
		data[1][3] = "";
		
		data[2][0] = "k";
		data[2][1] = "vd";
		data[2][2] = "seleniumTool";
		data[2][3] = "pW@12";
		
		data[3][0] = "";
		data[3][1] = "vd";
		data[3][2] = "seleniumTool";
		data[3][3] = "pW@1209876";

		return data;
	}

}
