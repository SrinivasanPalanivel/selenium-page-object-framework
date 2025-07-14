package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class RegistrationTest {
	
	HomePage homePage;
	
	@BeforeMethod(description = "Launch Application HomePage")
	public void setup() {
		homePage = new HomePage(CHROME);
	}
	
	@Test
	public void registrationTest() {
		
	}

}
