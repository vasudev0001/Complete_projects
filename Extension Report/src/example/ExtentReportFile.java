package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFile 
{
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		File file = new File("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporter.html");
		ExtentSparkReporter sr = new ExtentSparkReporter(file);
		er.attachReporter(sr);
		er.createTest("Test1").fail("This is Fail");
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporter.html").toURI());
	}

}
