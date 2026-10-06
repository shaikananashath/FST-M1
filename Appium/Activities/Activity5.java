package examples;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage(
                "com.google.android.apps.messaging"
        );

        options.setAppActivity(
                ".ui.ConversationListActivity"
        );

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(
                serverURL,
                options
        );

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    @Test
    public void smsTest() {

        // Click Start Chat
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id(
                                "com.google.android.apps.messaging:id/start_chat_fab"
                        )
                )
        ).click();


        // Find recipient area
        WebElement recipientArea =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                AppiumBy.xpath(
                                        "//*[@text='Type name, phone number, or email']"
                                )
                        )
                );

        // Click recipient area
        recipientArea.click();


        // Enter recipient number into focused element
        driver.switchTo()
                .activeElement()
                .sendKeys("18282832912");


        // Press Enter
        driver.pressKey(
                new KeyEvent(
                        AndroidKey.ENTER
                )
        );


        // Wait for message field
        WebElement messageBox =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.id(
                                        "com.google.android.apps.messaging:id/compose_message_text"
                                )
                        )
                );


        // Enter message
        messageBox.sendKeys(
                "Hello from Appium"
        );


        // Click Send
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//*[contains(@content-desc,'Send')]"
                        )
                )
        ).click();


        // Wait for sent message
        WebElement sentMessage =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath(
                                        "//*[@text='Hello from Appium']"
                                )
                        )
                );


        // Read sent message
        String messageTextSent =
                sentMessage.getText();


        // Print result
        System.out.println(
                "Message Sent: " + messageTextSent
        );


        // Verify message
        Assert.assertEquals(
                messageTextSent,
                "Hello from Appium"
        );
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}