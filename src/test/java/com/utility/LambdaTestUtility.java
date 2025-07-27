package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {

	private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal  = new ThreadLocal<>();
	
	public static WebDriver lambdaTestSetup(String browserName, String testName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "sripal0207");
        ltOptions.put("accessKey", "LT_pfOndIOiuMoVhBpBU5gNIsoQIanB6xa0YzScNFmUAA2Fd1p");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driverLocal.set(driver);
        
        return driverLocal.get();
	}
	
	public static void quitDriver() {
		if (driverLocal.get() != null) {
			driverLocal.get().quit();
			driverLocal.remove();
		}
		if (capabilitiesLocal.get() != null) {
			capabilitiesLocal.remove();
		}
	}
}
