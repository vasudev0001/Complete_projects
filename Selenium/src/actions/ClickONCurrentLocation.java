package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickONCurrentLocation
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(1000);
	WebElement gmail =	driver.findElement(By.xpath("//a[text()='Gmail']"));
	
	 Actions actions = new Actions(driver); 

	// Get the location and Coordinate (x, y) of WebElement “gmail”. Call getLocation(), getX(), and getY() methods to find the location and coordinate. 
	     int getX = gmail.getLocation().getX(); 
	     System.out.println("X coordinate: " + getX); 
	     int getY = gmail.getLocation().getY(); 
	     System.out.println("Y coordinate: " + getY); 

	// Call moveByOffset() method of Actions class to move the mouse cursor from initial position to given Offset. 
	// Pass the coordinates of x and y as parameters to moveByOffset() method. 
	     actions.moveByOffset(getX+1, getY+1).click(); 
	     actions.build().perform(); 
	  
	     System.out.println("Clicked Successfully on Gmail"); 
	   
		
	}

}
