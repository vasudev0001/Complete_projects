package com.TestNgExtentReport;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {
	
	public static WebDriver driver;
	public static String currentTimefolder;
	public static ExtentReports er;                
	public static ExtentTest extentTest;

	public static int a =0;
	
	public  void report() //ITestContext context   ITestResult result
	{ 
		
		String path=System.getProperty("user.dir");
		File f= new File(".\\reporter12"+"/"+"reporter.html");
		ExtentSparkReporter sr = new ExtentSparkReporter(f); 
		er = new ExtentReports();  
		er.attachReporter(sr);
		
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
		er.setSystemInfo("operating System",System.getProperty("os.name"));
		er.setSystemInfo("java version",System.getProperty("java.version"));
		er.setSystemInfo("Browser", cap.getBrowserName());
		er.setSystemInfo("Browser version",cap.getBrowserVersion());
	}
	
	@BeforeMethod
	public void launchApplication(ITestContext context)  //ITestContext context
	{
		String url ="http://127.0.0.1/orangehrm-2.6/login.php";
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		driver.get(url);	
		boolean loginbtn = driver.findElement(By.xpath("//input[@name='Submit']")).isDisplayed();
		
		if(a==0)
		{
			report(); //report(context);
		}
	      a++;
		extentTest = er.createTest(context.getName()); // context.getName()
		extentTest.info("URL: "+url);
		Assert.assertEquals(true, loginbtn);
		extentTest.info("Application login page is opened");
	}
	
	@AfterMethod
	public void takeScreenShot(Method m,ITestResult result) throws Exception
	{
		Reporter.log("After method",true);
		if(result.getStatus() == ITestResult.FAILURE) 
		{
			String path = captureScreenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg"); 
			extentTest.addScreenCaptureFromPath(path);
			extentTest.fail(result.getThrowable());	
		}
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.pass(m.getName()+" is passed");
		}	
		driver.quit();
	} 
	
	public String captureScreenShot(String file)
	{
		if(currentTimefolder == null)
		{
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
		    currentTimefolder = myDateObj.format(myFormatObj);
		    System.out.println(currentTimefolder);	
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Takescreenshot2/"+currentTimefolder+"/"+file);
		try {
			FileUtils.copyFile(srcfile, destfile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Screenshot saved successfully");
		 return destfile.getAbsolutePath();
	}
	
	@AfterSuite
	public void flush() throws Exception
	{
		er.flush();
		Desktop.getDesktop().browse(new File("reporter.html").toURI());
		
	}
}
