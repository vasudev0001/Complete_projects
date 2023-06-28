package streams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class GetItemPriceFromWebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebElement headers = driver.findElement(By.xpath("//table[contains(@class,'table')]"));
		int column = getHeaderIndex(headers, "Veg/fruit name");
		System.out.println("header Index:"+column);

		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table')]"));
		getItemPrice(table, "Wheat", column);
		
	}

	private static void getItemPrice(WebElement table, String rowValue, int ColumnIndex) {

		List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr/td[" + ColumnIndex + "]"));
		boolean flag = false;
		int rowIndex = 1;
		for (WebElement ele : rows) {
			boolean b = ele.getText().contains(rowValue);
			if (b == true) {
				flag = true;
				break;
			}
			rowIndex++;
		}
		int column=getHeaderIndex(table,"price");
		if(flag==true) {
			String rowText = table.findElement(By.xpath(".//tbody//tr[" + rowIndex + "]/td[" + column + "]"))
					.getText();
			System.out.println( rowText);
			Assert.assertEquals(rowText, "67");
			System.out.println("It display correct item price");
		}else
			System.out.println("item not found in a rows");
	}

	private static int getHeaderIndex(WebElement table, String headerName) {
		List<WebElement>headers=table.findElements(By.xpath(".//thead/tr/th"));
		int headerIndex = 1;
		boolean flag = false;
		for (WebElement header : headers) {
			boolean b = header.getText().equalsIgnoreCase(headerName);
			if (b == true) {
				flag = true;
				break;
			}
			headerIndex++;
		}
		if (flag == false)
			System.out.println("header is not found:" + headerName);
		return headerIndex;
	}

}
