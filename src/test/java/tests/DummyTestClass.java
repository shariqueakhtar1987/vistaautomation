package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import config.Hooks;
import reporting.MyRetry;

public class DummyTestClass extends Hooks{
	
	@Test(priority = 3,retryAnalyzer = MyRetry.class)
	public void DummyFailedTestScenario() {
		System.out.println("Failed");
		Assert.fail();
	}

}
