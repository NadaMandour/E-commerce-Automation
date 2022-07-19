package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    // categories
    public List<WebElement> categoriesList() {
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public List<WebElement> subcategoryList(int selectedCategory) {
        selectedCategory = selectedCategory + 1;
        String locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        List<WebElement> subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
        return subCategoryLinks;
    }

    public WebElement pageTitle() {
        return Hooks.driver.findElement(By.className("page-title"));

    }

    // sliders
    public WebElement firstSliderSelect() {
        return Hooks.driver.findElement(By.xpath("//a[@ rel=\"0\"]"));

    }

    public WebElement secondSliderSelect() {
        return Hooks.driver.findElement(By.xpath("//a[@ rel=\"1\"]"));

    }

    public WebElement sliderSelect() {
        return Hooks.driver.findElement(By.xpath(" //a[@style=\"display: block;\"]"));

    }

    public String getUrl() {

        return Hooks.driver.getCurrentUrl();
    }

    //follow us
    public WebElement facebookBtn() {
        return Hooks.driver.findElement(By.className("facebook"));

    }

    public WebElement twitterBtn() {
        return Hooks.driver.findElement(By.className("twitter"));

    }

    public WebElement rssBtn() {
        return Hooks.driver.findElement(By.className("rss"));

    }

    public WebElement youtubeBtn() {
        return Hooks.driver.findElement(By.className("youtube"));

    }

    // wish List
    public List<WebElement> wishlistIcons() {
        return Hooks.driver.findElements(By.xpath("//button[@title=\"Add to wishlist\"]"));
    }

    public WebElement wishListSuccessMessage() {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
    }

    public WebElement wishlistBtn() {

        return Hooks.driver.findElement(By.xpath("//span[@class=\"wishlist-label\"]"));
    }

    public WebElement wishlistQtyHome() {

        return Hooks.driver.findElement(By.xpath("//span[@class=\"wishlist-qty\"]"));
    }

    public WebElement wishlistQtyWish() {

        return Hooks.driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
    }


}
