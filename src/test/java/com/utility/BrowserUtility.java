package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // --> Instance Variable

	// Getter Method to Pass the Instance
	public WebDriver getDriverInstance() {
		return driver.get();
	}

	// Constructor to Initialize the driver
	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
	}

	// Another Constructor to
	public BrowserUtility(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver.set(new ChromeDriver());
			break;
		case "edge":
			driver.set(new EdgeDriver());
			break;
		default:
			System.err.println("Invalid Browser Name....");
		}
	}

	// Another Constructor to
	public BrowserUtility(Browser browserName) {
		switch (browserName) {
		case CHROME:
			driver.set(new ChromeDriver());
			break;
		case EDGE:
			driver.set(new EdgeDriver());
			break;
		default:
			System.err.println("Invalid Browser Name....");
		}
	}

	// Another Constructor to
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		switch (browserName) {
		case CHROME:
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
			break;
		case EDGE:
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
			break;
		default:
			System.err.println("Invalid Browser Name....");
			break;
		}
	}

	// Creating Wrapper Methods for Selenium
	
	public List<WebElement> getElements(By locator) {
		try {
			return driver.get().findElements(locator);
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find the element... Try different Locator");
			return null;
		} catch (Exception e) {
			System.err.println("An error occurred while getting elements: " + e.getMessage());
			return null;
		}
	}
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		driver.get().findElement(locator).click();
	}

	public void setText(By locator, String textToEnter) {
		driver.get().findElement(locator).sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		try {
			return driver.get().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find the element... Try different Locator");
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String getVisibleText(String element) {
		try {
			return driver.get().findElement(By.xpath(element)).getText();
		} catch (NoSuchElementException e) {
			System.err.println("Unable to find the element... Try different Locator");
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String takeScreenShot(String name) {
		TakesScreenshot snap = (TakesScreenshot) driver.get();
		File file = snap.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy - HHmmss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File newFile = new File(path);
		try {
			FileUtils.copyFile(file, newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void closeBrowser() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		} else {
			System.err.println("Driver is not initialized or already closed.");
		}
	}
}
