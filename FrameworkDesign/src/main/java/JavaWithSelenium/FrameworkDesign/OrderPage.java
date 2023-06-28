package JavaWithSelenium.FrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class OrderPage extends AbstractClass {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// order list
	@FindBy(css = "table[class*=' table-bordered'] tbody tr")
	List<WebElement> ordersList;
	// order header list
	@FindBy(css = "table[class*=' table-bordered'] thead tr th")
	List<WebElement> orderTableHeaderList;

	public List<WebElement> getOrders() {
		waitUntilAllWebElementsDisplayed(ordersList, 5,100);
		return ordersList;
	}

// header count
	public int getHeaderCounnt(String headerName) {
		waitUntilAllWebElementsDisplayed(orderTableHeaderList, 5,100);
		int i = 1;
		for (WebElement webElement : orderTableHeaderList) {
			boolean b = webElement.getText().equalsIgnoreCase(headerName);
			if (b == true)
				break;
			i++;
		}
		System.out.println("Header number: " + i);
		return i;
	}

	public int itemColumnIndex(String headerName) {
		int i = getHeaderCounnt(headerName);
		int d = i - 1;
		System.out.println("product column: " + d);
		return d;
	}

	public String getOrderedProduct(String headerName, String productName) {
		int a = itemColumnIndex(headerName);
		/*
		 * 1. create stream on list.
		 * 2. In each iteration get WebElement and find element on WebElement. product name is available in a specific column.
		 * 		column index is used to find the product WebElement text.
		 * 3. fetch text from element and compare it with product name. Matched element save in filter stream.
		 * 4. get Text from element and store it in map.
		 * 5. find first found element and return it.
		 * 
		 */
		String getProduct = getOrders().stream()
				.filter(s -> s.findElement(By.xpath(".//td[" + a + "]")).getText().equalsIgnoreCase(productName))
				.map(s -> s.findElement(By.xpath(".//td[" + a + "]")).getText()).findFirst().orElse(null);

		if (getProduct != null) {
			return getProduct;
		} else
			getProduct = "Search product is not found in orders page.";
		return getProduct;
	}
}
