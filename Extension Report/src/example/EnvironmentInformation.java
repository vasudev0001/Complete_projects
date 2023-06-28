package example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EnvironmentInformation {
	
	public static void main(String[] args) throws IOException {
		ExtentReports er = new ExtentReports();
		ExtentSparkReporter sr = new ExtentSparkReporter("C:\\Users\\91766\\eclipse-workspace\\Extension Report\\reporters.html");
		er.attachReporter(sr);
		
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
//		System.getProperties().list(System.out); // It returns system properties.
		
		er.setSystemInfo("operating System",System.getProperty("os.name"));
		er.setSystemInfo("java version",System.getProperty("java.version"));
		er.setSystemInfo("Browser", cap.getBrowserName());
		er.setSystemInfo("Browser version",cap.getBrowserVersion());
		er.setSystemInfo("URL", "www.hello.com");
		er.setSystemInfo("Username", "hello@123.com");
		er.setSystemInfo("Password", "bye@Goodnight9");
		
		er.flush();
		Desktop.getDesktop().browse(new File("reporters.html").toURI());
		
	}
}
