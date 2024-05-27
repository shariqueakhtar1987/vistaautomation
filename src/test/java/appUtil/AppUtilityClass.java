package appUtil;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import utils.GenericUtilityClass;

public class AppUtilityClass extends GenericUtilityClass{
	
	WebDriver driver;
	Map<String, String> TestData = new HashMap<>();
	Date currentDate = new Date();

	public AppUtilityClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String login(String ScenarioId) throws IOException, InterruptedException {
		String PageName = "Login";
		TestData = this.getTestData(PageName, ScenarioId);
		String ScenarioType = TestData.get("ScenarioType");
		this.clickElement(this.getWebElement("SignInLink"));
		this.type(this.getWebElement("UserIdTxtFld"), TestData.get("EmailId"));
		this.type(this.getWebElement("PwdTxtField"), TestData.get("Password"));
		this.clickElement(this.getWebElement("SignInBtn"));
		if(ScenarioType.equalsIgnoreCase("Positive") & this.elementExist(this.getWebElements("LoggedInUser"))==true) {
			return "Pass";
		}else if (ScenarioType.equalsIgnoreCase("Negative") & this.elementExist(this.getWebElements("LoggedInUser"))==false) {
			return "Pass";
		}else {
			return "Fail";
		}		
	}
	
	public String logout(String ScenarioId) throws IOException, InterruptedException {
		String ScenarioType = TestData.get("ScenarioType");
		this.clickElement(this.getWebElement("SignOutBtn"));
		if(ScenarioType.equalsIgnoreCase("Positive") & this.elementExist(this.getWebElements("SignInLink"))==true) {
			return "Pass";
		}else if (ScenarioType.equalsIgnoreCase("Negative") & this.elementExist(this.getWebElements("SignInLink"))==false) {
			return "Pass";
		}else {
			return "Fail";
		}
	}
	
	public String registeration(String ScenarioId) throws InterruptedException {
		try {
			String PageName = "Registeration";
			TestData = this.getTestData(PageName, ScenarioId);
			String ScenarioType = TestData.get("ScenarioType");
			this.clickElement(this.getWebElement("SignInLink"));
			this.clickElement(this.getWebElement("RegisterationLink"));
			if(TestData.get("SocialTitle").equalsIgnoreCase("Mr")) {
				this.clickElement(this.getWebElement("SocialTitleMaleRadio"));
			}else if (TestData.get("SocialTitle").equalsIgnoreCase("Mrs")) {
				this.clickElement(this.getWebElement("SocialTitleFemaleRadio"));
			}
			this.type(this.getWebElement("FirstNameTxtFld"), TestData.get("FirstName"));
			this.type(this.getWebElement("LastNameTxtFld"), TestData.get("LastName"));
			String EmailId= TestData.get("FirstName")+TestData.get("LastName")+currentDate.getTime()+"@test.com";
			this.type(this.getWebElement("EmailTxtFld"),EmailId);
			this.type(this.getWebElement("PwdTxtFld"), TestData.get("Password"));
			this.type(this.getWebElement("DOBTxtFld"), TestData.get("BirthDate"));
			if(TestData.get("OffersChebox").equalsIgnoreCase("Yes")) {
				this.clickElement(this.getWebElement("RcvOfferCheckbox"));
			}
			if(TestData.get("TermsCheckbox").equalsIgnoreCase("Yes")) {
				this.clickElement(this.getWebElement("TermsCheckbox"));
			}
			if(TestData.get("NewsletterCheckbox").equalsIgnoreCase("Yes")) {
				this.clickElement(this.getWebElement("NewsLetterSignUpCheckbox"));	
			}
			if(TestData.get("DataPrivacyCheckbox").equalsIgnoreCase("Yes")) {
				this.clickElement(this.getWebElement("DataPrivacyCheckbox"));	
			}			
			this.clickElement(this.getWebElement("RegisterationSaveBtn"));
			this.driver.navigate().refresh();
			if(ScenarioType.equalsIgnoreCase("Positive") & this.elementExist(this.getWebElements("RegisterationSaveBtn"))==false) {
				return "Pass";
			}else if(ScenarioType.equalsIgnoreCase("Negative") & this.elementExist(this.getWebElements("RegisterationSaveBtn"))==true) {
				return "Pass";
			}else {
				return "Fail";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}

	public String shopItems(String ScenarioId) throws IOException {
		String PageName = "Shoping";
		TestData = this.getTestData(PageName, ScenarioId);
		if(TestData.get("MenuOption").equalsIgnoreCase("Clothes")) {
			this.moveToElement(this.getWebElement("ClothesMenuLink"));
		}else if(TestData.get("MenuOption").equalsIgnoreCase("Accessories")) {
			this.moveToElement(this.getWebElement("AccessoriesMenuLink"));
		}else if(TestData.get("MenuOption").equalsIgnoreCase("Art")) {
			this.clickElement(this.getWebElement("ArtMenuLink"));
		}
		this.clickElement(this.getWebElementwithDynamicXPath("SubMenuLink",TestData.get("ProductCategory")));
		this.clickElement(this.getWebElementwithDynamicXPath("ProductTitleList",TestData.get("ProductName")));
		this.clickElement(this.getWebElement("Add2CartBtn"));
		this.clickElement(this.getWebElement("Prcd2ChkOut"));
		this.clickElement(this.getWebElement("Prcd2ChkOutConfirmation"));
		this.clickElement(this.getWebElement("AddressConfirmBtn"));
		this.clickElement(this.getWebElement("DlvryConfirmBtn"));
		this.clickElement(this.getWebElementwithDynamicXPath("PaymentOptionCheckbox",TestData.get("PaymentOption")));
		this.clickElement(this.getWebElement("PaymentTnCCheckbox"));
		this.clickElement(this.getWebElement("PlaceOrderBtn"));
		

		
		
		return ScenarioId;
		
	}


}
