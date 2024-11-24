package ScryAIGroundX.com.qa.stepdefinitions.forgotPassword;

import java.io.IOException;

import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.pages.GroundXForgotPasswordPage;
import ScryAIGroundX.com.qa.pages.GroundXLoginPage;
import ScryAIGroundX.com.qa.reports.Reports;
import ScryAIGroundX.com.qa.util.CSVFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(Reports.class)
public class ForgotPasswordStepDefinitions extends Base{
	
	private GroundXLoginPage groundXLoginPage = new GroundXLoginPage(Base.getDriver());
	private GroundXForgotPasswordPage forgotPasswordPage;
	CSVRecord testData;
	
	@Given("User is already on the forgot password page")
	public void user_is_already_on_the_forgot_password() throws InterruptedException {
		forgotPasswordPage = groundXLoginPage.validateForgotPasswordLink();
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}
	
	@Then("User fetch test data for {string} from {string}")
	public void user_fetch_test_data_from(String TestCaseName, String path) throws IOException {
		testData = CSVFileReader.readFromCsv(TestCaseName, path);
	}

	@Then("User validates forgot password page")
	public void user_validates_forgot_password_page() throws InterruptedException {
		Assert.assertTrue(forgotPasswordPage.validateGroundXLogo());
		Assert.assertTrue(forgotPasswordPage.resetYourPassword());
		Assert.assertTrue(forgotPasswordPage.validateEnterEmail());
		String descriptionMessage = forgotPasswordPage.validateDescrptionMessage();
		Assert.assertEquals(descriptionMessage, "Forgot your password? Please enter your email address. We will send you a verfication code via email to reset your password.", "GroundX application login page title is incorrect");
		
	}

	@Then("User enter email and submit")
	public void user_enter_email_and_submit() throws InterruptedException {
		String emailAddreess = testData.get("UserName");
		forgotPasswordPage.resetPassword(emailAddreess);
	}
	
	@Then ("User validates success notification message")
	public void user_validates_scuccessMessage() throws InterruptedException {
		String expectedMessage = testData.get("Notification Message");
		String actualMessage = forgotPasswordPage.validateDescrptionMessage();
		Assert.assertTrue(forgotPasswordPage.validateEnterCode());
		Assert.assertEquals(expectedMessage, actualMessage, "Incorrect email warning message");
	}
	
	@Then ("User validates error notification message")
	public void user_validates_errorMessage() {
		String expectedMessage = testData.get("Notification Message");
		String actualMessage = forgotPasswordPage.validatesErroMessage();
		Assert.assertEquals(expectedMessage, actualMessage, "Incorrect email warning message");
	}
	
}
