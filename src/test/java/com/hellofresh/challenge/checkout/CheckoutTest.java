package com.hellofresh.challenge.checkout;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.page.CategoryPage;
import com.hellofresh.challenge.page.CheckoutAddressPage;
import com.hellofresh.challenge.page.CheckoutShippingPage;
import com.hellofresh.challenge.page.CheckoutPayment;
import com.hellofresh.challenge.page.HomePage;
import com.hellofresh.challenge.page.LogInPage;
import com.hellofresh.challenge.page.OrderConfirmationPage;
import com.hellofresh.challenge.page.OrderPage;
import com.hellofresh.challenge.page.ProductDetailsPage;
import com.hellofresh.challenge.page.ShoppingCarProductsPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {
    protected void navigateTo() {
        HomePage homePage = new HomePage(driver);
        homePage.getLoginButton().click();

        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";

        LogInPage logInPage = new LogInPage((driver));
        logInPage.getEmail().sendKeys(existingUserEmail);
        logInPage.getPassword().sendKeys(existingUserPassword);
        logInPage.getLogInButton().click();

        homePage.getWomenCategoryButton().click();
    }

    @Test
    public void testCheckout() {
        navigateTo();

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

        assertThat(orderConfirmationPage.getTitle().getText(), equalTo("ORDER CONFIRMATION"));
        assertTrue(orderConfirmationPage.getShippingStepTitle().isDisplayed());
        assertTrue(orderConfirmationPage.getPaymentStepTitle().isDisplayed());
        assertThat(orderConfirmationPage.getOrderSubtitle().getText(), containsString("Your order on My Store is complete."));
        assertThat(driver.getCurrentUrl(), containsString("controller=order-confirmation"));
    }
}
