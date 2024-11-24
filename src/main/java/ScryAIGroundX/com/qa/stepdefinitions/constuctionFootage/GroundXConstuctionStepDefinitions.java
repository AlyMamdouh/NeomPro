package ScryAIGroundX.com.qa.stepdefinitions.constuctionFootage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import ScryAIGroundX.com.qa.reports.Logs4j;
import ScryAIGroundX.com.qa.util.CSVFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.reports.Reports;

import ScryAIGroundX.com.qa.pages.GroundXConstructionFootagePage;
import ScryAIGroundX.com.qa.pages.GroundXForgotPasswordPage;
import ScryAIGroundX.com.qa.pages.GroundXLoginPage;

@Listeners(Reports.class)
public class GroundXConstuctionStepDefinitions extends Base {

	private GroundXLoginPage groundXLoginPage = new GroundXLoginPage(Base.getDriver());
	private GroundXConstructionFootagePage groundXConstructionFootagePage;
	CSVRecord testData;

	@Then("User logged into GroundX application as {string}")
	public void user_logged_into_GroundX(String user) throws InterruptedException {
		groundXConstructionFootagePage = groundXLoginPage.loginAsDroneOperator(user);
		logger.info("User entered username, password and clicked on login");
	}

	@Then("User validates construction footage page")
	public void validatesConstructionFootagePage() throws InterruptedException {
		//groundXLoginPage.validateGroundXLogo();
		//groundXLoginPage.validatePayButton();
		groundXLoginPage.validateNotificationButton();
		groundXLoginPage.validateUserLogo();
		groundXLoginPage.validateLoggedInUser();

	}
	
	@Then("User fetch test data for {string} from {string}")
	public void user_fetch_test_data_from(String TestCaseName, String path) throws IOException {
		testData = CSVFileReader.readFromCsv(TestCaseName, path);
	}

	@Then("User should select user Type as {string}")
	public void user_select_GroundX_UserType(String userType) throws InterruptedException, AWTException {
		groundXLoginPage.selectUserType(userType);
		logger.info(userType + " is selected successfully");
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}

	@Given("User should be on GroundX login page")
	public void groundX_LoginPage() {
		logger.info("Application launched successfully");
		String title = getTitle();
		Assert.assertEquals(title, "GroundX DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}

	@Then("User filter the assets")
	public void filterAssets() throws Exception {
		String filter = testData.get("Filter");
		String filterVal= testData.get(filter);
		if(filter.contains("Region")){
			String Date = testData.get("DateRange");
			groundXConstructionFootagePage.filterAssets("DateRange", Date);
		}
		String title = getTitle();
		Assert.assertEquals(title, "Ground X DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
		groundXConstructionFootagePage.filterAssets(filter, filterVal);
		Assert.assertTrue(groundXConstructionFootagePage.validateAssetResults());

	}
	
	@Then("User uploads assets from construction footage page")
	public void userUploadsAssetsFromConstructionFootage() throws InterruptedException {
		String deviceID = testData.get("DeviceID");
		String date = testData.get("Date");
		String files = testData.get("UploadFiles");
		groundXConstructionFootagePage.uploadAssetsFromConstructionFootage(deviceID, date, files);
		Assert.assertTrue(groundXConstructionFootagePage.validateSRTFilesMessage());
		groundXConstructionFootagePage.startUpload();
	}
	
	@Then("User uploads assets from construction footage page and cancel")
	public void userUploadsAssetsFromConstructionFootageAndCancel() throws InterruptedException {
		String deviceID = testData.get("DeviceID");
		String date = testData.get("Date");
		String files = testData.get("Uplovalidates construction footage pageadFiles");
		groundXConstructionFootagePage.uploadAssetsFromConstructionFootage(deviceID, date, files);
		Assert.assertTrue(groundXConstructionFootagePage.validateSRTFilesMessage());
		groundXConstructionFootagePage.cancelUpload();
	}
	
	@Then("User uploads assets from workspace")
	public void userUploadsAssetsFromWorkspace() throws InterruptedException {
		groundXConstructionFootagePage.navigateToWorkSpace();
		String path = testData.get("Path");
		String classification = testData.get("Classification");
		String files = testData.get("UploadFiles");
		groundXConstructionFootagePage.uploadAssetsFromWorkspace(path, classification, files);
		String uploadMessage = groundXConstructionFootagePage.uploadMessage();
		Assert.assertEquals(uploadMessage, "2 assets uploaded", "Uploading assets is not successfull");
	}
	
	@Then("User validates assets uploaded by self")
	public void validatesAssetsUploadedBySefl() throws Exception {
		Assert.assertTrue(groundXConstructionFootagePage.validatesAssetsUploadedBySelf(), "There are no assets are available uploaded by user");
	}
	
	@Then ("User vlaidates links to construction footage")
	public void validatesLinksToContstructionFootage() throws Exception {
		groundXConstructionFootagePage.navigateToConstructionFooage();
		Assert.assertTrue(groundXConstructionFootagePage.notAuthorizationMessage());
		Assert.assertTrue(groundXConstructionFootagePage.accessToConstructionFootage());
		Assert.assertTrue(groundXConstructionFootagePage.apiAccessToConstructionFootage());
		
	}
		
	@Then("User logout from GroundX application")
	public void user_logout_from_ground_x_application() throws InterruptedException {
		groundXLoginPage.logout();
		logger.info("User loggedout successfully");
	}
	

}
