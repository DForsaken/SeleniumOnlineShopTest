package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import com.hellofresh.challenge.page.NewAccountPage;
import com.hellofresh.challenge.page.YourAccountPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {
    @Test
    public void testSingUp() {
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        String password = "Qwerty";
        String accountPath = "controller=my-account";

        HomePage homePage = new HomePage(driver);
        homePage.getLoginButton().click();

        LogInPage logInPage = new LogInPage((driver));
        logInPage.getNewEmail().sendKeys(email);
        logInPage.getCreateAccountButton().click();

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.getGender().click();
        newAccountPage.getFirstName().sendKeys(name);
        newAccountPage.getLastName().sendKeys(surname);
        newAccountPage.getPassword().sendKeys(password);

        Select select = new Select(newAccountPage.getDay());
        select.selectByValue("1");
        select = new Select(newAccountPage.getMonth());
        select.selectByValue("1");
        select = new Select(newAccountPage.getYear());
        select.selectByValue("2000");

        newAccountPage.getCompany().sendKeys("Company");
        newAccountPage.getAddress1().sendKeys("Qwerty, 123");
        newAccountPage.getAddress2().sendKeys("zxcvb");
        newAccountPage.getCity().sendKeys("Qwerty");

        select = new Select(newAccountPage.getState());
        select.selectByVisibleText("Colorado");

        newAccountPage.getPostcode().sendKeys("12345");
        newAccountPage.getOther().sendKeys("Qwerty");
        newAccountPage.getPhone().sendKeys("12345123123");
        newAccountPage.getMobile().sendKeys("12345123123");
        newAccountPage.getAlias().sendKeys("hf");
        newAccountPage.getSubmitButton().click();

        YourAccountPage accountPage = new YourAccountPage(driver);
        assertEquals("MY ACCOUNT", accountPage.getTitle().getText());
        assertEquals(name + " " + surname, accountPage.getAccountOwner().getText());
        assertTrue(accountPage.getAccountInfo().getText().contains("Welcome to your account."));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertTrue(driver.getCurrentUrl().contains(accountPath));
    }
}
