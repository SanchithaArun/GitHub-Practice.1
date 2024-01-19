package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 * @author asanc
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryCount=3;
	
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;//retry
		}
		return false;//stop retrying
	}

}
