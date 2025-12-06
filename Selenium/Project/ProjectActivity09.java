/*Traversing tables 2
Goal: Open the leads page and print the usernames and full names from the table.
a. Open the browser to the Alchemy CRM site and login.
b. Navigate to the Sales -> Leads.
c. Find the table on the page and print the first 10 values in the Name column and the User column of the table to the console.
d. Close the browser.*/

package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity09 extends Fixture{
	
	@Test(priority = 9)
	public void tableLeads() {
		
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
		
		WebElement Leads = driver.findElement(By.id("moduleTab_9_Leads"));
		Leads.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));
    	
		for(int i = 1; i <= 10; i++) {
			System.out.println("Row No: " + i);
			WebElement name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]"));
			WebElement username = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[8]"));
			System.out.println("Name is: " + name.getText());
			System.out.println("UserName is: " + username.getText());
			
		}
	}

}