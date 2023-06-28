package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProvideAttributes 
{
	public static void main(String[] args) throws IOException
	{
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporters.html");
		er.attachReporter(sr);
		
		
		er.createTest("OrangeHRM verify menu 1")
		  .assignAuthor("vasudev")
		  .assignCategory("smoke","sanity","regression")
		  .assignDevice("chrome","firefox","edge")
		  .log(Status.PASS,"This is pass");
		
		er.createTest("OrangeHRM verify menu 2")
		  .assignAuthor("vasudev","yadagiri")
		  .assignCategory("smoke","sanity","regression")
		  .assignDevice("chrome","firefox","edge")
		  .log(Status.PASS,"This is pass");
		
		er.createTest("OrangeHRM verify menu 3")
		  .assignAuthor(new String[]{"vasudev","yadagiri","Testing babai"})
		  .assignCategory(new String[]{"smoke","sanity","regression"})
		  .assignDevice(new String[]{"chrome","firefox","edge","smoke fox"})
		  .log(Status.PASS,"This is pass");
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporters.html").toURI());
		
		
	}

}
