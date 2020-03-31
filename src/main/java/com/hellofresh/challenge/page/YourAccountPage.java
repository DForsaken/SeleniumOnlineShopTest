package com.hellofresh.challenge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

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
