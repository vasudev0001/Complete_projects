package booking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");

		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[text()='OK']")).click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Later']")).click();
		driver.findElement(By.xpath("//p-calendar[@id='jDate']//input")).click();
		driver.findElement(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[text()='30']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// search box
		WebElement from = driver.findElement(By.xpath("//p-autocomplete[@id='origin']//input"));
		from.sendKeys("Gudu");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-autocomplete-panel')]")));
		list(driver, "GUDUR JN - GDR");

		WebElement To = driver.findElement(By.xpath("//p-autocomplete[@id='destination']//input"));
		To.sendKeys("Sec");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ui-autocomplete-panel')]")));
		list(driver, "SECUNDERABAD JN - SC");

		driver.findElement(By.xpath("//label[text()='Flexible With Date']/preceding-sibling::input/parent::span"))
				.click(); //
		driver.findElement(By.xpath("//button[text()='Search' or @class='search_btn train_Search']")).click(); // search
																												// button
		Thread.sleep(1000);
	}

	private static void list(WebDriver driver, String option) // WebDriver reference , Expected option
	{
		Actions act = new Actions(driver);
		List<WebElement> aa = driver
				.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete-items ui-autocomplete-list')]/li/span"));
		int Listsize = aa.size();
		System.out.println("size of list: " + Listsize);
		System.out.println("List of Elements for " + option);
//		for(WebElement a:aa)
//		{
//			System.out.println(a.getText());
//		}
		for (int i = 0; i < Listsize; i++) {
			WebElement oneWeb = aa.get(i);
			String text = oneWeb.getText();

			/*
			 * here compare two Strings, if Strings are not equal it will return true and if
			 * block is executed. inside if block perform keyboard down Arrow. if block
			 * expresion is false. then else block is executed. inside else block perform
			 * Enter.
			 * 
			 * note: perform keyboard down-Arrow until Expected and actual texts are
			 * matched. whenever texts are matched press keyboard Enter-key. Whenever
			 * expected text and actual text are matched then break statement is executed
			 * and loop is immediately terminated. Actual text =
			 * "getting text during execution of program". Expected text =
			 * " what kind of text (data) is user expected".
			 */
			if (!text.equals(option)) // here expected text is "SECUNDERABAD JN - SC"
			{
				act.moveToElement(oneWeb).sendKeys(Keys.ARROW_DOWN).perform(); // perform keyboard down arrow button
			} else {
				act.moveToElement(oneWeb).sendKeys(Keys.ENTER).perform(); // perform enter keyboard enter button
				break;
			}
		}
	}
}
