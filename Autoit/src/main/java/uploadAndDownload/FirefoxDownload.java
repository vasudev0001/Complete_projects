package uploadAndDownload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDownload {
	@Test
	public void download() throws InterruptedException {
		String file = "PDF";
		String fileSize = "150 kB";
		WebDriverManager.firefoxdriver().setup();
		String path = System.getProperty("user.dir");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile p= new FirefoxProfile();
		p.setPreference("pdfjs.disabled",true);
		p.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		p.setPreference("browser.download.dir",path);
		p.setPreference("browser.download.folderList", 2);
		options.setProfile(p);
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//h3[text()='Documents']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_5"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ad_iframe"));
			String a = driver.findElement(By.cssSelector("div[id='dismiss-button']")).getText();
			System.out.println("-->" + a);
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='dismiss-button']/div")));
		} catch (Exception e) {
			e.printStackTrace();
			driver.switchTo().defaultContent();
		}
			try {	
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_5']")));
				driver.findElement(By.cssSelector("div[id='dismiss-button'] svg")).click();
			} catch (Exception e) {
				driver.switchTo().defaultContent();
			}
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.cssSelector("div[id='table-files_filter'] label")));
		driver.findElement(By.xpath("//table[@id='table-files']//tr/td[text()='" + file
				+ "']/following-sibling::td/a[contains(text(),'Select file size')]")).click();
		js.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.cssSelector("div[id='table-files_filter'] label")));
		driver.findElement(By.xpath("//table[@id='table-files']//tr/td[text()='" + fileSize
				+ "']/following-sibling::td/a[contains(text(),'Download sample')]")).click();
	}
}
