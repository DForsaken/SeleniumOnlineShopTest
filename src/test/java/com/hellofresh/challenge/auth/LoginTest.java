package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.YourAccountPage;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";
        String fullName = "Joe Black";
        String accountPath = "controller=my-account";

        HomePage homePage = new HomePage(driver);
        homePage.getLoginButton().click();

        LogInPage logInPage = new LogInPage((driver));
        logInPage.getEmail().sendKeys(existingUserEmail);
        logInPage.getPassword().sendKeys(existingUserPassword);
        logInPage.getLogInButton().click();

        YourAccountPage accountPage = new YourAccountPage(driver);
        assertEquals("MY ACCOUNT", accountPage.getTitle().getText());
        assertEquals(fullName, accountPage.getAccountOwner().getText());
        assertTrue(accountPage.getAccountInfo().getText().contains("Welcome to your account."));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertTrue(driver.getCurrentUrl().contains(accountPath));
    }
}
