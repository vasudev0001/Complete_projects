package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import JavaWithSelenium.FrameworkDesign.CartPage;
import JavaWithSelenium.FrameworkDesign.OrderPage;

public class AbstractClass {

	WebDriver driver;

	// cart btn WebElement.
	@FindBy(xpath = "//button[contains(text(),'Cart')]")
	WebElement cartBtn;
	// orders btn WebElement
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement orderButton;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriverWait webDriverWait(int sleeping, int pooled) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sleeping), Duration.ofMillis(pooled));
		return wait;
	}

	public void waitUntilElementOnDomAndDisplayed(By locator, int sleeping, int pooled) {
		WebDriverWait wait = webDriverWait(sleeping, pooled);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitUntilWebElementOnDomAndDisplayed(By locator, int sleeping, int pooled) {
		WebDriverWait wait = webDriverWait(sleeping, pooled);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void waitUntilWebElementDisplayed(WebElement ele, int sleeping, int pooled) {
		WebDriverWait wait = webDriverWait(sleeping, pooled);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitUntilAllWebElementsDisplayed(List<WebElement> elements, int sleeping, int pooled) {
		WebDriverWait wait = webDriverWait(sleeping, pooled);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitUntilAnimationDisplayed(By locator, int sleeping, int pooled) {
		WebDriverWait wait = webDriverWait(sleeping, pooled);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public CartPage clickOnCart() {
		waitUntilWebElementDisplayed(cartBtn, 5, 200);
		Actions act = new Actions(driver);
		act.moveToElement(cartBtn).doubleClick().perform();
		System.out.println("clicked on cart button");

		CartPage cp = new CartPage(driver);
		return cp;
	}

	public OrderPage gotoOrdersPage() throws InterruptedException {
		waitUntilWebElementDisplayed(orderButton, 4, 200);
		orderButton.click();
		OrderPage op = new OrderPage(driver);
		return op;
	}

	public void scrollUntilView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView", ele);
	}

}
