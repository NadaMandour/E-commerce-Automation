package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {


    public WebElement logoBtn() {
        return Hooks.driver.findElement(By.cssSelector("img[alt =\"nopCommerce demo store\"]"));
    }

    public WebElement currencyBtn() {
        return Hooks.driver.findElement(By.name("customerCurrency"));
    }

    public List<WebElement> ProductPrice() {
        return Hooks.driver.findElements(By.className("actual-price"));
    }

}
