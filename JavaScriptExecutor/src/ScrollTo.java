import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollTo {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String scroll = "window.scrollTo(0,500)"; // x-axis, Y-axis
		jse.executeScript(scroll);
	}
}
