package com.hellofresh.challenge;

import com.hellofresh.challenge.enums.DriverType;
import com.hellofresh.challenge.utilities.Log;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hellofresh.challenge.drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        Log.step(Level.DEBUG, "Starting driver");
        driver = driverFactory.create(DriverType.CHROME, "http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 10, 50);
        Log.step(Level.DEBUG, "Opening browser in webpage");
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void tearDown() {
        Log.step(Level.DEBUG, "Quit driver");
        driver.quit();
    }

//    @BeforeTest
    protected abstract void navigateTo();

    public WebDriver getDriver() {
        return driver;
    }
}
