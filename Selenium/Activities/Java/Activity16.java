package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/selects");
        System.out.println("Page title is: " + driver.getTitle());

        WebElement select1 = driver.findElement(By.cssSelector("select.h-10"));
        Select dropdown = new Select(select1);
        
        dropdown.selectByVisibleText("One");
        dropdown.selectByIndex(2);
        dropdown.selectByValue("three");
        for(WebElement option : dropdown.getOptions()) {
        	System.out.println(option.getText());
        }
        
        driver.quit();
	}

}