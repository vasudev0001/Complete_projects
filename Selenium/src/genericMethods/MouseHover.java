package genericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	// mouseHover on menu,menuopt
	/*
	 * If boolean status is true then only click on menu-option.
	 */
		public Actions menuMouseHover(WebDriver driver,String menu,String menuoption,boolean status)
		{
			status = false;
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//div[@id='top-menu']//li//span[text()='"+menu+"']"))).perform(); 
			if(status==true) {
			act.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']//ul//span[text()='"+menuoption+"']"))).click().perform(); 
			}
			else
				act.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']//ul//span[text()='"+menuoption+"']"))).perform();
				
			return act;
		}
		/*
		 * If boolean status is false then only it mousehover on menu-option and sub-menu option.
		 */
		public void submenuopt(WebDriver driver,String menu,String menuoption,String submenu_opt,boolean status)
		{
			Actions act =menuMouseHover(driver, menu, menuoption,status);
			act.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']//ul//span[text()='"+submenu_opt+"']"))).click().perform();  
			
		}

}
