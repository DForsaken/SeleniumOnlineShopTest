package com.hellofresh.challenge.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver create(int browser, String hub) {
        switch (browser){
            case 1: //"CHROME":
                return getChromeDriver(hub);
            case 2: //"FIREFOX":
                return getFirefoxDriver(hub);
            default:
                throw new IllegalArgumentException("Provided browser doesn't exist");
        }
    }

    private WebDriver getFirefoxDriver(String hub) {
        FirefoxOptions options = new FirefoxOptions();
        return getDriver(options, hub);
    }

    private WebDriver getChromeDriver(String hub) {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.VERSION, "66");
        return getDriver(options, hub);
    }

    private WebDriver getDriver(MutableCapabilities options, String hub){
        try {
            driver = new RemoteWebDriver(new URL(hub), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println(e + " was thrown, HubUrl in the configuration file is incorrect or missing. " +
                    "Check the file configuration file.");
        }
        return driver;
    }
}
