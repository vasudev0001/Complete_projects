package javaTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import JavaWithSelenium.FrameworkDesign.CartPage;
import JavaWithSelenium.FrameworkDesign.CheckOutPage;
import JavaWithSelenium.FrameworkDesign.OrderConfirmationPage;
import JavaWithSelenium.FrameworkDesign.OrderPage;
import JavaWithSelenium.FrameworkDesign.ProductCatalogue;
import baseTestEcommerce.BaseTest;
import frameWork.resources.ExtentReportsHtml;

public class AddToChart extends BaseTest {

	@Test(dataProvider = "getData")
	public void orderProduct(HashMap<String, String> data) throws InterruptedException, IOException {
		System.out.println("-------------------------");
		ProductCatalogue pc = ln.loginTOApplication(data.get("username"), data.get("password"));
		
		String itemAddedToCart = pc.addProductToCart(data.get("product"));
		System.out.println("Item added to cart: " + itemAddedToCart);
		boolean matched = pc.compareMessage(itemAddedToCart, itemAddedToCart);
		Assert.assertTrue(matched);
		CartPage cp = pc.clickOnCart();
	
		System.out.println("hello");
		int numberOfProductsInCart = cp.getChartItemsSize();
		System.out.println("number of Cart Products:" + numberOfProductsInCart);
		// return true when product is available.
		String cartItem = cp.getProductInCart(data.get("product"));
		System.out.println("Item in chart: " + cartItem);
		boolean Item = cp.verifyProductInCart(data.get("product"));
		assertTrue(Item, "product not available.");
		// click on checkOut button.
		CheckOutPage checkOutPage = cp.clickOnCheckOutBtn();
		// Enter partial counrty name to edit box.
		checkOutPage.sendCountry("Ind");
		// select country from suggestion list.
		checkOutPage.selectCountryFromList("India");
		// click on place order button.
		OrderConfirmationPage orderConfirmation = checkOutPage.clickOnPlaceOrderButton();
		// capture order success message.
		String orderSuccessMessage = orderConfirmation.getOrderSuccessMessage();
		Assert.assertEquals(orderSuccessMessage, "THANKYOU FOR THE ORDER.");
		System.out.println("Order success message: " + orderSuccessMessage);
	}

	@Test() // dependsOnMethods = { "orderProduct" }
	public void verifyOrders() throws InterruptedException {
		System.out.println("-------------------------");
		String searchOrderedProduct = "zara coat 3";
		ProductCatalogue pc = ln.loginTOApplication("vasuK1234@gmail.com", "vasudevK@09");
		OrderPage op = pc.gotoOrdersPage();
		String productName = op.getOrderedProduct("Name", searchOrderedProduct);
		Assert.assertEquals(productName, searchOrderedProduct);
		System.out.println(productName + " is ordered.");
	}

	@DataProvider
	public Object[][] getData() throws JsonMappingException, JsonProcessingException {

		List<HashMap<String, String>> data = getJsonData();
		Object[][] obj = { { data.get(0) }, { data.get(1) } };
		return obj;
	}
}
