package example;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicExtension
{
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporter.html");
		er.attachReporter(sr);
		
		er.createTest("sample test");
		
		ExtentTest er1 = er.createTest("sample test 2", "sanity");
		er1.fail("This is fail");
		
		er.createTest("sample test 3").skip("skipped");
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporter.html").toURI());
	}

}
