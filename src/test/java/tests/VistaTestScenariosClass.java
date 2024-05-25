package tests;


import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import appUtil.AppUtilityClass;
import config.Hooks;

public class VistaTestScenariosClass extends Hooks{
	
	@Test(groups= {"Login Functionality"}) 
	public void LoginFunctionality_PositiveScenario_LoginScenario1() throws IOException {
		String ScenarioId = "LoginScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Login Functionality with Positive Data - Passed");
		}else if(AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Login Functionality with Positive Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}

	}
	
	@Test(groups= {"Login Functionality"}) 
	public void LoginFunctionality_NegativeScenario_LoginScenario2() throws IOException {
		String ScenarioId = "LoginScenario2";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Login Functionality with Invalid Data - Passed");
		}else if(AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Login Functionality with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
		
	// Below scenario is intentionally failed
	@Test(groups= {"Login Functionality"}) 
	public void LoginFunctionality_PositiveScenario_LoginScenario3() throws IOException {
		String ScenarioId = "LoginScenario3";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Login Functionality with Invalid Data - Passed");
		}else if(AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Login Functionality with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}

	}
	
	@Test(groups= {"Registeration Functionality"}) 
	public void RegisterationFunctionality_PositiveScenario_RegisterationScenario1() {
		String ScenarioId = "RegisterationScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Positive Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Positive Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario2() {
		String ScenarioId = "RegisterationScenario2";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario3() {
		String ScenarioId = "RegisterationScenario3";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario4() {
		String ScenarioId = "RegisterationScenario4";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario5() {
		String ScenarioId = "RegisterationScenario5";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
}
