package com.hellofresh.challenge;

import com.hellofresh.challenge.enums.DriverType;
import com.hellofresh.challenge.utilities.Log;
import com.hellofresh.challenge.utilities.TestsProperties;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hellofresh.challenge.drivers.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public abstract class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    /**
     *    This wait is meant to be used with web elements or specific conditions. To wait longer for
     *    pages then check on the fluent wait on BasePage
     */
    public WebDriverWait wait;
    private final int WAIT_TIMEOUT_DEFAULT = 10;
    private final int WAIT_SLEEP_TIME_DEFAULT = 50;

    /**
     * Handle driver init with properties file.
     * We use factory in case we need to switch between drivers
     */
    @BeforeMethod
    public void setUp() {
        Properties properties = TestsProperties.loadPropertiesFile();
        String browser = properties.getProperty("browser", "chrome");
        String hub = properties.getProperty("hubUrl", "http://127.0.0.1:4444/grid/hub");

        Log.step(Level.DEBUG, "Starting " + browser + " driver. Connecting to " + hub);
        DriverFactory driverFactory = new DriverFactory();
        driver.set(driverFactory.create(DriverType.get(browser), hub));

        wait = new WebDriverWait(driver.get(), WAIT_TIMEOUT_DEFAULT, WAIT_SLEEP_TIME_DEFAULT);
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

    /**
     * Should be use as a helper method to navigate to the target page.
     */
    protected abstract void navigateTo();

    /**
     * Should use this to get the current driver so we can handle it during parallel runs

     * @return current driver
     */
    public WebDriver getDriver() {
        return driver.get();
    }
}
