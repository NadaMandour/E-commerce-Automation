package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage home = new P03_homePage();

    @When("user opens facebook link")
    public void userOpensFacebookLink() {
        home.facebookBtn().click();
    }


    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        home.twitterBtn().click();
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        home.rssBtn().click();
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        home.youtubeBtn().click();
    }

    @Then("^url \"(.*)\" is opened in new tab$")
    public void isOpenedInNewTab(String url) {
        System.out.println(url);
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
     wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println( "tabs= "+tabs.size());
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +Hooks.driver.getCurrentUrl());

        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
Hooks.driver.close();
    }

}
