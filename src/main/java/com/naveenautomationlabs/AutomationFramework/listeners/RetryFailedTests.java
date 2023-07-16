package com.naveenautomationlabs.AutomationFramework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer{

	private int count=1;
	private int maxCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}

}
