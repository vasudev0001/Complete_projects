package ScreenShots;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutputTypeFile {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\91766\\Desktop\\"+"screen"+"/"+"google.png");
		try {
			FileUtils.copyFile(file, dest);
			System.out.println("Screenshot saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
