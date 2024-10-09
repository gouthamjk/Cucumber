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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

	}

	@Given("User is on GreenKart Landing Page")
	public void user_is_on_green_kart_landing_page() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Drivers\\chromedriver.exe"); testContextSetup.driver = new
		 * ChromeDriver(); testContextSetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with ShortName (.+) and extracted actual name of product$")
	public void user_searched_with_ShortName_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		// LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName + " is extracted from Home Page");
	}
	
	@When("added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
