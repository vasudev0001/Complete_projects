package webTable;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableEx {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//div[@class='left-align']//table[@id='product']")));

		String header = "city";
		String row = "Kolkata";
		// table header list
		List<WebElement> tableHeader = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr/th"));
		// get table column number
		int actualHeaderNum = getColumnHeaderNumber(header, tableHeader);
		System.out.println("actualHeaderNum: " + actualHeaderNum);

		List<WebElement> actualRows = driver.findElements(
				By.xpath("//div[@class='tableFixHead']//following-sibling::tbody/tr/td[" + actualHeaderNum + "]"));
		// get table row number
		int actualRowCount = getTableRowNum(row, actualRows);
		System.out.println("actualRowCount: " + actualRowCount);
//
		String a = getTableValue(driver, actualRowCount, actualHeaderNum);
		System.out.println(a);
		System.out.println("table value: " + a);
		By locator = By.xpath("//div[@class='tableFixHead']//tr/th");
		List<String> b = getEntireRowData(driver, locator, actualRowCount);
		System.out.println(b);

		List<String> specificdata = getSpecificColumnsRowData(driver, locator, actualRowCount, actualHeaderNum);
		System.out.println(specificdata);
	}

// get table header num
	public static int getColumnHeaderNumber(String header, List<WebElement> ele) {
		String actualHeader = "";
		int actualHeaderNumber = 0;
		for (int i = 0; i < ele.size(); i++) {
			actualHeader = ele.get(i).getText().trim();
			if (actualHeader.equalsIgnoreCase(header))
				actualHeaderNumber = i + 1;
		}
		return actualHeaderNumber;
	}

// get row num
	public static int getTableRowNum(String row, List<WebElement> actualRows) {
		String rowValue = "";
		int actualRowCount = 0;
		for (int i = 0; i < actualRows.size(); i++) {
			rowValue = actualRows.get(i).getText().trim();
			if (row.equalsIgnoreCase(rowValue)) {
				actualRowCount = i + 1;
				break;
			}
		}
		return actualRowCount;
	}

	// get table value
	public static String getTableValue(WebDriver driver, int actualRowCount, int actualHeaderNum) {
		String rowData = "";
		if (actualRowCount != 0) {
			rowData = driver.findElement(By.xpath("//div[@class='tableFixHead']//following-sibling::tbody/tr["
					+ actualRowCount + "]/td[" + actualHeaderNum + "]")).getText().trim();
		} else {
			System.out.println("data not found ");
		}
		return rowData;
	}

	public static List<String> getSpecificColumnsRowData(WebDriver driver, By locator, int actualRowCount,
			int specificColumns) {
		String rowData = "";
		List<String> entireRowData = new ArrayList<>();
		List<WebElement> a = driver.findElements(locator);
		for (int actualHeaderNum = specificColumns; actualHeaderNum <= a.size(); actualHeaderNum++) {
			rowData = getTableValue(driver, actualRowCount, actualHeaderNum);
			entireRowData.add(rowData);
		}
		return entireRowData;
	}

	// get Entire row data
	public static List<String> getEntireRowData(WebDriver driver, By locator, int actualRowCount) {
		String rowData = "";
		List<String> entireRowData = new ArrayList<>();
		List<WebElement> a = driver.findElements(locator);
		for (int actualHeaderNum = 1; actualHeaderNum <= a.size(); actualHeaderNum++) {
			rowData = getTableValue(driver, actualRowCount, actualHeaderNum);
			entireRowData.add(rowData);
		}
		return entireRowData;
	}
}
