package org.example.pages;


import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement loginBtn()
    {
        return   Hooks.driver.findElement(By.className("ico-login"));

    }
    public WebElement  emailField()
    {
        return   Hooks.driver.findElement(By.id("Email"));

    }
    public WebElement  passwordField()
    {
        return   Hooks.driver.findElement(By.id("Password"));

    }
    public WebElement  loginBtnInLogPage()
    {
        return   Hooks.driver.findElement(By.className("login-button"));

    }

    public String getUrl()
    {
        return Hooks.driver.getCurrentUrl();
    }

    public WebElement myAccTab()
    {
       return Hooks.driver.findElement(By.className("ico-account"));
    }
    public WebElement errorMessage()
    {
        return Hooks.driver.findElement(By.className("message-error"));
    }
}

