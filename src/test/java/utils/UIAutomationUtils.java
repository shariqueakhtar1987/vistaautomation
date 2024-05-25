package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Hooks;

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
	
	public boolean elementExist(By element) {
		if(driver.findElements(element).size()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void waitForWebElement(By element) {
//		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Hooks.configObject.get("wait_duration"))));
//		wait.until(el -> driver.findElement(element).isDisplayed());
	}
	
	public WebElement getLocatorFromDataSource(String page, String locatorName) throws IOException {
		//Hooks.configObject.get("locators_path")
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(page);
		int numRows = sheet.getLastRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();
		for(int i=0; i<=numRows; i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(locatorName)) {
				String locatorType = sheet.getRow(i).getCell(1).getStringCellValue();
				String locatorValue = sheet.getRow(i).getCell(2).getStringCellValue();
				
				switch(locatorType) {
				case "name":
					return this.driver.findElement(By.name(locatorValue));
				case "id":
					return this.driver.findElement(By.id(locatorValue));
				}
			}
		}
		return null;
	}
}
