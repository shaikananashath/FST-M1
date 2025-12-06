/*Get the copyright text
Goal: Print the first copyright text in the footer to the console
a. Open a browser.
b. Navigate to ‘ http://alchemy.hguy.co/crm ’.
c. Get the first copyright text in the footer.
d. Print the text to the console.
e. Close the browser.*/

package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProjectActivity03 extends Fixture{
	
	@Test(priority = 3)
	public void getCopyrightText() {
		
		driver.get("http://alchemy.hguy.co/crm");
		List<WebElement> copyrightElements = driver.findElements(By.xpath("//div[@class = 'p_login_bottom']/a"));
		if(!copyrightElements.isEmpty()) {
			System.out.println("The first copyright text is: " + copyrightElements.get(0).getText());
		}else {
			System.out.println("No copyright text found.");
		}
	}

}