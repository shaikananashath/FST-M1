package examples;

import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity(
                "com.google.android.apps.chrome.Main"
        );
        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

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
                "https://training-support.net/webelements/sliders"
        );
    }


    @Test(priority = 1)
    public void volume75Test() {

        WebElement slider =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath(
                                        "//android.widget.SeekBar"
                                )
                        )
                );

        int sliderX =
                slider.getLocation().getX();

        int sliderY =
                slider.getLocation().getY();

        int sliderWidth =
                slider.getSize().getWidth();

        int sliderHeight =
                slider.getSize().getHeight();

        int centerY =
                sliderY + (sliderHeight / 2);


        // Start from 50%
        int startX =
                sliderX +
                        (int) (sliderWidth * 0.50);


        // CALIBRATED TARGET FOR 75%
        int endX =
                sliderX +
                        (int) (sliderWidth * 0.74);


        Point start =
                new Point(
                        startX,
                        centerY
                );

        Point end =
                new Point(
                        endX,
                        centerY
                );


        new ActionsBase().doSwipe(
                driver,
                1000,
                start,
                end
        );


        String volumeText =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text,'%')]"
                        )
                ).getText();


        System.out.println(
                "Volume after first swipe: "
                        + volumeText
        );


        assertTrue(
                volumeText.contains("75%"),
                "Expected 75% but found: "
                        + volumeText
        );
    }


    @Test(priority = 2)
    public void volume25Test() {

        WebElement slider =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath(
                                        "//android.widget.SeekBar"
                                )
                        )
                );

        int sliderX =
                slider.getLocation().getX();

        int sliderY =
                slider.getLocation().getY();

        int sliderWidth =
                slider.getSize().getWidth();

        int sliderHeight =
                slider.getSize().getHeight();

        int centerY =
                sliderY + (sliderHeight / 2);


        // Start from calibrated 75% position
        int startX =
                sliderX +
                        (int) (sliderWidth * 0.74);


        // CALIBRATED TARGET FOR 25%
        int endX =
                sliderX +
                        (int) (sliderWidth * 0.27);


        Point start =
                new Point(
                        startX,
                        centerY
                );

        Point end =
                new Point(
                        endX,
                        centerY
                );


        new ActionsBase().doSwipe(
                driver,
                1000,
                start,
                end
        );


        String volumeText =
                driver.findElement(
                        AppiumBy.xpath(
                                "//android.view.View/android.widget.TextView[contains(@text,'%')]"
                        )
                ).getText();


        System.out.println(
                "Volume after second swipe: "
                        + volumeText
        );


        assertTrue(
                volumeText.contains("25%"),
                "Expected 25% but found: "
                        + volumeText
        );
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}