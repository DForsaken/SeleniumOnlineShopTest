package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class ProductDetailsPage extends BasePage {
    @FindBy(name = "Submit")
    private WebElement addToCarButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(addToCarButton);
    }

    public WebElement getAddToCarButton() {
        return addToCarButton;
    }
}
