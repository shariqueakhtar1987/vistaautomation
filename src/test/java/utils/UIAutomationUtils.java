package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIAutomationUtils {
	// IMPLEMENTATION FOR RE-USABLE METHODS
	
	public WebDriver driver;
	
	public UIAutomationUtils(WebDriver driver) {
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
		element.click();
	}
	
	public void type(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public boolean elementExist(List<WebElement> element) {
		if(element.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void waitForWebElement(By element) {
//		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Hooks.configObject.get("wait_duration"))));
//		wait.until(el -> driver.findElement(element).isDisplayed());
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
		//int numCols = sheet.getRow(0).getLastCellNum();
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
}
