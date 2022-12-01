package test;
;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Set;

public class SafariTest extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        IOSDriver driver = iosDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext());
        driver.findElementById("nav-logobar-greeting").click();

        Thread.sleep(3000);

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
        Assert.assertTrue(driver.findElementByXPath("//div[@id='outer-accordion-signin-signup-page']/h2").isDisplayed());
        System.out.println(driver.getContext());
    }
}
