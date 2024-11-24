package ScryAIGroundX.com.qa.stepdefinitions.workspaces;

import java.awt.AWTException;
import java.io.IOException;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

@Listeners(Reports.class)
public class WorkspacesStepDefinitions extends Base {

	private GroundXLoginPage groundXLoginPage = new GroundXLoginPage(Base.getDriver());
	private GroundXConstructionFootagePage groundXConstructionFootagePage;
	private GroundXDashboardPage groundXDashboardPage;
	private GroundXWorkspacesPage groundXWorkspacesPage;

	CSVRecord testData;

	@Given("User should be on GroundX login page")
	public void groundX_LoginPage() {

		logger.info("Application launched successfully");
		String title = getTitle();
		Assert.assertEquals(title, "Ground X DAM | Discover, Collaborate, Manage Digital Assets",
				"GroundX application login page title is incorrect");
	}

	@Then("User waits to go to Login again")
	public void user_waits_login_page() throws InterruptedException, AWTException {
		waitForPageToLoad();
		Thread.sleep(10000);
		//groundXLoginPage.selectUserType("Login as an external partner or vendor");

	}

	@Then("User should select user Type as {string}")
	public void user_select_GroundX_UserType(String userType) throws InterruptedException, AWTException {
		groundXLoginPage.selectUserType(userType);
		logger.info(userType + " is selected successfully");
		String title = getTitle();
		//	Assert.assertEquals(title, "Ground X DAM | Discover, Collaborate, Manage Digital Assets", "GroundX application login page title is incorrect");
	}

