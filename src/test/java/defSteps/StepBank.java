package defSteps;

import java.io.IOException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.BankPage;
import page.LoginPage;
import util.BrowserFactory;

public class StepBank {

	WebDriver driver;
	LoginPage loginPage;
	BankPage bankPage;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.init();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		bankPage = PageFactory.initElements(driver, BankPage.class);
	}

	@Given("^User is on the TechFios login page$")
	public void user_is_on_the_TechFios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters(String username, String password) {
		loginPage.enterCredentials(username, password);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_signin_button() throws Throwable {
		loginPage.clickOnSignInButton();
	}

	@Then("^User should be able to see the dashboard$")
	public void user_should_be_land_on_Dashboard_page() throws Throwable {
		String expectedTitled = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitled, actualTitle);
		loginPage.takeScreenshotAtEndOfTest(driver);
	}

	@When("^User clicks on bank and cash$")
	public void user_clicks_on_bank_and_cash() {
		bankPage.bankAndCash();
	}

	@When("^User clicks on new account$")
	public void user_clicks_on_new_account() {
		bankPage.newAccount();
	}

	@When("^User fill up the form entering \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\" clicks on submit$")
	public void user_fill_up_the_form(String title, String description, String balance, String accountNumber,
			String contact, String phone, String website) throws Throwable {
		bankPage.fillForm(title, description, balance, accountNumber, contact, phone, website);
		bankPage.clickSubmit();
	}

	@Then("^User should be able to validate new account created$")
	public void user_should_be_able_to_see_validate() throws IOException {
				
		String accountExpectedTitle = "Accounts- iBilling";
		String accountActualTitle = bankPage.accountgetPageTitle();
		Assert.assertEquals(accountExpectedTitle, accountActualTitle);
		loginPage.takeScreenshotAtEndOfTest(driver);
	}
	
	@After
	public void afterRun() {
		driver.close();
		driver.quit();
	}

}
