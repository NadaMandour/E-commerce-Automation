package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
//Tc1
    P02_login log = new P02_login();
SoftAssert soft = new SoftAssert();
String val = null;
    @Given("user go to login page")
    public void goLoginPage() throws InterruptedException {
       System.out.println("Login page");
       log.loginBtn().click();
        Thread.sleep(5000);

    }

    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void login( String type , String email , String password)
    {
        log.emailField().sendKeys(email);
        log.passwordField().sendKeys(password);

            System.out.println("user entered "+type +"data");
       }
    @And("user press on login button")
    public void pressLoginBtn()
    {

       log.loginBtnInLogPage().click();

    }

    @Then("user login to the system successfully")
    public void checkLogin() throws InterruptedException {
        Thread.sleep(2000);

            //assert for valid data
            soft.assertEquals(log.getUrl(), "https://demo.nopcommerce.com/");
            soft.assertTrue(log.myAccTab().isDisplayed()," My Account tab id displayed");

        soft.assertAll();

    }
    @Then("user could not login to the system")
    public void checkNotLogin()
    {
        //assert for invalid data

        soft.assertTrue(log.errorMessage().getText().contains("Login was unsuccessful."));
        soft.assertEquals( Color.fromString(log.errorMessage().getCssValue("color")).asHex(), "#e4434b");
        soft.assertAll();

    }



}