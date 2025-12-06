/*Get the url of the header image
Goal: Print the url of the header image to the console
a. Open a browser.
b. Navigate to ‘ http://alchemy.hguy.co/crm ’.
c. Get the url of the header image.
d. Print the url to the console.
e. Close the browser.*/

package project;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProjectActivity02 extends Fixture{
	
	@Test(priority = 2)
	public void getImageUrl() {
		
		driver.get("http://alchemy.hguy.co/crm");
		String imageUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src");
		System.out.println("The URL of the header image is: " + imageUrl);
	}

}