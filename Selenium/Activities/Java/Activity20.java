package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("prompt")).click();
        Alert promptalert = driver.switchTo().alert();
        System.out.println(promptalert.getText());
        promptalert.sendKeys("Awesome!");
        promptalert.accept();
        
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();

	}

}