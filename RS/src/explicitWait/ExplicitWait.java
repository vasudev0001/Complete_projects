package explicitWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 
		 // send username
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("rahulshettyacademy");
		// send password
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		// click on user radio button
		driver.findElement(By.xpath("//span[.=' User']//following-sibling::span")).click();
	   
	  // wait ubtil ok button is displayed
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#okayBtn"))));
	    // click on flash message okay button
		driver.findElement(By.cssSelector("#okayBtn")).click();
		// finding dropdown webElement
		WebElement dropdown= driver.findElement(By.cssSelector("select.form-control"));
		Select dropdwn = new Select(dropdown);
		// select dropdown option
		dropdwn.selectByVisibleText("Student");
		// click on check box
		driver.findElement(By.cssSelector("#terms")).click();
		// click on sign button  
		driver.findElement(By.cssSelector("#signInBtn")).click();
		// wait until landing page heading is displayd
	    wait.until(d->d.findElement(By.xpath("//div[@class='container']/a[@class='navbar-brand']")).isDisplayed());
	    // get the list of items in page
		List<WebElement> itemsList =driver.findElements(By.cssSelector("app-card-list.row app-card div.card-footer button"));
		// iterate list and click on each webElement add button( to add chart)
		for(WebElement item:itemsList) {
			item.click();
		}
		// click on checkout button in home page
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		// click on checkout button chart
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')] ")).click();
		// send country
		driver.findElement(By.cssSelector("input#country")).sendKeys("India");
		// wait until suggestion is displayed
		wait.until(d->d.findElement(By.cssSelector("div.suggestions li")).isDisplayed());
		// click on list option
		driver.findElement(By.cssSelector("div.suggestions li")).click();
		
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']"))));
		// click on ckeckbox
		driver.findElement(By.xpath("//div[@class='checkbox checkbox-primary']")).click();
		// click on purchase button
		driver.findElement(By.cssSelector("input.btn.btn-success.btn-lg")).click();
		
		
		
	}

}
