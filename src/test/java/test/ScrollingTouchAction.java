package test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.awt.geom.PathIterator;
import java.net.MalformedURLException;
import java.time.Duration;

public class ScrollingTouchAction extends BaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //i will get my device screen size with Dimension class from selenium
        //this code will get size of my device
        Thread.sleep(3000);

        Dimension dimension = driver.manage().window().getSize();

        int start_x = (int) (dimension.height * 0.5);
        int start_y = (int) (dimension.width * 0.8);

        int end_x = (int) (dimension.height * 0.5);
        int end_y = (int) (dimension.width * 0.2);

        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(PointOption.point(start_x,start_y)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(end_x,end_y)).release().perform();

        Thread.sleep(3000);


        int start_x1 = (int) (dimension.height * 0.5);
        int start_y1 = (int) (dimension.width * 0.4);

        int end_x1 = (int) (dimension.height * 0.5);
        int end_y1 = (int) (dimension.width * 0.8);

        TouchAction touchAction1 = new TouchAction(driver);

        touchAction.press(PointOption.point(start_x1,start_y1)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(end_x1,end_y1)).release().perform();

        Thread.sleep(3000);
    }
}
