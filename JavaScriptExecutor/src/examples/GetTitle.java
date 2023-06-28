package examples;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

public class GetTitle 
{
	
	 public static void main(String[] args) 
	 { 
	   System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
	   WebDriver driver = new FirefoxDriver(); 

	// Maximize the window. 
	   driver.manage().window().maximize(); 

	// Store the URL of home page in a variable URL of type String. 
	    String URL = "https://www.google.com"; 

	// Call get() method and pass URL as a parameter. 
	    driver.get(URL); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 

	// Create the JavascriptExecutor interface object by Type casting of WebDriver instance. 
	    JavascriptExecutor js = (JavascriptExecutor)driver; 

	// Call executeScript() method to get the title of web page. 
	     Object title = js.executeScript("return document.title"); // Here, the return type of executeScript() method is object. 

	// Since the return type of executeScript() method is object, we need to perform type casting to get title in String text. 
	     String getTitle = (String)title; 
	     System.out.println("Title of Home page: " +getTitle); 

	// The last three lines of code can also be written in one line like this: 
	// String getTitle = (String)js.executeScript("return document.title"); 
	   
	   driver.close(); 
	  } 
	}
