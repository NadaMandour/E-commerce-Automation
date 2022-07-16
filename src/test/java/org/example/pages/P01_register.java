package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class P01_register {

    public WebElement registerBtn()
    {
        return   Hooks.driver.findElement(By.className("ico-register"));

    }
public WebElement genderBtn()
{
    return   Hooks.driver.findElement(By.id("gender-female"));

}
    public WebElement firstnameField()
    {
        return   Hooks.driver.findElement(By.id("FirstName"));

    }

    public WebElement lastnameField()
    {
        return   Hooks.driver.findElement(By.id("LastName"));

    }

    public WebElement emailField()
    {
        return   Hooks.driver.findElement(By.id("Email"));

    }
    public WebElement passwordField()
    {
        return   Hooks.driver.findElement(By.id("Password"));

    }
    public WebElement confirmPasswordField()
    {
        return   Hooks.driver.findElement(By.id("ConfirmPassword"));

    }
    public WebElement registerBtnInRegPage()
    {
        return   Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement successMessage()
    {
        return   Hooks.driver.findElement(By.className("result"));
    }
}
