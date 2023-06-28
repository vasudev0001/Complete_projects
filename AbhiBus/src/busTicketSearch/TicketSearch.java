package busTicketSearch;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TicketSearch
{
	@Test
	public void main() throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		Alert alert = driver.switchTo().alert();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
		String month = "June";         // change month
		int date = 21; 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// enter starting point
		jse.executeScript("document.getElementById('source').value='Nellore (By-pass)';");
		// enter destination 
		jse.executeScript("document.getElementById('destination').value='Hyderabad Airport RGIA'");
	/*	String date ="29-06-2022";
		WebElement ele =  driver.findElement(By.id("datepicker1"));

		jse.executeScript("arguments[0].setAttribute('value','"+date+"')",ele); //directly enter date using javaScript   
	*/
	   // identify date picker
	   WebElement ele =  driver.findElement(By.id("datepicker1"));
	   ele.click(); //click on date picker
	   // select date from calender
	   driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//span[text()='"+month+"']/parent::div/parent::div[contains(@class,'ui-datepicker-header ui-widget-header')]/following-sibling::table/tbody/tr//a[text()='"+date+"']")).click();
	   
	   driver.findElement(By.xpath("//a[text()='Search']")).click();    // click on searech button
	   WebElement  mess =  driver.findElement(By.xpath("//span[text()='Please enter your Origin City ']"));  // here identify the error message
	   boolean messagedisplay = mess.isDisplayed(); // check error message displayed
	   
	  // here this code is to repeat to enter start and entering locations.
	for(int i=1;i<=5;i++) {
	 if(messagedisplay)
	   { 
			jse.executeScript("document.getElementById('source').value='Nellore (By-pass)';");
			jse.executeScript("document.getElementById('destination').value='Hyderabad Airport RGIA'");
			Thread.sleep(500);
			// Identify search button. 
			 WebElement h =	driver.findElement(By.xpath("//a[text()='Search']"));
			    // change border colour as black.
				jse.executeScript("arguments[0].style.border='4px black solid'",h);
				// click on search button.
			    driver.findElement(By.xpath("//a[text()='Search']")).click();
		     // change button colour after click on search button.
			jse.executeScript("arguments[0].style.border='4px Green solid'",h);
			
		if(!messagedisplay) // check message is not displayed.
		{
			break;
		}
		
	   }
	 }  
	driver.quit();
  }
}
