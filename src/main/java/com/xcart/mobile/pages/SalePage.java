package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class SalePage extends Utility {

    By pageTitleText=By.xpath("//h1[@id='page-title']");
    By sortByFilter=By.xpath("//div[@class='sort-box']");
    By filterDropDown=By.xpath("//ul[@class='display-sort sort-crit grid-list']//li//a");
    By productNameList=By.xpath("//div[@class='items-list items-list-products sale-products']//h5");
    By productPriceList=By.xpath("//div[@class='items-list items-list-products sale-products']//span[@class='price product-price']");
    By productRateList=By.xpath("//div[@class='products']//div[@class='stars-row full']");
    By avengersAddToCartButton =By.xpath("(//button[@type='button'])[4]");
    By productAddedVerifyTextLink =By.xpath("//li[contains(text(),'Product has been added to your cart')]");
    By closeVerifyButton=By.xpath("//a[@class='close']");
    By yourCartIcon=By.xpath("//div[@title='Your cart']");
    By viewCartButton=By.xpath("//span[contains(text(),'View cart')]");



    public String getTitleFromSalePage(){
        Reporter.log("Getting Page title Text"+pageTitleText.toString()+"<br>");
        return getTextFromElement(pageTitleText);
    }


    public void mouseHoverOnSortByFilter(){
        Reporter.log("Mouse Hover on Sort by filter Link"+sortByFilter+"<br>");
        mouseHoverToElement(sortByFilter);
    }

    public void selectSortByFilter(String filter) throws InterruptedException {

        List<WebElement> filterList=driver.findElements(filterDropDown);
        for(WebElement element:filterList){
            Thread.sleep(1000);
            Reporter.log("Getting text from element "+element.toString()+" and compare it with "+filter+"<br>");
            if(element.getText().trim().equalsIgnoreCase(filter)){
                Reporter.log("Clicking on element "+element.toString()+"<br>");
                mouseHoverAndClickOnElement(element);
                break;
            }
        }
    }

    public List<String> getProductNameList() throws InterruptedException {
        Reporter.log("Getting List of Product name "+productNameList.toString()+"<br>");
        return setProductNameList(productNameList);
    }

    public List<Double> getProductPriceList() throws InterruptedException {
        Reporter.log("Getting List of product price "+productPriceList.toString()+"<br>");
        return setProductPriceList(productPriceList);
    }

    public List<Double> getProductRateList() throws InterruptedException {
        Reporter.log("Getting List of product rates "+productRateList.toString()+"<br>");
        return setProductRateList(productRateList);
    }

    public void selectAvengersAddToCartButton(){
        Reporter.log("Clicking add to cart button of avengers "+avengersAddToCartButton.toString()+"<br>");
        mouseHoverAndClickOnElement(avengersAddToCartButton);
    }

    public String getTextFromVerifyMessage(){
        Reporter.log("Getting product verify message "+productAddedVerifyTextLink.toString()+"<br>");
        return getTextFromElement(productAddedVerifyTextLink);
    }

    public void closeVerifyButton(){
        Reporter.log("Clicking on verify message close button "+closeVerifyButton.toString()+"<br>");
        clickOnElement(closeVerifyButton);
    }

    public void selectYourCartButton(){
        Reporter.log("Clicking on your cart button "+yourCartIcon.toString()+"<br>");
        clickOnElement(yourCartIcon);
    }

    public void selectViewCartButton(){
        Reporter.log("Clicking on view your cart button");
        clickOnElement(viewCartButton);
    }
}
