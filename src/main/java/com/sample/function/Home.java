package com.sample.function;

import com.sample.page.CartPage;
import com.sample.page.HomePage;

public class Home extends BaseFunction {

    public Home addProduct (String prodId, int prodQty){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        homePage.clickOnProduct(prodId);
        for (int qty=0; qty<prodQty; qty++){
            cartPage.addProducts();
        }
        return this;
    }

    public Home searchForProduct (String prodName){
        homePage = new HomePage(driver);
        homePage.clickOnPopUp();
        homePage.clickOnSearch();
        homePage.searchForProduct(prodName);
        return this;
    }

    public Home sortTheProduct (String sortByVal){
        homePage = new HomePage(driver);
        homePage.clickOnSort();
        homePage.clickOnSortByValue(sortByVal);
        return this;
    }


}
