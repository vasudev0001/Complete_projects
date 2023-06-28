package ScreenShots;

import java.io.File;
import java.io.FileOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutputByteSs {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] arr = ts.getScreenshotAs(OutputType.BYTES);
		File file = new File("C:\\Users\\91766\\Desktop\\google64.png");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(arr);
			fos.close();
			System.out.println("Screenshot saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
