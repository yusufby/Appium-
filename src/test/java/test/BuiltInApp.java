package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BuiltInApp {
    @Test
    public void test() throws MalformedURLException, InterruptedException {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");

            AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

           driver.findElementByXPath("//android.widget.ImageView[@content-desc='Phone']").click();
           Thread.sleep(2000);

           driver.findElementByAccessibilityId("key pad").click();

           MobileElement num1 = driver.findElementByXPath("//android.widget.TextView[@text='1']");

           MobileElement num0 = driver.findElementByXPath("//android.widget.TextView[@text='0']");

           num1.click();
           num0.click();
           num0.click();

           Thread.sleep(2000);

           driver.findElementByAccessibilityId("dial").click();

           Thread.sleep(2000);

           driver.findElementByAccessibilityId("End call").click();

           Thread.sleep(2000);

           driver.quit();


    }
}
