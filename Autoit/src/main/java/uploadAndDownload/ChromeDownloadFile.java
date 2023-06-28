package uploadAndDownload;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDownloadFile {

	@Test
	public void downloadFile() {
		String file="PDF";//"DOC, DOCX";
		String fileSize="100 kB";
		WebDriverManager.chromedriver().setup();
		String path = System.getProperty("user.dir");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> pref = new HashMap<String, Object>();
		pref.put("plugins.always_open_pdf_externally", true);
		pref.put("download.default_directory", path);
		options.setExperimentalOption("prefs", pref);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//h3[text()='Documents']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		try {
		driver.switchTo().frame(driver.findElement(By.id("aswift_5")));
		driver.switchTo().frame("ad_iframe");
		driver.findElement(By.cssSelector("div[id='dismiss-button']")).click();
		}catch (Exception e) {
			driver.switchTo().frame("aswift_5");
			driver.switchTo().frame("ad_iframe");  
			driver.findElement(By.cssSelector("div[id='dismiss-button'] svg")).click();
		}
		
		
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.cssSelector("div[id='table-files_filter'] label")));
		driver.findElement(By.xpath("//table[@id='table-files']//tr/td[text()='"+file+"']/following-sibling::td/a[contains(text(),'Select file size')]")).click();
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.cssSelector("div[id='table-files_filter'] label")));
		driver.findElement(By.xpath("//table[@id='table-files']//tr/td[text()='"+fileSize+"']/following-sibling::td/a[contains(text(),'Download sample')]")).click();
		
	}

}
