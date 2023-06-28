package highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BorderHighLight
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
         
		//Finding an element using Javascript and highlighting it.s
		String unameborder="document.getElementsByName('email')[0].style.border='2px RED Solid';";
		jse.executeScript(unameborder);  
		
		// Finding an element using the selenium webdriver and highlighting it.
		WebElement element =driver.findElement(By.id("passContainer"));
		jse.executeScript("arguments[0].style.border='2px Green solid'", element);
		// xpath 
		String lobinborder = "document.evaluate(\"//button[text()='Log In']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.style.border='3px RED Solid';";
		jse.executeScript(lobinborder);
	}

}
