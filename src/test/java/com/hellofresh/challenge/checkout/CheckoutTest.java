package com.hellofresh.challenge.checkout;

import com.hellofresh.challenge.BaseTest;
import com.hellofresh.challenge.data.User;
import com.hellofresh.challenge.page.*;
import org.testng.annotations.Test;

import static com.hellofresh.challenge.page.BasePage.waitForLoadedPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {
    protected void navigateTo() {
        HomePage homePage = new HomePage(getDriver());
        homePage.getLoginButton().click();

        User user = new User();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.doLogin(user);

        homePage.getWomenCategoryButton().click();
    }

    @Test
    public void testCheckout() {
        navigateTo();

        CategoryPage categoryPage = waitForLoadedPage(new CategoryPage(getDriver()));
        categoryPage.getFadShortSleeveTSTitle().click();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.getAddToCarButton().click();

        ShoppingCarProductsPage shoppingCarProductsPage = waitForLoadedPage(new ShoppingCarProductsPage(getDriver()));
        shoppingCarProductsPage.getCheckoutButton().click();

        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.getCheckoutButton().click();

        CheckoutAddressPage checkoutAddressPage = new CheckoutAddressPage(getDriver());
        checkoutAddressPage.getContinueButton().click();

        CheckoutShippingPage checkoutShippingPage = new CheckoutShippingPage(getDriver());
        checkoutShippingPage.getTermsOfServiceRadioButton().click();
        checkoutShippingPage.getContinueButton().click();

        CheckoutPayment checkoutPayment = new CheckoutPayment(getDriver());
        checkoutPayment.getBankwireMethodButton().click();
        checkoutPayment.getConfirmationButton().click();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());

        assertThat(orderConfirmationPage.getTitle().getText(), equalTo("ORDER CONFIRMATION"));
        assertTrue(orderConfirmationPage.getShippingStepTitle().isDisplayed());
        assertTrue(orderConfirmationPage.getPaymentStepTitle().isDisplayed());
        assertThat(orderConfirmationPage.getOrderSubtitle().getText(), containsString("Your order on My Store is complete."));
        assertThat(getDriver().getCurrentUrl(), containsString("controller=order-confirmation"));
    }
}
