package JavaWithSelenium.FrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class CheckOutPage extends AbstractClass {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// country Suggestion List locator.
	By countrySuggestionList = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	// country selection dropdown WebElement.
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryDropDown;
	// countries Suggestion list.
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> countriesList;
	// place order button WebElement
	@FindBy(xpath = "//a[contains(@class,'action__submit')]")
	WebElement placeOrderButton;

	public void sendCountry(String countryName) {
		countryDropDown.sendKeys(countryName);
		waitUntilElementOnDomAndDisplayed(countrySuggestionList, 5,200);

	}

	public String selectCountryFromList(String Country) {
		WebElement desiredCountry = countriesList.stream().filter(s -> s.getText().equalsIgnoreCase(Country))
				.findFirst().orElse(null);
		if (desiredCountry != null) {
			System.out.println(Country + " is selected");
			desiredCountry.click();
		} else
			System.out.println(Country + " not in country list");
		return countryDropDown.getAttribute("value");
	}

	// click on place order button.
	public OrderConfirmationPage clickOnPlaceOrderButton() {
		placeOrderButton.click();
		OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(driver);
		return orderConfirmation;
	}
}
