package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import appUtil.AppUtilityClass;
import config.Hooks;

public class VistaShoppingTestScenarioClass extends Hooks {

	/*
	 * TestNG Annoations 1) invocationCount = 2
	 * 
	 */

	@Test(groups = { "Shopping Functionality" }, priority = 1, enabled = true)
	public void Shopping_PositiveScenario_Scenario1() throws IOException, InterruptedException {
		String ScenarioId = "ShoppingScenario1";
		ExtentTest test = extent.createTest(ScenarioId);
		AppUtilityClass AppUtil = new AppUtilityClass(driver);
		if (AppUtil.login(ScenarioId).equalsIgnoreCase("Pass")) {
			test.pass("Step:- Login Functionality with Valid Data - Passed");
			if (AppUtil.shopItems(ScenarioId).equalsIgnoreCase("Pass")) {
				test.pass("Step:- Add2Cart Functionality with Valid Data - Passed");
			}else if (AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")) {
				test.fail("Step:- Add2Cart Functionality with Valid Data - Failed");
				AppUtil.TakeScreenshot(ScenarioId);
			}
		} else if (AppUtil.login(ScenarioId).equalsIgnoreCase("Fail")) {
			test.fail("Step:- Login Functionality with Valid Data - Failed");
			AppUtil.TakeScreenshot(ScenarioId);
		}
	}
}
