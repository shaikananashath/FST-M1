/*Verify the website title
Goal: Read the title of the website and verify the text
a. Open a browser.
b. Navigate to ‘ http://alchemy.hguy.co/crm ’.
c. Get the title of the website.
d. Make sure it matches “SuiteCRM” exactly.
e. If it matches, close the browser.*/

package project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectActivity01 extends Fixture{
	
	@Test(priority = 1)
	public void verifyTitle() {
		
		driver.get("http://alchemy.hguy.co/crm");
		String pageTitle = driver.getTitle();
		System.out.println("The title of the page is: " + pageTitle);
		Assert.assertTrue(pageTitle.contains("SuiteCRM"), "Page title doesn't contain 'SuiteCRM'");
	}

}