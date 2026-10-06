package examples;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage(
                "com.android.chrome"
        );

        options.setAppActivity(
                "com.google.android.apps.chrome.Main"
        );

        options.noReset();

        URL serverURL =
                new URI(
                        "http://127.0.0.1:4723"
                ).toURL();

        driver =
                new AndroidDriver(
                        serverURL,
                        options
                );

        wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );

        driver.get(
                "https://training-support.net/webelements/lazy-loading"
        );
    }


    @Test
    public void uiScrollableTest() {

        // Wait for initial images
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className(
                                "android.widget.Image"
                        )
                )
        );

        // Count images before scrolling
        List<WebElement> images =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.Image"
                        )
                );

        System.out.println(
                "Before scroll: "
                        + images.size()
        );


        // Get the main scrollable Chrome page
        WebElement scrollablePage =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().scrollable(true)"
                                )
                        )
                );


        /*
         * Scroll forward several times.
         * Lazy-loaded content should load as
         * the page moves downward.
         */
        for (int i = 0; i < 5; i++) {

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable("
                                    + "new UiSelector().scrollable(true)"
                                    + ".instance(0))"
                                    + ".scrollForward(55)"
                    )
            );

            // Stop scrolling as soon as 3 images exist
            images =
                    driver.findElements(
                            AppiumBy.className(
                                    "android.widget.Image"
                            )
                    );

            if (images.size() >= 3) {
                break;
            }
        }


        // Wait until lazy-loaded third image appears
        wait.until(
                driver -> driver.findElements(
                        AppiumBy.className(
                                "android.widget.Image"
                        )
                ).size() >= 3
        );


        // Count images after scrolling
        images =
                driver.findElements(
                        AppiumBy.className(
                                "android.widget.Image"
                        )
                );


        System.out.println(
                "After scroll: "
                        + images.size()
        );


        // Verify lazy-loaded image appeared
        Assert.assertEquals(
                images.size(),
                3,
                "Expected 3 images after scrolling"
        );
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}