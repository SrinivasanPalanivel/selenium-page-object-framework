package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	private static final By USERNAME_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By CREATE_ACCOUNT_BUTTON_LOCATOR = By.id("SubmitCreate");
	private static final By EMAIL_ADDRESS_TEXTBOX_LOCATOR = By.id("email_create");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Actions
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
	
	public LoginPage name(String emailAddress) {
		setText(CREATE_ACCOUNT_BUTTON_LOCATOR, emailAddress);
		return this;
	}
	
	public LoginPage clickOnCreateAccount() {
		clickOn(CREATE_ACCOUNT_BUTTON_LOCATOR);
		return this;
	}
	
	//Page Function
	public MyAccountPage doLoginWith(String username, String password) {
		enterUsername(username).enterPassword(password).clickOnLogin();
		MyAccountPage myAccountPage = new MyAccountPage(getDriverInstance());
		return myAccountPage;
	}

}
