package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl");
		driver.manage().window().maximize();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign')]");
		WebElement signInLinkWebElement = driver.findElement(signInLinkLocator);
		signInLinkWebElement.click();
		
		By usernameTextBoxLocator = By.id("email");
		WebElement usernameTextBoxWebElement = driver.findElement(usernameTextBoxLocator);
		usernameTextBoxWebElement.sendKeys("fifepo3104@binafex.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		WebElement passwordTextBoxWebElement = driver.findElement(passwordTextBoxLocator);
		passwordTextBoxWebElement.sendKeys("Test@123");
		
		By loginButtonLocator = By.id("SubmitLogin");
		WebElement loginButtonWebElement = driver.findElement(loginButtonLocator);
		loginButtonWebElement.click();

	}

}
