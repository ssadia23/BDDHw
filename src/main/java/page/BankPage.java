package page;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankPage {

	WebDriver driver;

	public BankPage(WebDriver driver) {
		this.driver = driver;
	}

	// @FindBy(how = How.XPATH, using = "//span[contains(text(),'Bank & Cash')]")WebElement BankandCash;
	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")WebElement BankandCash;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'New Account')]")WebElement NewAcccount;

	@FindBy(how = How.XPATH, using = "//input[@id='account']")WebElement AccountTitle;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")WebElement Description;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")WebElement Balance;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")WebElement AccountNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")WebElement ContactPerson;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")WebElement Phone;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")WebElement Website;
	@FindBy(how = How.XPATH, using = "//button[@type='submit' and @class='btn btn-primary']")WebElement Submit;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")WebElement AccountCreated;
	//@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[3]/div[1]")WebElement AccountCreated;
	
	
	public void bankAndCash() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BankandCash);
		// BankandCash.click();
	}

	public void newAccount() {
		NewAcccount.click();
	}

	public void fillForm(String accountTitle, String description, String balance, String accountNumber, String contactPerson, String phone, String website) {
	
			Random rnd = new Random();
			int num = rnd.nextInt(999);
		
		AccountTitle.sendKeys(accountTitle + num);
		Description.sendKeys(description);
		Balance.sendKeys(balance);
		AccountNumber.sendKeys(num + accountNumber);
		ContactPerson.sendKeys(contactPerson);
		Phone.sendKeys(num + phone);
		Website.sendKeys(website);

	}

	public void clickSubmit() {
		Submit.click();
	}

	public String accountgetPageTitle() { 
		return driver.getTitle(); 
		}
	
	public String accountCreated () {
		
		String accountCreated = AccountCreated.getText();
		return accountCreated;
		
	}
	
	
}
