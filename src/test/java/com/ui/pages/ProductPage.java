package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class ProductPage extends BrowserUtility {
	
	private static final By LIST_OF_PRODUCT_LOCATOR = By.xpath("//ul[@class='product_list grid row']/li");
	private static final By PRODUCT_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean verifySearchResults() {
		int numberOfProducts = getElements(LIST_OF_PRODUCT_LOCATOR).size();
		for(int i=1; i<=numberOfProducts; i++) {
			String productName = getVisibleText("(//h5[@itemprop='name']/a)["+i+"]");
			System.out.println("Product Name: " + productName);
			if(productName.contains("Summer") || productName.contains("Printed") || productName.contains("Dress")) {
				continue;
			} else {
				System.err.println("Product name does not match the search criteria: " + productName);
				return false;
			}
		}
		return true;
	}

}
