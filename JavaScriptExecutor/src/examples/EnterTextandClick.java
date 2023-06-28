package examples;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 
public class EnterTextandClick 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver(); 
		  driver.manage().window().maximize(); 
		 
		      String URL = "https://www.google.com"; 
		// Call get() method and pass URL as a parameter. 
		     driver.get(URL); 
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Locate the WebElement Searchbox and submit button of Google home page by By.xpath. 
		   WebElement search = driver.findElement(By.xpath("//input[@name = 'q']")); 
		   WebElement submit = driver.findElement(By.xpath("//input[@name = 'btnK']")); 

		// Create the JavascriptExecutor interface reference by Type casting of WebDriver reference. 
		   JavascriptExecutor js = (JavascriptExecutor)driver; 

		// Send a text value "Selenium" using JavascriptExecutor. 
		//   js.executeScript("arguments[0].value = 'Selenium'", search); // Line 1 

		// Click on submit button using JavascriptExecutor. 
		//   js.executeScript("arguments[0].click()", submit); // Line 2 

		// We can write Line 1 and Line 2 code in a single line like this: 
		 js.executeScript("arguments[0].value = 'Selenium', arguments[1].click()", search, submit); 

		   System.out.println("Test successful"); 
		   
		  } 
	  }


