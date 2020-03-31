package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(linkText = "Women")
    private WebElement womenCategoryButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWomenCategoryButton() {
        return womenCategoryButton;
    }
}
