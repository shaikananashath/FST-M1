package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/alerts");
        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("confirmation")).click();
        Alert confirmalert = driver.switchTo().alert();
        String alerttext = confirmalert.getText();
        System.out.println("Text in alert:" + alerttext);
        confirmalert.accept();
        driver.switchTo().defaultContent();
        
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();

	}

}