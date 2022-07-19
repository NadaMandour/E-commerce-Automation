package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();

    Actions actions=new Actions(Hooks.driver);



    @When("user hover the categories and select category or sub category if found")
    public void userSelectCategory() throws InterruptedException {
        for (int i = 0; i < home.categoriesList().size(); i++) {

            System.out.println("main categories: "+home.categoriesList().get(i).getText());
        }

        int count =  home.categoriesList().size();
        System.out.println("category size "+count);
        int min = 0;
        int max = count-1;
        int selectedCategory = (int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement( home.categoriesList().get(selectedCategory)).build().perform();
        System.out.println("the category selected is:   " +home.categoriesList().get(selectedCategory).getText());
       // Thread.sleep(2000);
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        System.out.println("sub category size: "+home.subcategoryList(selectedCategory).size());

        if(home.subcategoryList(selectedCategory).size()!=0) {


             max = home.subcategoryList(selectedCategory).size()-1;
            int selectedSubCategory = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println( "selected sub category is "+home.subcategoryList(selectedCategory).get(1).getText());
            home.subcategoryList(selectedCategory).get(1).click();
            Thread.sleep(3000);
           Assert.assertEquals(home.pageTitle().getText(),home.subcategoryList(selectedCategory).get(selectedSubCategory).getText());
        }
        else if (home.subcategoryList(selectedCategory).size()==0)
        {
            home.categoriesList().get(selectedCategory).click();
            Thread.sleep(3000);
            Assert.assertEquals(home.pageTitle().getText(),home.categoriesList().get(selectedCategory).getText());

        // reset it to the initial value
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



    }
    }


    @Then("user directed to selected category page")
    public void checkSelectedCategoryPage() {
        System.out.println("categories are located");

    }
}
