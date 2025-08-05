package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	
	private static final By ACCOUNT_NAME_TEXT_LOCATOR = By.xpath("//a[@class='account']");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_query_top");
	private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//button[@name='submit_search']");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Actions
	public String getAccountName() {
		return getVisibleText(ACCOUNT_NAME_TEXT_LOCATOR);
	}
	
	public MyAccountPage searchFor(String searchText) {
		setText(SEARCH_TEXTBOX_LOCATOR, searchText);
		return this;
	}
	
	public MyAccountPage clickOnSearchButton() {
		clickOn(SEARCH_BUTTON_LOCATOR);
		return this;
	}
	
	//Page Function
	public ProductPage searchForProduct(String searchText) {
		searchFor(searchText).clickOnSearchButton();
		ProductPage productPage = new ProductPage(getDriverInstance());
		return productPage;
	}
	

}
