package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutAddressPage extends BasePage {
    @FindBy(name = "processAddress")
    private WebElement continueButton;

    public CheckoutAddressPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}
