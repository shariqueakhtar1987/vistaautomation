package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class DebugClass {

	public WebElement getLocatorFromDataSource(String page, String locatorName) throws IOException {
		//Hooks.configObject.get("locators_path")
		FileInputStream fis = new FileInputStream(new File("./src/test/resources/webelements.xlsx"));
		Workbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(page);
		int numRows = sheet.getLastRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();
		for(int i=0; i<numRows; i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(locatorName)) {
				System.out.println("Found locator in row "+i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		new DebugClass().getLocatorFromDataSource("loginPage", "userIdField");
	}
}
