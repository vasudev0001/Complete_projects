package winowHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

//	public Actions menuMouseHover(WebDriver driver,By menu_l,By opt_l,boolean status) throws InterruptedException
//	{
//	//	status = false;
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(menu_l)).perform(); 
//		if(status==true) {
//			Thread.sleep(1000);
//			System.out.println(status);
//		act.moveToElement(driver.findElement(opt_l)).click().perform(); 
//		}
//		else
//			act.moveToElement(driver.findElement(opt_l)).perform();
//			
//		return act;
//	}
	public void menuMouseHover(WebDriver driver,String menu,String menu_opt) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='nav1']//li//a[text()='"+menu+"']"))).perform(); 
		
			Thread.sleep(500);
			List<WebElement> ele =driver.findElements(By.xpath("//ul[@id='nav1']//li//a[text()='"+menu+"']/following-sibling::ul/li/a"));

			for(WebElement element:ele)
			{
				String tag = element.getText();
				if(tag.equals(menu_opt)) {
				element.click();
				break;
				}
				else
					act.moveToElement(element).perform();
			}
		}
	}

