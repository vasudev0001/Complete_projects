package JavaWithSelenium.FrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class ProductCatalogue extends AbstractClass {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.la-ball-scale-multiple")
	WebElement productAddAnimation;

	By productAddMessager = By.xpath("//div[@aria-label='Product Added To Cart']");

	@FindBy(xpath = "//div[@class='container']/div[not(@class='d-flex flex-row mb-2')]/div")
	List<WebElement> productItems;
	@FindBy(xpath = "//div[@aria-label='Product Added To Cart']")
	WebElement productAddingMessage;

	public List<WebElement> getProducts() {
		waitUntilAllWebElementsDisplayed(productItems, 5, 200);
		List<WebElement> items = productItems;
		System.out.println(items.size());
		return items;
	}

	public WebElement getDesiredProduct(String productName) {
		List<WebElement> items = getProducts();

		WebElement desiredItem = items.stream()
				.filter(s -> s.findElement(By.xpath("./div//b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		return desiredItem;
	}

	public String addProductToCart(String productName) {
		
		String addingMessage = null;
		WebElement desiredItem = getDesiredProduct(productName);
		if (desiredItem != null) {
			desiredItem.findElement(By.xpath(".//b/following::button[not(@class='btn w-40 rounded')]")).click();
			waitUntilWebElementDisplayed(productAddAnimation, 5, 100);
			System.out.println("Animation is diaplayed when product add to chart.");
			waitUntilElementOnDomAndDisplayed(productAddMessager, 6, 200);
			addingMessage = productAddingMessage.getText();
			return addingMessage;
		} else {
			System.out.println("product not loaded in webpage");
			addingMessage = "product not loaded in webpage";
		}

		return addingMessage;
	}
	public boolean compareMessage(String actual,String expected) {
		return actual.equalsIgnoreCase(expected);
	}
}
