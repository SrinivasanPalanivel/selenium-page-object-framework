package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	private static WebDriver driver;
	public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
	
    @BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}
	
	public static void loginActions(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Test(priority = 1)
	public static void validLoginTest() {
		//Actions
		loginActions("fifepo3104@binafex.com", "Test@123");
		
		//Verifications
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		
		String actualPageName = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		String expectedPageName = "My account";
		
		String actualAccountName = driver.findElement(By.xpath("//a[@class='account']")).getAttribute("innerText");
		String expectedAccountName = "John Doe";

		if(actualURL.equals(expectedURL) && actualPageName.equalsIgnoreCase(expectedPageName) && actualAccountName.equals(expectedAccountName)) {
			System.out.println(GREEN+"Test Passed Successfully!!!"+RESET);
		} else {
			System.err.println("Test Failed!!!");
		}
	}
	
	@Test(priority = 2)
	public static void invalidLoginTest() {
		loginActions("fifepo3104@binafex.com", "password");
		
		//Verifications
		String actualError = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getAttribute("innerText");
		String expectedError = "Authentication failed.";
		
		if(actualError.contains(expectedError)) {
			System.out.println(GREEN+"Test Passed Successfully!!!"+RESET);
		} else {
			System.err.println("Test Failed!!!");
		}
	}
	
	@AfterTest
	public static void tearDown() {
		driver.quit();
	}

}
