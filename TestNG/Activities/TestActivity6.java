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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestActivity6 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test
	@Parameters({"username", "password"})
	public void loginTest(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-center"))).getText();		

		Assert.assertEquals("Welcome Back, Admin!", message);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
