package EcommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Scenario02Positive extends EcommerceBaseClass{
    @Test
    public void scenario02() throws MalformedURLException, InterruptedException {
        /*
        Scenario02:
        app installed and opened
        select the country in my case "France"
        provide a name
        hide keyboard
        select gender
        click on lets shop button
        validate user on products page
         */
        //app insatlled and opened
        AndroidDriver driver = androidDriver();

        WebElement countriesMenu = driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
        countriesMenu.click();
        //we store countries inside the list
        List<WebElement> countries = driver.findElementsByClassName("android.widget.TextView");
        //we can see how many countries on UI
       // System.out.println("Country number: "+countries.size());
        //if the country which is provided by user is not on UI so scroll and find the country until it is visible
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"France\"))");
        //click the country
        WebElement country = driver.findElementByXPath("//*[@text='France']");
        country.click();

        //provide a name
        WebElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");
        nameBox.sendKeys("Anne");

        //hide keyboard
        driver.hideKeyboard();
       //select gender
        MobileElement gender = (MobileElement) driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        gender.click();
       //click shop now bittun
        WebElement shopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        shopButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement pageTitle = driver.findElementById("com.androidsample.generalstore:id/toolbar_title");
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
       //validate user is on products page
        Assert.assertTrue(pageTitle.isDisplayed());


    }
}
