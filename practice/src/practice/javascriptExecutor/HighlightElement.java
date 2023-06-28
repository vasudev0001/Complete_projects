package practice.javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HighlightElement {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		WebElement ele= driver.findElement(By.id("email"));
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid orange')",ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='2px solid black';arguments[1].style.background='white'",ele,ele);
		js.executeScript("document.getElementById('email').value='hello facebook'");
	}

} 
