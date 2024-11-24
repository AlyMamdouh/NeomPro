package ScryAIGroundX.com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ScryAIGroundX.com.qa.base.Base;

public class GroundXWorkspacesPage extends Base {



	private WebDriver driver;

	public GroundXWorkspacesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li/div/div[text()='Create new folder']/preceding-sibling::a")
	WebElement createNewFolder;

	@FindBy(xpath = "//input[@id='autoFocusElement']")
	WebElement folderNameInput;


	@FindBy(css = "mat-expansion-panel-header span:last-of-type")
	//@FindBy(xpath = "//mat-expansion-panel-header[@id='mat-expansion-panel-header-0']/span[2]")
	WebElement folderAdditionalInformation;

	@FindBy(xpath = "//input[@name='folderDescriptionRef']")
	WebElement folderDescription;

	@FindBy(xpath = "//input[@name='folderDateRef']")
	WebElement folderDate;


	@FindBy(xpath = "//button[contains(.,'Create folder')]")
	WebElement createFolderButton;

	//@FindBy(xpath = "//button[contains(.,'Create folder')]")
	//@FindBy(xpath = "//*[@id=\"mat-mdc-slide-toggle-1-button\"]")
	//@FindBy(xpath = "//*[@class=\"mdc-switch mdc-switch--unselected\"]")
	//WebElement selectFolderType;

	@FindBy(xpath = "//li[@class='tollTipWorkspace workspaceInfoHover ng-star-inserted']")
	//@FindBy(xpath = "//*[@id='child']/div[2]/div[2]/div/ul/li[2]")
	WebElement uploadInFolderButton;

	@FindBy(xpath = "//input[@id='undefined']")
	WebElement uploadAssetsInFolder;

	@FindBy(xpath = "//button[contains(.,'Start upload')]")
	WebElement startUpload;

	@FindBy(xpath = "//button[contains(.,'Close')]")
	WebElement closeButton;

	@FindBy(xpath = "//*[@id=\"child\"]/div[2]/div[1]/h6/span[2]/a")
	WebElement MarketingLinkPath;

	@FindBy(xpath = "//div[text()=' Folder with same name already exists. ']")
	WebElement folderExists;
	//*[@id="child"]/div/div[2]/div/ul/li[1]/app-create-folder/div/form/div[3]/div[2]/div/div

	@FindBy(xpath = "//mat-select/div/div[1]")
	WebElement pagination;

	@FindBy(xpath = "//mat-option/span[text()=' 100 ']")
	WebElement setPaginationTo100;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	WebElement nextPage;

	//mat-mdc-paginator-range-label
	// @FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	@FindBy(xpath = "//div[@class='mat-mdc-paginator-range-label']")
	WebElement totalItems;

	@FindBy(xpath = "//div[@class='publicUseBlock']/div[text()='Locked']")
	WebElement lockedSymbol;

	@FindBy(xpath = "//span/a[@class='flexible']/img")
	WebElement linkIcon;

	@FindBy(xpath = "//span/a[@class='flexible']/span[text()='Copy Link']")
	WebElement copyLink;

	@FindBy(xpath = "//div[@class='dateFileSize ng-star-inserted']/ul/li")
	WebElement noOfItems;

	@FindBy(xpath = "//*[@id=\"customScrollBar\"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/span")
	WebElement RightAction_InternalUser;

	//*[@id="customScrollBar"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/span/svg


	@FindBy(xpath = "//*[@id=\"customScrollBar\"]/div[2]/div[2]/app-add-user-modal/div/div/div/div[1]/span/span")
	WebElement RightAction_ExternalUser;


	//*[@id="customScrollBar"]/div[2]/div[2]/app-add-user-modal/div/div/div/div[1]/span/span

	@FindBy(xpath = "//div[@class='addignCollaborators ng-star-inserted']/img")
	WebElement folderUploadIcon;

	@FindBy(xpath = "//div[@class='addignCollaborators ng-star-inserted']/h2[text()='Start adding assets to this Locked folder:']")
	WebElement folderUploadMessage;

