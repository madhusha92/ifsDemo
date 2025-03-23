package com.sample.function;

import com.sample.page.CartPage;

import java.math.BigDecimal;

public class Cart extends BaseFunction{



    public Cart addToCart (){
        cartPage = new CartPage(driver);
        cartPage.clickOnCart();
        return this;
    }

    public Cart viewCart (){
        cartPage = new CartPage(driver);
        cartPage.viewCart();
        return this;
    }

    public String getAddToCartProductName (){
        cartPage = new CartPage(driver);
        return cartPage.getProductName();
    }

    public String getViewCartProductName (){
        cartPage = new CartPage(driver);
        return cartPage.getCartProductName();
    }
    public String getProdPrice (){
        cartPage = new CartPage(driver);
        return cartPage.getProductPrice();
    }

    public String getSubTotal (){
        cartPage = new CartPage(driver);
        return cartPage.getSubTotal();
    }

    public String getTotalProdPrice (int qty, String price){
        BigDecimal bigDecimalPrice = new BigDecimal(price);
        BigDecimal quantity = new BigDecimal(qty);
        BigDecimal total = bigDecimalPrice.multiply(quantity);
        return total.toString();
    }

    public int getTotalProductQuantity (){
        return cartPage.getTotalQty();
    }

    public boolean isRealTimeChatDisplayed(){
        return cartPage.isChatDisplayed();
    }
}
