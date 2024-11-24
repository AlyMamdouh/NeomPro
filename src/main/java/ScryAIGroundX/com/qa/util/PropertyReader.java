package ScryAIGroundX.com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	FileInputStream fis;

	private Properties prop;

	public Properties PropertyReader() {

		try {
			File file = new File("./src/main/resources/properties/test-uat.prop");

			fis = new FileInputStream(file);

			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Property Reader failed due to " + e);
		}
		
		return prop;

	}

	public String getBrowserName() {
		String browsername = prop.getProperty("BrowserName");
		return browsername;
	}

	public String getEnvironment() {
		String environment = prop.getProperty("Environment");
		return environment;
	}

	public String getAppliactionUrl() {

		String url = prop.getProperty("ApplicationUrl");
		System.out.println(url);
		return url;

	}

	public String getTestDataExcelPath() {
		String excelfilepath = "";
		try {
			excelfilepath = prop.getProperty("ExcelTestData");
		} catch (Exception e) {
			System.out.println("Get Excel Path failed due to " + e);
		}
		return excelfilepath;
	}

	public String getScreenshotPath() {
		String screenshotPath = prop.getProperty("Screnshots");

		return screenshotPath;
	}

}
