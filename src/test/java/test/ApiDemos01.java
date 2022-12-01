package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ApiDemos01 extends BaseClass {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
         AndroidDriver driver = androidDriver();
//permission automation
         driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        Thread.sleep(3000);
         driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
         driver.findElementById("com.touchboarder.android.api.demos:id/buttonDefaultPositive").click();

         Thread.sleep(3000);
         driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
         driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);
         driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        Thread.sleep(3000);
         driver.findElementById("android:id/checkbox").click();

         driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        Thread.sleep(3000);
         driver.findElementByClassName("android.widget.EditText").sendKeys("Appium");
        Thread.sleep(3000);
         driver.findElementById("android:id/button1").click();
        Thread.sleep(3000);
        driver.quit();









    }
}
