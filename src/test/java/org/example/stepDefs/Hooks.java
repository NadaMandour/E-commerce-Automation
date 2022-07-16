package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver= null;


    @Before
    public static void openBrowser() throws InterruptedException {
       //WebDriverManager.chromedriver().setup();
        String chromePath=  System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
       System.setProperty("webdriver.chrome.driver",chromePath);

        //2- create object from webDriver
        driver = new ChromeDriver();
//3- configuration
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 4- navigate to url
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);


    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
