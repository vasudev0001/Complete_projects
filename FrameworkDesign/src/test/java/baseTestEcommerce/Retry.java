package baseTestEcommerce;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int i=0;
	@Override
	public boolean retry(ITestResult result) {
		
		int maxRun=1;
		if(i<maxRun) {
			System.out.println();
			i++;
			return true;
		}
		return false;
	}

}
