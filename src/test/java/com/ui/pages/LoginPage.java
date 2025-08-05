package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	private static final By USERNAME_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ALERT_ERROR_LOCATOR = By.xpath("//div[@class='alert alert-danger']/ol/li");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public LoginPage enterUsername(String username) {
		setText(USERNAME_TEXTBOX_LOCATOR, username); 
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		setText(PASSWORD_TEXTBOX_LOCATOR, password);
		return this;
	}
	
	public LoginPage clickOnLogin() {
		clickOn(LOGIN_BUTTON_LOCATOR);
		return this;
	}
	
	public String getErrorMessage() {
		return getVisibleText(ALERT_ERROR_LOCATOR);
	}
	
	//Page Function
	public MyAccountPage doValidLogin(String username, String password) {
		enterUsername(username).enterPassword(password).clickOnLogin();
		MyAccountPage myAccountPage = new MyAccountPage(getDriverInstance());
		return myAccountPage;
	}
	
	public String  doInvalidLogin(String username, String password) {
		return enterUsername(username).enterPassword(password).clickOnLogin().getErrorMessage();
	}

}
