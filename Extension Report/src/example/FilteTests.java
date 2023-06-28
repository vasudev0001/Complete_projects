package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FilteTests {
	
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("TotalReporter.html");
		ExtentSparkReporter sr_fail = new ExtentSparkReporter("reporters.html");
		sr_fail.filter().statusFilter().as(new Status [] {Status.FAIL}).apply();
		
		ExtentSparkReporter s_failed = new ExtentSparkReporter("Failedreporters.html");
		s_failed.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				}).apply();
		
		er.attachReporter(sr,sr_fail,s_failed);
		
		er.createTest("Test1")
		.pass("This is pass test");
		
		er.createTest("test2")
		.fail("fail test");
		
		er.createTest("Test3")
		.skip("This is skip test");
		
		er.createTest("Test4")
		.warning("This is warning test");
		
		er.flush();
		Desktop.getDesktop().browse(new File("TotalReporter.html").toURI());
		Desktop.getDesktop().browse(new File("reporters.html").toURI());
		Desktop.getDesktop().browse(new File("Failedreporters.html").toURI());
	}
}
