package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class CheckOutPage extends Utility {

    By verifyLogInText=By.xpath("//h3[contains(text(),'Log in to your account')]");
    By emailField=By.xpath("//input[@id='email']");
    By continueButton=By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']");
    By secureCheckOutText=By.xpath("//h1[contains(text(),'Secure Checkout')]");
    By firstNameField=By.xpath("//input[@id='shippingaddress-firstname']");
    By lastNameField=By.xpath("//input[@id='shippingaddress-lastname']");
    By addressField=By.xpath("//input[@id='shippingaddress-street']");
    By cityField=By.xpath("//input[@id='shippingaddress-city']");
    By countryField=By.xpath("//select[@id='shippingaddress-country-code']");
    By stateField=By.xpath("//input[@id='shippingaddress-custom-state']");
    By zipCodeField=By.xpath("//input[@id='shippingaddress-zipcode']");
    By createAccountCheckBox=By.xpath("//input[@id='create_profile']");
    By passwordField=By.xpath("//input[@id='password']");
    By deliveryMethods=By.xpath("//ul[@class='shipping-rates']//li//div//label");
    By paymentMethods=By.xpath("//ul[@class='payments']//span");
    By totalLink=By.xpath("(//span[@class='surcharge-cell'])[6]");
    By placeOrderButton=By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");
    By orderConfirmationText=By.xpath("//h1[@id='page-title']");


    public String getLoginVerifyText(){
        Reporter.log("Getting text from verify login text "+verifyLogInText.toString()+"<br>");
        return getTextFromElement(verifyLogInText);
    }

    public void enterEmailId(String userName,String domainName){
        Reporter.log("Send email "+userName+randomNumber()+domainName+" to email field"+emailField.toString()+"<br>");
        sendTextToElement(emailField,userName+randomNumber()+domainName);
    }

    public void selectContinueButton(){
        Reporter.log("Clicking on continue button "+continueButton.toString()+"<br>");
        clickOnElement(continueButton);
    }

    public String getSecureCheckOutText(){
        Reporter.log("Getting text from secure checkout "+secureCheckOutText.toString()+"<br>");
        return getTextFromElement(secureCheckOutText);
    }

    public void enterFirstName(String firstName){
        Reporter.log("Enter first name "+firstName+" In first name field "+firstNameField.toString()+"<br>");
        sendTextToElement(firstNameField,firstName);
    }

    public void enterLastName(String lastName){
        Reporter.log("Enter last name "+lastName+" in last name field "+lastNameField.toString()+"<br>");
        sendTextToElement(lastNameField,lastName);
    }

    public void enterAddress(String address){
        Reporter.log("Enter address "+address+" in address field "+addressField.toString()+"<br>");
        sendTextToElement(addressField,address);
    }

    public void enterCityName(String city){

        WebElement element=driver.findElement(cityField);
        element.clear();
        Reporter.log("Send city name "+city+" In city field "+cityField.toString()+"<br>");
        element.sendKeys(city);
    }

    public void selectCountryName(String visibleText){

        Reporter.log("Select country "+visibleText+" in country field"+countryField.toString());
        selectByVisibleText(countryField,visibleText);
    }

    public void enterStateName(String state){
        Reporter.log("Send text state "+state+" In state field "+stateField.toString()+"<br>");
        sendTextToElement(stateField,state);
    }

    public void enterZipCode(String zipCode){

        WebElement element=driver.findElement(zipCodeField);
        element.clear();
        Reporter.log("Enter zip code "+zipCode+" in zip code field "+zipCodeField.toString()+"<br>");
        element.sendKeys(zipCode);
    }

    public void selectCreateAccountCheckBox(){
        Reporter.log("Clicking on create account check box "+createAccountCheckBox.toString()+"<br>");
        clickOnElement(createAccountCheckBox);
    }

    public void enterPassword(String password){
        Reporter.log("Send password "+password+"In password field "+passwordField.toString()+"<br>");
        sendTextToElement(passwordField,password);
    }

    public void selectDeliveryMethods(String deliveryMethod){

        List<WebElement> methodList=driver.findElements(deliveryMethods);
        for(WebElement element:methodList){
            Reporter.log("Getting attribute value of title "+element.toString()+" compare it with delivery method "+deliveryMethod+"<br>");
           if( element.getAttribute("title").equalsIgnoreCase(deliveryMethod)){
               Reporter.log("Mouse hover and clicking on element "+element.toString()+"<br>");
               mouseHoverAndClickOnElement(element);
               break;
           }
        }
    }

    public void selectPaymentMethods(String paymentMethod){

        List<WebElement> paymentMethodList=driver.findElements(paymentMethods);
        for(WebElement element:paymentMethodList){
            Reporter.log("Getting text "+element.getText()+" from element "+element.toString()+"And compare with payment method "+paymentMethod+"<br>");
            if ((element.getText().equalsIgnoreCase(paymentMethod))){
                Reporter.log("Mouse hover and click on element "+element.toString()+"<br>");
                mouseHoverAndClickOnElement(element);
                break;
            }
        }
    }

    public String getTotalText(){
        Reporter.log("Getting text from Total link "+totalLink.toString()+"<br>");
        return getTextFromElement(totalLink);
    }
    public void selectPlaceOrderButton(){
        Reporter.log("Mouse hover and click on place order button "+placeOrderButton.toString()+"<br>");
        mouseHoverAndClickOnElement(placeOrderButton);
    }

    public String getOrderConfirmationText(){
        Reporter.log("Getting text from order confirmation "+orderConfirmationText.toString()+"<br>");
        return getTextFromElement(orderConfirmationText);
    }
}
