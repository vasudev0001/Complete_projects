package baseTestEcommerce;

//import java.awt.Desktop;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import frameWork.resources.ExtentReportsHtml;

public class TestNgListeners extends BaseTest implements ITestListener {
	ExtentReports report = ExtentReportsHtml.extentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> synchronizedtest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		synchronizedtest.set(test);
		synchronizedtest.get().log(Status.INFO,result.getMethod().getMethodName() + " execution started.");
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		synchronizedtest.get().log(Status.PASS, result.getMethod().getMethodName() + " is passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// WebDriver driver=null;
		synchronizedtest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}

		String path = null;
		try {
			path = takeScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		synchronizedtest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		report.flush();
//		try {
//			Desktop.getDesktop()
//					.browse(new File(System.getProperty("user.dir") + "\\reports\\TestReport.html").toURI());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
