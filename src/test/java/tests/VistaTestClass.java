package tests;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import appUtil.AppUtilityClass;
import config.Hooks;

public class VistaTestClass extends Hooks{
	
	
	@Test
	public void RegisterationFunctionality_PositiveScenario_RegisterationScenario1() {
		String ScenarioId = "RegisterationScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Positive Data - Passed");
		}else if(AppUtil.registeration("RegisterationScenario1").equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Positive Data - Failed");
		}
	}
	
	@Test
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario2() {
		String ScenarioId = "RegisterationScenario2";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration("RegisterationScenario1").equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
		}
	}
	
	@Test
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario3() {
		String ScenarioId = "RegisterationScenario3";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
		}
	}
	
	@Test
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario4() {
		String ScenarioId = "RegisterationScenario4";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
		}
	}
	
	@Test
	public void RegisterationFunctionality__NegativeScenaio_RegisterationScenario5() {
		String ScenarioId = "RegisterationScenario5";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Pass")){
			test.pass("Step:- Registeration with Negative Data - Passed");
		}else if(AppUtil.registeration(ScenarioId).equalsIgnoreCase("Fail")){
			test.pass("Step:- Registeration with Negative Data - Failed");
		}
	}
}
