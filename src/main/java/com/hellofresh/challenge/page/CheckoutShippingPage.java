package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutShippingPage extends BasePage {
    @FindBy(id = "uniform-cgv")
    private WebElement termsOfServiceRadioButton;

    @FindBy(name = "processCarrier")
    private WebElement continueButton;

    public CheckoutShippingPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTermsOfServiceRadioButton() {
        return termsOfServiceRadioButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}