	@Then("User logged into GroundX application as {string}")
	public void user_logged_into_GroundX(String user) throws InterruptedException {
		System.out.println(user);
		String[] keys = { "Drone Operator", "External User", "Broader Access", "Internal User" };
		String[] values = { "Drone Operator", "External User", "External user with broader access", "Internal User" };

		String match = "default";
		for (int i = 0; i < keys.length; i++) {
			//
			// System.out.println(keys[i]);
			if (user.contains(keys[i])) {
				match = values[i];
				break;
			}
		}

		switch (match) {
		case "Drone Operator": {
			groundXConstructionFootagePage = groundXLoginPage.loginAsDroneOperator(user);
			logger.info(match+"User entered username, password and clicked on login");
			System.out.println("Drone operator User entered username, password and clicked on login");
			break;
		}

		case "External User": {
			groundXWorkspacesPage = groundXLoginPage.loginAsExternalUser(user);
			logger.info(match+"User entered username, password and clicked on login");
			System.out.println("External User entered username, password and clicked on login");
			break;
		}

		case "External user with broader access": {
			groundXDashboardPage = groundXLoginPage.loginAsExternalUserwithBroaderAccess(user);
			logger.info(match+"User entered username, password and clicked on login");
			System.out.println("Broader access User entered username, password and clicked on login");
			break;

		}

		case "Internal User": {
			groundXDashboardPage = groundXLoginPage.loginAsInternalUser(user);
			logger.info(match+"User entered username, password and clicked on login");
			System.out.println("Internal User entered username, password and clicked on login");
			break;
		}

		default:
			System.out.println("some code for default");
			logger.info("Please provide valid username");
			break;
		}
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
	public void user_fetch_test_data_from(String testCaseName, String path) throws IOException {
		System.out.println(testCaseName);
		testData = CSVFileReader.readFromCsv(testCaseName, path);
	}

	@Then("User navigates to workspaces")
	public void user_Navigate_To_Workspaces() throws InterruptedException {
		groundXWorkspacesPage = groundXLoginPage.navigateToWorkspaces();
		logger.info("User navigated to workspaces");
	}

	@Then("User navigates to Shared with me")
	public void user_Navigate_To_SharedWithMe() throws InterruptedException {
		groundXWorkspacesPage.navigateToSharedWithMe();
		logger.info("User navigated to workspaces");
	}

	@Then("User selects workspace")
	public void user_Selects_Workspaces() throws InterruptedException {
		String workspaceName = testData.get("WorkspaceName");
		groundXWorkspacesPage.selectWorkspace(workspaceName);
		logger.info("User selected " + workspaceName + " workspace");
	}

	@Then("User navigates to folder")
	public void user_NavigatesTo_Folder() throws InterruptedException {
		String folderName = testData.get("FolderName");
		groundXWorkspacesPage.navigateToItem(folderName);
		logger.info("User navigated to " + folderName);
	}

	@Then("User download assets")
	public void user_Downloads_Assets() throws InterruptedException {
		String uploadFiles = testData.get("UploadFiles");
		groundXWorkspacesPage.downloadAssetInPreviewMode(uploadFiles);
		logger.info("User downloaded assets " + uploadFiles);
	}

	@Then("User creates Nested folder in workspace")
	public void user_Create_Nested_Folder_in_Workspace() throws InterruptedException {
		String folderName = "";
		String folderType = testData.get("NestedFolderType");
		if(folderType.contains("Standard"))
		{
			 folderName = testData.get("CreateStandardFolderName");
		}
		else
		{
			 folderName = testData.get("CreateLockedFolderName1");
		}
		String description = testData.get("CreateFolderDesc");
		String date = testData.get("Date");
		groundXWorkspacesPage.createFolder(folderName, folderType, description, date);
	}

	@Then("User Navigates to old existing folder")
	public void User_Navigates_to_old_existing_folder() throws InterruptedException {

		groundXWorkspacesPage.navigateToItem(testData.get("FolderName"));

	}

	@Then("User creates Main Folder in workspace")
	public void user_Create_Main_Folder_in_Workspace() throws InterruptedException {
		String folderName = "";
		String folderType = testData.get("MainFolderType");
		if(folderType.contains("Standard"))
		{
			folderName = testData.get("CreateStandardFolderName");
		}
		else
		{
			folderName = testData.get("CreateLockedFolderName1");
		}

		String description = testData.get("CreateFolderDesc");
		String date = testData.get("Date");
		groundXWorkspacesPage.createFolder(folderName, folderType, description, date);
	}

	@Then("User creates folder with existing folder name in workspace")
	public void user_Create_Folder_with_Existing_Folder_Name() throws InterruptedException {
//		String folderName = testData.get("CreateFolderName1");
//		String folderType = testData.get("FolderType");
//		String description = testData.get("CreateFolderDesc");
//		String date = testData.get("Date");
//		groundXWorkspacesPage.createFolder(folderName, folderType, description, date);
		String folderName = "";
		String folderType = testData.get("MainFolderType");
		if(folderType.contains("Standard"))
		{
			folderName = testData.get("CreateStandardFolderName");
		}
		else
		{
			folderName = testData.get("CreateLockedFolderName1");
		}

		String description = testData.get("CreateFolderDesc");
		String date = testData.get("Date");
		groundXWorkspacesPage.createFolder(folderName, folderType, description, date);
         boolean result = groundXWorkspacesPage.validateFolderExistWithSameName();

		Assert.assertTrue(groundXWorkspacesPage.validateFolderExistWithSameName());
	}

	@Then("User invites user to collaborate folder by External user")
	public void user_Invites_External_User() throws InterruptedException {
		String userEmail = testData.get("ExternalUserEmail");
		//System.out.println("User Email test : " + userEmail);
		groundXWorkspacesPage.inviteUser_ByExternalUser(userEmail);

		//groundXWorkspacesPage.inviteUser("hossam@yahoo.com");
		//Assert.assertTrue(groundXWorkspacesPage.validateFolderExistWithSameName());
	}

	@Then("User invites user to collaborate folder by Internal user")
	public void user_Invites_Internal_User() throws InterruptedException {
		String userEmail = testData.get("ExternalUserEmail");
		//System.out.println("User Email test : " + userEmail);
		groundXWorkspacesPage.inviteUser(userEmail);

		//groundXWorkspacesPage.inviteUser("hossam@yahoo.com");
		//Assert.assertTrue(groundXWorkspacesPage.validateFolderExistWithSameName());
	}
	
	@Then("User removes user from folder")
	public void user_Removes_External_User() throws InterruptedException {
		String userEmail = testData.get("ExternalUserEmail");
		groundXWorkspacesPage.removeUser(userEmail);
		Assert.assertTrue(groundXWorkspacesPage.validateFolderExistWithSameName());
	}

	@Then("User uploads assets into the folder")
	public void user_Uploads_Assets_Into_Folder() throws InterruptedException {
		String assets = testData.get("UploadFiles");
		groundXWorkspacesPage.uploadAssetsIntoFolderWithoutClassification(assets);

	}

	@Then("External User uploads assets into the folder")
	public void External_user_Uploads_Assets_Into_Folder() throws InterruptedException {
		String assets = testData.get("UploadFiles");
		groundXWorkspacesPage.uploadAssetsByExternalUser(assets);

	}

	@Then("User validates newly created folder")
	public void user_Validates_Created_Folder() throws InterruptedException, IOException {
		//String folderName = testData.get("CreateFolderName1");
		groundXWorkspacesPage.validateFolder();
		takeScreenshot();
	}
	
	@Then("User navigates to shared folder")
	public void user_NavigatesTo_Shared_Folder() throws InterruptedException {
		String shareFolder = testData.get("SharedFolderName");
		groundXWorkspacesPage.navigateToItem(shareFolder);
		logger.info("User navigated to " + shareFolder);
	}
	
	@Then("User copy items to folder")
	public void copyFolderToFolder() throws InterruptedException {
		String items = testData.get("SourceItems");
		String destWorkspace = testData.get("DestWorkspace");
		String destFolder = testData.get("DestFolder");
		groundXWorkspacesPage.copyItemsToFolder(items, destWorkspace, destFolder);
		Assert.assertTrue(groundXWorkspacesPage.validateCopySuccessMessage());
		logger.info("Copied successfully");
	}
	
	@Then("User move items to folder")
	public void moveFolderToFolder() throws InterruptedException {
		String items = testData.get("SourceItems");
		String destFolder = testData.get("DestFolder");
		groundXWorkspacesPage.moveItemsToFolder(items, destFolder);
		Assert.assertTrue(groundXWorkspacesPage.validateMoveSuccessMessage());
		logger.info("Moved successfully");
	}
	
	@Then("User validates items")
	public void validatesItems() throws InterruptedException {
		String items = testData.get("SourceItems");
		String destWorkspace = testData.get("DestWorkspace");
		String destFolder = testData.get("DestFolder");
		groundXWorkspacesPage.validateItems(destWorkspace, destFolder, items);
	}

	@Then("User logout from GroundX application")
	public void user_logout_from_ground_x_application() throws InterruptedException {
		groundXLoginPage.logout();
		logger.info("User loggedout successfully");

	}

}
