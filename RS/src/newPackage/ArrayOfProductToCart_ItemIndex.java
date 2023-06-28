package newPackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * Add items to chart.
 * checkout the chart
 * palce order
 */
public class ArrayOfProductToCart_ItemIndex {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String addProduct[] = {"Capsicum", "Potato", "Carrot", "Tomato", "Beans", "Capsicum"};
		List<String> a = Arrays.asList(addProduct);
		
		int j = 0;
		List<WebElement> prouctlist = driver
				.findElements(By.xpath("//div[@class='product']/h4[@class='product-name']"));
		System.out.println(prouctlist.size());

		for (int i = 0; i < prouctlist.size(); i++) {
			String itemName = prouctlist.get(i).getText().split("-")[0].trim();
			if (a.contains(itemName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (a.size() == j)
					break;
			}
		}

		// ************** checkout chart **************
		// click on chart icon
		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		
		List<WebElement> cartItems = driver
				.findElements(By.xpath("//div[@class='cart-preview active']//p[@class='product-name']"));
		System.out.println("list of chart items: ");
		for (int i = 0; i < cartItems.size(); i++) {
			System.out.println(cartItems.get(i).getText());
		}
		// click on proceed to chechout button
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		WebDriverWait wait = webDriverWait(driver, 3, "seconds");
		wait.until(d -> d.findElement(By.cssSelector("input[placeholder='Enter promo code']")).isEnabled());
		// enter promocode
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		// click on promo code apply button
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		// click on place order button
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		// country dropdown
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='wrapperTwo']//following-sibling::div/select"));
		Select selectDropdown = new Select(dropdown);
		selectDropdown.selectByVisibleText("India");
		// click on checkbox
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		// click on proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}

	private static WebDriverWait webDriverWait(WebDriver driver, long waitValue, String waitType) {
		WebDriverWait wait = null;
		switch (waitType) {
		case "millis":
			wait = new WebDriverWait(driver, Duration.ofMillis(waitValue));
		case "seconds":
			wait = new WebDriverWait(driver, Duration.ofSeconds(waitValue));
		}
		return wait;
	}
}
