package com.hellofresh.challenge.page;

import com.hellofresh.challenge.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        logInButton.click();
    }
}
