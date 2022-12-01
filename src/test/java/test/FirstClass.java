package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class FirstClass {
    @Test
    public void test() throws MalformedURLException {
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



    }
}
