package com.sample.test;

import com.sample.function.BaseFunction;
import com.sample.utils.ProjectProperties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    private String url = ProjectProperties.getProperty("application.url");

    @BeforeTest
    public void launchApp (){
        new BaseFunction().openApp(url);
    }

    @Test
    public void addToCartViaHambugerMenuTest (){
        int prodQty = 2;
        home.searchForProduct("cars");
        home.sortTheProduct("Price: Low to high");
        home.addProduct("1",prodQty);
        String prodPrice = cart.getProdPrice();
        cart.addToCart();
        cart.viewCart();
        String totalPrice = cart.getTotalProdPrice(prodQty+1,prodPrice);
        Assert.assertEquals(cart.getSubTotal(),totalPrice);
        Assert.assertEquals(cart.getTotalProductQuantity(),prodQty+1);
        Assert.assertTrue(cart.isRealTimeChatDisplayed());

    }

    @AfterTest
    public void closeApp (){
        new BaseFunction().closeApp();
    }
}
