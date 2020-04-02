package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CheckoutPayment extends BasePage {
    @FindBy(className = "bankwire")
    private WebElement bankwireMethodButton;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement confirmationButton;

    public CheckoutPayment(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(bankwireMethodButton);
    }

    public WebElement getBankwireMethodButton() {
        return bankwireMethodButton;
    }

    public WebElement getConfirmationButton() {
        return confirmationButton;
    }
}
