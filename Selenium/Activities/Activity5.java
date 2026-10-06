import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title: " + driver.getTitle());

        System.out.println(
            "Checkbox is displayed: " +
            driver.findElement(By.id("checkbox")).isDisplayed()
        );

        driver.findElement(
            By.xpath("//button[text()='Toggle Checkbox']")
        ).click();

        boolean checkboxDisplayed =
            !driver.findElements(By.id("checkbox")).isEmpty()
            && driver.findElement(By.id("checkbox")).isDisplayed();

        System.out.println("Checkbox is displayed: " + checkboxDisplayed);

        driver.quit();
    }
}