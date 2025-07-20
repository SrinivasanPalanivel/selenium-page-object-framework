package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class RetryMechanism implements IRetryAnalyzer {
	
	//Reading Max Attempts from Properties file
//	private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperties(Env.QA, "MAX_RETRY_ATTEMPTS"));
	
	//Reading Max Attempts from JSON file
	private static final int MAX_ATTEMPTS = JSONUtility.readJSONFile(Env.QA).getMAX_RETRY_ATTEMPTS();
	
	private static int currentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
