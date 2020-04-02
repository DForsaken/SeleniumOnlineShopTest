package com.hellofresh.challenge.page;

import com.hellofresh.challenge.utilities.Log;
import org.apache.log4j.Level;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class BasePage {
    protected WebDriver driver;
    private  static final long LOAD_TIMEOUT_SECONDS = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static <Page extends BasePage> Page waitForLoadedPage(Page page) {
        return page.waitLoad(page);
    }

    protected  <Page extends BasePage> Page waitLoad(Page page) {
        try {
            wait(getElementsToLoad(), LOAD_TIMEOUT_SECONDS);
        } catch (Exception e) {
            Log.error("Page " + page.getClass().getSimpleName().toString() + " is not the current page. " + "\n" + e);
        }
        return page;
    }

    /**
     * Group of essential elements of a page (recommend only one or two) that will be used to verify if the
     * expected page is loaded.
     *
     * @return  List of WebElements (RECOMMENDED ONLY ONE OR TWO)
     */
    protected List<WebElement> getElementsToLoad() {
        throw new UnsupportedOperationException("Should override");
    }

    /**
     * Fluent wait that works to check if a certain group of elements from a page are visible.
     *
     * @param elements  List of WebElements
     * @param timeoutSeconds    Timeout before wait expires
     */
    private void wait(List<WebElement> elements, Long timeoutSeconds) {
        Log.step(Level.DEBUG, "Wait for " + this.getClass().getSimpleName() + " elements to be loaded");

        new WebDriverWait(driver, timeoutSeconds)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
