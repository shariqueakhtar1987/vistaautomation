package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;


public class GenericUtilityClass {
	// IMPLEMENTATION FOR RE-USABLE METHODS
	
	public WebDriver driver;
	Wait<WebDriver> wait;
	
	public GenericUtilityClass(WebDriver driver) {
		this.driver = driver;
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
	
	public void  moveToElement(WebElement element) {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void clickElementwithTxt(List<WebElement> element, String Text) {
		for(WebElement e: element) {
			if(e.getText().equalsIgnoreCase(Text)) {
				clickElement(e);
			}
		}		
	}
	
 	public void type(WebElement element, String text) {
		waitForWebElement(element);
		element.sendKeys(text);
	}
	
	public boolean elementExist(List<WebElement> element) throws InterruptedException {
		if(element.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void waitForWebElement(WebElement element) {
//		wait = new WebDriverWait(this.driver,Duration.ofSeconds(Integer.parseInt(Hooks.configObject.get("wait_duration"))));
//		//Hooks.configObject.get("wait_duration")
//		wait.until(ExpectedConditions.);
		
	}
	public WebElement getWebElement(String locatorName) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		//int numCols = sheet.getRow(0).getLastCellNum();
		for(int i=0; i<=numRows; i++) {
			if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String locatorType = sheet.getRow(i).getCell(2).getStringCellValue();
				String locatorValue = sheet.getRow(i).getCell(3).getStringCellValue();
				
				switch(locatorType) {
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
		if(numRows<1) {
			return null;
		}
		return null;
	}
	
	public List<WebElement> getWebElements(String locatorName) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		for(int i=0; i<=numRows; i++) {
			if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String locatorType = sheet.getRow(i).getCell(2).getStringCellValue();
				String locatorValue = sheet.getRow(i).getCell(3).getStringCellValue();
				
				switch(locatorType) {
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
		if(numRows<1) {
			return null;
		}
		return null;
	}
	
	public Map<String, String> getTestData(String PageName, String ScenarioId) throws IOException {
		Map<String, String> TestData = new HashMap<>();
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/test-data.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(PageName);
		int numRows = sheet.getLastRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();
		for(int j=0; j<=numRows; j++) {
			if(sheet.getRow(j).getCell(0).getStringCellValue().equalsIgnoreCase(ScenarioId)) {
				for (int k=0; k<numCols; k++) {
					TestData.put(sheet.getRow(0).getCell(k).getStringCellValue(), sheet.getRow(j).getCell(k).getStringCellValue());
				}
				break;
			}	
		}
		workBook.close();
		return TestData;
	}

	public void TakeScreenshot(String ScenarioId) {
		TakesScreenshot scrShot =((TakesScreenshot)this.driver);
		Date currentDate = new Date();
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"\\Screenshots\\"+ScenarioId+"_"+currentDate.getTime()+".jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.driver.quit();
		Assert.fail();
		
	}
	

	
	@SuppressWarnings("resource")
	public WebElement getWebElementwithDynamicXPath(String locatorName, String Text) throws IOException {

		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet("ObjectRepository");
		int numRows = sheet.getLastRowNum();
		for(int i=0; i<=numRows; i++) {
			if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String LocatorVal =  sheet.getRow(i).getCell(3).getStringCellValue();	
				return this.driver.findElement(By.xpath(LocatorVal.replace("{%s}", Text)));
			}
		}
		workBook.close();
		if(numRows<1) {
			return null;
		}
		return null;
	}
}
