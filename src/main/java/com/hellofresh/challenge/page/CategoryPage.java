package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
    private WebElement fadShortSleeveTSTitle;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(fadShortSleeveTSTitle);
    }

    public WebElement getFadShortSleeveTSTitle() {
        return fadShortSleeveTSTitle;
    }
}
