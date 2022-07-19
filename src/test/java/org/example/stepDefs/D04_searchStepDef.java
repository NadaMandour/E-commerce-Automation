package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_homepage_search;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class D04_searchStepDef {
    P04_homepage_search ser = new P04_homepage_search();
    SoftAssert soft = new SoftAssert();


    @When("^user enters ([^\"]*) in search field and clicks on search button$")
    public void enterInSearchField(String searchWord) throws InterruptedException {

        ser.searchField().sendKeys(searchWord);
        ser.searchBtn().click();
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(ser.serUrl());
        soft.assertTrue(ser.serUrl().contains("https://demo.nopcommerce.com/search"), "the search Url does not contain it");

        List<WebElement> serList = ser.searchList();

        for (int i = 0; i < serList.size(); i++) {
            System.out.println(" the option number " + i + " is: " + serList.get(i).getText());

        }
        for (int i = 0; i < serList.size(); i++) {
            if (searchWord.contains("_") == false) {
                soft.assertTrue(serList.get(i).getText().toLowerCase().contains(searchWord.toLowerCase()), "item does not contain search word");
                soft.assertAll();
            }
        }
        if (searchWord.contains("_")) {
            ser.serEleBySku().click();
            System.out.println("selected item is:" + ser.searchList().get(0).getText());

            ser.searchList().get(0).click();
            Thread.sleep(3000);
        } else {
            // select random item

            int min = 0;
            int max = serList.size() - 1;
            int selectedItem = (int) Math.floor(Math.random() * (max - min + 1) + min);
            ser.searchList().get(selectedItem).click();
            System.out.println("selected item is:" + ser.searchList().get(selectedItem).getText());
        }
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Then("^search results with ([^\"]*) will displayed$")
    public void checkSerResultsWithSku(String search) throws InterruptedException {
//Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        if (search.contains("_")) {
            String sku = search;
            System.out.println(ser.getSku().getText() + " is the sku found");

            soft.assertTrue(ser.getSku().getText().contains(sku), " item selected did not have the same sku");
            System.out.println(ser.getSku().getText() + " >>>>>>>>is the sku found");
            soft.assertAll();
        }
        System.out.println("search results displayed");
    }


}

