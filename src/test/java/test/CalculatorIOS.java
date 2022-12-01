package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CalculatorIOS extends BaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        IOSDriver driver = iosDriver();

        MobileElement num0 = (MobileElement) driver.findElementByAccessibilityId("0");
        MobileElement num1 = (MobileElement) driver.findElementByAccessibilityId("1");
        MobileElement num2 = (MobileElement) driver.findElementByAccessibilityId("2");
        MobileElement num3 = (MobileElement) driver.findElementByAccessibilityId("3");
        MobileElement num4 = (MobileElement) driver.findElementByAccessibilityId("4");
        MobileElement num5 = (MobileElement) driver.findElementByAccessibilityId("5");
        MobileElement num6 = (MobileElement) driver.findElementByAccessibilityId("6");
        MobileElement num7 = (MobileElement) driver.findElementByAccessibilityId("7");
        MobileElement num8 = (MobileElement) driver.findElementByAccessibilityId("8");
        MobileElement num9 = (MobileElement) driver.findElementByAccessibilityId("9");

        MobileElement min = (MobileElement) driver.findElementByAccessibilityId("-");
        MobileElement equal = (MobileElement) driver.findElementByAccessibilityId("=");

        num4.click();
        num5.click();
        min.click();
        num2.click();
        num3.click();

        String expectedResult = driver.findElementByClassName("XCUIElementTypeStaticText").getText();
        Thread.sleep(3000);
        equal.click();
        Thread.sleep(2000);
       String actualResult = driver.findElementByClassName("XCUIElementTypeTextView").getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualResult,expectedResult);





    }

}
