package highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BackgroundColour
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// Finding Element using javaScript.
		jse.executeScript("document.getElementById('email').style.background='Yellow';");
		
		//Finding element using WebDriver
		WebElement passbackground =driver.findElement(By.id("passContainer"));
		jse.executeScript("arguments[0].style.background='Yellow';",passbackground);
		
		//Finding element using javaScript evaluate method (Xpath):
		String loginbtn ="document.evaluate(\"//button[text()='Log In']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.style.background='Green';";
          jse.executeScript(loginbtn);
	}

}
