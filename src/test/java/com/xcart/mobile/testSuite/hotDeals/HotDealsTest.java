package com.xcart.mobile.testSuite.hotDeals;

import com.xcart.mobile.pages.BestsellersPage;
import com.xcart.mobile.pages.HomePage;
import com.xcart.mobile.pages.SalePage;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage();
    SalePage salePage = new SalePage();
    BestsellersPage bestsellersPage = new BestsellersPage();

    @Test(groups = {"smoke","sanity","regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Sale");
        Thread.sleep(3000);
        String expectedTitleTextFromSalePage = "Sale";
        String actualTitleTextFromSalePage = salePage.getTitleFromSalePage();
        softAssert.assertEquals(expectedTitleTextFromSalePage, actualTitleTextFromSalePage);
        salePage.mouseHoverOnSortByFilter();
        salePage.selectSortByFilter("Name A - Z");
        Thread.sleep(3000);
        List<String> productNameList = salePage.getProductNameList();
        List<String> sortedProductNameList = new ArrayList<>(productNameList);
        Collections.sort(sortedProductNameList);
        softAssert.assertEquals(sortedProductNameList, productNameList);

    }


    @Test(groups = {"sanity","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Sale");
        Thread.sleep(3000);
        String expectedTitleTextFromSalePage = "Sale";
        String actualTitleTextFromSalePage = salePage.getTitleFromSalePage();
        softAssert.assertEquals(expectedTitleTextFromSalePage, actualTitleTextFromSalePage);
        salePage.mouseHoverOnSortByFilter();
        salePage.selectSortByFilter("Price Low - High");
        Thread.sleep(2000);
        List<Double> productPriceList = salePage.getProductPriceList();
        List<Double> sortedProductPriceList = new ArrayList<>(productPriceList);
        Collections.sort(sortedProductPriceList);
        softAssert.assertEquals(sortedProductPriceList, productPriceList);

    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Sale");
        Thread.sleep(3000);
        String expectedTitleTextFromSalePage = "Sale";
        String actualTitleTextFromSalePage = salePage.getTitleFromSalePage();
        softAssert.assertEquals(expectedTitleTextFromSalePage, actualTitleTextFromSalePage);
        salePage.mouseHoverOnSortByFilter();
        salePage.selectSortByFilter("Rates");
        Thread.sleep(2000);
        List<Double> productRateList = salePage.getProductRateList();
        List<Double> sortedProductRateList = new ArrayList<>(productRateList);
        Collections.sort(sortedProductRateList, Collections.reverseOrder());
        softAssert.assertEquals(sortedProductRateList, productRateList);


    }


    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Bestsellers");
        Thread.sleep(3000);
        String expectedTitleTextFromBestsellersPage = "Bestsellers";
        String actualTitleTextFromBestsellersPage = bestsellersPage.getPageTitleTextFromBestSellersPage();
        softAssert.assertEquals(expectedTitleTextFromBestsellersPage, actualTitleTextFromBestsellersPage);
        bestsellersPage.mouseHoverOnSortByFilter();
        bestsellersPage.selectSortByFilter("Name Z - A");
        Thread.sleep(3000);
        List<String> productNameList = bestsellersPage.getProductNameList();
        List<String> sortedProductNameList = new ArrayList<>(productNameList);
        Collections.sort(sortedProductNameList, Collections.reverseOrder());
        softAssert.assertEquals(sortedProductNameList, productNameList);

    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)

    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Bestsellers");
        Thread.sleep(3000);
        String expectedTitleTextFromBestsellersPage = "Bestsellers";
        String actualTitleTextFromBestsellersPage = bestsellersPage.getPageTitleTextFromBestSellersPage();
        softAssert.assertEquals(expectedTitleTextFromBestsellersPage, actualTitleTextFromBestsellersPage);
        bestsellersPage.mouseHoverOnSortByFilter();
        bestsellersPage.selectSortByFilter("Price High - Low");
        Thread.sleep(3000);
        List<Double> productPriceList = bestsellersPage.getProductPriceList();
        List<Double> sortedProductPriceList = new ArrayList<>(productPriceList);
        Collections.sort(sortedProductPriceList, Collections.reverseOrder());
        softAssert.assertEquals(sortedProductPriceList, productPriceList);

    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        homePage.mouseHoverOnHotDealTab();
        homePage.selectSaleOrBestSellersFromHotDealsLink("Bestsellers");
        Thread.sleep(3000);
        String expectedTitleTextFromBestsellersPage = "Bestsellers";
        String actualTitleTextFromBestsellersPage = bestsellersPage.getPageTitleTextFromBestSellersPage();
        softAssert.assertEquals(expectedTitleTextFromBestsellersPage, actualTitleTextFromBestsellersPage);
        bestsellersPage.mouseHoverOnSortByFilter();
        bestsellersPage.selectSortByFilter("Rates");
        Thread.sleep(3000);
        List<Double> productRateList = bestsellersPage.getProductRateList();
        List<Double> sortedProductRateList = new ArrayList<>(productRateList);
        Collections.sort(sortedProductRateList, Collections.reverseOrder());
        softAssert.assertEquals(sortedProductRateList, productRateList);
    }
}