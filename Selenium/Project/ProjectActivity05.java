/*Getting colors
Goal: Get the color of the navigation menu
a. Open a browser.
b. Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided.
c. Get the color of the navigation menu and print it to the console.
d. Close the browser.*/

package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProjectActivity05 extends Fixture{
	
	@Test(priority = 5)
	public void getNavMenuColor() {
		
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='username_password']"));
		WebElement loginButton = driver.findElement(By.name("Login"));
		
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
		
		WebElement navigationmenu = driver.findElement(By.xpath("//*[@class='desktop-toolbar']"));
		String navigationColor = navigationmenu.getCssValue("color");
		System.out.println("The Navigation menu colour is: " + navigationColor);
	}

}