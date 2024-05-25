//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import utils.UIAutomationUtils;
//
//public class GTPLBankNewCustomer extends UIAutomationUtils {
//	
//	WebDriver driver;
//
//	public GTPLBankNewCustomer(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//		this.driver = driver;
//	}
//	
//	By NewCustomerMenuLink = By.xpath("//ul[@class='menusubnav']//*[contains(text(),'New Customer')]");
//	By CustomerNameField = By.name("name");
//	By GenderMaleRadio = By.xpath("//input[@name='rad1'][1]");
//	By GenderFemaleRadio = By.xpath("//input[@name='rad1'][2]");
//	By DOBField = By.name("dob");
//	By AddressField = By.name("addr");
//	By CityField = By.name("city");
//	By StateField = By.name("state");
//	By PINField = By.name("pinno");
//	By TelPhonField = By.name("telephoneno");
//	By EmailField = By.name("emailid");
//	By SubmitBtn = By.name("sub");
//	By ResetBtn = By.name("res");
//	
//	public String AddCustomer(String CustomerName, String Gender, String DOB, String Address, String CityName,String StateName, String Pin, String Telephone, String Emaild) {
//		super.clickElement(NewCustomerMenuLink);
//		super.driver.navigate().refresh();
//		super.clickElement(NewCustomerMenuLink);
//		super.type(CustomerNameField, CustomerName);
//		if(Gender.equalsIgnoreCase("Male")) {
//			super.clickElement(GenderMaleRadio);
//		}else {
//			super.clickElement(GenderFemaleRadio);
//		}
//		super.type(DOBField, DOB);
//		super.type(AddressField, Address);
//		super.type(CityField, CityName);
//		super.type(StateField, StateName);
//		super.type(PINField, Pin);
//		super.type(TelPhonField, Telephone);
//		super.type(EmailField, Emaild);
//		super.clickElement(SubmitBtn);
//		if(super.elementExist(SubmitBtn)==false){
//			return "Passed";
//		}else {
//			return "Failed";
//		}
//	}
//
//}
