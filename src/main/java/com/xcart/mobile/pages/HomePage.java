package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    By topMenuTab=By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span");
    By welcomeText=By.xpath("//h1[contains(text(),'Welcome to X-Cart Demo Store!')]");
    By hotDealsLink=By.xpath("(//li[@class='leaf has-sub']/child::span[text()='Hot deals'])[2]");
    By saleLink=By.xpath("(//span[text()='Sale'])[2]");
    By hotDealsDropDownLink=By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li//ul//li//span");

    public void selectTopMenuTab(String menu) {

        List<WebElement> menuList = driver.findElements(topMenuTab);
        for (WebElement element : menuList) {
            Reporter.log("Getting text "+element.getText()+"From element "+element.toString()+" and compare it with top tab "+topMenuTab+"<br>");
            if (element.getText().equalsIgnoreCase(menu)) {
                Reporter.log("Clicking on element "+element.toString()+"<br>");
                element.click();
                break;
            }
        }
    }

    public String getActualText() {
        Reporter.log("Getting welcome text "+welcomeText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(welcomeText, 30).getText();
    }

    public void mouseHoverOnHotDealTab(){
        Reporter.log("Mouse hover and clicking on hot deal link "+hotDealsLink.toString()+"<br>");
        mouseHoverToElement(hotDealsLink);
    }

    public void selectSaleOrBestSellersFromHotDealsLink(String hotDealsDropDown){

        List<WebElement> hotDeal=driver.findElements(hotDealsDropDownLink);
        for(WebElement list:hotDeal){
            Reporter.log("Getting text from hot deal drop down "+list.toString()+" and compare it with hot deal drop down "+hotDealsDropDown+"<br>");
            if(list.getText().equalsIgnoreCase(hotDealsDropDown)){
                Reporter.log("Mouse hover and clicking on element"+list.toString()+"<br>");
                mouseHoverAndClickOnElement(list);
                break;
            }
        }

    }
}
