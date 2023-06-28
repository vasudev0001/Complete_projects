package alert;

import org.openqa.selenium.Alert; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrompAlert 
{
	public static void main(String[] args) throws Exception 
	{ 
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver(); 
	  String URL = "https://selenium08.blogspot.com/2019/07/alert-test.html"; 
	  driver.get(URL); 
	  driver.manage().window().maximize(); 

	// Click on confirm button to show prompt alert box. 
	    WebElement element = driver.findElement(By.xpath("//button[@id='prompt']")); 
	     element.click(); 

	// Switching to alert from web page. 
	    Alert alert = driver.switchTo().alert(); 

	// Enter some text on prompt alert box. 
	     alert.sendKeys("dev"); 
	     Thread.sleep(1000);
	     alert.accept(); 
	    
	// Check webpage displays message with text entered in prompt box. 
	     WebElement displayMessage = driver.findElement(By.id("prompt_demo")); 
	     String getText = displayMessage.getText(); 
	     System.out.println(getText); 
	 
	  if(getText.equalsIgnoreCase("Hello dev! How are you today?"))
	  { 
	      System.out.println("Exact matched"); 
	  }
	  else { 
	     System.out.println("Something went wrong"); 
	   } 
	    driver.close(); 
	  } 
	}
	 
 


