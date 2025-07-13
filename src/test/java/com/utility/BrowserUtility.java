package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private WebDriver driver; // --> Instance Variable

	// Getter Method to Pass the Instance
	public WebDriver getDriverInstance() {
		return driver;
	}

	// Constructor to Initialize the driver
	public BrowserUtility(WebDriver driver) {
		this.driver = driver;
	}

	// Another Constructor to
	public BrowserUtility(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("Invalid Browser Name....");
		}
	}
	
	// Another Constructor to
	public BrowserUtility(Browser browserName) {
		switch (browserName) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("Invalid Browser Name....");
		}
	}

	// Creating Wrapper Methods for Selenium
	public void goToWebsite(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {
		driver.findElement(locator).click();
	}

	public void setText(By locator, String textToEnter) {
		driver.findElement(locator).sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		return driver.findElement(locator).getText();
	}

}
