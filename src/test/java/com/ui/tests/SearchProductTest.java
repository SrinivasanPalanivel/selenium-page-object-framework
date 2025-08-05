package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListener.class})
public class SearchProductTest extends BaseTest {
	
	private MyAccountPage myAccountPage;
	
	@BeforeMethod
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doValidLogin("fifepo3104@binafex.com", "Test@123");
	}
	
	@Test(description = "Search for a product and verify results", 
			groups = {"regression", "smoke"})
	public void searchProductTest() {
		boolean result = myAccountPage.searchForProduct("Printed Summer Dress").verifySearchResults();
		assertEquals(result, true);
	}

}
