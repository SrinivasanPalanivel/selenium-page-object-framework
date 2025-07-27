package com.ui.tests;

import static com.constants.Browser.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class BaseTest {

	protected HomePage homePage;
	private boolean isLambdaTest; // Set to true if running on LambdaTest

	@Parameters({"browser", "isLambdaTest", "isHeadLess"})
	@BeforeMethod(description = "Launch Application HomePage")
	public void setup(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadLess, 
			ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.lambdaTestSetup(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			homePage = new HomePage(valueOf(browser.toUpperCase()), isHeadLess);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Close Browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitDriver();
		} else {
			homePage.closeBrowser();
		}
	}

}
