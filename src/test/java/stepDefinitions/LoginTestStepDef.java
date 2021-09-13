package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import core.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectRepository.LoginPageObject;
import utilites.WebDriverUtility;

public class LoginTestStepDef extends Base{
	
	// create object of Login Page Object in order to access its methods
	
	LoginPageObject login = new LoginPageObject();
	
	// every Step in Scenario needs to have
	// a method associated with in StepDefinitons class
	@Given("^User is on Retail Website$")
	public void user_is_on_Retail_Website() {
		openBrowser();
		logger.info("Retail Website is opened");
		WebDriverUtility.screenShot();
		
	}
	
	@When("^User click on MyAccount$")
	public void user_click_on_MyAccount() {
		login.clickOnMyAccount();
		logger.info("User clicked on MyAccount");
	}
	
	@And("^User click on Login$")
	public void user_click_on_Login() {
		login.clickOnLogin();
		logger.info("User Clicked on Login");
		
	}
	
	// in cucumber stepDefinitions we need to pass value as a parameter
	//we need to replace values with (.+)
	// we nned to pass parameters in our java methods as well
	@And("^User enter userName '(.+)' and password '(.+)'$")
	public void user_enter_userName_and_password(String userName, String password) {
		login.enterEmail(userName);
		logger.info("user entered email");
		login.enterPassword(password);
		logger.info("user entered password");
		WebDriverUtility.screenShot();
	}
	
	@And("^User click on Login button$")
	public void user_click_on_Login_button() {
		login.clickOnLoginButton();
		logger.info("user clicked on login button");
	}
	
	@Then("^User should be logged in to myAccount Dashboard$")
	public void user_should_be_logged_in_to_myAccount_Dashboard() {
		WebDriverUtility.wait(5000);
		WebDriverUtility.screenShot();
		logger.info("user logged to myAccount Dashboard");
	}
	
	@When("^User click on Register option$")
	public void user_click_on_Register_option()  {
		login.clickOnRegisterOption();
		logger.info("user clicked on Register option");
	   
	}

	@When("^User fill the Registration form with below information$")
	public void user_fill_the_Registration_form_with_below_information(DataTable info) {
	// Cucumber DataTables has a return of List<Map<String,String>> This is when your cucumber
	// DataTable has headers. When cucumber DataTable does not has headers we will use List<List<index>
	List<Map<String, String>> dataValues = info.asMaps(String.class, String.class);
	login.enterFirstName(dataValues.get(0).get("firstName"));
	login.enterLastName(dataValues.get(0).get("lastName"));
	login.enterRegistrationEmail(dataValues.get(0).get("eMail"));
	login.enterTelephone(dataValues.get(0).get("telephone"));
	login.enterRegistrationPassword(dataValues.get(0).get("password"));
	login.enterConfirmPassword(dataValues.get(0).get("passwordConfirm"));
	login.subscribe(dataValues.get(0).get("Subscribe"));
	logger.info("User filled the information form");
	
	}

	@When("^User accept the privacy and policy$")
	public void user_accept_the_privacy_and_policy()  {
	    login.clickOnPrivacyPolicy();
	    logger.info("user accepted privacy and policy");
	    WebDriverUtility.screenShot();
	    
	}

	@When("^User click on continue button$")
	public void user_click_on_continue_button()  {
		login.clickOnContinueButton();
	   logger.info("user clicked on continue button");
	}

	@Then("^User should be registered in Retail Website$")
	public void user_should_be_registered_in_Retail_Website()  {
	  String expectedMessage = "Your Account Has Been Created!";
	  String actualMessage = login.accountCreationMessage();
	  Assert.assertEquals(expectedMessage, actualMessage);
	  logger.info("user Account has been created");
	  WebDriverUtility.screenShot();
	    
	}	
	

}



