package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity2 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Chrome package and activity
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        options.noReset();

        // Appium server address
        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        // Initialize Android Driver
        driver = new AndroidDriver(serverURL, options);

        // Open Training Support website
        driver.get("https://training-support.net");
    }

    @Test
    public void chromeTest() {

        // Find Training Support heading
        String pageHeading = driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@text='Training Support']"
                )
        ).getText();

        // Print heading
        System.out.println("Heading: " + pageHeading);

        // Click About Us
        driver.findElement(
                AppiumBy.accessibilityId("About Us")
        ).click();

        // Find About Us heading
        String aboutPageHeading = driver.findElement(
                AppiumBy.xpath(
                        "//android.widget.TextView[@text='About Us']"
                )
        ).getText();

        // Print About Us heading
        System.out.println(
                "About Page Heading: " + aboutPageHeading
        );
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}