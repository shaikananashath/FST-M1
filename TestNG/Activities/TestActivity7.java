package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@DataProvider(name = "InvalidCreds")
	public static Object[][] credentials(){
		return new Object[][] {
			{"admin", "wrongPass"},
			{"wrongAdmin", "password"},
			{"@#$%#@", "DELETE TABLE users;"}
		};
	}
	
	@Test(dataProvider = "InvalidCreds")
	public void loginTest(String userName, String password) {
		WebElement userField = driver.findElement(By.id("username"));
		WebElement passField = driver.findElement(By.id("password"));
		userField.clear();
		passField.clear();
		userField.sendKeys(userName);
		passField.sendKeys(password);
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();		

		Assert.assertEquals(message, "Invalid credentials");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	

}