package ScryAIGroundX.com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ScryAIGroundX.com.qa.base.Base;

public class GroundXForgotPasswordPage extends Base{

	private WebDriver driver;

	public GroundXForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/h2/img")
	WebElement groundXLogo;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//h3[text()=' Reset your password']")
	WebElement resetYourPassword;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitButton;

	@FindBy(xpath = "//form/ul/li/p")
	WebElement descrptionMessage;

	@FindBy(xpath = "//div[text()='User email not found']")
	WebElement emailNotificationMessage;

	@FindBy(xpath = "//h3[text()=' Check your email']")
	WebElement checkYourEmail;

	@FindBy(xpath = "//button[text()='Enter code']")
	WebElement enterCode;

	public boolean validateGroundXLogo() throws InterruptedException {
		Thread.sleep(5000);
		return groundXLogo.isDisplayed();
	}

	public boolean validateEnterEmail() {
		return emailInput.isDisplayed();
	}

	public String validateDescrptionMessage() throws InterruptedException {
		Thread.sleep(10000);
		waitForPageToLoad();
		WebElement descMessage = driver.findElement(By.xpath("//form/ul/li/p"));
		if (descrptionMessage.isDisplayed()) {
			return descMessage.getText();
		}
		return null;
	}

	public void resetPassword(String emailAddress) throws InterruptedException {
		Thread.sleep(5000);
		emailInput.clear();
		emailInput.sendKeys(emailAddress);
		submitButton.click();
	}

	public String validatesErroMessage() {
		return emailNotificationMessage.getText();
	}

	public boolean validateEnterCode() {
		return enterCode.isDisplayed();
	}
	
	public boolean resetYourPassword() {
		return resetYourPassword.isDisplayed();
	}
}
