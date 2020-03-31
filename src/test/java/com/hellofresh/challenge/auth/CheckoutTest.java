package com.hellofresh.challenge.auth;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    @Test
    public void testCheckout() {
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

        homePage.getWomenCategoryButton().click();

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.getFadShortSleeveTSTitle().click();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.getAddToCarButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ShoppingCarProductsPage shoppingCarProductsPage = new ShoppingCarProductsPage(driver);
        shoppingCarProductsPage.getCheckoutButton().click();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.getCheckoutButton().click();

        CheckoutAddressPage checkoutAddressPage = new CheckoutAddressPage(driver);
        checkoutAddressPage.getContinueButton().click();

        CheckoutShippingPage checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.getTermsOfServiceRadioButton().click();
        checkoutShippingPage.getContinueButton().click();

        CheckoutPayment checkoutPayment = new CheckoutPayment(driver);
        checkoutPayment.getBankwireMethodButton().click();
        checkoutPayment.getConfirmationButton().click();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        assertEquals("ORDER CONFIRMATION", orderConfirmationPage.getTitle().getText());
        assertTrue(orderConfirmationPage.getShippingStepTitle().isDisplayed());
        assertTrue(orderConfirmationPage.getPaymentStepTitle().isDisplayed());
        assertTrue(orderConfirmationPage.getOrderSubtitle().getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
    }
}
