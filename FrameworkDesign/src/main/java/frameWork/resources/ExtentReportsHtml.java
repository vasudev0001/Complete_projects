package frameWork.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsHtml {

	public static ExtentReports extentReports() {
		String path = System.getProperty("user.dir") + "\\reports\\TestReport.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(path);
		esp.config().setDocumentTitle("Test Result");
		esp.config().setReportName("product ordering");

		ExtentReports er = new ExtentReports();
		er.attachReporter(esp);
		return er;
	}
}
