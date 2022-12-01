package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class ApiDemos02 extends BaseClass{
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        Thread.sleep(3000);
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(3000);
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");
        if(list.size()>0) {
            String unEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)").getAttribute("enabled");

            if (unEnabled.equals("false")) {
                driver.findElementById("android:id/checkbox").click();
            }

        }

        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        Thread.sleep(3000);
        driver.findElementByClassName("android.widget.EditText").sendKeys("Appium");
        Thread.sleep(3000);
        driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.quit();

    }
}
