package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
        import io.cucumber.java.en.Given;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register reg = new P01_register();
SoftAssert soft = new SoftAssert();

    @Given("user go to register page")
    public void goRegisterPage() throws InterruptedException {
       // Hooks.driver.findElement(By.className("ico-register")).click();
        System.out.println("test for first step");
        reg.registerBtn().click();
Thread.sleep(5000);



    }
   @When("user select gender type")
    public void selectGender()
    {
        reg.genderBtn().click();


    }
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
public void enterFirstName( String firstName , String lastName)
{
reg.firstnameField().sendKeys(firstName);
reg.lastnameField().sendKeys(lastName);

}
//////////////////////working on it ////////////
@And("user enter date of birth")
public void enterDateOfBirth( )
{
// check static or dynamic drop list
}
@And("^user enter email \"(.*)\" field$")
public void enterEmail( String email)
{
reg.emailField().sendKeys(email);
}
    @And("^user fills Password fields \"(.*)\" and \"(.*)\"$")
    public void enterPassword( String password , String conPassword)
    {
reg.passwordField().sendKeys(password);
reg.confirmPasswordField().sendKeys(conPassword);
    }
    @And("user clicks on register button")
    public void clickRegisterBtn( )
    {
reg.registerBtnInRegPage().click();
    }
@Then("success message is displayed")
public void checkMessage() throws InterruptedException {
    Thread.sleep(5000);

   soft.assertEquals(reg.successMessage().getText(),"Your registration completed");
    System.out.println("registration completed ");
    soft.assertEquals(reg.successMessage().getCssValue("color"),"rgba(76, 177, 124, 1)");
    System.out.println("color is green ");
soft.assertAll();

}




}