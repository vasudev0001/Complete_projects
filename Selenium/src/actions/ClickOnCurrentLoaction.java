package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnCurrentLoaction 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(1000);
	WebElement gmail =	driver.findElement(By.xpath("//a[text()='Gmail']"));
	
	 Actions actions = new Actions(driver); 
	 actions.click(gmail).perform();
		
	}

}
