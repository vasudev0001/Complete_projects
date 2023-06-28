
package actions;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.interactions.Actions; 
public class DragandDrop 
{
	
	public static void main(String[] args) 
	{ 
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		  driver.manage().window().maximize(); 
		  
		  String URL = "https://selenium08.blogspot.com/2020/01/drag-drop.html"; 
		  driver.get(URL); 

		// Locate WebElements by By.id. 
		   WebElement src = driver.findElement(By.id("draggable")); 
		   WebElement trgt = driver.findElement(By.id("droppable")); 

		// Create an object of Actions class and pass driver object reference to its constructor. 
		     Actions actions = new Actions(driver); 

		// Call dragAndDrop() method of actions class. 
		     actions.dragAndDrop(src, trgt); 
		     actions.build().perform(); 
		  
		     System.out.println("Drag and drop action has been performed successfully"); 
	  } 
	}
