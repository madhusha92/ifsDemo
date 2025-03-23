package com.sample.function;

import com.sample.page.BasePage;
import com.sample.page.CartPage;
import com.sample.page.HomePage;
import com.sample.utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class  BaseFunction {
    protected WebDriver driver;
    protected HomePage homePage;
    protected CartPage cartPage;

    protected Object createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        DriverHolder.setDriver(driver);
        return options;
    }

    public Home openApp (String url){
        createChromeDriver();
        driver.get(url);
        maximizeWindows();
        return new Home();
    }


    private void maximizeWindows(){
        DriverHolder.getDriver().manage().window().maximize();
    }

    public void closeApp (){
        DriverHolder.getDriver().quit();
    }
}
