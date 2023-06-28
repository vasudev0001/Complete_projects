package handlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		String middleFrameText = driver.findElement(By.id("content")).getText();
		System.out.println(middleFrameText);
		driver.close();

	}

}
