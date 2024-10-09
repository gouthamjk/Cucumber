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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup =testContextSetup;
	}
	@Then("^User Searched for (.+) ShortName in offers page$")
	public void user_searched_for_short_name_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offersPageProductName = offersPage.getProductName();
		System.out.println(offersPageProductName + " is extracted from Offers Page");

	}
	
	public void switchToOffersPage()
	{
		
	//	pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
	}

	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_Landing_Page() {
		Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
	}

}
