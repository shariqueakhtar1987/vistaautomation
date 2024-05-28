package reporting;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int retryCount = 0;
		int maxRetryCount = 3;
		{
			if (retryCount < maxRetryCount) {
				retryCount++;
				return true;
			}
			return false;
		}

	}

}
