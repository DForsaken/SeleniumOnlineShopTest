package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(name = "Submit")
    private WebElement addToCarButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCarButton() {
        return addToCarButton;
    }
}
