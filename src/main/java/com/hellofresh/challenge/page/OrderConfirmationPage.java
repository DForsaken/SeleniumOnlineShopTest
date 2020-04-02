package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class OrderConfirmationPage extends BasePage {
    @FindBy(css = "h1")
    private WebElement title;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private WebElement shippingStepTitle;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private WebElement paymentStepTitle;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private WebElement orderSubtitle;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(title);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getShippingStepTitle() {
        return shippingStepTitle;
    }

    public WebElement getPaymentStepTitle() {
        return paymentStepTitle;
    }

    public WebElement getOrderSubtitle() {
        return orderSubtitle;
    }
}
