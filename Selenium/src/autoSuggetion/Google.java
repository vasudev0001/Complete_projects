package autoSuggetion;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit
		// wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String searchData = "selenium webdriver";
		String entersearch = "sele";

		WebElement txtbox = driver.findElement(By.xpath("//input[@name='q']"));

		System.out.println(txtbox.isDisplayed());
		System.out.println(txtbox.isEnabled());

		txtbox.sendKeys(entersearch);
		wait.until(d -> d.findElement(By.xpath("//div[@jsname='aajZCb']")).isDisplayed());
		List<WebElement> a = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li//div[@class='wM6W7d']/span"));
		Actions act = new Actions(driver);

		System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			WebElement ele = a.get(i);
			String text = ele.getText();
			System.out.println(text);
			if (searchData.equalsIgnoreCase(text)) {

				act.moveToElement(ele).click().perform();
				break;
			}
		}

	}

}
