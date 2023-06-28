package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomepageSearch {
	By searchBox_o = By.name("q");
	By searchButton = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']");
	private WebDriver driver;
	
	public HomepageSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchField_Enter(String value) {
		driver.findElement(searchBox_o).sendKeys(value,Keys.ENTER);
	}
	
	public void searchField(String value) throws InterruptedException {
		driver.findElement(searchBox_o).sendKeys(value);
	//	WebElement ele =driver.findElement(By.xpath("//div[contains(@class,'o3j99 ikrT4e om7nvf')]"));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.moveByOffset(100, 100).click().perform();
		//ele.click();
	}
	
	public void searchButton() {
		driver.findElement(searchButton).click();
	}

}
