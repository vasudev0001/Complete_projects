package handlingCalender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDateInSpecificMonth {
	static WebDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//label[@for='form-field-travel_comp_date']"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		Thread.sleep(2000);

		int year = 2023;

		selectMonthYear("June", year);
		System.out.println(selectCalenderDate(driver, 22));
	}

	private static String selectCalenderDate(WebDriver driver, int selectDate) {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flatpickr-innerContainer']")));
		try {
			List<WebElement> dates = driver
					.findElements(By.xpath("//span[(@class='flatpickr-day ') or contains(@class,'today')]"));
			System.out.println("size: " + dates.size());
			for (WebElement ele1 : dates) {
				String date = ele1.getText();
				if (date.equals(String.valueOf(selectDate))) {
					ele1.click();
					break;
				}
			}
		} catch (Exception e) {
			selectCalenderDate(driver, selectDate);
		}
		return driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).getAttribute("value");
	}

	private static void selectMonthYear(String month, int year) throws InterruptedException {

		wait.until(d -> d.findElement(By.id("form-field-travel_comp_date")).isEnabled());
		driver.findElement(By.id("form-field-travel_comp_date")).click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'flatpickr-calendar')]"))));
		String currentYear = driver.findElement(By.xpath("//input[contains(@class,'cur-year')]")).getAttribute("value");
		String currentMonth = driver.findElement(By.xpath("//span[@class='cur-month']")).getText();
		System.out.println(currentMonth + "-" + currentYear);

		while (!(currentYear.equals(String.valueOf(year)) && month.equals(currentMonth.trim()))) {
			if (Integer.parseInt(currentYear) < year || !month.equals(currentMonth.trim())) {
				driver.findElement(By.xpath("//span[@class='flatpickr-next-month']/*")).click();
			}
//			else if ((Integer.parseInt(currentYear) > year )) {
//				driver.findElement(By.xpath("//span[@class='flatpickr-prev-month']/*")).click();
//			}

			wait.until(
					d -> d.findElement(By.xpath("//div[@class='numInputWrapper']/input[contains(@class,'cur-year')]"))
							.isDisplayed());
			currentYear = driver.findElement(By.xpath("//input[contains(@class,'cur-year')]")).getAttribute("value");

			wait.until(ExpectedConditions
					.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[@class='cur-month']")))));
			wait.until(d -> d.findElement(By.xpath("//span[@class='cur-month']")).isDisplayed()); 
			
			currentMonth = driver.findElement(By.xpath("//span[@class='cur-month']")).getText();
			System.out.println(currentMonth + "+" + currentYear);

			if ((currentYear.equals(String.valueOf(year)) && month.equals(currentMonth.trim())))
				break;
		}
	}
}
