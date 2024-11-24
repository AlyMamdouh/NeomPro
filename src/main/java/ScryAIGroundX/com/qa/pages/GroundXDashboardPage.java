package ScryAIGroundX.com.qa.pages;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ScryAIGroundX.com.qa.util.PropertyReader;

public class GroundXDashboardPage {

    public GroundXDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='searchDiv ng-star-inserted']/form/input")
	WebElement searchAssets;
	
	public void userSearchAssets(String searchKey) {
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchAssets.click();
		searchAssets.sendKeys(searchKey);
		searchAssets.sendKeys(Keys.ENTER);		
	}
	
	

}
