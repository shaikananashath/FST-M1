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

        System.out.println("Page title: " + driver.getTitle());

        WebElement selectElement =
                driver.findElement(By.cssSelector("select.h-80"));

        Select multiSelect = new Select(selectElement);

        multiSelect.selectByVisibleText("HTML");

        for (int i = 3; i <= 5; i++) {
            multiSelect.selectByIndex(i);
        }

        multiSelect.selectByValue("nodejs");

        List<WebElement> selectedOptions =
                multiSelect.getAllSelectedOptions();

        System.out.println("Selected options are:");

        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        multiSelect.deselectByIndex(4);

        selectedOptions = multiSelect.getAllSelectedOptions();

        System.out.println("Selected options after deselecting:");

        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}