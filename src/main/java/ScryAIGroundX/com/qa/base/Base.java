package ScryAIGroundX.com.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ScryAIGroundX.com.qa.enums.Browsers;
import ScryAIGroundX.com.qa.reports.Logs4j;
import ScryAIGroundX.com.qa.util.CSVFileReader;
import ScryAIGroundX.com.qa.util.PropertyReader;
import ScryAIGroundX.com.qa.util.TestUtil;
import io.cucumber.java.Scenario;

public  class Base {

//	public WebDriver driver;
	public static WebDriverWait wait;
	protected Logger logger = Logger.getLogger(Logs4j.class);
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static Scenario scenario;

	String pageLoadStatus = null;

	static String currentDir = System.getProperty("user.dir");

	static JavascriptExecutor js;

	Robot robot;

	//public abstract void marina();

	/**
	 * Initializes a WebDriver instance based on the specified browser and mode.
	 *
	 * @param browser     The name of the browser to be used (e.g., "chrome", "firefox", "edge").
	 * @param browserMode The mode in which the browser should run. If set to "headless",
	 *                    the browser will run without a graphical user interface.
	 *
	 * @throws IllegalArgumentException if the specified browser is not supported.
	 */
	public WebDriver init(String browser, String browserMode) {
		switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				if (browserMode.equalsIgnoreCase("headless")) {
					chromeOptions.addArguments("--headless=new");
				}
				tlDriver.set(new ChromeDriver(chromeOptions));
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				tlDriver.set(new EdgeDriver());
				break;
			default:
				throw new IllegalArgumentException("Browser not supported: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(TestUtil.implicitWait);
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut);
		js = (JavascriptExecutor) getDriver();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

	public String getTitle() {
		waitForPageToLoad();
		String title = getDriver().getTitle();
		return title;
	}

	public void setBrowserZoom() throws AWTException {
		robot = new Robot();
		for (int i = 0; i < 1; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		}
	}

	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) Base.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(currentDir + "/test-output/extentReports/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static String getScreenshot() {
		String screenshotBase64 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
	}

	public static void addReport() throws IOException {
		byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
		try {
			scenario.attach(sourcePath, "image/png", scenario.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageToLoad() {
		getDriver().manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeOut);
	}

	public void close() {
		getDriver().close();
	}

	public void goToURL(String url) {
		getDriver().navigate().to(url);
	}

	public void back() {
		getDriver().navigate().back();
	}

	public void refresh() {
		getDriver().navigate().refresh();
	}

	public String getCurrentURL() {
		return getDriver().getCurrentUrl();
	}

	public void scrollBy(int scroll) {
		js.executeScript("window.scrollBy(0,1000)");
	}

	// Scroll up to element to be visible
	public void scrollToViewElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToViewAndSendKeys(WebElement element, String input) {
		js.executeScript("arguments[0].setAttribute('value','" + input + "')", element);
	}

	public void scrollToViewAndCLickElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
	}

	// Scroll to bottom of page
	public void scrollToBottomOfPage() {
		js.executeScript("window.scrollTo(0, document.body.clientHeight);");
	}

	// Scroll to top of page
	public void scrollToTopOfPage() {
		js.executeScript("window.scrollTo(0, 0)");
	}

	// Get single element
	public void waitVisible(WebElement element) {
		WebDriverWait expliciteWait = new WebDriverWait(getDriver(), Duration.ofSeconds(150));
		expliciteWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementClickable(WebElement element) {
		WebDriverWait expliciteWait = new WebDriverWait(getDriver(), Duration.ofSeconds(100));
		expliciteWait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void waitExistsForNestedElements(WebElement element, By subelement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(subelement, subelement));
	}

	public WebElement waitUntilElementClickable(WebElement element) {
		try {
			WebDriverWait expliciteWait = new WebDriverWait(getDriver(), Duration.ofSeconds(70));
			return expliciteWait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			System.out.println("Element : '" + element + "' was not found in current context page.");
			throw e;
		}
	}

	public void jsClick(WebElement element) {
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		js.executeScript("arguments[0].click();", element);
	}

	/* Alert Handler */
	public boolean acceptAlert() {
		try {
			Alert alert = getDriver().switchTo().alert();
			alert.accept();
			System.out.println("Alert Was Present");
			return true;
		} catch (Exception e) {
			System.out.println("No Alert Found");
			return false;
		}
	}

	public boolean dismissAlert() {
		try {
			Alert alert = getDriver().switchTo().alert();
			alert.dismiss();
			System.out.println("Alert Was Present");
			return true;
		} catch (Exception e) {
			System.out.println("No Alert Found");
			return false;
		}
	}

	public String getAlertText() {
		try {
			Alert alert = getDriver().switchTo().alert();
			String text = alert.getText();
			System.out.println("Alert Was Present");
			return text;
		} catch (Exception e) {
			System.out.println("No Alert Found");
			return null;
		}
	}

	public void mouseHoverOnElement(WebElement element) {
		Actions hover = new Actions(getDriver());
		hover.moveToElement(element);
		hover.perform();
	}

	public void mouseHoverAndClick(WebElement element) {
		waitVisible(element);
		Actions hover = new Actions(getDriver());
		hover.moveToElement(element).click().perform();
	}

	public void mouserHoverAndClick(WebElement element, WebElement clickElement) {
		waitVisible(element);
		Actions hover = new Actions(getDriver());
		hover.moveToElement(element).perform();
		hover.moveToElement(clickElement).click().perform();
	}

	public void selectByText(WebElement element, String text) {
		waitVisible(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public  void PasteText() {
		Actions action = new Actions(getDriver());
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.build().perform();

	}



	// Select By Value from Drop down
	public void selectByValue(WebElement element, String value) {
		waitVisible(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// Select by Index from drop down
	public void selectByIndex(WebElement element, int index) {
		waitVisible(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void enter(By by) {
		getDriver().findElement(by).sendKeys(Keys.ENTER);
	}

	public String generateRandonString(String text) {
		LocalTime currenttime = LocalTime.now();
		String newcategoryname = text + currenttime;

		return newcategoryname;
	}

	public static void failed() throws IOException {
		File scrFile = ((TakesScreenshot) Base.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(currentDir + "/test-output/ExtentReports/screenshots/" + System.currentTimeMillis() + ".png"));
	}



	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) getDriver();
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
		} else if (messageType.equals("info")) {
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		} else if (messageType.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		} else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

	private PropertyReader propertyReader = new PropertyReader();
	protected Properties prop = propertyReader.PropertyReader();

	private CSVFileReader csvReader = new CSVFileReader();

}
