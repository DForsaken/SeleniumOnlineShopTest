package com.hellofresh.challenge.drivers;

import com.hellofresh.challenge.enums.DriverType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private RemoteWebDriver driver;

    public RemoteWebDriver create(DriverType type, String hub) {
        switch (type){
            case CHROME:
                return getChromeDriver(hub);
            case FIREFOX:
                return getFirefoxDriver(hub);
            default:
                throw new IllegalArgumentException("Provided driver type doesn't exist");
        }
    }

    private RemoteWebDriver getFirefoxDriver(String hub) {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/chromedriver");
        //FirefoxOptions options = new FirefoxOptions();
        //return getDriver(options, hub);
        return new FirefoxDriver();
    }

    private RemoteWebDriver getChromeDriver(String hub) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.setCapability(CapabilityType.VERSION, "66");
        //return getDriver(options, hub);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");

//        return new ChromeDriver();
        return getDriver(options, "");
    }

    private RemoteWebDriver getDriver(MutableCapabilities options, String hub){
        try {
            driver = new RemoteWebDriver(new URL("http://172.17.0.1:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println(e + " was thrown, HubUrl in the configuration file is incorrect or missing. " +
                    "Check the file configuration file.");
        }
        return driver;
    }
}
