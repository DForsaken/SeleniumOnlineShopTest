package com.hellofresh.challenge;

import com.hellofresh.challenge.enums.DriverType;
import com.hellofresh.challenge.utilities.Log;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hellofresh.challenge.drivers.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        Log.step(Level.DEBUG, "Starting driver");
        driver.set(driverFactory.create(DriverType.CHROME, "http://automationpractice.com/index.php"));
        //driver.set(driverFactory.create(DriverType.FIREFOX, "http://automationpractice.com/index.php"));
        wait = new WebDriverWait(driver.get(), 10, 50);
        Log.step(Level.DEBUG, "Opening browser in webpage");
        driver.get().get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void tearDown() {
        Log.step(Level.DEBUG, "Quit driver");
        getDriver().quit();
    }

    @AfterClass
    public void terminate () {
        driver.remove();
    }

//    @BeforeTest
    protected abstract void navigateTo();

    public WebDriver getDriver() {
        return driver.get();
    }
}
