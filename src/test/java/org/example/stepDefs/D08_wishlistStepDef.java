package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D08_wishlistStepDef {

    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();

    @When("user click add to wishList icon")
    public void clickWishListBtn() throws InterruptedException {
        int selectedProduct = home.wishlistIcons().size();
        System.out.println("No. of products in page: " + home.wishlistIcons().size());
        home.wishlistIcons().get(selectedProduct - 2).click();
        System.out.println("selected product:  "+home.wishlistIcons().get(selectedProduct-1).getText());
    Thread.sleep(5000);

    }


    @Then("the green success message is displayed")
    public void theGreenSuccessMessageIsDisplayed() throws InterruptedException {
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("background color: "+home.wishListSuccessMessage().getCssValue("background-color"));
// #4bb07a   rgb 75, 176, 122

        soft.assertEquals(home.wishListSuccessMessage().getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @Then("product added successfully to wishList")
    public void productAddedSuccessfullyToWishList() throws InterruptedException {
        System.out.println("Qty in Home page= " + home.wishlistQtyHome().getText());

        home.wishlistBtn().click();
        System.out.println("wish list btn " + home.wishlistBtn().getText());

        Thread.sleep(5);
        boolean qtyCheck = false;
        System.out.println(  " Qty in wish list page= "+      home.wishlistQtyWish().getAttribute("value"));
        if (Integer.parseInt(home.wishlistQtyWish().getAttribute("value")) > 0)
        {qtyCheck = true;
    } else {
        qtyCheck = false;
    }
//        if (Integer.parseInt(home.wishlistQtyHome().getAttribute("value")) > 0) {
//            Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
        soft.assertTrue(qtyCheck);
        soft.assertAll();
    }
}
