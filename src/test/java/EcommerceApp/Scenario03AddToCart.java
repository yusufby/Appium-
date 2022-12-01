package EcommerceApp;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Scenario03AddToCart extends EcommerceBaseClass {
    @Test
    public void scenario03() throws MalformedURLException, InterruptedException {
        /*
        as a user make shop for specific item in the app and add to cart
        if the item is not on ui(dom) so scroll to until the product and add to cart
        then verify selected item on the cart
        in 15 min
         */
        AndroidDriver<WebElement> driver =  androidDriver();

        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Azerbaijan\"))");

        driver.findElementByXPath("//android.widget.TextView[@text='Azerbaijan']").click();

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("John");

        driver.hideKeyboard();

        driver.findElementById("com.androidsample.generalstore:id/radioMale").click();

        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        //we are on second page (products)

      //  driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(text(\"Jordan 6 Rings\"))");

        List<WebElement> listOfNames = driver.findElementsById("com.androidsample.generalstore:id/productName");
        System.out.println(listOfNames.size());

        for (int i = 0; i < listOfNames.size(); i++) {
            String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (name.equals("Jordan 6 Rings")){
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
        }

        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
       Thread.sleep(3000);
       String itemInCart = driver.findElementByXPath("//android.widget.TextView[@text='Jordan 6 Rings']").getText();

        Assert.assertEquals(itemInCart,"Jordan 6 Rings");
        System.out.println(itemInCart);


    }
}
