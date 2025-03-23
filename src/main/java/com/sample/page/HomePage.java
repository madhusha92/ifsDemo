package com.sample.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    private final By popUp = By.xpath("//*[@id='title-Close-dialog']/parent::*/parent::button");
    private final By searchTxt = By.xpath("//input[@class='input-group-field']");
    private final By sortByDD = By.xpath("//div[@class='kuDropdown kuDropSortBy']");
    private static final String sortByValue = "//div[@class='kuDropdown kuDropSortBy']//div[text()='%s']";
    private static final String productValue = "(//div[@data-block-id='ku_landing_result_items']//li)/div[@class='kuProdWrap'][%s]";


    public HomePage (WebDriver driver){
        super(driver);
    }

    public HomePage clickOnPopUp (){
        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUp));
        driver.findElement(popUp).click();
        return this;
    }

    public HomePage clickOnSearch (){
        driver.findElement(searchTxt).click();
        return this;
    }

    public HomePage searchForProduct (String searchValue){
        driver.findElement(searchTxt).clear();
        driver.findElement(searchTxt).sendKeys(searchValue);
        driver.findElement(searchTxt).sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage clickOnSort (){
        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortByDD));
        driver.findElement(sortByDD).click();
        return this;
    }

    public HomePage clickOnSortByValue (String sortValue) {
        Duration duration = Duration.ofSeconds(120);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(replaceValues(sortByValue,sortValue))));
        driver.findElement(By.xpath(replaceValues(sortByValue,sortValue))).click();
        return this;
    }

    public HomePage clickOnProduct (String prodId){
        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath(replaceValues(productValue,prodId))).click();
            return this;
        }catch (Exception e){
            return this;
        }
    }


}
