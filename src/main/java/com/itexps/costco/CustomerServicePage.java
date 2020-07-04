/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.costco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author gregshadd
 */
public class CustomerServicePage {
    //Adding greg shaddd
    WebDriver driver;

    public CustomerServicePage(WebDriver driver) {
        this.driver = driver;
    }
 @FindBy(xpath = "//div[@id='costcoModalText']/div[2]/div[2]/a/button")
   private WebElement updateMembershipInfo;
   // updateMembershipInfo(

    public void updateMembershipInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
