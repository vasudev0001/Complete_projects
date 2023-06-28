package highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BackgroundBorder 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		String uname ="document.getElementById('email').setAttribute('style','border:2px solid red; background:Yellow')";
		jse.executeScript(uname);
		
		WebElement pass =driver.findElement(By.id("passContainer"));
		jse.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:Yellow')", pass);
		
		String link ="document.evaluate(\"//a[text()='Forgotten password?']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.setAttribute('style','border:2px solid red; background:yellow');";
		//.singleNodeValue.setAttribute('style','border:2px solid red; background:yellow');
		jse.executeScript(link);
	}

}
