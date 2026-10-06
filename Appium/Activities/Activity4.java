package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity4 {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity(
                "com.android.contacts.activities.PeopleActivity"
        );

        options.noReset();

        URL serverURL =
                new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    @Test
    public void contactsTest() {

        /*
         * Check whether Create Contact form
         * is already open from a previous run.
         */
        List<WebElement> firstNameFields =
                driver.findElements(
                        AppiumBy.xpath(
                                "//android.widget.EditText[@text='First name']"
                        )
                );

        /*
         * If Create Contact is NOT already open,
         * click the + button.
         */
        if (firstNameFields.isEmpty()) {

            List<WebElement> createButtons =
                    driver.findElements(
                            AppiumBy.accessibilityId(
                                    "Create contact"
                            )
                    );

            if (createButtons.isEmpty()) {

                createButtons =
                        driver.findElements(
                                AppiumBy.id(
                                        "com.google.android.contacts:id/floating_action_button"
                                )
                        );
            }

            if (!createButtons.isEmpty()) {

                createButtons.get(0).click();

            } else {

                throw new RuntimeException(
                        "Create Contact button was not found."
                );
            }
        }


        /*
         * Wait for First Name
         */
        WebElement firstName =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath(
                                        "//android.widget.EditText[@text='First name']"
                                )
                        )
                );

        firstName.clear();
        firstName.sendKeys("Aaditya");


        /*
         * Last Name
         */
        WebElement lastName =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath(
                                        "//android.widget.EditText[@text='Last name']"
                                )
                        )
                );

        lastName.clear();
        lastName.sendKeys("Varma");


        /*
         * Phone
         *
         * Verified from your actual window.xml:
         *
         * class = android.widget.EditText
         * text  = Mobile
         */
        WebElement phone =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath(
                                        "//android.widget.EditText[@text='Mobile']"
                                )
                        )
                );

        phone.clear();
        phone.sendKeys("999148292");


        /*
         * Save
         *
         * Your emulator visibly shows the Save button,
         * so locate it using its displayed text.
         */
        WebElement saveButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//*[@text='Save']"
                                )
                        )
                );

        saveButton.click();


        /*
         * Wait until Aaditya Varma appears
         */
        WebElement savedContact =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath(
                                        "//*[@text='Aaditya Varma']"
                                )
                        )
                );


        String contactName =
                savedContact.getText();


        System.out.println(
                "Contact Name: " + contactName
        );


        Assert.assertEquals(
                contactName,
                "Aaditya Varma"
        );
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}