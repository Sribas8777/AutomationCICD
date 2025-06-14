package SrijitLearning.StepDefinetion;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SrijitLearning.TestComponents.BaseTest;
import SrijitLearning.pageobjects.CartPage;
import SrijitLearning.pageobjects.CheckoutPage;
import SrijitLearning.pageobjects.ConfirmationPage;
import SrijitLearning.pageobjects.LandingPage;
import SrijitLearning.pageobjects.ProductCataloge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinetionimplementation extends BaseTest {
	 public LandingPage landingPage;
	public ProductCataloge productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerse site")
	public void I_landed_on_Ecommerse_site() throws IOException {
		landingPage=launchApplication();
		
	}
	@Given("^logged in with username (.+) and password (.+)$") //regular expression and (.+) will take any string value
	public void logged_in_with_username_and_password(String username,String password) throws InterruptedException {
		productCatalogue = landingPage.loginApplication(username,password);
	}
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productname) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);
		
	}
	@When("^checkout product(.+) and submit the order$")
	public void checkout_product_and_submit_the_order(String productname) {
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on the confirmation page")
	public void  message_is_displayed_on_the_confirmation_page(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		d.close();
		
	}
	@Then("{string} message is displayed")
	public void   message_is_displayed(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());
		d.close();
	}
	

}