	@FindBy(xpath = "//div[@class='addignCollaborators ng-star-inserted']/div/div[text()='Upload']")
	WebElement folderUploadButton;

	@FindBy(xpath = "//div[@class='no-items']/img")
	WebElement noItemsIcon;

	@FindBy(xpath = "//div[@class='no-items' and text()=' No items here ']")
	WebElement noItemsHere;

	@FindBy(xpath = "//div[@class='manageAccess ng-star-inserted']/ul/li ")
	WebElement manageAccessIcon;

	//@FindBy(xpath = "//*[@id=\"cdk-step-content-0-1\"]/div/app-upload-modal-common/div/div[2]/div")
	@FindBy(xpath = "//div[text()='Your files have been uploaded successfully']")
	WebElement ConfirmationMessage;

	public void selectWorkspace(String workspace) {
		WebElement selectWorkspace = driver.findElement(By.xpath("//li/div/span/a[text()=' " + workspace + " ']"));
		scrollToViewAndCLickElement(selectWorkspace);
	}

	public void navigateToItem(String item) {
		scrollToViewAndCLickElement(pagination);
		scrollToViewAndCLickElement(setPaginationTo100);
		String numberOfFolders = totalItems.getText();
		//System.out.println("Total number of folders" + numberOfFolders);
		String[] sp = numberOfFolders.split(" ");
		//System.out.println("Last digit is"+sp[4]);
		int totalFolders = 0;
		try {
			 totalFolders = Integer.parseInt(sp[4]);
		}
		catch (Exception e) {

		}
			//totalFolders = 1;
		if (totalFolders > 1) {
				for (int i = 0; i <= totalFolders / 100; i++) {
					if (driver.findElements(By.xpath("//p/span/div[text()='" + item + "']")).size() == 0) {
						nextPage.click();
					} else {
						WebElement selectFolder = driver.findElement(By.xpath("//p/span/div[text()='" + item + "']"));
						scrollToViewAndCLickElement(selectFolder);
						break;
					}
				}
			} else {
				WebElement selectFolder = driver.findElement(By.xpath("//p/span/div[text()='" + item + "']"));
				scrollToViewAndCLickElement(selectFolder);
			}

	}


	public void createFolder(String createFolderName, String folderType, String folderDesc, String date) throws InterruptedException {
		//Thread.sleep(1000);
		waitVisible(createNewFolder);
		Thread.sleep(1000);
		createNewFolder.click();
		if (folderType.equalsIgnoreCase("locked")) {
			//Thread.sleep(5000);
			try
			{

				WebElement toggle = driver.findElement(By.xpath("//*[@class=\"mdc-switch mdc-switch--unselected\"]"));
				//= selectFolderType.isDisplayed();
				if(toggle.isDisplayed()) {
					toggle.click();
				}
			}
			catch (Exception e) {

			}


			}


		jsClick(folderAdditionalInformation);
		//Thread.sleep(5000);
		folderNameInput.clear();
		folderNameInput.sendKeys(createFolderName);
		folderDescription.clear();
		folderDescription.sendKeys(folderDesc);
		folderDate.clear();
		folderDate.sendKeys(date);
		//Thread.sleep(5000);
		scrollToViewAndCLickElement(createFolderButton);
		//Thread.sleep(3000);
		navigateToItem(createFolderName);
	}

	public void uploadAssetsByExternalUser(String files) throws InterruptedException {
		//scrollToViewAndCLickElement(uploadInFolderButton);
		Thread.sleep(2000);
		uploadInFolderButton.click();
		Thread.sleep(8000);

		String[] filePaths = files.split(";");
		for (String filePath : filePaths) {
			uploadAssetsInFolder
					.sendKeys(System.getProperty("user.dir") + "/src/main/resources/testData/Uploads/" + filePath);
		}
		Thread.sleep(5000);
		startUpload.click();
		Thread.sleep(80000);
		waitVisible(ConfirmationMessage);
		boolean visible = ConfirmationMessage.isDisplayed();
		if (!visible){
			System.out.println("Failed to upload files");

		}

		waitElementClickable(closeButton);
		//closeButton.click();
	}


