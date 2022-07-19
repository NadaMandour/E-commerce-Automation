package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_homepage_search {


    public WebElement logoBtn() {
        return Hooks.driver.findElement(By.cssSelector("img[alt =\"nopCommerce demo store\"]"));
    }

    public WebElement searchField() {
        return Hooks.driver.findElement(By.name("q"));
    }

    public WebElement searchBtn() {
        return Hooks.driver.findElement(By.className("search-box-button"));
    }


    public List<WebElement> searchList() {
        //return Hooks.driver.findElements(By.className("ui-menu-item-wrapper"));
        return Hooks.driver.findElements(By.className("product-title"));
    }
    public WebElement serEleBySku()
    {
        return Hooks.driver.findElement(By.className("product-title"));
    }

    public WebElement getSku() {
        List<WebElement> elements = Hooks.driver.findElements(By.className("value"));
        WebElement skuEle = elements.get(elements.size() - 1);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getAttribute("id").contains("sku")) {

                skuEle = elements.get(i);
            }
        }
        return skuEle;
    }



    public String serUrl() {
        return Hooks.driver.getCurrentUrl();
    }
}








