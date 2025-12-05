package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivity9 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Opened Browser |");
	}
	
	@BeforeMethod
	public void beforeMethod() {
        driver.switchTo().defaultContent();
    }
	
	@Test (priority = 1)
	public void simpleAlertTest() {
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert opened |");
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		Assert.assertEquals("You've just triggered a simple alert!", alertText);
		simpleAlert.accept();
		Reporter.log("Alert closed");
	}
	
	@Test (priority = 2)
	public void confirmAlertTest() {
		driver.findElement(By.id("confirmation")).click();
        Alert confirmAlert = driver.switchTo().alert();
        String alertText = confirmAlert.getText();
        Assert.assertEquals("You've just triggered a confirmation alert!", alertText);
 
        confirmAlert.accept();
        Reporter.log("Alert closed");
	}
	
	@Test (priority = 3)
	public void promptAlertTest() {
		driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
        // Type some text into the prompt
        promptAlert.sendKeys("Awesome!");
        promptAlert.accept();
        Reporter.log("Alert closed");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}