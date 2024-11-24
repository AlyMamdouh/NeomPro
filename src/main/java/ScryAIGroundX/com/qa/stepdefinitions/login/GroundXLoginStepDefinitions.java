package ScryAIGroundX.com.qa.stepdefinitions.login;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.pages.GroundXConstructionFootagePage;
import ScryAIGroundX.com.qa.pages.GroundXDashboardPage;
import ScryAIGroundX.com.qa.pages.GroundXLoginPage;
import ScryAIGroundX.com.qa.pages.GroundXWorkspacesPage;
import ScryAIGroundX.com.qa.reports.Reports;
import ScryAIGroundX.com.qa.util.CSVFileReader;
import ScryAIGroundX.com.qa.util.PropertyReader;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@Listeners(Reports.class)
public class GroundXLoginStepDefinitions extends Base {

	Scenario scenario;

	private GroundXLoginPage groundXLoginPage = new GroundXLoginPage(Base.getDriver());
	private GroundXConstructionFootagePage groundXConstructionFootagePage;
	private GroundXDashboardPage groundXDashboardPage;
	private GroundXWorkspacesPage groundXWorkspacesPage;
	private String userName;
	CSVRecord testData;

	@Given("User launch the GroundX application")
	public void userLaunchTheGroundXApplication() {

		Base.getDriver().get(prop.getProperty("url"));
	}

	@Then("User fetch test data for {string} from {string}")
	public void user_fetch_test_data_from(String testCaseName, String path) throws IOException {
		testData = CSVFileReader.readFromCsv(testCaseName, path);
	}

	@Given("User should be on GroundX login page")
	public void groundX_LoginPage() {
		logger.info("Application launched successfully");
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}

	@Then("User validates login page")
	public void validates_groundX_loginPage() throws InterruptedException {
		Assert.assertTrue(groundXLoginPage.validateAppName());
		logger.info("Application Name is displayed successfully");
		Assert.assertTrue(groundXLoginPage.validateNeomUser());
		logger.info("NEOM user option is displayed successfully");
		Assert.assertTrue(groundXLoginPage.validateExternalUser());
		logger.info("External user option is displayed successfully");
	}

	@Then("User validates forgot passwor link")
	public void validates_ForgotPasswordLink() throws InterruptedException {
		groundXLoginPage.validateForgotPasswordLink();
	}

	@Then("User should select user Type as {string}")
	public void user_select_GroundX_UserType(String userType) throws InterruptedException, AWTException {
		groundXLoginPage.selectUserType(userType);
		logger.info(userType + " is selected successfully");
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}
	
	@Then ("User validates external user login page")
	public void validates_externalUserLoginPage() {
		Assert.assertTrue(groundXLoginPage.validateForgotPassword());
		logger.info("Forgot password is displayed successfully");
//		Assert.assertTrue(groundXLoginPage.validateNeedAnAccount());	***Feature removed
//		logger.info("Need an account is displayed successfully");
	}

	@Then("user validates need an account link")
	public void validates_NeedAccountLink() {
		groundXLoginPage.validateNeedAnAccountLink();
	}

	@Then("User logged into GroundX application as {string}")
	public void user_logged_into_GroundX(String user) throws InterruptedException {
		String[] keys = { "Drone operator", "External user", "Broader access", "Internal User" };
		String[] values = { "Drone operator", "External user", "External user with broader access", "Internal user" };

		String match = "default";
		for (int i = 0; i < keys.length; i++) {
			if (user.contains(keys[i])) {
				match = values[i];
				break;
			}
		}

		switch (user) {
		case "Drone Operator": {
			groundXConstructionFootagePage = groundXLoginPage.loginAsDroneOperator(user);
			break;

		}

		case "External User": {
			groundXWorkspacesPage = groundXLoginPage.loginAsExternalUser(user);
			break;

		}

		case "External user with broader access": {
			groundXDashboardPage = groundXLoginPage.loginAsExternalUserwithBroaderAccess(user);
			break;

		}

		case "Internal User": {
			groundXDashboardPage = groundXLoginPage.loginAsInternalUser(user);
			break;

		}

		default:
			System.out.println("some code for default");

		}

		logger.info("User entered username, password and clicked on login");
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() throws InterruptedException {
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
		logger.info("GroundX dashboard page is page displayed successfully");
		this.userName = groundXLoginPage.userName;
		String loggedInUser = groundXLoginPage.validateLoggedInUser();
		Assert.assertEquals(userName, loggedInUser, "Loggedin user is incorrect");
		logger.info("User logged in successfully");
		//Assert.assertTrue(groundXLoginPage.validateGroundXLogo());
		//logger.info("GorundX logo is displayed successfully");
		//Assert.assertTrue(groundXLoginPage.validatePayButton());
		//logger.info("Play button is displayed successfully");
		Assert.assertTrue(groundXLoginPage.validateNotificationButton());
		logger.info("Notification button is displayed successfully");
		Assert.assertTrue(groundXLoginPage.validateUserLogo());
		logger.info("User logo is displayed successfully");
	}
	
	@Then("User fetch test data for")
	public void user_logout_() throws InterruptedException {
		groundXLoginPage.logout();
		logger.info("User loggedout successfully");
	}

	@Then("User logout from GroundX application")
	public void user_logout_from_ground_x_application() throws InterruptedException {
		groundXLoginPage.logout();
		logger.info("User loggedout successfully");
	}

}
