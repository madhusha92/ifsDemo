package com.sample.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class CartPage extends BasePage{

    private final By prodQuantityTxt = By.xpath("//input[@aria-label='quantity']/parent::div//button[@aria-label='Increase item quantity by one']");
    private final By addToCartBtn = By.xpath("//button[@id='AddToCart-']");
    private final By viewCartBtn = By.xpath("//a[@id='addToCart-btn']");
    private final By productNameLbl = By.xpath("//h1");
    private final By cartProductNameLbl = By.xpath("//a[@class='cart__item-name']");
    private final By proPriceLbl = By.xpath("//span[@class='product__price']");
    private final By subTotalLbl = By.xpath("//div[@class='a_pplr_item_line_price']");
    private final By totalQtyLbl = By.xpath("//input[@id='cart_updates_41312896876631:06bfcf6eabdec51b53ed4e9a5efe6f86']");
    private final By chatIframe = By.xpath("//iframe[@id='chat-button']");
    private final By realtimeChatBtn = By.xpath("//button[@id='gorgias-chat-messenger-button']");

    public CartPage (WebDriver driver) {
        super(driver);
    }

    public CartPage addProducts (){
        driver.findElement(prodQuantityTxt).click();
        return this;
    }


    public CartPage clickOnCart (){
        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        driver.findElement(addToCartBtn).click();
        return this;
    }

    public CartPage viewCart (){
        Duration duration = Duration.ofSeconds(60);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn));
        driver.findElement(viewCartBtn).click();
        return this;
    }

    public String getProductName (){
        return driver.findElement(productNameLbl).getText();
    }

    public String getCartProductName () {
        return driver.findElement(cartProductNameLbl).getText();
    }

    public String getProductPrice () {
        String price = driver.findElement(proPriceLbl).getText();
        return price.substring(1);
    }

    public String getSubTotal () {
        String subTotal = driver.findElement(subTotalLbl).getText();
        return subTotal.substring(1);
    }

    public int getTotalQty () {
        int totalQuantity = Integer.parseInt(driver.findElement(totalQtyLbl).getAttribute("value"));
        return totalQuantity;
    }

    public boolean isChatDisplayed () {
        WebElement element = driver.findElement(chatIframe);
        driver.switchTo().frame(element);
        return driver.findElement(realtimeChatBtn).isDisplayed();
    }

}
