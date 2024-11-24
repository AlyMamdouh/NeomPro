package ScryAIGroundX.com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ScryAIGroundX.com.qa.base.Base;

public class GroundXConstructionFootagePage extends Base {

	private WebDriver driver;

	public GroundXConstructionFootagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@id='navbarDropdown']")
	WebElement profile;

	@FindBy(xpath = "//a[text()='Upload']")
	WebElement upload;

	@FindBy(xpath = "//input[@typetosearchtext='Search users']")
	WebElement searchDeviceID;

	@FindBy(xpath = "//button[text()=' Start upload ']")
	WebElement startUpload;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelUpload;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//div[text()='Region']/following-sibling::div/input")
	WebElement regionFilter;

	@FindBy(xpath = "//div[text()='Sub-area']/following-sibling::div/input")
	WebElement subAreaFilter;

	@FindBy(xpath = "//div[text()='Device ID']/following-sibling::div/input")
	WebElement deviceIDFilter;

	@FindBy(xpath = "//div[text()='Device type']/following-sibling::div/input")
	WebElement deviceTypeFilter;

	@FindBy(xpath = "//div[text()='Format']/following-sibling::div/input")
	WebElement formatFilter;

	@FindBy(xpath = "//input[@placeholder='Start date']")
	WebElement startDate;

	@FindBy(xpath = "//input[@placeholder='End date']")
	WebElement endDate;

	@FindBy(xpath = "//mat-label[text()='Enter a date range']")
	WebElement dateFilter;

	@FindBy(xpath = "//a[text()=' Discovery ']")
	WebElement discovery;

	@FindBy(xpath = "//a/div[text()=' Media Assets ']")
	WebElement mediaAssets;

	@FindBy(xpath = "//a/div[text()=' Construction Footage ']")
	WebElement constructionFootage;

	@FindBy(xpath = "//ngx-masonry/div[1]/document-card[1]")
	WebElement assetResults;


	@FindBy(xpath = "//input[@id='undefined']")
	WebElement uploadFiles;

	@FindBy(xpath = "//input[@placeholder='Set the date the media assets were captured']")
	WebElement uploadDate;

	@FindBy(xpath = "//button[contains(.,'Next')]")
	WebElement nextButton;

	@FindBy(xpath = "//button[contains(.,'Review')]")
	WebElement reviewButton;

	@FindBy(xpath = "//button[contains(.,'Close')]")
	WebElement publishButton;

	@FindBy(xpath = "//div[@class='cdk-overlay-container']/div/div/snack-bar-container/simple-snack-bar/span")
	WebElement uploadMessage;

	@FindBy(xpath = "//label[text()=' Only show assets uploaded by me ']/div")
	WebElement assetsByMeCheckbox;

	@FindBy(xpath = "//a[@id='contact-tab0']")
	//*[@id="contact-tab0"]
	WebElement infoButton;

	//@FindBy(xpath = "//li/span[text()='Created']/following-sibling::span")
	@FindBy(xpath = "//*[@id='contact0']/div/div[2]/div[1]/ul/li[1]/span[2]")
	WebElement createdDetails;

	//@FindBy(xpath = "//li/button[@class='close-modal-icon']")
	@FindBy(xpath = "//*[@id='modal-component']/div/div/div/ngx-slick-carousel/div/div/div[2]/div[1]/div/div[2]/ul/li[3]/button")
	WebElement closeAsset;

	@FindBy(xpath = "//a[text()=' Workspace ']")
	WebElement workspace;

	@FindBy(xpath = "//li/div/span/a[text()=' Ground X ']")
	WebElement groundXFolder;

	@FindBy(xpath = "//li/div/span/a[text()=' Entertainment & Culture ']")
	WebElement MarketingFolder;

	@FindBy(xpath = "//li[@class='tollTipWorkspace workspaceInfoHover ng-star-inserted']")
	//@FindBy(xpath = "//*[@id='navbarSupportedContent']/ul/li[1]/a")
	WebElement uploadInFolderButton;

	@FindBy(xpath = "//input[@id='customScrollBar']")
	WebElement uploadInFolderFiles;

	@FindBy(xpath = "//div[@class='row pt-2 acknowledgeBlock']/div/label/div")
	WebElement acknowledgementCheckbox;

	@FindBy(xpath = "//div[@id='myCustomSelect']/input")
	WebElement folderName;

	@FindBy(xpath = "//div[text()=' Please ensure drone videos are uploaded with corresponding .SRT files. ']")
	WebElement srtFilesMessage;

	@FindBy(xpath = "//p[text()='You are not authorized to view other construction footage.']")
	WebElement notAuthorizationMessage;

	@FindBy(xpath = "//li[contains(.,'Click here to request viewing access to construction footage.')]")
	WebElement accessToConstructionFootage;

	@FindBy(xpath = "//li[contains(.,'Click here to request API access to construction footage.')]")
	WebElement apiAccessToConstructionFootage;

    @FindBy(xpath = "/html/body/app-root/app-header/section/ul/li[2]/a")
	WebElement WorkSpace;


	public void searchDeviceId(String deviceID) {
		searchDeviceID.sendKeys(deviceID);
		WebElement selectDevice = driver.findElement(By.xpath("//li/span[text()='" + deviceID + "']"));
		selectDevice.click();
	}

	public void filterWithRegion(String regionVal) {
		regionFilter.clear();
		regionFilter.sendKeys(regionVal);
		WebElement selectFilter = driver
				.findElement(By.xpath("//div[@role='option']/span/div/span[text()=' " + regionVal + " ']"));
		selectFilter.click();
	}

	public void filterWithSubArea(String subAreaVal) {
		subAreaFilter.clear();
		subAreaFilter.sendKeys(subAreaVal);
		WebElement selectFilter = driver
				.findElement(By.xpath("//div[@role='option']/span/div/span[text()=' " + subAreaVal + " ']"));
		try {
			waitUntilElementClickable(selectFilter);
			selectFilter.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void filterWithDeviceID(String deviceIDVal) {
		deviceIDFilter.clear();
		deviceIDFilter.sendKeys(deviceIDVal);
		WebElement selectFilter = driver.findElement(By.xpath("//div/span[text()='" + deviceIDVal + "']"));
		selectFilter.click();

	}

	public void filterWithDeviceType(String deviceTypeVal) {
		deviceTypeFilter.clear();
		deviceTypeFilter.sendKeys(deviceTypeVal);
		WebElement selectFilter = driver
				.findElement(By.xpath("//div[@role='option']/span[text()=' " + deviceTypeVal + " ']"));
		selectFilter.click();
	}

	public void filterWithFormat(String format) {
		formatFilter.clear();
		formatFilter.sendKeys(format);
		WebElement selectFilter = driver.findElement(By.xpath("//div/span[text()=' " + format + " ']"));
		selectFilter.click();
	}

	public void filterWithDateRange(String date) {
		String[] dateVal = date.split("-");
		startDate.clear();
		startDate.sendKeys(dateVal[0]);
		endDate.clear();
		endDate.sendKeys(dateVal[1]);

	}

	public Boolean validateUpload() {
		return upload.isDisplayed();
	}

	public Boolean validateRegion() {
		return regionFilter.isDisplayed();
	}

	public Boolean validatesubArea() {
		return subAreaFilter.isDisplayed();
	}

	public Boolean validateDeviceID() {
		return deviceIDFilter.isDisplayed();
	}

	public Boolean validateDeviceType() {
		return deviceTypeFilter.isDisplayed();
	}

	public Boolean validateFormat() {
		return formatFilter.isDisplayed();
	}

	public Boolean validateDate() {
		return dateFilter.isDisplayed();
	}

	public void navigateToConstructionFooage() {
		discovery.click();
		constructionFootage.click();
//		refresh();
	}

	public void navigateToWorkSpace() {
		workspace.click();

	}

	public void filterAssets(String filterType, String filterValue) {
		switch (filterType) {

		case "Region":
			filterWithRegion(filterValue);
			break;
		case "SubArea":
			filterWithSubArea(filterValue);
			break;
		case "DeviceID":
			filterWithDeviceID(filterValue);
			break;
		case "DeviceType":
			filterWithDeviceType(filterValue);
			break;
		case "Format":
			filterWithFormat(filterValue);
			break;
		case "DateRange":
			filterWithDateRange(filterValue);

			break;

		default:
			System.out.println("Please select correct filter");
			break;
		}
	}

	public boolean validateAssetResults() throws Exception {
		Thread.sleep(5000);
		boolean x = assetResults.isDisplayed();
		return assetResults.isDisplayed();
	}

	public void uploadAssetsFromConstructionFootage(String deviceID, String date, String files)
			throws InterruptedException {
		upload.click();
		waitUntilElementClickable(searchDeviceID);
		searchDeviceID.click();
		searchDeviceID.clear();
		searchDeviceID.sendKeys(deviceID);
		Thread.sleep(5000);
		WebElement selectDevice = driver.findElement(By.xpath("//li/span[text()='" + deviceID + "']"));
		selectDevice.click();
		uploadDate.clear();
		uploadDate.sendKeys(date);
		nextButton.click();
//		uploadFiles.sendKeys("C:/Uploads/Uploads1.SRT \n C:/Uploads/Uploads1.DNG");
		String[] filePaths = files.split(";");
		for (String filePath : filePaths) {
			uploadFiles.sendKeys(
					System.getProperty("user.dir") + "/src/main/resources/testData/Uploads/" + filePath);
		}

	}

	public void startUpload() {
		startUpload.click();
		try {
			waitUntilElementClickable(publishButton);
			publishButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelUpload() {
		cancelUpload.click();
		//yesButton.click();
	}

	public boolean validateSRTFilesMessage() {
		return srtFilesMessage.isDisplayed();
	}

	public String uploadMessage() {
		return uploadMessage.getText();
	}

	public boolean validatesAssetsUploadedBySelf() throws Exception {

		assetsByMeCheckbox.click();
		waitUntilElementClickable(assetResults);
		refresh();
		driver.findElement(By.xpath("//ngx-masonry/div[1]")).click();
		waitUntilElementClickable(infoButton);
		Thread.sleep(2000);
		infoButton.click();
		String createdInfo = createdDetails.getText();
		System.out.println("Created info is " + createdInfo);
		System.out.println("Title is "+ profile.getAttribute("title"));
		if (createdInfo.contains(profile.getAttribute("title"))) {
			closeAsset.click();
			return true;
		}
		return false;
	}

	public void uploadAssetsFromWorkspace(String folderPath, String classification, String files)
			throws InterruptedException {
		//workspace.click();
		//waitUntilElementClickable(groundXFolder);
		//groundXFolder.click();
	//	MarketingFolder.click();
//		String[] folders = folderPath.split("/");
//		for (String folder : folders) {
//			System.out.println(folder);
//			WebElement selectFolder = driver
//					.findElement(By.xpath("//p[@class='workspaeName']/span/div[text()='" + folder + "']"));
//			scrollToViewAndCLickElement(selectFolder);
//		}
		uploadInFolderButton.click();

//		uploadInFolderFiles.sendKeys("C:/Uploads/Uploads1.SRT \n C:/Uploads/Uploads1.DNG");
		String[] filePaths = files.split(";");
		for (String filePath : filePaths) {
			uploadInFolderFiles.sendKeys(
					System.getProperty("user.dir") + "/src/main/resources/testData/Uploads/" + filePath);
		}
		Thread.sleep(5000);
		acknowledgementCheckbox.click();
		nextButton.click();
		folderName.sendKeys("Test");
		reviewButton.click();

		WebElement selectClassification = driver
				.findElement(By.xpath("//li/div/label/h2[text()=' " + classification + "']"));
		selectClassification.click();
		waitUntilElementClickable(publishButton);
		publishButton.click();

	}

	public boolean notAuthorizationMessage() throws Exception {
		Thread.sleep(2000);
		boolean x = notAuthorizationMessage.isDisplayed();
		return notAuthorizationMessage.isDisplayed();
	}

	public boolean accessToConstructionFootage() {
		return accessToConstructionFootage.isDisplayed();
	}

	public boolean apiAccessToConstructionFootage() {
		return apiAccessToConstructionFootage.isDisplayed();
	}
	
	public GroundXWorkspacesPage navigateToWorkspaces() {
		workspace.click();
		return new GroundXWorkspacesPage(driver);
	}

}
