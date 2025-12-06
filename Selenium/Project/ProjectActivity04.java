/*Logging into the site
Goal: Open the site and login with the credentials provided
a. Open the browser
b. Navigate to ‘ https://alchemy.hguy.co/crm ’.
c. Find and select the username and password fields
d. Enter login credentials into the respective fields
e. Click login
f. Verify that the homepage has opened.
g. Close the browser.*/

package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity04 extends Fixture{
	
	@Test(priority = 4)
	public void loginCRM() {
		
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginButton = driver.findElement(By.name("Login"));
		
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
		
		String home = driver.getCurrentUrl();
		Assert.assertTrue(home.contains("Home"));
		System.out.println("Home page has opened!");
		
	}

}