package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class ChromeTestingUsingRemoteDevice {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        //below code is going to invoke app on your device (provide absolute path here)
      //  desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/GestureTool.apk");
        //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("appPackage","com.android.chrome");
        desiredCapabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        // desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        desiredCapabilities.setCapability("chromedriverExecutable","/Users/ayyildiz/IdeaProjects/appiumEnglish/chromeDriver/chromedriver");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.get("https://www.facebook.com");
//getContext() is giving us app view I mean are in which view native or web view?
        System.out.println(driver.getContext());
//we can see all app type with codes below
        //we put all views in Set
        Set contextNames = driver.getContextHandles();
        //with foreach we see each one one by one
        for (Object contextName : contextNames) {
            System.out.println(contextName);
            Thread.sleep(5000);
            //select which view you want to proceed
            if (contextName.toString().contains("WEBVIEW")){
                driver.context((String) contextName);
                Thread.sleep(5000);
            }
        }
        System.out.println(driver.getContext());

//https://developer.chrome.com/docs/devtools/remote-debugging/
        // you can do your configuration for remote device with above link
        driver.findElementByXPath("//input[@name='email']").sendKeys("Ali");
        driver.findElementByXPath("//input[@name='pass']").sendKeys("Veli");
        driver.findElementByXPath("//button[@name='login']").click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementByXPath("//div[@class='_52je']").isDisplayed());

        Thread.sleep(3000);
        //close session
        driver.quit();

    }
}
