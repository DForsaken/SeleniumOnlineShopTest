package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCarProductsPage extends BasePage {
    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private WebElement checkoutButton;

    public ShoppingCarProductsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}
