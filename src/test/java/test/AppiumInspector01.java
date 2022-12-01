package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumInspector01 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");
        //below code is going to invoke app on your device (provide absolute path here)
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/GestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
  /*
        lunch GestureTool app
        click addGesture button
        verify title "Create a gesture"
        click Discard button
         */

        //driver.findElementByXPath("(//android.widget.Button)[1]").click();
        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(3000);
        String actualText =  driver.findElementById("android:id/title").getText();
        String expectedText = "Create a gesture";

        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(3000);
        driver.findElementByXPath("(//android.widget.Button)[2]").click();

        System.out.println("test passed");



    }
}
