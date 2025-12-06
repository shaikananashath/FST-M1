/*Menu checking
Goal: Make sure that the “Activities” menu item exists and is clickable
a. Open a browser.
b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided.
c. Locate the navigation menu.
d. Ensure that the “Activities” menu item exists.
e. Close the browser*/

package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity06 extends Fixture{
	
	@Test(priority = 6)
	public void checkActivitiesMenu() {
		
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginButton = driver.findElement(By.name("Login"));
		
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']")));
		List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li/span/a"));

        boolean foundActivities = false;
        for (WebElement item : menuItems) {
            String text = item.getText().trim();
            System.out.println("- " + text);
            if (text.equals("ACTIVITIES")) {
                foundActivities = true;
                
            Assert.assertTrue(item.isDisplayed() && item.isEnabled(), "'Activities' menu is not clickable");
            System.out.println("'Activities' menu item is clickable.");
            }
        }

        Assert.assertTrue(foundActivities, "'Activities' menu item is NOT present!");
        System.out.println("'Activities' menu item exists in the navigation menu.");
        
	}

}