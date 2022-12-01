package test;

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
        DesiredCapabilities desiredCapabilities =  new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"1fd655780409");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(3000);

        WebElement addButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addButton.click();
        Thread.sleep(2000);
        WebElement nameBox = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        nameBox.sendKeys("testing1");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();

        WebElement doneButton = driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();
        String actualText = driver.findElementByXPath("//android.widget.TextView[@text='testing']").getText();

        Assert.assertEquals(actualText,"testing1");

        Thread.sleep(3000);
        //close session
        driver.quit();


    }
}
