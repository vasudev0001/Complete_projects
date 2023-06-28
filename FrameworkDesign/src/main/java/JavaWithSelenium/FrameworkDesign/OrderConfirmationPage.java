package JavaWithSelenium.FrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class OrderConfirmationPage extends AbstractClass {
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// order success message locator
	By orderSuccessMessageLocator = By.cssSelector("td h1[class='hero-primary']");
	// order success message WebElement
	@FindBy(css = "td h1[class='hero-primary']")
	WebElement orderSuccessMessageElement;

	public String getOrderSuccessMessage() {
		// wait until success message to be displaying.
		waitUntilElementOnDomAndDisplayed(orderSuccessMessageLocator, 5, 200);
		// capture success message.
		String orderSuccessMessage = orderSuccessMessageElement.getText();
		return orderSuccessMessage;
	}

}