	public void uploadAssetsIntoFolderWithoutClassification(String files) throws InterruptedException {
		//scrollToViewAndCLickElement(uploadInFolderButton);
		Thread.sleep(2000);
		uploadInFolderButton.click();
		Thread.sleep(8000);

		nextButton.click();
		String[] filePaths = files.split(";");
		for (String filePath : filePaths) {
			uploadAssetsInFolder
					.sendKeys(System.getProperty("user.dir") + "/src/main/resources/testData/Uploads/" + filePath);
		}
		Thread.sleep(5000);
		startUpload.click();
		Thread.sleep(80000);
		waitVisible(ConfirmationMessage);
		boolean visible = ConfirmationMessage.isDisplayed();
		if (!visible){
			System.out.println("Failed to upload files");

		}

		waitElementClickable(closeButton);
		//closeButton.click();
	}

	public boolean validateFolderExistWithSameName() {
		try{
			return folderExists.isDisplayed();
		}
		catch (Exception e){
			return false;
		}

	}

	public void DeleteFolder(){
		MarketingLinkPath.click();
		if(createFolderButton.isDisplayed()) {

		}
	}

	public void validateFolder() {
		validateCopyLinkFolder();
		validateNoOfItems();
	}

	public void validateLockedFolder() {
		lockedSymbol();
	}

	public boolean lockedSymbol() {
		return lockedSymbol.isDisplayed();
	}

	public boolean[] validateCopyLinkFolder() {
		boolean copyValidations[] = { linkIcon.isDisplayed(), copyLink.isDisplayed() };
		return copyValidations;
	}

	public boolean validateNoOfItems() {
		return noOfItems.isDisplayed();
	}

	public boolean[] validateUploadsInEmptyFolder() {
		boolean uploadValidations[] = { folderUploadIcon.isDisplayed(), folderUploadMessage.isDisplayed(),
				folderUploadButton.isDisplayed() };
		return uploadValidations;
	}

	public boolean[] validateNoItemsInFolder() {
		boolean noItemsValidations[] = { noItemsIcon.isDisplayed(), noItemsHere.isDisplayed() };
		return noItemsValidations;
	}

	public boolean validateManageAccessIcon() {
		return manageAccessIcon.isDisplayed();
	}

	//@FindBy(xpath = "//div[@class='manageAccess ng-star-inserted']/ul/li")
	@FindBy(xpath = "//*[@id=\"customScrollBar\"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input")
	//@FindBy(xpath = "//div[text()='Add users by their name or email address']")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@id=\"customScrollBar\"]/div[2]/div[2]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input")
	WebElement InviteEmailbyExternal;
	//*[@id="customScrollBar"]/div[2]/div[2]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input

	@FindBy(xpath = "//div[@class='manageAccess ng-star-inserted']/ul/li")
	//@FindBy(xpath = "//*[@id=\"customScrollBar\"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input")
	WebElement sendInvite;// button[text()=' Save changes ']

	@FindBy(xpath = "//button[text()=' Save changes ']")
	WebElement saveChanges;

	@FindBy(xpath = "//li/span[text()=' Shared with me']")
	WebElement sharedWithMe;

	@FindBy(xpath = "//div[@class='slide ng-star-inserted slick-slide slick-current slick-active']/div/div/div/ul/li/div/div/a")
	WebElement previewDownload;

	@FindBy(xpath = "//div[@class='slide ng-star-inserted slick-slide slick-current slick-active']/div/div/div/ul/li/button[@class='close-modal-icon']")
	WebElement closePreview;

	public void navigateToSharedWithMe() {
		scrollToViewAndCLickElement(sharedWithMe);
	}

