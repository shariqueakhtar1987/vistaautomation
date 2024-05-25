package appUtil;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import utils.UIAutomationUtils;

public class AppUtilityClass extends UIAutomationUtils{
	
	WebDriver driver;
	Map<String, String> TestData = new HashMap<>();
	Date currentDate = new Date();

	public AppUtilityClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String login(String ScenarioId) throws IOException {
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
	
	public String registeration(String ScenarioId) {
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
}
