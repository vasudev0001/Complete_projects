package javaTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import JavaWithSelenium.FrameworkDesign.CartPage;
import JavaWithSelenium.FrameworkDesign.ProductCatalogue;
import baseTestEcommerce.BaseTest;


public class ErrorValidations extends BaseTest {

	@Test(groups={"Error Handling"})// retryAnalyzer = Retry.class
	public void verifyLoginErrorMessage() {
		System.out.println("-------------------------");
		ln.loginTOApplication("qwe123@gmail.com", "13dfeg");
		String errorMessage = ln.getErrorMessage();
		System.out.println("Actual login error message: "+errorMessage);
		System.out.println("Expected login error message: "+"Incorrect email or password.");
		Assert.assertEquals(errorMessage, "Incorrect email or password.");
		System.out.println("It display correct error message");
	}
	
	@Test(groups={"Error Handling"})
	public void verifyProductAddingMsg() {
		System.out.println("-------------------------");
		String productName = "iphone 13 pro";
		ProductCatalogue pc = ln.loginTOApplication("vasuK1234@gmail.com", "vasudevK@09");
		String itemAddedToCartMsg=pc.addProductToCart(productName);
		System.out.println("product added to cart message: "+itemAddedToCartMsg);
		boolean matched=pc.compareMessage("Product Added To Cart", itemAddedToCartMsg);
		assertTrue(matched);
		CartPage cp = pc.clickOnCart();
		String heading=cp.getChartHeading();
		System.out.println("cart page heading: "+heading);
		int numberOfCartItems=cp.getChartItemsSize();
		System.out.println("number of products in cart: "+numberOfCartItems);
		String itemInChart=cp.getProductInCart(productName);
		System.out.println("Product in cart: "+itemInChart);
		// return true when product is available.
		boolean Item = cp.verifyProductInCart("Iphone 13 pro");
		System.out.println(Item);
		assertTrue(Item,"expected product is: "+"Iphone 13 pro"+", but actual product is: "+itemInChart);
	}
}
