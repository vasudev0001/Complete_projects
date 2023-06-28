package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class VerifyWebTableIsSorted {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		List<WebElement> headerList = driver.findElements(By.xpath("//table[@class='table table-bordered']//th"));
		long columnIndex = getSpecificColumnIndex(headerList, "Veg/fruit name");
		System.out.println("column Index: " + columnIndex);

		WebElement ele1 = driver.findElement(By.xpath("//table[@class='table table-bordered']"));
		sorted(ele1, columnIndex);
	}

// get header index by using header Text
	private static long getSpecificColumnIndex(List<WebElement> headers, String headerName) {
		int headerIndex = 1;
		boolean flag = false;
		for (WebElement header : headers) {
			boolean b = header.getText().contains(headerName);
			if (b) {
				flag = true;
				break;
			}
			headerIndex++;
		}
		if (flag == false)
			System.out.println("No header match with name: " + headerName);
		return headerIndex;
	}

	// sorting the list and compare origional list with sorted list.
	private static void sorted(WebElement list, long columnIndex) {
		SoftAssert sa = new SoftAssert();
		int headerSize = list.findElements(By.xpath("//thead//th")).size();
		if (!(columnIndex > headerSize)) {
			List<WebElement> specificRow = list.findElements(By.xpath(".//tbody//tr/td[" + columnIndex + "]"));
			List<String> origionalList = specificRow.stream().map(s -> s.getText()).collect(Collectors.toList());
			if (origionalList.size() == 0)
				System.out.println();
			System.out.println(origionalList.size());
			System.out.println("origional list: " + origionalList);
			List<String> sortedList = origionalList.stream().sorted().collect(Collectors.toList());
			System.out.println("sorted:" + sortedList);
			sa.assertEquals(origionalList, sortedList);
			sa.assertAll();
		}
	}
}