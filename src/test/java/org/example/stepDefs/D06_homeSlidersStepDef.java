package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {

    P03_homePage home = new P03_homePage();
    String firUrl = "urlF";
    String secUrl = "urlS";
SoftAssert soft = new SoftAssert();
    @When("user click on first slider")
    public void userClickOnFirstSlider() {

        home.firstSliderSelect().click();
        System.out.println("slider selected is: " + home.firstSliderSelect().getText());
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        firUrl = home.getUrl();
        System.out.println("first slider url"+home.getUrl());
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() {
        System.out.println("userClickOnSecondSlider");
        home.secondSliderSelect().click();
        home.sliderSelect().click();

        System.out.println("slider selected is: " + home.secondSliderSelect().getText());
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        secUrl = home.getUrl();
        System.out.println( "second slider url"+home.getUrl());

    }

    @Then("user directed to url for first slider")
    public void userDirectedToUrl() {
        System.out.println("url 1 "+ firUrl);

        soft.assertEquals(firUrl,"https://demo.nopcommerce.com/nokia-lumia-1020");
        System.out.println("url1 checked");
soft.assertAll();
    }


    @Then("user directed to url for second slider")
    public void userDirectedToUrlForSecondSlider() {
        System.out.println("url 2 "+ secUrl);

        soft.assertEquals(secUrl,"https://demo.nopcommerce.com/iphone-6");
        System.out.println("url2 checked");
        soft.assertAll();

    }
}
