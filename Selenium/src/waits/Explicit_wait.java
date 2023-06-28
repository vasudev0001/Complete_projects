package waits;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Explicit_wait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://testproject.io/");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Login")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
		Function<WebDriver, Boolean> f = new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver t) {
				return t.findElement(By.id("username")).isDisplayed();
			}

		};

//		wait.until(d->d.findElement(By.id("username")).isDisplayed());
		wait.until(f);
		driver.findElement(By.id("username")).sendKeys("hello");
		driver.findElement(By.id("password")).sendKeys("123");
	}

}
