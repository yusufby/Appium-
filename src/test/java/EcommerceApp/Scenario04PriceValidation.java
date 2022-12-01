package EcommerceApp;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Scenario04PriceValidation extends EcommerceBaseClass {
    @Test
    public void scenario04() throws MalformedURLException, InterruptedException {
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
        Thread.sleep(2000);

        driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
        Thread.sleep(2000);
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
        //4- Validate the total Amount displayed in the checkout page matches with sum of
        // product amounts selected for shopping

        List<WebElement> listOfPrice = driver.findElementsById("com.androidsample.generalstore:id/productPrice");

        String firstItemPrice =  listOfPrice.get(0).getText();
        System.out.println("First item price = " + firstItemPrice);//$160.97
        String secondItemPrice = listOfPrice.get(1).getText();
        System.out.println("Second item price = "+secondItemPrice);// $165.0
        //we make the value numeric
        firstItemPrice = firstItemPrice.substring(1);//160.97
        secondItemPrice = secondItemPrice.substring(1); //165.0
        System.out.println(firstItemPrice);
        System.out.println(secondItemPrice);
        //parse the string to double
        double price1 = Double.parseDouble(firstItemPrice);
        System.out.println("Now first item price in Double ="+price1);
        double price2 = Double.parseDouble(secondItemPrice);
        System.out.println("2nd price is double also = "+price2);

        String totalAmount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        System.out.println(totalAmount);
        //we need to make it numeric
        totalAmount = totalAmount.substring(1);
        System.out.println(totalAmount);//
        //we need to parse it in double
        double totalAmountDouble = Double.parseDouble(totalAmount);
        System.out.println("actual total amount ="+totalAmountDouble);

        double expectedTotalAmount = price1+price2;
        System.out.println("expected total amount = "+expectedTotalAmount);

        Assert.assertEquals(totalAmountDouble,expectedTotalAmount,0.0);

    }
}
