package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class CartPage extends Utility {

    By productQuantityVerifyTextLink=By.xpath("//h1[@id='page-title']");
    By quantityLink=By.xpath("//input[contains(@id,'amount')]");
    By subTotalLink=By.xpath("(//li[@class='subtotal'])[1]");
    By totalLink=By.xpath("(//span[@class='surcharge-cell'])[7]");
    By goToCheckOutButton=By.xpath("//span[contains(text(),'Go to checkout')]");
    By emptyYourCartLink =By.xpath("//a[contains(text(),'Empty your cart')]");
    By itemDeletedConfirmationMessageLink=By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]");


    public String getQuantityVerifyText(){

        Reporter.log("Getting text from productQuantityVerifyLink "+productQuantityVerifyTextLink.toString()+"<br>");
        return getTextFromElement(productQuantityVerifyTextLink);
    }

    public void changeQuantity(String quantity){

        Reporter.log("Change quantity on quantity link "+quantityLink.toString()+"Quantity is"+quantity.toString()+"<br>");
       changeQuantityOnElement(quantityLink,quantity);
    }

    public String getTextFromSubTotal(){
        Reporter.log("Getting text from sub total link "+subTotalLink.toString()+"<br>");
        return getTextFromElement(subTotalLink);
    }

    public String getTextFromTotal(){
        Reporter.log("Getting text from total link "+totalLink.toString()+"<br>");
        return getTextFromElement(totalLink);
    }

    public void selectGoToCheckOutButton(){
        Reporter.log("Clicking on go to checkout button "+goToCheckOutButton.toString()+"<br>");
        clickOnElement(goToCheckOutButton);
    }

    public void selectEmptyYourCartLink(){
        Reporter.log("Clicking on empty your cart link "+emptyYourCartLink.toString()+"<br>");
        clickOnElement(emptyYourCartLink);
    }

    public String getItemDeletedConfirmationMessage(){
        Reporter.log("Getting text from item deleted confirmation "+itemDeletedConfirmationMessageLink.toString()+"<br>");
        return getTextFromElement(itemDeletedConfirmationMessageLink);
    }
}
