package test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackIOS {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "mehmetayyildiz1");
        caps.setCapability("browserstack.key", "yUfM2vRqAPF97nopgPYE");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c26aeb2574790c73d2e356675a7428d1f5a55168");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        /* Write your Custom code here */
       driver.findElementByAccessibilityId("Text Button").click();

       driver.findElementByAccessibilityId("Text Input").sendKeys("Appium Cloud Test");

       driver.findElementByAccessibilityId("Return").click();

       Assert.assertEquals(driver.findElementByAccessibilityId("Text Output").getText(),"Appium Cloud Test");


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();




    }
}
