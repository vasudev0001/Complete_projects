package winowHandle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Win1 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Window
		driver.get("https://www.flipkart.com/"); // https://www.flipkart.com/
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='_2QfC02']/button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("mobiles", Keys.ENTER);
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(
				By.xpath("(//div[@class='_2kHMtA']/a/div[@class='_3pLy-c row']/*/div[@class='_4rR01T'])"));
		for (int i = 0; i <= 3; i++) {
			elements.get(i).click();
			Thread.sleep(1000);
		}
		win();
		switchToWindow(0);
		driver.findElement(By.xpath("(//div[@class='_2kHMtA']/a/div[@class='_3pLy-c row']/*/div[@class='_4rR01T'])[5]"))
				.click();

	}

	private static ArrayList<String> win() throws InterruptedException {
		// String parent = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<>();
		Iterator<String> I1 = windows.iterator(); // iterate windows
		String child_window = "";
		while (I1.hasNext()) // it will return true until getting last String.
		{
			child_window = I1.next();
			list.add(child_window);
		}
		return list;
	}

	private static void switchToWindow(int index) throws InterruptedException {
		ArrayList<String> list = win();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(list.get(index))) {
				driver.switchTo().window(list.get(i));
			}
		}
	}
}
