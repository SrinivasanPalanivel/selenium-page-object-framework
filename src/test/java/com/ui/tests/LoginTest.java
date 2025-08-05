package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends BaseTest{

	@Test(description = "Verify Login with Valid Credentials", groups = {"smoke","regression"}, 
			dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider_JSON", 
			priority = 1)
	public void loginTest_Valid_JSON(User user) {
		String accountName = homePage.goToLoginPage().doValidLogin(user.getUsername(), user.getPassword()).getAccountName();
		assertEquals(accountName, user.getAccountName());	
	}
	
	@Test(description = "Verify Login with Invalid Credentials", groups = {"smoke", "regression"}, priority = 2)
	public void loginTest_Invalid_JSON() {
		String errorMessage = homePage.goToLoginPage().doInvalidLogin("nasurath@firefox.com", "Test@123");
		assertEquals(errorMessage, "Authentication failed.");
	}
	
//	@Test(description = "Verify Login with Valid Credentials", groups = {"smoke"}, 
//			dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider_CSV")
//	public void loginTest_CSV(User user) {
//		String accountName = homePage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getAccountName();
//		assertEquals(accountName, "John Doe");
//	}
//	
//	@Test(description = "Verify Login with Valid Credentials", groups = {"smoke","sanity"}, 
//			dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider_Excel",
//			retryAnalyzer = com.ui.listeners.RetryMechanism.class)
//	public void loginTest_Excel(User user) {
//		String accountName = homePage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getAccountName();
//		assertEquals(accountName, "John Doe");
//	}

}
