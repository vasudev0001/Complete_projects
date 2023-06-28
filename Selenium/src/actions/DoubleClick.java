package actions;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.interactions.Actions; 

public class DoubleClick 
{
	
	public static void main(String[] args) 
	{ 
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	// Create a driver object for Firfox browser. 
	    WebDriver driver = new FirefoxDriver(); 

	// Maximize web browser. 
	   driver.manage().window().maximize(); 

	// Store URL in a variable URL of String type. 
	   String url = "https://selenium08.blogspot.com/2019/11/double-click.html"; 

	// Call get() method and pass the URL as an input parameter. 
	   driver.get(url); 

	// Wait for loading complete web page. 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	// Locate WebElement by using By.xpath. 
	    WebElement dblclick = driver.findElement(By.xpath("//button[text() = 'Double-Click me to see Alert message']")); 

	// Create an object of Actions class and pass the driver as an parameter. 
	   Actions actions = new Actions(driver); 

	// Call moveToElement() method to move the mouse to the location of button element and pass element as an input parameter. 
	   actions.moveToElement(dblclick); // Line 1. 

	// Call doubleClick() method to peform the double-click action at current location. 
	    actions.doubleClick(); // Line 2. 

	// Call perform() method to perform a sequence of actions. 
	   actions.perform(); //Line 3. 

	// The Line 1, Line 2, and Line 3 can also be written in a single line like this: 
	// actions.moveToElement(dblclick).doubleClick().perform(); 

	  System.out.println("Double click action performed successfully at current location"); 
	  } 
	}

