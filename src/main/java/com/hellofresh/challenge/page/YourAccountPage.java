package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class YourAccountPage extends BasePage {
    @FindBy(css = "h1")
    private WebElement title;

    @FindBy(className = "account")
    private WebElement accountOwner;

    @FindBy(className = "info-account")
    private WebElement accountInfo;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(title);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getAccountOwner() {
        return accountOwner;
    }

    public WebElement getAccountInfo() {
        return accountInfo;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}
