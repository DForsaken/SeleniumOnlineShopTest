package com.hellofresh.challenge.listeners;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.utilities.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);

        System.out.println("TESTS TO RUN:");
        for (ITestNGMethod method : iTestContext.getAllTestMethods()) {
            System.out.println(method.getTestClass().getRealClass().getSimpleName());
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("SUCCESSFUL TESTS:");
        for (ITestNGMethod method : iTestContext.getPassedTests().getAllMethods()) {
            System.out.println(method.getTestClass().getRealClass().getSimpleName());
        }

        System.out.println("FAILED TESTS:");
        for (ITestNGMethod method : iTestContext.getFailedTests().getAllMethods()) {
            System.out.println(method.getTestClass().getRealClass().getSimpleName());
        }

        System.out.println("SKIPPED TESTS:");
        for (ITestNGMethod method : iTestContext.getSkippedTests().getAllMethods()) {
            System.out.println(method.getTestClass().getRealClass().getSimpleName());
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.debug("TEST TO RUN: " +  getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.debug("TEST SUCCEEDED: " +  getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            saveScreenshotPNG(driver);
        }

        Log.debug("TEST FAILED: " +  getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.debug("TEST SKIPPED: " +  getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.debug("TEST UNSTABLE: " +  getTestMethodName(iTestResult));
    }

    @Override
    protected void navigateTo() {
        //do nothing by default
    }
}
