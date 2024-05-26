package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import appUtil.AppUtilityClass;
import config.Hooks;

public class VistaLogInLogOutTestScenarioClass extends Hooks {

	/*
	 * TestNG Annoations 1) invocationCount = 2
	 * 
	 */

	@Test(groups = { "Login Functionality" }, priority = 1, enabled = true)
	public void LoginFunctionality_PositiveScenario_LoginScenario1() throws IOException {
		String ScenarioId = "LoginScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if (AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")) {
			test.pass("Step:- Login Functionality with Positive Data - Passed");
		} else if (AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")) {
			test.fail("Step:- Login Functionality with Positive Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}

	}

	@Test(groups = { "Login Functionality" }, priority = 2, alwaysRun = true)
	public void LoginFunctionality_NegativeScenario_LoginScenario2() throws IOException {
		String ScenarioId = "LoginScenario2";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if (AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")) {
			test.pass("Step:- Login Functionality with Invalid Data - Passed");
		} else if (AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")) {
			test.fail("Step:- Login Functionality with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}

	// Below scenario is intentionally failed
	@Test(groups = { "Login Functionality" }, priority = 3)
	public void LoginFunctionality_PositiveScenario_LoginScenario3() throws IOException {
		String ScenarioId = "LoginScenario3";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if (AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")) {
			test.pass("Step:- Login Functionality with Invalid Data - Passed");
		} else if (AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")) {
			test.fail("Step:- Login Functionality with Invalid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}

	}
}
