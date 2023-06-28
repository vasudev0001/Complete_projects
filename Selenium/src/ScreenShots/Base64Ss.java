 package ScreenShots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base64Ss {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		byte[] a = Base64.getDecoder().decode(base64);
		File path = new File("C:\\Users\\91766\\Desktop\\google64.png");
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(a);
			fos.close();
			System.out.println("screenshot save successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
