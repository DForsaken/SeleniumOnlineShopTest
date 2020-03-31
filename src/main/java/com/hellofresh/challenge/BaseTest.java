package com.hellofresh.challenge;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hellofresh.challenge.drivers.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

//        DriverFactory driverFactory = new DriverFactory();
//        driver = driverFactory.create(1, "http://automationpractice.com/index.php");

//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
