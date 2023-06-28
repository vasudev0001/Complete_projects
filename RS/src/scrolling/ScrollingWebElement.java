package scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingWebElement {
	
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()",
					driver.findElement(By.xpath("//div[@class='left-align']//table[@id='product']")));
			Thread.sleep(500);
			// scrolling webElement
			jse.executeScript("document.querySelector(\".tableFixHead\").scrollTop=('100');");
//		     WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
//			jse.executeScript("arguments[0].scrollTop='100'",tableElement);
			
			// scroll using Actions class
//			WebElement ele=driver.findElement(By.xpath("//div[@class='tableFixHead']"));
//			Actions act =new Actions(driver);
//			act.moveToElement(ele).clickAndHold().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).release().perform();
		}
}
