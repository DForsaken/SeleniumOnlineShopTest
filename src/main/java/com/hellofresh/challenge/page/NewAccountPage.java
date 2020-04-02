package com.hellofresh.challenge.page;

import com.hellofresh.challenge.data.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class NewAccountPage extends BasePage {
    @FindBy(id = "id_gender2")
    private WebElement gender;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "other")
    private WebElement other;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement mobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected List<WebElement> getElementsToLoad() {
        return Arrays.asList(gender, firstName);
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getAddress2() {
        return address2;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getOther() {
        return other;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getAlias() {
        return alias;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    /****** Filling page helper methods *****/

    public void doSingUp(User user) {
        gender.click();
        firstName.sendKeys(user.getName());
        lastName.sendKeys(user.getSurname());
        password.sendKeys(user.getPassword());

        Select select = new Select(day);
        select.selectByValue(user.getDay());
        select = new Select(month);
        select.selectByValue(user.getMonth());
        select = new Select(year);
        select.selectByValue(user.getYear());

        company.sendKeys(user.getCompany());
        address1.sendKeys(user.getAddress1());
        address2.sendKeys(user.getAddress2());
        city.sendKeys(user.getCity());

        select = new Select(state);
        select.selectByVisibleText(user.getState());

        postcode.sendKeys(user.getPostcode());
        other.sendKeys(user.getOther());
        phone.sendKeys(user.getPhone());
        mobile.sendKeys(user.getMobile());
        alias.sendKeys(user.getAlias());

        submitButton.click();
    }
}
