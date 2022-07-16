package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePage home = new P03_homePage();
    @Given("user go to home page")
    public void goHomePage() throws InterruptedException {
        System.out.println("Home Page");
        home.logoBtn().click();
        Thread.sleep(5000);
    }

    @When("user clicks on currency drop list")
    public void clickCurrency()
    {
home.currencyBtn().click();
    }

    @And("user select Euro currency")
    public void selectEuro()
    {
        Select sel = new Select(home.currencyBtn());
        sel.selectByVisibleText("Euro");
    }

    @Then("Euro currency selected successfully")
    public void checkSelection()
    {
        Select sel = new Select(home.currencyBtn());
        System.out.println(sel.getFirstSelectedOption().getText()+ "selected");
        List<WebElement> elements = home.ProductPrice();
        for (int i = 0; i < elements.size(); i++) {
           Assert.assertTrue(elements.get(i).getText().contains("€"),"assert product number"+(i+1));
            System.out.println((i+1)+"checked");
        }

    }






}
