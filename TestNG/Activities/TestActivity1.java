package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://training-support.net");
	}
	
	@Test(priority = 1)
	public void homePageTest() {
		Assert.assertEquals(driver.getTitle(), "Training Support");
	}
	
	
	@Test (priority = 2)
	public void aboutPageTest() {
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}