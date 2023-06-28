package JavaWithSelenium.FrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.AbstractClass;

public class LoginPage extends AbstractClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userNameField;
	@FindBy(id = "userPassword")
	WebElement passwordField;
	@FindBy(id = "login")
	WebElement loginBtn;
	
	// login error message  // #toast-container div[class*='toast-message']    #toast-container div[aria-label^='Incorrect email or password.']
	@FindBy(css = "#toast-container div[class*='toast-message']")
	WebElement loginErrorMessage;
	
	By errorMessageLocator =By.cssSelector("#toast-container div[class*='toast-message']");

	public ProductCatalogue loginTOApplication(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}

	public String getErrorMessage() {
		waitUntilElementOnDomAndDisplayed(errorMessageLocator, 5,200);
		return loginErrorMessage.getText();
	}
}
