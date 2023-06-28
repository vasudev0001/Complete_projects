package downloads;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class File {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String file = "PDF"; // "DOC, DOCX"
		String filetype = "pdf";
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//
		ChromeOptions opt = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", "C:\\Users\\91766\\Desktop\\Downloads");
		opt.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//h3[text()='Documents']"));
		String scrol = "arguments[0].scrollIntoView()";
		jse.executeScript(scrol, ele);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();

		// ********************* Handle advertisement *********************
		try {
			driver.switchTo().frame("aswift_5");
			wait.until(d -> d.findElement(By.xpath("//div[@id='card']")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//div[@id='card']")).isDisplayed());
			driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			wait.until(d -> d.findElement(By.xpath("//div[@id='card']")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//div[@id='card']")).isDisplayed());
			driver.switchTo().frame("ad_iframe");
			driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
			driver.switchTo().defaultContent();
		} finally {
			wait.until(d->d.findElement(By.xpath("//div[@id='table-files_filter']//label[text()='Search:']")).isDisplayed());
			WebElement e = driver.findElement(By.xpath("//div[@id='table-files_filter']//label[text()='Search:']"));
			System.out.println(e.isDisplayed());
			String scrol1 = "arguments[0].scrollIntoView()";
			jse.executeScript(scrol1, e); // perform scrolling
			WebElement ee = driver.findElement(By.xpath(
					"//table[@id='table-files']//tbody//tr/td[text()='" + file + "']/following-sibling::td[2]/a"));
			System.out.println("pdf button displayed: " + ee.isDisplayed());
			ee.click();

			String scrol2 = "arguments[0].scrollIntoView()";
			jse.executeScript(scrol2,
					driver.findElement(By.xpath("//div[@id='table-files_filter']/label[text()='Search:']")));
			driver.findElement(By.xpath("(//td[text()='"+filetype+"'])[1]/following-sibling::td/a")).click();

		}
	}
}
