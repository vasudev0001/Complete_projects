package handlinkLinks;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingFooterLinks {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footerFirstColumn = driver.findElement(By.xpath("//div[@id='gf-BIG']//tr/td[1]"));
		List<WebElement>footerFirstColumnLinks=footerFirstColumn.findElements(By.tagName("a"));
		System.out.println(footerFirstColumnLinks.size());

		for (int i = 1; i < footerFirstColumnLinks.size(); i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerFirstColumnLinks.get(i).sendKeys(clickOnLinkTab);
		}

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> childs = tabs.iterator();
		
		while (childs.hasNext()) {
			String tab = childs.next();
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}

	}

}
