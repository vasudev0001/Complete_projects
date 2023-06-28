package ScreenShots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenShot 
{
	private WebDriver driver;
	@Test
	private void screenshot()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver ();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("Hello");
		driver.findElement(By.name("txtPassword")).sendKeys("Dreams");
		driver.findElement(By.name("Submit")).click();
		
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File input =takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\91766\\eclipse-workspace\\TestNG\\ScreenShot\\hrm.jpg");
		try {
			FileUtils.copyFile(input, destfile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
	

}
