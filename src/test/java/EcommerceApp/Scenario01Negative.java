package EcommerceApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Scenario01Negative extends EcommerceBaseClass{
    @Test
    public void scenario01() throws MalformedURLException {
        /*
        Scenario01:(Negative)
        user will leave blank name field and can not successfully shop on application
        and see error message "Please enter your name"
         */
        AndroidDriver driver = androidDriver();

        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        List<AndroidElement> countries = driver.findElementsByClassName("android.widget.TextView");
        System.out.println("Country number: "+countries.size());

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))");

        driver.findElementByXPath("//*[@text='France']").click();

        //not provide a name

        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        String toastMessage = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
        String expectedErrorMessage = "Please enter your name";

        Assert.assertEquals(toastMessage,expectedErrorMessage);

        System.out.println(toastMessage);


    }
}
