package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPagePageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;

	public CheckoutPagePageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();

	}

	@Then("Verify user has ability to enter promo code and place the order")
	public void and_Verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) 
	{
		checkoutPage.checkoutItems();
	}


}
