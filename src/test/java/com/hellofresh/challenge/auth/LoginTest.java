package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.YourAccountPage;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    protected void navigateTo() {
        HomePage homePage = new HomePage(driver);
        homePage.getLoginButton().click();
    }

    @Test
    public void testLogin() {
        navigateTo();

        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";
        String fullName = "Joe Black";
        String accountPath = "controller=my-account";

        LogInPage logInPage = new LogInPage((driver));
        logInPage.getEmail().sendKeys(existingUserEmail);
        logInPage.getPassword().sendKeys(existingUserPassword);
        logInPage.getLogInButton().click();

        YourAccountPage accountPage = new YourAccountPage(driver);
        assertThat(accountPage.getTitle().getText(), equalTo("MY ACCOUNT"));
        assertThat(accountPage.getAccountOwner().getText(), equalTo(fullName));
        assertThat(accountPage.getAccountInfo().getText(), containsString("Welcome to your account."));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertThat(driver.getCurrentUrl(), containsString(accountPath));
    }
}
