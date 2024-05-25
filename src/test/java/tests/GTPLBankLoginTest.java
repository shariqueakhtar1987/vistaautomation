package tests;


import java.io.IOException;

import org.testng.annotations.Test;
import config.Hooks;
import pages.LoginFunctionalityClass;

public class GTPLBankLoginTest extends Hooks{
//	
//	@Test
//	public void loginTest() throws InterruptedException {
//		
//		ExtentTest test = extent.createTest("TC1_loginTest_ValidUser");
//		GTPLBankHomepage homepage = new GTPLBankHomepage(driver);
//		homepage.login("mngr571718", "patygYh");
//		Thread.sleep(2000);
//		test.pass("Step:- LogIn - Passed");
//	}
//	
//	@Test
//	public void newCustomerTest() throws InterruptedException {
//		ExtentTest test = extent.createTest("TC1_newCustomerTest");
//		GTPLBankHomepage homepage = new GTPLBankHomepage(driver);
//		GTPLBankNewCustomer AddNewCustomer = new GTPLBankNewCustomer(driver);
//		if(homepage.login("mngr571718", "patygYh")=="Passed") {
//			AddNewCustomer.AddCustomer("FirstCustomer", "Female", "13/02/1985", "Dubai Silicon Test Address", "TestCity", "TestState", "852963", "+971523257739", "testcustomer@outlook.com");
//			Thread.sleep(2000);
//			test.pass("Step:- LogIn - Passed");
//		}else {
//			//System.out.println("Log in failed");
//			test.pass("Step:- LogIn - Failed");
//		}
//		//String CustomerName, String Gender, String DOB, String Address, String CityName,String StateName, String Pin, String Telephone, String Emaild
//		
//	}
//	
	
	@Test
	public void testLoginFunctionalityPositive() throws IOException {
		LoginFunctionalityClass functionality = new LoginFunctionalityClass(driver);
		functionality.login("mngr571718", "patygYh");
	}
}
