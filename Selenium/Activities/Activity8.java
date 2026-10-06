import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title is: " + driver.getTitle());

        WebElement checkbox =
                driver.findElement(By.id("checkbox"));

        System.out.println(
                "Checkbox is visible? " + checkbox.isDisplayed()
        );

        driver.findElement(
                By.xpath("//button[text()='Toggle Checkbox']")
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOf(checkbox)
        );

        System.out.println("Checkbox is visible? false");

        driver.findElement(
                By.xpath("//button[text()='Toggle Checkbox']")
        ).click();

        WebElement newCheckbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("checkbox")
                )
        );

        newCheckbox.click();

        System.out.println(
                "Checkbox is selected? " + newCheckbox.isSelected()
        );

        driver.quit();
    }
}