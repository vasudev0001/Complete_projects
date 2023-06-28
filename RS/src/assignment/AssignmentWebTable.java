package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignmentWebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()",
				driver.findElement(By.xpath("//div[@class='left-align']//table[@id='product']")));
		Thread.sleep(1000);

		List<WebElement> rowsSize = driver.findElements(By.xpath("//div[@class='left-align']//table//tr"));
		System.out.println("Number of table rows: " + rowsSize.size());
		List<WebElement> columnSize = driver.findElements(By.xpath("//div[@class='left-align']//table//th"));
		System.out.println("Number of table header columns: " + columnSize.size());

		int requredRowIndex = 3;

		for (int column = 1; column <= columnSize.size(); column++) {
			String cellData = driver
					.findElement(By
							.xpath("//div[@class='left-align']//table//tr[" + requredRowIndex + "]/td[" + column + "]"))
					.getText();
			System.out.println(cellData);
		}
	}
}
