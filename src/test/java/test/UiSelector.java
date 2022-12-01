package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UiSelector {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //we can write desired capabilities in different ways as below
        //https://appium.io/docs/en/writing-running-appium/caps/
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");
        //below code is going to invoke app on your device (provide absolute path here)
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/GestureTool.apk");
        //if your session is not created normally appium will suggest you troubleshooting link you can set below capabilities then it will work
        //https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md

//        desiredCapabilities.setCapability("appPackage","com.davemac327.gesture.tool");
//        desiredCapabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        /*
        What is UiSelector()?
        it is part of Android SDK. When we write findElement() eith any command in apppium it is going directly to Android SDK
        and execute android command which we send from mobile. Appium annd selenium jars faile are top of Android SDK
        internally they use andorid file only. (UiSelecter work with only android.)
        if you could not findElement you can also use UiSelector it will reach element directly.
         */

        //UiSelector() with resourceId
       // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        //className
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();
        //className with index
      //  driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(2)").click();
        //lets click 3rd button using loop(list)
     //   List<MobileElement> buttons = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
//        Thread.sleep(3000);
//        for (MobileElement button :buttons) {
//            if (button.getText().equals("Add gesture")){
//                button.click();
//                break;
//            }
//        }

        Thread.sleep(3000);
        //we cn find with the text
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();
       // Thread.sleep(3000);

        //click with contains
       // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"dd\")").click();

        //click with startTextWith()
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")").click();
        /**
         * you can get all in from below link
         * https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
         */

        //UiSelector help us to check the function of elements

       // driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)").getAttribute("checkable");
       // System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)").getAttribute("checkable"));

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").getAttribute("checkable"));
    }
}
