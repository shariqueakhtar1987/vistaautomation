package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Hooks {
	
	public static Map<String, String> configObject;
	public WebDriver driver;
	public static ExtentReports extent =  new ExtentReports();
	ExtentSparkReporter sparkReporter;

	
	@BeforeSuite
	public void beforeSuite() {
		configObject = readConfigToMap();
		Date currentDate = new Date();

		String ExtenReportFilePath = System.getProperty("user.dir")+"\\ExtentReport\\"+"ExecutionStatus-"+currentDate.getTime()+"_ExtentReport.html";
		sparkReporter = new ExtentSparkReporter(ExtenReportFilePath);
		extent.attachReporter(sparkReporter);
	}
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		this.launchBrowser();
	}
	
	@AfterMethod
	public void afterMethod() {
		this.closeBrowser();
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		// CLOSE BROWSER 
		// EXIT WEBDRIVER INSTANCE
		// PUBLISH REPORT
		// POST COMPLETION STEPS
		if(this.driver != null) {
			this.driver.quit();
		}
		extent.flush();
	}
	
	/**
	 * <p>Reads the config properties file into an In-Memory HashMap</p>
	 * @return Map<String, String>
	 * @author Siddharth
	 */
	public Map<String, String> readConfigToMap() {
		try {
			FileInputStream fis = new FileInputStream(new File("./src/test/resources/config.properties"));
			Properties properties = new Properties();
			properties.load(fis);
			Map<Object, Object> configProps = properties;
			return new HashMap(configProps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void launchBrowser() {
		if(configObject.get("browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chromer.driver", configObject.get("browser_driver_path"));
			 this.driver = new ChromeDriver();
		}
	}
	
	public void closeBrowser() {
		if(this.driver != null) {
			driver.quit();
		}
	}
	
	
}
