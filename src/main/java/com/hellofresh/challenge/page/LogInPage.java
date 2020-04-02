package com.hellofresh.challenge.page;

import com.hellofresh.challenge.data.User;
import com.hellofresh.challenge.utilities.Log;
import org.apache.log4j.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class LogInPage extends BasePage {
    @FindBy(id = "email_create")
    private WebElement newEmail;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement logInButton;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(email, newEmail);
    }

    public WebElement getNewEmail() {
        return newEmail;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    /****** Filling page helper methods *****/

    public void doLogin(User user) {
        Log.step(Level.DEBUG, "Login with an existing user");
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        logInButton.click();
    }
}
