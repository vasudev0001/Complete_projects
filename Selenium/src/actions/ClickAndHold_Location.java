package actions;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.interactions.Actions; 
public class ClickAndHold_Location
{
	
	 public static void main(String[] args) 
	 { 
		 System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	   WebDriver driver = new FirefoxDriver(); 
	   driver.manage().window().maximize(); 
	   
	   String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html"; 
	   driver.get(url); 

	// Locate the element C by By.xpath. 
	     WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']")); 

	// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
	     Actions actions = new Actions(driver); 

	// Move the cursor to the position of element C. 
	     actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation. 
	     actions.clickAndHold().perform(); 
	  } 
	}


