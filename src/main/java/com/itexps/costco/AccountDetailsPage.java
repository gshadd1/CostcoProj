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
 * @author 16309
 */
public class AccountDetailsPage {

    WebDriver driver;

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //My Account click select
    @FindBy(xpath = "//*[@id=\"myaccount-d\"]")
    private WebElement myAcctclick;

    //Account Details click select
    @FindBy(linkText = "Account Details")
    private WebElement acctDetailsclick;

    //Edit Phone click
    @FindBy(id = "edit-phone")
    private WebElement editphoneclick;

    //Phone Text Box
    @FindBy(id = "update-phone")
    private WebElement phone;

    //Update Phone button click
    @FindBy(id = "update-primary-phone-btn")
    private WebElement phoneupdate;

    //Edit Mobile click
    @FindBy(id = "edit-mobile-phone")
    private WebElement editmobileclick;

    //Mobile Text Box
    @FindBy(id = "update-mobile")
    private WebElement mobile;

    //Update Mobile button click
    @FindBy(id = "update-primary-mobile-phone-btn")
    private WebElement mobileupdate;

    //Edit Address click
    @FindBy(id = "edit-address")
    private WebElement editaddressclick;

    //Street Text Box
    @FindBy(id = "update-line1")
    private WebElement street;

    //ZIP Text Box
    @FindBy(id = "update-zip")
    private WebElement zip;

    //City Text Box
    @FindBy(id = "update-city")
    private WebElement city;

    //State Text Box
    @FindBy(id = "update-state")
    private WebElement state;

    //Update Address button click
    @FindBy(id = "update-primary-address-btn")
    private WebElement addressupdate;

    //Edit Email click
    @FindBy(xpath = "//*[@id=\"primary-membership-email-block\"]/div/div[2]/a")
    private WebElement editemailclick;

    //Email Text Box
    @FindBy(id = "update-membership-email")
    private WebElement email;

    //Update Email button click
    @FindBy(id = "update-primary-email-btn")
    private WebElement emailupdate;
    
    public void updatephone(String phonenum)
            throws Exception {
        try {

            myAcctclick.click();
            acctDetailsclick.click();
            editphoneclick.click();
            phone.clear();
            phone.sendKeys(phonenum);
            phone.submit();
            editphoneclick.click();
            phoneupdate.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updatemobile(String mobilenum)
            throws Exception {
        try {

            myAcctclick.click();
            acctDetailsclick.click();
            editmobileclick.click();
            mobile.clear();
            mobile.sendKeys(mobilenum);
            mobile.submit();
            editmobileclick.click();
            mobileupdate.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateemail(String newemail)
            throws Exception {
        try {

            myAcctclick.click();
            acctDetailsclick.click();
            editemailclick.click();
            email.clear();
            email.sendKeys(newemail);
            email.submit();
            editemailclick.click();
            emailupdate.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
