package com.xcart.mobile.utility;


import com.xcart.mobile.basePage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility extends BasePage {

    public void clickOnElement(By by){

        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element){

        element.click();
    }

    //this method get text form element
    public String getTextFromElement(By by){

      return   driver.findElement(by).getText();

    }

    //This method get text form element by element using explicit time
    public String getTextFromElement(WebElement element){

        return   element.getText();

    }


    //this method will send text on element
    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);

    }

    public void sendTextToElement(WebElement element,String text){

        element.sendKeys(text);

    }

    public void selectByValueDropDown(By by,String value){

        //this method select value from drop down

        Select select=new Select(driver.findElement(by));

        //Select by value
        select.selectByValue(value);
    }

    public void selectByValueDropDown(WebElement element,String value){

        //this method select value from drop down
        Select select=new Select(element);
        //Select by value
        select.selectByValue(value);
    }

    //this method select visible text from drop down
    public void selectByVisibleText(By by,String visibleText){
        Select select=new Select(driver.findElement(by));
        select.selectByVisibleText(visibleText);
    }

    public void selectByVisibleText(WebElement element,String visibleText){
        Select select=new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectByIndex(By by,int index){
        Select select=new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public void selectByIndex(WebElement element,int index){
        Select select=new Select(element);
        select.selectByIndex(index);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void mouseHoverAndClickOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    //This method is used for wait until element located
    public WebElement waitUntilVisibilityOfElementLocated(By by,int timeout){

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;

    }

    //This method get the List of ProductName
    public List<String> setProductNameList(By by) throws InterruptedException {

        List<WebElement> productList= driver.findElements(by);
        List<String>  productNameList=new ArrayList<>();
        for(WebElement name:productList){
            Thread.sleep(2000);
            //productNameList.add(getTextFromElement(waitUntilVisibilityOfElementLocated(by,20)));
            productNameList.add(name.getText());
        }
        return productNameList;
    }

    //This method is for get the Price list of product
    public List<Double> setProductPriceList(By by) throws InterruptedException {

        List<WebElement> productList= driver.findElements(by);
        List<Double>  productPriceList=new ArrayList<>();
        for(WebElement name:productList){
            Thread.sleep(1000);
            productPriceList.add(Double.parseDouble(name.getText().replace("$","")));
        }
        return productPriceList;
    }

    //This method get the List of ProductRate
    public List<Double> setProductRateList(By by) throws InterruptedException {

        List<WebElement> productList = driver.findElements(by);
        List<Double> productRateList = new ArrayList<>();
        for (WebElement name : productList) {

            Thread.sleep(1000);
            String rate = name.getAttribute("style").replace("width:", "");
            productRateList.add(Double.parseDouble(rate.replace("%;","")));
        }
        return productRateList;
    }



    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }


    public int randomNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(1000);
    }

    public void changeQuantityOnElement(By by,String quantity){

        WebElement element=driver.findElement(by);
        element.clear();
        sendTextToElement(by,quantity);
    }

    //This method verify text of alert and accept alert

    public String getAlertMessageAndAcceptAlert() throws InterruptedException {

        Alert alert = driver.switchTo().alert();
        String actualTxt = alert.getText();
        alert.accept();
        return actualTxt;
    }
}
