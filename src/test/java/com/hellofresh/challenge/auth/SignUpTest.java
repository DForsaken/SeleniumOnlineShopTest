package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.data.User;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import com.hellofresh.challenge.page.NewAccountPage;
import com.hellofresh.challenge.page.YourAccountPage;
import org.testng.annotations.Test;

import java.util.Date;

import static com.hellofresh.challenge.page.BasePage.waitForLoadedPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {
    protected void navigateTo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.getLoginButton().click();
    }

    @Test
    public void testSingUp() {
        navigateTo();

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String accountPath = "controller=my-account";
        String accountTitle = "MY ACCOUNT";
        String accountInfo = "Welcome to your account.";
        User user = new User(email);

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.getNewEmail().sendKeys(user.getEmail());
        logInPage.getCreateAccountButton().click();

        NewAccountPage newAccountPage = waitForLoadedPage(new NewAccountPage(getDriver()));
        newAccountPage.doSingUp(user);

        YourAccountPage accountPage = new YourAccountPage(getDriver());

        assertThat(accountPage.getTitle().getText(), equalTo(accountTitle));
        assertThat(accountPage.getAccountOwner().getText(), equalTo(user.getFullName()));
        assertThat(accountPage.getAccountInfo().getText(), containsString(accountInfo));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertThat(getDriver().getCurrentUrl(), containsString(accountPath));
    }
}
