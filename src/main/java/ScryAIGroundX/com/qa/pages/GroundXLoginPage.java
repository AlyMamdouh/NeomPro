package ScryAIGroundX.com.qa.pages;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.util.PropertyReader;
import ScryAIGroundX.com.qa.util.TestUtil;

public class GroundXLoginPage extends Base {

	protected WebDriver driver;
	private String userType;
	public String userName;
	TestUtil util = new TestUtil();

	public GroundXLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='username']")
	WebElement email;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;


	//@FindBy(xpath = "//a[@id='navbarDropdown']")
	@FindBy(xpath = "//*[@id='navbarDropdown']")
	WebElement profile;
	//*[@id="navbarDropdown"]


	@FindBy(xpath = "//a[text()=' Settings ']")
	WebElement Settings;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;

	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement logout;

	@FindBy(xpath = "//h2[text()='Groundx']")
	WebElement groundXAppName;

	/*
	@FindBy(xpath = "//img[@src='../../assets/images/NEOM_logo.svg']")
	WebElement neomLogo;
	*/


	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgorPassword;

	@FindBy(xpath = "//a[text()='Need an account']")
	WebElement needAnAccount;

	@FindBy(xpath = "//button[text()='Login with NEOM account']")
	WebElement neomUser;

	@FindBy(xpath = "//button[text()='Login as an external partner or vendor']")
	WebElement externalUser;

	//@FindBy(xpath = "//img[@src='../../../assets/images/new-logo.svg']")
	//WebElement groundXLogo;

	@FindBy(xpath = "//div[@class='button button-play play-button']")
	WebElement playButton;

	@FindBy(xpath = "//img[@src='../../../assets/images/alarm-bell.svg']")
	WebElement notificationButton;

	@FindBy(xpath = "//*[@id=\"navbarDropdown\"]")
	//@FindBy(xpath = "//div[@class='button button-play play-button']")
	WebElement userLogo;

	@FindBy(xpath = "/html/body/app-root/app-header/section/ul/li[2]/a")
	//@FindBy(xpath = "//a[text()=' Workspace ']")
	WebElement workspace;
	
	@FindBy(tagName = "html")
	WebElement html;

	/*
	public boolean validateNeomLogo() throws InterruptedException {
		Thread.sleep(5000);
		return neomLogo.isDisplayed();
	}

	 */

	public boolean validateAppName() {
		return groundXAppName.isDisplayed();
	}

	public boolean validateNeomUser() {
		return neomUser.isDisplayed();
	}

	public boolean validateExternalUser() {
		return externalUser.isDisplayed();
	}

	public boolean validateForgotPassword() {

		return forgorPassword.isDisplayed();
	}
/*
	public boolean validate() throws InterruptedException {
		Thread.sleep(20000);
		return groundXLogo.isDisplayed();
	}

	public boolean validatePayButton() {
		return playButton.isDisplayed();
	}

 */

	public boolean validateNeedAnAccount() {
		return needAnAccount.isDisplayed();
	}

	public GroundXNeedAnAccountPage validateNeedAnAccountLink() {
		needAnAccount.click();
		return new GroundXNeedAnAccountPage(driver);
	}

	public GroundXForgotPasswordPage validateForgotPasswordLink() throws InterruptedException {
		externalUser.click();
		forgorPassword.click();
		return new GroundXForgotPasswordPage(driver);
	}

	public boolean validateNotificationButton() {
		waitVisible(notificationButton);
		return notificationButton.isDisplayed();
	}

	public boolean validateUserLogo() {
		return userLogo.isDisplayed();
	}

	public void selectUserType(String userType) throws InterruptedException, AWTException {
		setBrowserZoom();
		this.userType = userType;

		waitForPageToLoad();
		//WebElement NeomLogin = driver.findElement(By.xpath("//button[text()=' Login with NEOM account ']"));
	//	waitUntilElementClickable(NeomLogin);
		WebElement selectUserType = driver.findElement(By.xpath("//button[text()='" + userType + "']"));
		selectUserType.click();
	}

	public void loginAsUser(String user) throws InterruptedException {
		email.clear();
		waitForPageToLoad();

		user = user.replaceAll(" ", "_");
		userName = prop.getProperty(user + "_UserName");
		email.sendKeys(userName);
		password.clear();
		password.sendKeys(prop.getProperty(user + "_Password"));
		login.click();
	}

	public GroundXDashboardPage loginAsExternalUserwithBroaderAccess(String user) throws InterruptedException {
		loginAsUser(user);
		return new GroundXDashboardPage(driver);
	}
	
	public GroundXWorkspacesPage loginAsExternalUser(String user) throws InterruptedException {
		loginAsUser(user);
		return new GroundXWorkspacesPage(driver);
	}

	public String validateLoggedInUser() throws InterruptedException {
		waitForPageToLoad();
		return profile.getAttribute("title");
	}

	public void logout() throws InterruptedException {
		waitForPageToLoad();
		waitVisible(profile);

		try {
			if (profile.isDisplayed()) {
				profile.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logout.click();
	}

	public GroundXConstructionFootagePage loginAsDroneOperator(String user) throws InterruptedException {
		loginAsUser(user);
		return new GroundXConstructionFootagePage(driver);
	}

	@FindBy(xpath = "//a[@id='social-saml1']")
	WebElement useNuxeoCredentials;

	@FindBy(xpath = "//input[@name='loginfmt']")
	WebElement internalEmail;
	@FindBy(xpath = "//*[@id=\"idSubmit_ProofUp_Redirect\"]")
	WebElement Inforequired;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/div/section[2]/div/div[2]/a")
	WebElement SkipAuthontication;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//input[@type='password']")
	WebElement internalPassword;

	public GroundXDashboardPage loginAsInternalUser(String user) throws InterruptedException {
		//useNuxeoCredentials.click();

		waitUntilElementClickable(internalEmail);
 		internalEmail.clear();
		waitForPageToLoad();

		user = user.replaceAll(" ", "_");
		userName = prop.getProperty(user + "_UserName");
		internalEmail.sendKeys(userName);
		submit.click();
		waitForPageToLoad();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		internalPassword.click();;
		internalPassword.clear();
		
		internalPassword.sendKeys(prop.getProperty(user + "_Password"));
		submit.click();
		Thread.sleep(2000);
		waitVisible(Inforequired);
		Inforequired.click();
		waitVisible(SkipAuthontication);
		Thread.sleep(2000);
		SkipAuthontication.click();
		submit.click();
		return new GroundXDashboardPage(driver);
	}
	
	public GroundXWorkspacesPage navigateToWorkspaces() throws InterruptedException {
		Thread.sleep(7000);
		//waitVisible(workspace);
		waitUntilElementClickable(workspace);
		workspace.click();
		return new GroundXWorkspacesPage(driver);
	}

	public GroundXSettingsPage navigateToSettings() throws InterruptedException {
		waitForPageToLoad();
		try {
			Thread.sleep(1000);
			waitVisible(profile);
			if (profile.isDisplayed()) {
				profile.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Thread.sleep(2000);
		Settings.click();
		return new GroundXSettingsPage(driver);
	}
}
