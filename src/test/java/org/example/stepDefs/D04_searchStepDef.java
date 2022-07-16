package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_homepage_search;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P04_homepage_search ser = new P04_homepage_search();
    SoftAssert soft = new SoftAssert();

    @Given("user goes to home page")
    public void goHomePage() throws InterruptedException {
        System.out.println("Home Page");
        ser.logoBtn().click();
        Thread.sleep(5000);
    }

    @When("^user enters ([^\"]*) in search field$")
    public void enterInSearchField(String searchWord) {

        ser.searchField().sendKeys(searchWord);
        List<WebElement> serList = ser.searchList();
        for (int i = 0; i < serList.size(); i++) {
            System.out.println(" the option number " + i + " is: " + serList.get(i).getText());
            if  (searchWord.contains("_")==false)
            { soft.assertTrue(serList.get(i).getText().contains(searchWord),"item does not contain search word");}
        }
        int min = 0;
        int max = serList.size();
        int selectedItem = 0;//(int) Math.floor(Math.random() * (max - min + 1) + min);
        ser.searchList().get(selectedItem).click();
    }

    @And("user click on search button")
    public void clickSerBtn() {
        ser.searchBtn().click();

    }

    @Then("^search results with ([^\"]*) will displayed$")
    public void checkSerResultsWithSku(String search) throws InterruptedException {
        Thread.sleep(3000);
        if (search.contains("_")) {
            String sku = search;

            soft.assertTrue(ser.getSku().getText().contains(sku)," item selected did not have the same sku");
            System.out.println(ser.getSku().getText()+" is the sku found");

        }
soft.assertTrue(ser.serUrl().contains("nopCommerce demo store. Search "),"the search Url does not contain it");
    }


}

