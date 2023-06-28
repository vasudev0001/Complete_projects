package JavaWithSelenium.FrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class CartPage extends AbstractClass {
	WebDriver driver;

	// cart products locator
	By productsInChart = By.xpath("//ul[contains(@class,'cartWrap')]/li//h3");
	// cart Item WebElement
	@FindBy(xpath = "//ul[contains(@class,'cartWrap')]/li//h3")
	List<WebElement> listOfCartItems;
	// checkOut button
	@FindBy(css = "div[class='subtotal cf ng-star-inserted'] button")
	WebElement checkOutBtn;
	
	@FindBy(css="div[class='heading cf'] h1")
	WebElement cartPageHeading;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// get Cart Products
	public List<WebElement> getChartItems() {
		waitUntilAllWebElementsDisplayed(listOfCartItems, 10, 200);
		return listOfCartItems;
	}
	// get product count in cart.
	public int getChartItemsSize() {
		return getChartItems().size();
	}
	public String getChartHeading() {
		waitUntilWebElementDisplayed(cartPageHeading, 5,200);
		return cartPageHeading.getText();
	}
	
	
	// return true when product is available.
	public boolean verifyProductInCart(String productName) {
		return getChartItems().stream().filter(s2 -> s2.getText().equalsIgnoreCase(productName)).map(s2 -> s2.getText())
				.anyMatch(s2 -> s2.equalsIgnoreCase(productName));
	}

	public String getProductInCart(String productName) {
		String productNameInCart = getChartItems().stream().filter(s -> s.getText().equalsIgnoreCase(productName))
				.map(s -> s.getText()).findFirst().orElse(null);
		String productInCart = (productNameInCart != null) ? productNameInCart : productName + " not in chart";
		return productInCart;
	}

	// click on checkOut Btn
	public CheckOutPage clickOnCheckOutBtn() {
		scrollUntilView(checkOutBtn);
		waitUntilWebElementDisplayed(checkOutBtn, 4, 200);
		Actions act = new Actions(driver);
		act.click(checkOutBtn).perform();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
}