	@FindBy(xpath = "//*[@id='navbarDropdown']")
	WebElement profile;
	public void inviteUser_ByExternalUser(String email) throws InterruptedException {
		manageAccessIcon.click();
		InviteEmailbyExternal.sendKeys(email);
		//	sendInvite.click();

		//enter(By.xpath("//*[@id=\"customScrollBar\"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input"));
		//RightAction.click();
		RightAction_ExternalUser.click();
		Thread.sleep(5000);
		saveChanges.click();
		waitUntilElementClickable(profile);
		//	waitUntilElementClickable(saveChanges);
		//waitElementClickable(saveChanges);
		//	waitVisible(manageAccessIcon);
		//	waitUntilElementClickable(manageAccessIcon);
		//Thread.sleep(10000);
	}
	public void inviteUser(String email) throws InterruptedException {
		manageAccessIcon.click();
		emailAddress.sendKeys(email);
	//	sendInvite.click();

		//enter(By.xpath("//*[@id=\"customScrollBar\"]/div[2]/div[3]/app-add-user-modal/div/div/div/div[1]/span/ng-select/div/div/div[2]/input"));
		//RightAction.click();
		RightAction_InternalUser.click();
		Thread.sleep(5000);
		saveChanges.click();
	//	waitUntilElementClickable(saveChanges);
		//waitElementClickable(saveChanges);
	//	waitVisible(manageAccessIcon);
	//	waitUntilElementClickable(manageAccessIcon);
		Thread.sleep(10000);
	}

	public void removeUser(String email) {
		manageAccessIcon.click();
		WebElement removeIcon = driver.findElement(By.xpath(
				"//table[@class='folderListview']/tr/td/div/div[text()='" + email + " ']/following::td[5]/span"));
		removeIcon.click();
		saveChanges.click();
	}

	public void downloadAssetInPreviewMode(String assets) throws InterruptedException {
		String[] assetNames = assets.split(";");
		for (String assetName : assetNames) {
			navigateToItem(assetName);
			Thread.sleep(5000);
			previewDownload.click();
			closePreview.click();
		}
	}

//	Copy function
	@FindBy(xpath = "//*[local-name()='svg' and @class='copysIcon']")
	WebElement copyIcon;

	@FindBy(xpath = "//button[text()=' Copy here ']")
	WebElement copyHere;

	@FindBy(xpath = "//*[local-name()='svg' and @class='movesIcon']")
	WebElement moveIcon;

	@FindBy(xpath = "//button[text()=' Move here ']")
	WebElement moveHere;

	@FindBy(xpath = "//span[text()='All the selected items have been copied into the selected folder.']")
	WebElement successCopyMessage;

	@FindBy(xpath = "//span[text()='All the selected items have been moved into the selected folder.']")
	WebElement successMoveMessage;

	@FindBy(xpath = "//div[@class='moveCopy']/div/span/a[text()='All Workspace']")
	WebElement allWorkspace;

