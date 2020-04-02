package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.data.User;
import com.hellofresh.challenge.page.YourAccountPage;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import org.testng.annotations.Test;

import static com.hellofresh.challenge.page.BasePage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    protected void navigateTo() {
        getDriver().get("http://automationpractice.com/index.php");
        HomePage homePage = waitForLoadedPage(new HomePage(getDriver()));
        homePage.getLoginButton().click();
    }

    @Test
    public void testLogin() {
        navigateTo();

        String accountPath = "controller=my-account";
        String title = "MY ACCOUNT";
        String accountInfo = "Welcome to your account.";

        User user = new User();

        LogInPage logInPage = waitForLoadedPage(new LogInPage(getDriver()));
        logInPage.doLogin(user);

        YourAccountPage accountPage = waitForLoadedPage(new YourAccountPage(getDriver()));

        assertThat(accountPage.getTitle().getText(), equalTo(title));
        assertThat(accountPage.getAccountOwner().getText(), equalTo(user.getFullName()));
        assertThat(accountPage.getAccountInfo().getText(), containsString(accountInfo));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertThat(getDriver().getCurrentUrl(), containsString(accountPath));
    }
}
