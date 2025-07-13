package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	
	HomePage homePage;
	
	@BeforeMethod(description = "Launch Application HomePage")
	public void setup() {
		homePage = new HomePage(CHROME);
	}

	@Test(description = "Verify Login with Valid Credentials", groups = {"smoke","regression"}, 
			dataProviderClass = com.ui.dataproviders.LoginDataProviders.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {
		String accountName = homePage.goToLoginPage().doLoginWith(user.getUsername(), user.getPassword()).getAccountName();
		assertEquals(accountName, "John Doe");
	}

}
