package ScryAIGroundX.com.qa.commons;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import ScryAIGroundX.com.qa.base.Base;
import ScryAIGroundX.com.qa.util.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Commons extends Base {

	private Base base;
	private WebDriver driver;
	private PropertyReader propertyReader;
	Properties prop;

	@Before(order = 0)
	public void readProperty() {
		propertyReader = new PropertyReader();
		prop = propertyReader.PropertyReader();
		// return prop;
	}

	@Before(order = 1)
	public void launchTheBrowser() {
		String broswer = prop.getProperty("browser");
		String broswerMode = prop.getProperty("browserMode");
		base = new Base();
		driver = base.init(broswer, broswerMode);
		driver.get(prop.getProperty("url"));
	}
	



	@AfterStep
	public void afterStep(Scenario scenario) {
		waitForPageToLoad();
		if (scenario.isFailed()) {
			String sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String path = "data:image/png;base64," + sourcePath;
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromBase64String(sourcePath).build());
		}
	}

	@AfterMethod
	public void afterMethod() {
	
	}

	@After
	public void tearDown() throws IOException {
		driver.quit();
	}

}