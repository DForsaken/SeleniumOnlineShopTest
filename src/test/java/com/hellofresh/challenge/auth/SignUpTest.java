package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import com.hellofresh.challenge.page.NewAccountPage;
import com.hellofresh.challenge.page.YourAccountPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest {
    protected void navigateTo() {
        HomePage homePage = new HomePage(driver);
        homePage.getLoginButton().click();
    }

    @Test
    public void testSingUp() {
        navigateTo();

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        String password = "Qwerty";
        String accountPath = "controller=my-account";

        LogInPage logInPage = new LogInPage((driver));
        logInPage.getNewEmail().sendKeys(email);
        logInPage.getCreateAccountButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        assertThat(accountPage.getTitle().getText(), equalTo("MY ACCOUNT"));
        assertThat(accountPage.getAccountOwner().getText(), equalTo(name + " " + surname));
        assertThat(accountPage.getAccountInfo().getText(), containsString("Welcome to your account."));
        assertTrue(accountPage.getLogoutButton().isDisplayed());
        assertThat(driver.getCurrentUrl(), containsString(accountPath));
    }
}
