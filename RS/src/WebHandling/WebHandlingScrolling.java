package WebHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebHandlingScrolling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		WebElement webTable= driver.findElement(By.xpath("//div[@class='tableFixHead']/../legend"));
		
		jse.executeScript("arguments[0].scrollIntoView()",webTable);
	//	Thread.sleep(1000);
		
		
		
		
	}
}
