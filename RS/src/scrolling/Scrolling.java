package scrolling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrolling {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions o = new ChromeOptions();

	       o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.get("https://www.electronicscomp.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2//span[contains(text(),'New Arrivals')]")));
		
//		new WebDriverWait(driver,  Duration.ofSeconds(2)).until(
//			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
		System.out.println(driver.findElement(By.xpath("//span[@class='coupon-header-text']")).getText());
	WebElement ele =driver.findElement(By.xpath("//h2//span[contains(text(),'New Arrivals')]"));
	System.out.println(ele.getText());
	WebElement ele1 =driver.findElement(By.xpath("//span[text()='Best Seller']"));
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()", ele1);
	}
}
