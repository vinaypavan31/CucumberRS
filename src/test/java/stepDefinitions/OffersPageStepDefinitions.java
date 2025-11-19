package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {

	WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for the (.+) shortname in offers page$")
	public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exist(String shortName)
			throws InterruptedException {
		switchToOffersPage();
		Thread.sleep(3000);
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);

		offerPageProductName = offersPage.getProduct();

	}

	public void switchToOffersPage() {
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage =testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Then("validate product Name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
