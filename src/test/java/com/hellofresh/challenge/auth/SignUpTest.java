package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.data.User;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import com.hellofresh.challenge.page.NewAccountPage;
import com.hellofresh.challenge.page.YourAccountPage;
import org.openqa.selenium.support.ui.Select;
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
        User user = new User(email);

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.getNewEmail().sendKeys(user.getEmail());
        logInPage.getCreateAccountButton().click();

        NewAccountPage newAccountPage = waitForLoadedPage(new NewAccountPage(getDriver()));
        newAccountPage.getGender().click();
        newAccountPage.getFirstName().sendKeys(user.getName());
        newAccountPage.getLastName().sendKeys(user.getSurname());
        newAccountPage.getPassword().sendKeys(user.getPassword());

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

        YourAccountPage accountPage = new YourAccountPage(getDriver());

        assertThat(accountPage.getTitle().getText(), equalTo("MY ACCOUNT"));
        assertThat(accountPage.getAccountOwner().getText(), equalTo(user.getName() + " " + user.getSurname()));
        assertThat(accountPage.getAccountInfo().getText(), containsString("Welcome to your account."));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertThat(getDriver().getCurrentUrl(), containsString(accountPath));
    }
}
