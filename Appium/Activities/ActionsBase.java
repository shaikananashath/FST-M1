package examples;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {

    private final PointerInput finger =
            new PointerInput(
                    PointerInput.Kind.TOUCH,
                    "finger"
            );

    public void doSwipe(
            AppiumDriver driver,
            int duration,
            Point start,
            Point end) {

        Sequence swipe =
                new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        ofMillis(0),
                        viewport(),
                        start.getX(),
                        start.getY()
                )
        );

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        swipe.addAction(
                finger.createPointerMove(
                        ofMillis(duration),
                        viewport(),
                        end.getX(),
                        end.getY()
                )
        );

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Arrays.asList(swipe)
        );
    }
}