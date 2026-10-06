package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class Activity3 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    @BeforeMethod
    public void clearCalculator() {

        // Relaunch Calculator before every calculation
        driver.activateApp("com.google.android.calculator");

        try {
            driver.findElement(
                    AppiumBy.id(
                            "com.google.android.calculator:id/clr"
                    )
            ).click();
        } catch (Exception ignored) {
            // Calculator is already clear
        }
    }

    @Test(priority = 1)
    public void additionTest() {

        click("digit_5");
        click("op_add");
        click("digit_9");
        click("eq");

        String result = getResult();

        System.out.println("5 + 9 = " + result);

        Assert.assertEquals(result, "14");
    }

    @Test(priority = 2)
    public void subtractTest() {

        click("digit_1");
        click("digit_0");
        click("op_sub");
        click("digit_5");
        click("eq");

        String result = getResult();

        System.out.println("10 - 5 = " + result);

        Assert.assertEquals(result, "5");
    }

    @Test(priority = 3)
    public void multiplyTest() {

        click("digit_5");
        click("op_mul");
        click("digit_1");
        click("digit_0");
        click("digit_0");
        click("eq");

        String result = getResult();

        System.out.println("5 x 100 = " + result);

        Assert.assertEquals(result, "500");
    }

    @Test(priority = 4)
    public void divideTest() {

        click("digit_5");
        click("digit_0");
        click("op_div");
        click("digit_2");
        click("eq");

        String result = getResult();

        System.out.println("50 / 2 = " + result);

        Assert.assertEquals(result, "25");
    }

    private void click(String id) {

        driver.findElement(
                AppiumBy.id(
                        "com.google.android.calculator:id/" + id
                )
        ).click();
    }

    private String getResult() {

        return driver.findElement(
                AppiumBy.id(
                        "com.google.android.calculator:id/result_final"
                )
        ).getText();
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}