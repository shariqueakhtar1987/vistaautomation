package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.Hooks;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericUtilityClass extends Hooks {
	// IMPLEMENTATION FOR RE-USABLE METHODS

	public WebDriver driver;
	WebDriverWait wait;
	Map<String, String> configObject;
	//Hooks hooks = new Hooks();
	public GenericUtilityClass(WebDriver driver) {
		this.driver = driver;
		this.configObject = readConfigToMap();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configObject.get("wait_duration"))));
	}

	/**
	 *
	 * @param url
	 */
	public void navigateToUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickElement(WebElement element) {
		waitForWebElement(element);
		element.click();
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(this.driver);
		waitForWebElement(element);
		actions.moveToElement(element).build().perform();
	}

	public void clickElementwithTxt(List<WebElement> element, String Text) {
		for (WebElement e : element) {
			if (e.getText().equalsIgnoreCase(Text)) {
				clickElement(e);
			}
		}
	}

	public void type(WebElement element, String text) {
		waitForWebElement(element);
		element.sendKeys(text);
	}

	public boolean elementExist(List<WebElement> element) throws InterruptedException {
		waitForAllWebElement(element);
        return !element.isEmpty();
	}

	public void waitForAllWebElement(List<WebElement> element) {
		//this.wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public void waitForWebElement(WebElement element) {
		//this.wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	public WebElement getWebElement(String locatorName) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();

		for (int i = 0; i <= numRows; i++) {
			if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String locatorType = sheet.getRow(i).getCell(2).getStringCellValue();
				String locatorValue = sheet.getRow(i).getCell(3).getStringCellValue();

				switch (locatorType) {
				case "name":
					return this.driver.findElement(By.name(locatorValue));
				case "id":
					return this.driver.findElement(By.id(locatorValue));
				case "xpath":
					return this.driver.findElement(By.xpath(locatorValue));
				}
			}
		}
		workBook.close();
		if (numRows < 1) {
			return null;
		}
		return null;
	}

	public List<WebElement> getWebElements(String locatorName) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		for (int i = 0; i <= numRows; i++) {
			if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String locatorType = sheet.getRow(i).getCell(2).getStringCellValue();
				String locatorValue = sheet.getRow(i).getCell(3).getStringCellValue();

				switch (locatorType) {
				case "name":
					return this.driver.findElements(By.name(locatorValue));
				case "id":
					return this.driver.findElements(By.id(locatorValue));
				case "xpath":
					return this.driver.findElements(By.xpath(locatorValue));
				}
			}
		}
		workBook.close();
		if (numRows < 1) {
			return null;
		}
		return null;
	}

	public Connection getSQLConnection(){
		try{
			if(DriverManager.getConnection(configObject.get("SQLConnectionString"),configObject.get("SQLServerUId"),configObject.get("SQLServerPwd")).isClosed()){
				return null;
			}else{
				return DriverManager.getConnection(configObject.get("SQLConnectionString"),configObject.get("SQLServerUId"),configObject.get("SQLServerPwd"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
    }

	public Map<String, String> getSQLTestData(String PageName, String ScenarioId) throws IOException, SQLException {
		Map<String, String> TestData = new HashMap<>();
		String query="";
		switch (PageName) {
			case "Login":
				query = "SELECT * FROM VB_LoginDetails";
				break;
			case "Registeration":
				//query = "SELECT * FROM VB_LoginDetails";
				//break;
			case "Shopping":
				//query = "SELECT * FROM VB_LoginDetails";
				//	break;
		}
		try{
			Connection con = this.getSQLConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData RS = resultSet.getMetaData();
			int row= 1;
			int column=1;
			while (resultSet.next()){
				row = row ++;
				if(resultSet.getString(row).equalsIgnoreCase(ScenarioId)){
					while(column<=RS.getColumnCount()) {
						TestData.put(RS.getColumnName(column),resultSet.getString(column));
						column++;
					}
					break;
				}
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}


		return TestData;
	}

	public Map<String, String> getTestData(String PageName, String ScenarioId) throws IOException {
		Map<String, String> TestData = new HashMap<>();
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/test-data.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(PageName);
		int numRows = sheet.getLastRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();
		for (int j = 0; j <= numRows; j++) {
			if (sheet.getRow(j).getCell(0).getStringCellValue().equalsIgnoreCase(ScenarioId)) {
				for (int k = 0; k < numCols; k++) {
					TestData.put(sheet.getRow(0).getCell(k).getStringCellValue(),
							sheet.getRow(j).getCell(k).getStringCellValue());
				}
				break;
			}
		}
		workBook.close();
		return TestData;
	}

	public void TakeScreenshot(String ScenarioId) {
		TakesScreenshot scrShot = ((TakesScreenshot) this.driver);
		Date currentDate = new Date();
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + ScenarioId + "_" + currentDate.getTime() + ".jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.driver.quit();
		Assert.fail();

	}

	public WebElement getWebElementwithDynamicXPath(String locatorName, String Text) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		for (int i = 0; i <= numRows; i++) {
			if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String LocatorVal = sheet.getRow(i).getCell(3).getStringCellValue();
				return this.driver.findElement(By.xpath(LocatorVal.replace("{%s}", Text)));
			}
		}
		workBook.close();
		if (numRows < 1) {
			return null;
		}
		return null;
	}

	public List<WebElement> getWebElementswithDynamicXPath(String locatorName, String Text) throws IOException {
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		for (int i = 0; i <= numRows; i++) {
			if (sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String LocatorVal = sheet.getRow(i).getCell(3).getStringCellValue();
				return this.driver.findElements(By.xpath(LocatorVal.replace("{%s}", Text)));
			}
		}
		workBook.close();
		if (numRows < 1) {
			return null;
		}
		return null;
	}
}