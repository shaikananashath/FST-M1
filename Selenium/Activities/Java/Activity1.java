package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/");
		System.out.println("Page title is :" + driver.getTitle());

		driver.findElement(By.linkText("About Us")).click(); //first element that match the locator/unique element
		System.out.println("New page title is :" + driver.getTitle());

		driver.quit(); 

	}

}