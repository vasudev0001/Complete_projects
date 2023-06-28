package webTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebTable2 {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/web-table-element.php"); // http://demo.guru99.com/test/web-table-element.php

		getWebTableData("Sun Pharma.", "Prev Close (Rs)");
	}

	private void getWebTableData(String rowData, String columnHeaderName) throws InterruptedException {
		int columns = driver.findElements(By.xpath("//table[@class='dataTable']//tr/th")).size();
		int rows_including_header = driver.findElements(By.xpath("//table[@class='dataTable']//tr")).size();
		int rows_Excluding_header = driver.findElements(By.xpath("//table[@class='dataTable']/child::tbody/tr")).size();

		System.out.println("Total number of columns: " + columns);
		System.out.println("Number of rows including header: " + rows_including_header);
		System.out.println("Number of rows Excluding header: " + rows_Excluding_header);

		for (int i = 1; i <= rows_Excluding_header; i++) {
			String a = driver.findElement(By.xpath("//table[@class='dataTable']//tr[" + i + "]/td[1]")).getText();

			if (a.trim().equals(rowData)) {
				for (int j = 1; j <= columns; j++) {
					String b = driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr[1]/th[" + j + "]"))
							.getText();
					if (b.equals(columnHeaderName)) {
						String a1 = driver
								.findElement(By.xpath("//table[@class='dataTable']//tr[" + i + "]/td[" + j + "]"))
								.getText();
						System.out.println(a.trim() + " " + b + "value: " + a1);
						break;
					}
				}

				break;
			} else if (i == rows_Excluding_header && !(a.trim().equals(rowData)))
				System.out.println(rowData + " not in a table");
		}
	}
}
