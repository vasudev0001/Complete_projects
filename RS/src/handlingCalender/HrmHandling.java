package handlingCalender;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HrmHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/orangehrm-2.6/");
		driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("Hello");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Dreams");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
		Actions act = new Actions(driver);

		String ele1 = mouseHoverOnMenu(driver, "time", act);
		System.out.println("mouse hover on menu: " + ele1);
		String ele2 = menuopt(driver, ele1, "timesheets");
		System.out.println("mouse hover on menuoption: " + ele2);
		String ele3 = clickOnMenuOpt(driver, ele2, "print timesheets");
		System.out.println("clicked on submenu option: " + ele3);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

//		wait.until(new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//			}
//		});

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("rightMenu"))));

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnStartDate")));

		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.id("btnStartDate")));

		driver.findElement(By.id("btnStartDate")).click();
		WebElement e = driver.findElement(By.xpath("//div[@id='cal1Container']"));
		if (!e.isDisplayed()) {
			System.out.println("->");
			act.moveToElement(driver.findElement(By.id("btnStartDate"))).click().perform();
		}

		String a = driver.findElement(By.xpath("//div[@class='calheader']")).getAttribute("innerText");
		String[] b = a.split("\n");
		System.out.println(b[2]);
		String c[] = b[2].split(" ");
		String actualMonth = c[0].trim();
		String actualYear = c[1].trim();
		System.out.println(c[1]);
		
		String expectedMonth = "January";
		int actualMonthNum = getMonthNumber(actualMonth);
		int ExpectedMonthNum = getMonthNumber(expectedMonth);
		selectMonth(driver, actualMonthNum, ExpectedMonthNum);
		
		selectYear(driver,actualYear,1998);
		String selectedMonth=selectDate(driver,9);
		System.out.println("selected date in calender: "+selectedMonth);

	}
	
	//---------selectDay------
	private static String selectDate(WebDriver driver,int date) {
		List<WebElement> a1=driver.findElements(By.xpath("//tbody[contains(@class,'calbody')]//td[not(contains(@class,'oom'))]/a"));
		for(WebElement ele:a1) {
			if(ele.getText().equals(String.valueOf(date)))
				ele.click();
		}
		return driver.findElement(By.id("txtStartDate")).getAttribute("value");
	}

	// ---------Select year-------------
	private static void selectYear(WebDriver driver, String actualYear, int expectedYear) {

		while (!(Integer.valueOf(actualYear) == expectedYear)) {
			if (Integer.valueOf(actualYear) > expectedYear) {
				driver.findElement(By.xpath("//a[@class='calnavfirst']")).click();
			} else if (Integer.valueOf(actualYear) < expectedYear) {	
				driver.findElement(By.xpath("//a[@class='calnavlast']")).click();
			} 
			String a = driver.findElement(By.xpath("//div[@class='calheader']")).getAttribute("innerText");
			String[] b = a.split("\n");
			String c[] = b[2].split(" ");
			 actualYear = c[1].trim();
			System.out.println(c[1]);
			if (Integer.valueOf(actualYear) == expectedYear) {
				break;
			}
		}
	}

	// ------------select month-------------
	private static void selectMonth(WebDriver driver, int actualMonthNumber, int expectedMonthNumber) {

		System.out.println(expectedMonthNumber);
		System.out.println(actualMonthNumber);
		while (true) {
			if (expectedMonthNumber >= actualMonthNumber) {
				System.out.println("click on left side");
				expectedMonthNumber--;
			} else if (expectedMonthNumber <= actualMonthNumber) {
				System.out.println("click on right side");
				driver.findElement(By.xpath("//a[@class='calnavleft']")).click();
				expectedMonthNumber++;
			}
			if (expectedMonthNumber == actualMonthNumber)
				break;
		}
	}

	private static int getMonthNumber(String month) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "January");
		map.put(2, "February");
		map.put(3, "March");
		map.put(4, "April");
		map.put(5, "May");
		map.put(6, "June");
		map.put(7, "July");
		map.put(8, "August");
		map.put(9, "September");
		map.put(10, "October");
		map.put(11, "November");
		map.put(12, "December");
		int monthIndex = 0;
		Set<Entry<Integer, String>> s1 = map.entrySet();
		Iterator<Entry<Integer, String>> itr = s1.iterator();
		while (itr.hasNext()) {
			Entry<Integer, String> m1 = itr.next();
			if (month.equals(m1.getValue()))
				monthIndex = m1.getKey();
		}
		return monthIndex;
	}

//------------- MouseHover--------------------
	private static String mouseHoverOnMenu(WebDriver driver, String menu, Actions act) {
		List<WebElement> menuList = driver.findElements(By.xpath("//ul[@id='nav']/li"));
		String ele1 = null;
		for (WebElement ele : menuList) {
			if (ele.getText().trim().equalsIgnoreCase(menu)) {
				ele1 = ele.getText();
				act.moveToElement(ele).perform();
				break;
			}
		}
		return ele1;
	}

	private static String menuopt(WebDriver driver, String ele1, String menuOption) throws InterruptedException {
		Actions act = new Actions(driver);
		List<WebElement> menuOptionList = driver
				.findElements(By.xpath("//span[.='" + ele1 + "']/../following-sibling::ul/li/a/span"));
		String option = null;
		for (WebElement ele : menuOptionList) {
			option = ele.getAttribute("textContent").trim();
			if (option.equalsIgnoreCase(menuOption)) {
				act.moveToElement(ele).perform();
				break;
			}
		}
		return option;
	}

	private static String clickOnMenuOpt(WebDriver driver, String ele1, String menuOption) throws InterruptedException {
		Actions act = new Actions(driver);
		List<WebElement> menuOptionList = driver
				.findElements(By.xpath("//span[.='" + ele1 + "']/../following-sibling::ul/li/a/span"));
		String option = null;
		for (WebElement ele : menuOptionList) {
			option = ele.getAttribute("textContent").trim();
			if (option.equalsIgnoreCase(menuOption)) {
				act.moveToElement(ele).click().perform();
			}
		}
		return option;
	}
}