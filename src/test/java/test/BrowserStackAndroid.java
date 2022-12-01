package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackAndroid {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz1");
        caps.setCapability("browserstack.key", "yUfM2vRqAPF97nopgPYE");

        // Set URL of the application under test
        caps.setCapability("app", "bs://edec207dcc6495b81a85189a14413d5c4abb86ad");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S10");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);


        /* Write your Custom code here */
        driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        driver.findElementById("android:id/checkbox").click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();

        driver.findElementByClassName("android.widget.EditText").sendKeys("Appium");

        driver.findElementById("android:id/button1").click();


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
