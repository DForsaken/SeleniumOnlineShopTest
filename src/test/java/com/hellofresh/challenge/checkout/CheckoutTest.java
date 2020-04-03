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
        getDriver().get("http://automationpractice.com/index.php");
        HomePage homePage = waitForLoadedPage(new HomePage(getDriver()));
        homePage.getLoginButton().click();

        User user = new User();

        LogInPage logInPage = waitForLoadedPage(new LogInPage(getDriver()));
        logInPage.doLogin(user);

        homePage.getWomenCategoryButton().click();
    }

    @Test
    public void testCheckout() {
        navigateTo();

        String orderConfirmationTitle = "ORDER CONFIRMATION";
        String orderConfirmationSubtitle = "Your order on My Store is complete.";
        String relativePath = "controller=order-confirmation";

        CategoryPage categoryPage = waitForLoadedPage(new CategoryPage(getDriver()));
        categoryPage.getFadShortSleeveTSTitle().click();

        ProductDetailsPage productDetailsPage = waitForLoadedPage(new ProductDetailsPage(getDriver()));
        productDetailsPage.getAddToCarButton().click();

        ShoppingCarProductsPage shoppingCarProductsPage = waitForLoadedPage(new ShoppingCarProductsPage(getDriver()));
        shoppingCarProductsPage.getCheckoutButton().click();

        OrderPage orderPage = waitForLoadedPage(new OrderPage(getDriver()));
        orderPage.getCheckoutButton().click();

        CheckoutAddressPage checkoutAddressPage = waitForLoadedPage(new  CheckoutAddressPage(getDriver()));
        checkoutAddressPage.getContinueButton().click();

        CheckoutShippingPage checkoutShippingPage = waitForLoadedPage(new  CheckoutShippingPage(getDriver()));
        checkoutShippingPage.getTermsOfServiceRadioButton().click();
        checkoutShippingPage.getContinueButton().click();

        CheckoutPayment checkoutPayment = waitForLoadedPage(new  CheckoutPayment(getDriver()));
        checkoutPayment.getBankwireMethodButton().click();
        checkoutPayment.getConfirmationButton().click();

        OrderConfirmationPage orderConfirmationPage = waitForLoadedPage(new  OrderConfirmationPage(getDriver()));

        assertThat(orderConfirmationPage.getTitle().getText(), equalTo(orderConfirmationTitle));
        assertTrue(orderConfirmationPage.getShippingStepTitle().isDisplayed());
        assertTrue(orderConfirmationPage.getPaymentStepTitle().isDisplayed());
        assertThat(orderConfirmationPage.getOrderSubtitle().getText(), containsString(orderConfirmationSubtitle));
        assertThat(getDriver().getCurrentUrl(), containsString(relativePath));
    }
}
