package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/selects");
        System.out.println("Page title is: " + driver.getTitle());

        WebElement select1 = driver.findElement(By.cssSelector("select.h-80"));
        Select multiselect = new Select(select1);
        
        multiselect.selectByVisibleText("HTML");
        for(int i =3 ;i<=5;i++) {
        	multiselect.selectByIndex(i);
        }
        multiselect.selectByValue("nodejs");
        List<WebElement> selectedoptions = multiselect.getAllSelectedOptions();
        System.out.println("Selected options are :");
        for(WebElement option :selectedoptions) {
        	System.out.println(option.getText());
        }
        
        multiselect.deselectByIndex(4);
        selectedoptions = multiselect.getAllSelectedOptions();
        System.out.println("Options are :");
        for(WebElement option : selectedoptions) {
        	System.out.println(option.getText());
        }
        
        driver.quit();

	}

}