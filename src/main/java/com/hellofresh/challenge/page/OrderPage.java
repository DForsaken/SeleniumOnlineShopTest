package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class OrderPage extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private WebElement checkoutButton;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(checkoutButton);
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}
