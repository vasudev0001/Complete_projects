package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ModifyOrderOfTabs 
{
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporters.html");
		er.attachReporter(sr);
		
		sr.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.AUTHOR,
		}).apply();
		
		er.createTest("Test1")
		.pass("This is working");
		er.flush();
		Desktop.getDesktop().browse(new File("reporters.html").toURI());
	}

}
