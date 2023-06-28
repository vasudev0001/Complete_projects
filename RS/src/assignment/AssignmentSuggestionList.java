package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignmentSuggestionList {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement editBox = driver.findElement(By.id("autocomplete"));
		editBox.sendKeys("Ind");

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-1']")));
		// w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@id='ui-id-1']"))));
		Actions act = new Actions(driver);

		List<WebElement> suggestList = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		String editBoxValue=null;
		for (int i = 0; i < suggestList.size(); i++) {
			act.moveToElement(suggestList.get(i)).sendKeys(Keys.ARROW_DOWN).perform();
			editBoxValue = editBox.getAttribute("value");
			if (editBoxValue.equals("India")) 
				break;
		}
		Assert.assertEquals(editBoxValue, "India");
		System.out.println("Edit Box displaying focusing option: "+editBoxValue);
	}
}
