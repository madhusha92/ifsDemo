package com.sample.page;
import com.sample.utils.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver= DriverHolder.getDriver();
    }


    protected void init () {}

    private <E extends BasePage> void initFindByAnnotations (final E page){
        PageFactory.initElements(driver, page);
    }

    protected String replaceValues (String locator, String... values){
        return String.format(locator,values);
    }

}
