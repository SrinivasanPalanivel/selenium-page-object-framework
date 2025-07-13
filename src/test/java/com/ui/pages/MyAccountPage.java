package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	
	private static final By ACCOUNT_NAME_TEXT_LOCATOR = By.xpath("//a[@class='account']");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Actions
	public String getAccountName() {
		return getVisibleText(ACCOUNT_NAME_TEXT_LOCATOR);
	}
	

}
