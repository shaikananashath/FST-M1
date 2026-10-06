import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/tabs");

        System.out.println("Page title: " + driver.getTitle());

        String parentTab = driver.getWindowHandle();

        System.out.println("Current tab: " + parentTab);

        driver.findElement(
                By.xpath("//button[text()='Open A New Tab']")
        ).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();

        System.out.println("Currently open windows: " + windows);

        String secondTab = "";

        for (String handle : windows) {
            if (!handle.equals(parentTab)) {
                secondTab = handle;
                driver.switchTo().window(handle);
                break;
            }
        }

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(), 'Another One')]")
                )
        );

        System.out.println("Current tab: " + driver.getWindowHandle());

        System.out.println("New Page title: " + driver.getTitle());

        System.out.println(
                "New Page message: " +
                driver.findElement(By.cssSelector("h2.mt-5")).getText()
        );

        driver.findElement(
                By.xpath("//button[contains(text(), 'Another One')]")
        ).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        windows = driver.getWindowHandles();

        System.out.println("Currently open windows: " + windows);

        for (String handle : windows) {
            if (!handle.equals(parentTab) && !handle.equals(secondTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        System.out.println("Third tab: " + driver.getWindowHandle());

        System.out.println("Third Page title: " + driver.getTitle());

        driver.quit();
    }
}