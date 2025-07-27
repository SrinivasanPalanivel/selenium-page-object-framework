package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.ui.pojo.Environment;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.JSONUtility.*;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		maximizeWindow();
		//goToWebsite(readProperties(QA, "URL"));
		goToWebsite(readJSONFile(QA).getUrl());
	}
	
	public HomePage(WebDriver lambdaDriver) {
		super(lambdaDriver);
		maximizeWindow();
		goToWebsite(readJSONFile(QA).getUrl());
	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriverInstance());
		return loginPage;
	}

}
