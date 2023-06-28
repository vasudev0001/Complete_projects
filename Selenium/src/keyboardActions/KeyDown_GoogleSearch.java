package keyboardActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDown_GoogleSearch
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		
		WebElement box =driver.findElement(By.xpath("//input[@name='q']"));

		box.sendKeys("java");
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		List<WebElement> googlesearch = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[contains(@class,'wM6W7d')]"));
		int size =googlesearch.size();
		
		System.out.println("size: "+size);
		for(int i=0;i<size;i++)
		{
			WebElement each=googlesearch.get(i);
			String eachTect = each.getText();
		   if(!eachTect.equalsIgnoreCase("java online compiler"))
		   {
			   act.moveToElement(each).sendKeys(Keys.ARROW_DOWN).perform();
			   act.pause(1000);
		   }
		   else {
		      act.moveToElement(each).sendKeys(Keys.ENTER).perform();
		      break;
		} 
	 }	
  }
	
}
