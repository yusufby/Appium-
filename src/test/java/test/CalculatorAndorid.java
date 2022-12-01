package test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorAndorid {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");
        //below code is going to invoke app on your device (provide absolute path here)
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/ayyildiz/IdeaProjects/appiumEnglish/Apps/Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

       /* appPackage           appActiviy
       TEST CASe
       lunch app
       locate all elements
       make any mathematical operation(+,-,/,*)
       check pre-result
       verify result
        */



        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement equal = driver.findElementByAccessibilityId("equals");

        num2.click();
        num5.click();
        plus.click();
        num3.click();
        num8.click();
        Thread.sleep(3000);
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        String expectedResult = preResult.getText();
        System.out.println("EX "+expectedResult );
        equal.click();
        Thread.sleep(3000);
        MobileElement finalResult = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = finalResult.getText();
        System.out.println("AC "+actualResult);
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult);

    }
}
