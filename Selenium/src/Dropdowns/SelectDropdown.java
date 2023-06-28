package Dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericMethods.Dropdown;
import genericMethods.MouseHover;

public class SelectDropdown {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

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
		mh.submenuopt(driver, "Leave", "Leave Summary", "Employee Leave Summary", false);
		Thread.sleep(1000);
		driver.switchTo().frame("rightMenu");

		By locator1 = By.name("year");
		By locator_leave = By.name("leaveTypeId");
		Dropdown dd = new Dropdown();
		dd.doSelectByVisibleText(driver, locator1, "2023");
		dd.doSelectByVisibleText(driver, locator_leave, "Medical");

		System.out.println("dropdown selected option: " + driver.findElement(By.name("year")).getAttribute("value"));

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		mh.submenuopt(driver, "Leave", "Define Days Off", "Days Off", false);
		driver.switchTo().frame("rightMenu");

		By monadydd = By.xpath("(//select[@name='sltLeaveLength[]'])[1]");
		By tuedd = By.xpath("(//select[@name='sltLeaveLength[]'])[2]");
		By weddd = By.xpath("(//select[@name='sltLeaveLength[]'])[3]");
		Thread.sleep(1000);
		// ------------------------------------------
		String ele = driver.findElement(monadydd).getAttribute("value");
		System.out.println(driver.findElement(By.xpath("//option[@value='" + ele + "']")).getAttribute("textContent"));

		dd.dropdownSelection(driver, monadydd, "index", "1"); // webddriver, locator, selection_type, select_option

		ele = driver.findElement(monadydd).getAttribute("value");
		System.out.println(driver.findElement(By.xpath("//option[@value='" + ele + "']")).getAttribute("textContent"));
		// ------------------------------------------
		dd.dropdownSelection(driver, tuedd, "visible_text", "Full Day");
		dd.dropdownSelection(driver, weddd, "value", "4");
		driver.switchTo().defaultContent();
	}
}
