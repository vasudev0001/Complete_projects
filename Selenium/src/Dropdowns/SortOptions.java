package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import genericMethods.Dropdown;
import genericMethods.MouseHover;

public class SortOptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://127.0.0.1/orangehrm-2.6/login.php");
		Thread.sleep(1000);
		driver.findElement(By.name("txtUserName")).sendKeys("Hello");
		driver.findElement(By.name("txtPassword")).sendKeys("Dreams");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(1000);

		MouseHover mh = new MouseHover();
		mh.menuMouseHover(driver, "PIM", "Employee List", true);
		driver.switchTo().frame("rightMenu");
		By locator = By.id("loc_code");
		sortdrpdwn(driver, locator, "-1");
		driver.switchTo().defaultContent();

		mh.submenuopt(driver, "Time", "Timesheets", "Print Timesheets", false);
		Thread.sleep(1000);
		driver.switchTo().frame("rightMenu");
		Thread.sleep(2000);
		By timeSheet = By.id("cmbEmploymentStatus");
		sortdrpdwn(driver, timeSheet, "-1");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li//span[text()='Bug Tracker']")).click();
		driver.switchTo().frame("rightMenu");
		By priority = By.id("priority");
		sortdrpdwn(driver, priority, "0");
		driver.switchTo().defaultContent();
		driver.quit();
	}

	/*
	 * This method is used to print the dropdown options, dropdown sorting options,
	 * options sorting result.
	 */
	public static void sortdrpdwn(WebDriver driver, By locator, String exclude) {
		System.out.println("************* NEW Dropdown *************");
		Dropdown dd = new Dropdown();
		String[][] a = dd.dropdownSort(driver, locator, exclude);
		for (int i = 0; i < a.length; i++) {
			switch (i) {
			case 0:
				System.out.println("Dropown option list");
				break;
			case 1:
				System.out.println("Sorted dropdown option list");
				break;
			case 2:
				System.out.println("sorting option result");
				break;
			}
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(a[i][j]);
			}
			System.out.println("---------------------------");
		}
	}
}
