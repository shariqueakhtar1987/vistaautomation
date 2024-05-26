package tests;


import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import appUtil.AppUtilityClass;
import config.Hooks;

public class VistaRegisterationTestScenarioClass extends Hooks{
	
	/*
	 TestNG Annoations
	 1) invocationCount = 2
	 * 
	 */
	
	
	@Test(groups= {"Registeration Functionality"}, priority = 1) 
	public void RegisterationFunctionality_PositiveScenario_RegisterationScenario1() throws InterruptedException {
		String ScenarioId = "RegisterationScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Valid Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.fail("Step:- Registeration with Valid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}, priority = 2) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario2() throws InterruptedException {
		String ScenarioId = "RegisterationScenario2";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Invalid Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.fail("Step:- Registeration with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}, priority = 3) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario3() throws InterruptedException {
		String ScenarioId = "RegisterationScenario3";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Invalid Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.fail("Step:- Registeration with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}, priority = 4) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario4() throws InterruptedException {
		String ScenarioId = "RegisterationScenario4";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Invalid Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.fail("Step:- Registeration with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
	
	@Test(groups= {"Registeration Functionality"}, priority = 5) 
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario5() throws InterruptedException {
		String ScenarioId = "RegisterationScenario5";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Invalid Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.fail("Step:- Registeration with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
}
