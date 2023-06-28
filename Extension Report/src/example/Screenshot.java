package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Screenshot
{
	static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporter.html");
		er.attachReporter(sr);
		
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 driver.get("https://www.asus.com/in/");
		 String path = screenshot();
		 String base64 = screenshot1();
		
		er.createTest("Asus Home page")
		  .log(Status.INFO, "<b><i>It's a brand</b></i>");
		
		er.createTest("ScreenShot")  // screenshot using path along with title
		  .addScreenCaptureFromPath(path, "Asus home page");
		
		er.createTest("Log level")  // screenshot using path along with description and title.
		  .fail("Title did not match",MediaEntityBuilder.createScreenCaptureFromPath(path,"Asus home page").build());
		
		er.createTest("Asus screenshot 1")
		  .addScreenCaptureFromBase64String(base64)
		  .addScreenCaptureFromBase64String(base64, "Asus fail screenShot");
		
		er.createTest("Asus screenshot 2")
		  .addScreenCaptureFromPath(path, "Asus home page")
		  .fail("Title did not match",MediaEntityBuilder.createScreenCaptureFromPath(path,"Asus home page").build())
		  .addScreenCaptureFromBase64String(base64,"Asus home page")
		  .fail("menu disabled",MediaEntityBuilder.createScreenCaptureFromBase64String(base64,"This is failure screenshot").build());
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporter.html").toURI());
	}
	
	public static String screenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\screenshot\\Asus.jpg");
		FileUtils.copyFile(srcfile, destFile);
	    return destFile.getAbsolutePath();
	}
	
	public static String screenshot1() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		String srcfile = ts.getScreenshotAs(OutputType.BASE64);
	    return srcfile;
	}
}
