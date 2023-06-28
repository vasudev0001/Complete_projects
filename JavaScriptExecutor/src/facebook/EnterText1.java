package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnterText1 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		
		// Finding Element using WebDriver 
		WebElement element =driver.findElement(By.id("email"));

		// convert webDriver reference into javascriptExecutor
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		
		//here enter Text with webDriver element using javascriptExecutor
		jse.executeScript("arguments[0].value='username123'",element);
		// get the text
	    String s= (String)	jse.executeScript("return arguments[0].value",element);
        System.out.println("Getting text from user name Textbox: "+s);
	}

}
