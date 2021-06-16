package com.xcart.mobile.testSuite.shopping;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testBase.TestBase;
import com.xcart.mobile.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingTest extends TestBase {

    SoftAssert softAssert=new SoftAssert();
    HomePage homePage=new HomePage();
    SalePage salePage=new SalePage();
    BestsellersPage bestsellersPage=new BestsellersPage();
    CartPage cartPage=new CartPage();
    CheckOutPage checkOutPage=new CheckOutPage();

    @Test(groups = {"smoke","sanity","regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Sale");
        Thread.sleep(3000);
        salePage.mouseHoverOnSortByFilter();
        salePage.selectSortByFilter("Name A - Z");
        Thread.sleep(2000);
        salePage.selectAvengersAddToCartButton();
        Thread.sleep(1000);
        String expectedVerifyMessage="Product has been added to your cart";
        String actualVerifyMessage=salePage.getTextFromVerifyMessage();
        softAssert.assertEquals(expectedVerifyMessage,actualVerifyMessage);
        salePage.closeVerifyButton();
        Thread.sleep(2000);
        salePage.selectYourCartButton();
        salePage.selectViewCartButton();
        Thread.sleep(2000);
        String expectedVerifyQuantityText="Your shopping cart - 1 item";
        String actualVerifyQuantityText=cartPage.getQuantityVerifyText();
        softAssert.assertEquals(expectedVerifyQuantityText,actualVerifyQuantityText);
        cartPage.changeQuantity("2");
        Thread.sleep(5000);
        String expectedVerifyQuantityText1="Your shopping cart - 2 item";
        String actualVerifyQuantityText1=cartPage.getQuantityVerifyText();
        softAssert.assertEquals(expectedVerifyQuantityText1,actualVerifyQuantityText1);
        String expectedSubTotal="Subtotal: $29.98";
        String actualSubTotal=cartPage.getTextFromSubTotal();
        softAssert.assertEquals(expectedSubTotal,actualSubTotal);
        String expectedTotal="$36.00";
        String actualTotal=cartPage.getTextFromTotal();
        softAssert.assertEquals(expectedTotal,actualTotal);
        cartPage.selectGoToCheckOutButton();
        Thread.sleep(5000);
        String expectedLoginPageVerifyText="Log in to your account";
        String actualLoginPageVerifyText=checkOutPage.getLoginVerifyText();
        softAssert.assertEquals(expectedLoginPageVerifyText,actualLoginPageVerifyText);
        checkOutPage.enterEmailId("jemspeter","@yahoo.com");
        checkOutPage.selectContinueButton();
        Thread.sleep(2000);
        String expectedSecureCheckOutText="Secure Checkout";
        String actualSecureCheckOutText=checkOutPage.getSecureCheckOutText();
        softAssert.assertEquals(expectedSecureCheckOutText,actualSecureCheckOutText);
        checkOutPage.enterFirstName("Mark");
        checkOutPage.enterLastName("ZuckerBerg");
        Thread.sleep(1000);
        checkOutPage.enterAddress("45,Cooper Street");
        checkOutPage.enterCityName("London");
        checkOutPage.selectCountryName("United Kingdom");
        Thread.sleep(1000);
        checkOutPage.enterStateName("London");
        checkOutPage.enterZipCode("900456");
        checkOutPage.selectCreateAccountCheckBox();
        checkOutPage.enterPassword("J123450");
        Thread.sleep(2000);
        checkOutPage.selectDeliveryMethods("Local shipping");
        Thread.sleep(2000);
        checkOutPage.selectPaymentMethods("COD");
        Thread.sleep(2000);
        String expectedTotalText="$37.03";
        String actualTotalText=checkOutPage.getTotalText();
        Assert.assertEquals(expectedTotalText,actualTotalText);
        checkOutPage.selectPlaceOrderButton();
        Thread.sleep(2000);
        String expectedThankYouForOrderText="Thank you for your order";
        String actualThankYouForOrderText=checkOutPage.getOrderConfirmationText();
        softAssert.assertEquals(expectedThankYouForOrderText,actualThankYouForOrderText);
    }

    @Test(groups = {"sanity","regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Bestsellers");
        Thread.sleep(3000);
        bestsellersPage.mouseHoverOnSortByFilter();
        bestsellersPage.selectSortByFilter("Name A - Z");
        Thread.sleep(5000);
        bestsellersPage.selectVinylIdolzProductToAddToCart();
        Thread.sleep(5000);
        String expectedProductAddedVerifyMessage="Product has been added to your cart";
        String actualProductAddedVerifyMessage=bestsellersPage.getProductAddedVerifyMessage();
        softAssert.assertEquals(expectedProductAddedVerifyMessage,actualProductAddedVerifyMessage);
        bestsellersPage.selectCloseButtonForVerifyMessage();
        Thread.sleep(2000);
        bestsellersPage.selectYourCartButton();
        Thread.sleep(1000);
        bestsellersPage.selectViewCartButton();
        Thread.sleep(2000);
        String expectedVerifyQuantityText="Your shopping cart - 1 item";
        String actualVerifyQuantityText=cartPage.getQuantityVerifyText();
        softAssert.assertEquals(expectedVerifyQuantityText,actualVerifyQuantityText);

        cartPage.selectEmptyYourCartLink();
        String expectedAlertMessage="Are you sure you want to clear your cart?";
        String actualAlertMessage=getAlertMessageAndAcceptAlert();
        softAssert.assertEquals(expectedAlertMessage,actualAlertMessage);
        String expectedItemDeletedConfirmationMessage="Item(s) deleted from your cart";
        String actualItemDeletedConfirmationMessage=cartPage.getItemDeletedConfirmationMessage();
        Thread.sleep(1000);
        softAssert.assertEquals(expectedItemDeletedConfirmationMessage,actualItemDeletedConfirmationMessage);
        Thread.sleep(1000);
        String expectedYourCartEmptyText="Your cart is empty";
        String actualYourCartEmptyText=cartPage.getQuantityVerifyText();
        softAssert.assertEquals(expectedYourCartEmptyText,actualYourCartEmptyText);
    }
}
