package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumInspector02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
      /*
//    lunch GestureTool app
//    click addGesture button
//    send text to name box "testing"
//    click done
//    verify testing gesture is created
//     */
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "R9YT60GPN7R");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\Documents\\Tools\\Appium\\Apps\\GestureTool.apk");

//        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
//        Thread.sleep(3000);
//        String actualText =  driver.findElementById("android:id/title").getText();
//        String expectedText = "Create a gesture";
//
//        Assert.assertEquals(actualText,expectedText);
//        Thread.sleep(3000);
//        driver.findElementByXPath("(//android.widget.Button)[2]").click();
//
//        System.out.println("test passed");


    }
}
