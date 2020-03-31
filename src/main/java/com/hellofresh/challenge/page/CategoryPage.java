package com.hellofresh.challenge.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']")
    private WebElement fadShortSleeveTSTitle;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFadShortSleeveTSTitle() {
        return fadShortSleeveTSTitle;
    }
}
