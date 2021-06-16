package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ContactUs extends Utility {

    By pageTitleText=By.xpath("//h1[@id='page-title']");

    public String getTitleFromContactUsPage(){

        Reporter.log("Getting text from page title "+pageTitleText.toString()+"<br>");
        return getTextFromElement(pageTitleText);
    }
}
