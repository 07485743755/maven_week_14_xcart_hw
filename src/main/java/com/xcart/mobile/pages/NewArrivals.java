package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class NewArrivals extends Utility {

    By pageTitleText=By.xpath("//h1[@id='page-title']");

    public String getTitleTextFromNewArrivalsPage(){
        Reporter.log("Getting page title text "+pageTitleText.toString()+"<br>");
        return getTextFromElement(pageTitleText);
    }
}
