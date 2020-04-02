package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {
    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(linkText = "Women")
    private WebElement womenCategoryButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(loginButton);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWomenCategoryButton() {
        return womenCategoryButton;
    }
}
