package basic_control;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBoxes {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/basic-controls.html");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// here getting number of check-box objects
		List<WebElement> checkbox = (List) (jse.executeScript("return document.getElementsByName('language');"));
		// here iterate each object from the List.
		for (Object chk : checkbox) {
			// click on check-box.
			jse.executeScript("arguments[0].click()", chk);
		}
	}
}
