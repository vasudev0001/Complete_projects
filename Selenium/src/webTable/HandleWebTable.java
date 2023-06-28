package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//div[@class='left-align']//table[@id='product']")));

		String expectedTableValue = "Smith";
		List<WebElement> tableCells = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td"));
//		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr"));
		List<WebElement> tableHeader = driver.findElements(By.xpath("//div[@class='tableFixHead']//thead//th"));

//		List<WebElement> tableCells = driver.findElements(By.xpath("//div[@class='left-align']//table//tbody/tr[not(th)]/td"));
//		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='left-align']//table//tbody/tr[not(th)]"));
//		List<WebElement> tableHeader = driver.findElements(By.xpath("//div[@class='left-align']//table//th"));

		System.out.println(tableHeader.size());
		// actualRowIndex is initilized with starting index of table row(excluding header
		// row).
		int actualRowIndex = 1; // including table header actualRowIndex =2, if exclude table header
		// actualColumnIndex is initilized with starting index of table column.
		int actualColumnIndex = 1;
		for (int k = 0; k < tableCells.size(); k++) {

			if (actualColumnIndex > tableHeader.size()) {
				actualRowIndex++;
				actualColumnIndex = 1;
			}

			String cellValue = tableCells.get(k).getText().trim();
			System.out.println(actualRowIndex + ":" + actualColumnIndex + "  " + cellValue);
			if (expectedTableValue.equalsIgnoreCase(cellValue)) {
				break;
			}
			actualColumnIndex++;
		}

		System.out.println("-- Entire row data --");
		String cellValue = null;
		if ((actualColumnIndex <= tableHeader.size())) {
			for (int j = actualColumnIndex; j <= tableHeader.size(); j++) {
				cellValue = driver
						.findElement(By.xpath(
								"//div[@class='tableFixHead']//table//tbody//tr[" + actualRowIndex + "]/td[" + j + "]"))
						.getText().trim();
				System.out.print("||" + cellValue);
			}
		} else
			System.out.println("No data found");
	}
}
