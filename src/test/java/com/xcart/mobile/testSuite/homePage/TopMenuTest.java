package com.xcart.mobile.testSuite.homePage;

import com.xcart.mobile.pages.*;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/*

    test will failed at last line for test retry analyzer
     String expectedContactUsPageTitleText="Contact us  !";
 */


public class TopMenuTest extends TestBase {

    SoftAssert softAssert=new SoftAssert();
    HomePage homePage=new HomePage();
    ShippingPage shippingPage=new ShippingPage();
    NewArrivals newArrivals=new NewArrivals();
    ComingSoonPage comingSoonPage=new ComingSoonPage();
    ContactUs contactUs=new ContactUs();

    @Test(groups = {"smoke","sanity","regression"})
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {

        homePage.selectTopMenuTab("Shipping");
        Thread.sleep(2000);
        String expectedShippingPageTitleText="Shipping";
        String actualShippingPageTitleText=shippingPage.getTitleTextFromShippingPage();
        softAssert.assertEquals(expectedShippingPageTitleText,actualShippingPageTitleText);
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {

        homePage.selectTopMenuTab("New!");
        Thread.sleep(2000);
        String expectedNewArrivalsPageTitleText="New arrivals";
        String actualNewArrivalsPageTitleText=newArrivals.getTitleTextFromNewArrivalsPage();
        softAssert.assertEquals(expectedNewArrivalsPageTitleText,actualNewArrivalsPageTitleText);
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully() throws InterruptedException {

        homePage.selectTopMenuTab("Coming soon");
        Thread.sleep(2000);
        String expectedComingSoonPageTitleText="Coming soon";
        String actualComingSoonPageTitleText=comingSoonPage.getTitleTextFromComingSoonPage();
        softAssert.assertEquals(expectedComingSoonPageTitleText,actualComingSoonPageTitleText);
    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {

        homePage.selectTopMenuTab("Contact us");
        Thread.sleep(3000);
        String expectedContactUsPageTitleText="Contact us  !";
        String actualContactUsPageTitleText=contactUs.getTitleFromContactUsPage();
        Assert.assertEquals(expectedContactUsPageTitleText,actualContactUsPageTitleText);

    }

}
