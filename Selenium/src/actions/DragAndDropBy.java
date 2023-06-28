package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		  driver.manage().window().maximize(); 
		 
		   String URL = "https://selenium08.blogspot.com/2020/01/drag-me.html"; 
		   driver.get(URL); 

		// Locate WebElements by By.id. 
		   WebElement src = driver.findElement(By.id("draggable")); 

		// Create an object of Actions class and pass the driver object reference to its constructor. 
		   Actions actions = new Actions(driver); 

		// Call dragAndDropBy() method of actions class. 
		     actions.dragAndDropBy(src, 250, 10).perform(); 
		      
		
	}

}
