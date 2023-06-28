package alert;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.Alert; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 

public class SimpleAlart
{
	
	
	public static void main(String[] args) 
	{ 
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	// Create an object of FirefoxDriver class. 
	   WebDriver driver = new FirefoxDriver(); 
	   String URL="https://selenium08.blogspot.com/2019/07/alert-test.html"; 
	  
	   driver.get(URL); driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	   driver.manage().window().maximize(); 

	// Click on simple alert button to show alert box. 
	   WebElement element = driver.findElement(By.xpath("//input[@id='simple']")); 
	    element.click(); 

	// Switching to Alert from webpage. 
	     Alert alert = driver.switchTo().alert(); 

	// Get or read the text displayed on Alert popup and save it in a string using variable "getText" in order to print it later. 
	     String getText = driver.switchTo().alert().getText(); 
	     System.out.println(getText); 

	// Check that the correct message is displayed to the user Alert box. 
	     if(getText.equalsIgnoreCase("Hello! I am a simple alert box!")) 
	     { 
	// Display a message that indicates whether verification was successful. 
	      System.out.println("It worked, the expected simple alert was shown"); 
	       } 
	     else 
	     { 
	         System.out.println("Something went wrong, expected simple alert was not shown"); 
	       } 
	// Click OK button, by calling accept() method. 
	      alert.accept(); 
	      driver.close(); 
	  } 
	}


