package gamil;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GmailLink {
	@Test
	public void main() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://accounts.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// explicit wait
		wait.until((wd) -> wd.findElement(By.xpath("//span[text()='Create account']")).isDisplayed());
		// finding create account link element
		WebElement b = driver.findElement(By.xpath("//span[text()='Create account']"));
		// check element is displayed
		boolean bb = b.isDisplayed();

		Reporter.log("Link status: " + bb, true);
		// click on create account webElement
		b.click();
		// explicit wait
		wait.until(
				(d) -> d.findElement(By.xpath("//ul[@class='VfPpkd-StrnGf-rymPhb DMZ54e']//span[text()='For my personal use']")))
				.isDisplayed();
		// click on my self option
		driver.findElement(By.xpath("//ul[@class='VfPpkd-StrnGf-rymPhb DMZ54e']//span[text()='For my personal use']")).click();

		// String firstname =
		// driver.findElement(By.xpath("//input[@id='firstName']/following-sibling::div")).getAttribute("innerText");
		// System.out.println("text: "+firstname);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// store list of text-box names
		List<String> list = new ArrayList<String>();
		list.add("First name");
		list.add("Last name");
		list.add("Username");
		list.add("Password");

		// Retrieving hidden text from the text box
		for (int i = 0; i < 4; i++) {
			String text = (String) jse
					.executeScript("return document.getElementsByClassName('AxOyFc snByac')['" + i + "'].innerText;");
			Reporter.log("Textbox inner text: " + text, true);
			String actualtext = list.get(i);
			// here verify the innerText in text boxes
			assertEquals(text, actualtext, actualtext + " is mismatched");
		}
		Reporter.log("inner text in all text boxes are displayed correctly", true);

		// getting text from user name text-box
		String un = driver.findElement(By.xpath("//input[@id='username']/following-sibling::div")).getText();
		Reporter.log("username text: " + un, true);

		// getting mail text : @gmail.com
		String unt = driver.findElement(By.xpath("//span[@class='A37UZe sxyYjd MQL3Ob']/span")).getText();
		Reporter.log("username mail text: " + unt);

		// click on check box
		driver.findElement(By.xpath("//input[@class='VfPpkd-muHVFf-bMcfAe']")).click();
		// Button text
		String btn = driver
				.findElement(
						By.xpath("//div[@id='accountDetailsNext']//following-sibling::span[@class='VfPpkd-vQzf8d']"))
				.getText();
		Reporter.log("Button text: " + btn, true);

		String ltext = driver
				.findElement(By.xpath("//div[@class='daaWTb']//div[@class='VfPpkd-Jh9lGc']//following-sibling::span"))
				.getText();
		Reporter.log("Link text: " + ltext, true);
		driver.quit();
	}
}
