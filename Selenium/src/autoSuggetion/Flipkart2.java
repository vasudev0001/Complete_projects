package autoSuggetion;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String searchData = "camera";
		String entersearch = "cam";

		driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click(); // click on notification cancel button.
		driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")).sendKeys(entersearch);
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")))
				.sendKeys(Keys.ARROW_DOWN).perform();
		String text = driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")).getAttribute("value");
		while (!(searchData.equalsIgnoreCase(text))) {
			act.moveToElement(driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")))
					.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
			text = driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']")).getAttribute("value");
			String t1 = text.replaceAll("\\s", " ");
			text = t1;
			System.out.println(text);
		}

		act.moveToElement(driver.findElement(By.xpath("//div[@class='_3OO5Xc']/input[@name='q']"))).sendKeys(Keys.ENTER)
				.perform();

	}
}
