/*Traversing tables
Goal: Open the accounts page and print the contents of the table.
a. Open the browser to the Alchemy CRM site and login.
b. Navigate to the Sales -> Accounts page.
c. Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
d. Close the browser.*/

package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity08 extends Fixture{
	
	@Test(priority = 8)
	public void tableAccountContent() {
		
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
		
		WebElement Accounts = driver.findElement(By.id("moduleTab_9_Accounts"));
		Accounts.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));
    	
		for(int i = 0; i < 10; i++) {
			i = i + 1;
			System.out.println("Row No: " + i);
			WebElement name= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td[3]"));
			System.out.println("Name is: " + name.getText());
			
		}
		
	}

}