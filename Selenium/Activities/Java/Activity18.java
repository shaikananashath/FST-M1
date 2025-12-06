package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("simple")).click();
        Alert simplealert = driver.switchTo().alert();
        System.out.println(simplealert.getText());
        simplealert.accept();
        
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();

	}

}