package stepDefinitions;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinitions {

	WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	public CheckOutPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	
	@Then("verify the user has ability to enter promocode and place the order")
	public void verify_the_user_has_ability_to_enter_promocode() {
		
		
		Assert.assertTrue( checkoutPage.VerifyPromoBtn());
		Assert.assertTrue( checkoutPage.VerifyPlaceOrder());
	}
	
	@Then("^User proceeds to Checkout  and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) {
		checkoutPage.CheckOutItems();
		
	}
	
	
}
