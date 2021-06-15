package defSteps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.LoginPage;
import util.BrowserFactory;

public class StepLogin {

	WebDriver driver;
	LoginPage loginPage;

//	@Before
//	public void beforeRun() {
//		driver = BrowserFactory.init();
//		loginPage = PageFactory.initElements(driver, LoginPage.class);
//	}

	@Given("^User is on the techfios login page$")
	public void user_is_on_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");

	}

	@When("^User enters username \"([^\"]*)\"$")
	public void user_enters_username_as(String username) throws Throwable {
		loginPage.enterUserName(username);
	}

	@When("^User enters password \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws Throwable {
	   loginPage.enterPassword(password);
	}

	@When("^User clicks signin button$")
	public void user_clicks_signin_button() throws InterruptedException {
		loginPage.clickOnSignInButton();
	}

	@Then("^User should be landing on the Dashboard page$")
	public void user_should_be_land_on_Dashboard_page() throws IOException  {
		String expectedTitled = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitled, actualTitle);
		loginPage.takeScreenshotAtEndOfTest(driver);

	}

//	@After
//	public void afterRun() {
//		driver.close();
//		driver.quit();
//
//	}

}
