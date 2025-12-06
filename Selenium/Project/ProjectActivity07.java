/*Reading additional information
Goal: Reading a popup that contains additional information about the account/lead.
a. Open the browser to the Alchemy CRM site and login.
b. Navigate to Sales -> Leads
c. In the table, find the Additional information icon at the end of the row of the lead information. Click it.
d. Read the popup and print the phone number displayed in it.
e. Close the browser.*/

package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity07 extends Fixture{
	
	@Test(priority = 7)
	public void readAdditionalInfo() {
		
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginButton = driver.findElement(By.name("Login"));
		
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
		
		WebElement salesMenu = driver.findElement(By.xpath("//a[text()='Sales']"));
		Assert.assertTrue(salesMenu.isDisplayed(), "Sales menu exists.");
		salesMenu.click();
		
		WebElement leadsMenu = driver.findElement(By.id("moduleTab_9_Leads"));
        leadsMenu.click();
		
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[last()]")));
		if(icon.isEnabled()) {
			System.out.println("ICON Exist");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			if(icon.isDisplayed()) {
				System.out.println("ICON is displaying");
			icon.click();
			}else {
				System.out.println("ICON is not displaying");
			}
		}
		
		WebElement mobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		System.out.println("Mobile number is: " + mobileNumber.getText());		
		
	}

}