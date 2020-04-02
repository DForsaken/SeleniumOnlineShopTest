package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CheckoutAddressPage extends BasePage {
    @FindBy(name = "processAddress")
    private WebElement continueButton;

    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(continueButton);
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}
