package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Calculator package and activity
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        // Keep existing app data
        options.noReset();

        // Appium Server
        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        // Start Android Driver
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiplyTest() {

        // Click 5
        driver.findElement(
                AppiumBy.accessibilityId("5")
        ).click();

        // Click multiply
        driver.findElement(
                AppiumBy.accessibilityId("multiply")
        ).click();

        // Click 8
        driver.findElement(
                AppiumBy.accessibilityId("8")
        ).click();

        // Click equals
        driver.findElement(
                AppiumBy.accessibilityId("equals")
        ).click();

        // Get the result
        String result = driver.findElement(
                AppiumBy.id(
                        "com.google.android.calculator:id/result_final"
                )
        ).getText();

        System.out.println("Calculator result: " + result);

        // Validate 5 × 8 = 40
        Assert.assertEquals(
                result,
                "40",
                "Multiplication result is incorrect"
        );
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}