package basic_control;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class radioButtons
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/basic-controls.html");
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		/* 
		 * click on radio button.  
		 *  Find element by using javascriptExecutor and perform click operation using javaScript 
		 */
		
	    jse.executeScript("document.getElementById('femalerb').click();");
	    
	    /*
	     * above code we can also write like this
	     * String a ="document.getElementById('femalerb').click()";
	        jse.executeScript(a);
	     */
		
		/* 
		 * click on radio button.  
		 *  Find element by using WebDriver and perform click operation using javaScript 
		 */
	//	WebElement element=(WebElement)driver.findElement(By.id("femalerb"));
	//	jse.executeScript("arguments[0].click()",element);
		
	}
}