	public void copyItemsToFolder(String sourceFolder, String destWorkspace, String destFolder) {
		scrollToViewAndCLickElement(pagination);
		scrollToViewAndCLickElement(setPaginationTo100);
		String numberOfFolders = totalItems.getText();
		String[] sp = numberOfFolders.split(" ");
		int totalFolders = Integer.parseInt(sp[4]);

		for (int i = 0; i <= totalFolders / 100; i++) {
			System.out.println(i);
			if (driver.findElements(By.xpath("//p/span/div[text()='" + sourceFolder + "']/ancestor::tr/td/div/div/label/input")).size() == 0) {
				nextPage.click();
			} else {
				WebElement selectItem = driver.findElement(
						By.xpath("//p/span/div[text()='" + sourceFolder + "']/ancestor::tr/td/div/div/label/input"));
				scrollToViewAndCLickElement(selectItem);
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copyIcon.click();

		navigateToWorkspace(destWorkspace);

		WebElement selectDestFolder = driver.findElement(By.xpath("//li/div/label[text()=' " + destFolder + " ']/div"));

		scrollToViewAndCLickElement(selectDestFolder);
		copyHere.click();
	}

	public void navigateToWorkspace(String destWorkspace) {
		if (!destWorkspace.equals(null) && !destWorkspace.isEmpty()) {
			allWorkspace.click();
			WebElement selectDestWorkspace = driver.findElement(
					By.xpath("//li/div/label[text()=' " + destWorkspace + " ']/parent::div/following-sibling::span"));
			scrollToViewAndCLickElement(selectDestWorkspace);
		}
	}

	public void moveItemsToFolder(String items, String destFolder) {
		scrollToViewAndCLickElement(pagination);
		scrollToViewAndCLickElement(setPaginationTo100);
		String numberOfFolders = totalItems.getText();
		String[] sp = numberOfFolders.split(" ");
		int totalFolders = Integer.parseInt(sp[4]);
		for (int i = 0; i <= totalFolders / 100; i++) {
			System.out.println(i);
			if (driver.findElements(By.xpath("//p/span/div[text()='" + items + "']/ancestor::tr/td/div/div/label/input")).size() == 0) {
				nextPage.click();
			} else {
				WebElement selectItem = driver.findElement(
						By.xpath("//p/span/div[text()='" + items + "']/ancestor::tr/td/div/div/label/input"));
				scrollToViewAndCLickElement(selectItem);
				break;
			}
		}

		moveIcon.click();

		WebElement selectDestFolder = driver
				.findElement(By.xpath("//li/div/label[text()=' " + destFolder + " ']/input"));

		scrollToViewAndCLickElement(selectDestFolder);
		moveHere.click();
	}

	public boolean validateItems(String destWorkspace, String destFolder, String sourceItems) {
		navigateToWorkspace(destWorkspace);
		navigateToItem(destFolder);
		String[] expectedItems = sourceItems.split(";");
		List<String> expectedList = new ArrayList<String>(Arrays.asList(expectedItems));

		List<WebElement> existingItemsElements = null;
		scrollToViewAndCLickElement(pagination);
		scrollToViewAndCLickElement(setPaginationTo100);
		String numberOfFolders = totalItems.getText();
		String[] sp = numberOfFolders.split(" ");
		int totalFolders = Integer.parseInt(sp[4]);
		for (int i = 0; i <= totalFolders / 100; i++) {
			existingItemsElements = driver.findElements(By.xpath("//p/span/div"));
		}

		List<String> existingItemsList = new ArrayList<String>();
		for (WebElement existingItemElement : existingItemsElements) {
			existingItemsList.add(existingItemElement.getText());
		}

		boolean found = false;
		for (String srcItem : expectedList) {
			if (existingItemsList.contains(srcItem)) {
				found = true;
			}
		}

		return found;
	}

	public boolean validateCopySuccessMessage() {
		return successCopyMessage.isDisplayed();
	}

	public boolean validateMoveSuccessMessage() {
		return successMoveMessage.isDisplayed();
	}

	@FindBy(xpath = "//a[text()='Upload']")
	WebElement upload;

	@FindBy(xpath = "//input[@id='title']")
	WebElement folderName;

	//@FindBy(xpath = "//button[text()='Next']")
	@FindBy(xpath = "//*[@id='cdk-step-content-0-0']/div[2]/div/button")
	WebElement nextButton;

	@FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-valid']/following::div[@class='control__indicator']")
	WebElement consentCheckbox;

	@FindBy(xpath = "//input[@id='undefined']")
	WebElement uploadFiles;

	public void globalUploadAssets(String destWorkspace, String folder, String classification, String files) {
		upload.click();
		if (!destWorkspace.equals(null) && !destWorkspace.isEmpty()) {
			WebElement selectWorkspace = driver.findElement(By.xpath("//li/div[text()='" + destWorkspace + "']"));
			selectWorkspace.click();
		}
		folderName.sendKeys(folder);
		nextButton.click();
		WebElement selectClassification = driver.findElement(
				By.xpath("//input[@name='classificationAssets']/following::h2[text()=' " + classification + "']"));
		selectClassification.click();
		consentCheckbox.click();
		nextButton.click();
		String[] filePaths = files.split(";");
		for (String filePath : filePaths) {
			uploadFiles.sendKeys(System.getProperty("user.dir") + "/src/main/resources/testData/Uploads/" + filePath);
		}

		startUpload.click();

		closeButton.click();
	}
	
	/////////////////////////Temp search assets/////////////////
	
	@FindBy(xpath = "//div[@class='searchDiv ng-star-inserted']/form/input")
	WebElement searchAssets;
	
	public void userSearchAssets() {
		searchAssets.click();
		searchAssets.sendKeys("test");
		searchAssets.sendKeys(Keys.ENTER);		
	}

}
