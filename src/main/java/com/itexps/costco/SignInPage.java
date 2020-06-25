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
public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    //Email address
    @FindBy(id = "logonId")
    private WebElement loginid;

    //Password
    @FindBy(id = "logonPassword")
    private WebElement loginpassword;

    //Sign In button click
    @FindBy(xpath = "//input[@value='Sign In']")
    private WebElement loginclick;

    //Forgot Password Button
    @FindBy(linkText = "Forgot Password?")
    private WebElement resetpassword;

    //Create Account Button
    @FindBy(xpath = "//*[@id=\"LogonForm\"]/fieldset/div[8]/a")
    private WebElement createAcctBttn;

    public void validlogin(LoginVO loginvo)
            throws Exception {
        try {
            loginid.click();
            loginid.clear();
            loginid.sendKeys(loginvo.getUsername());
            loginpassword.click();
            loginpassword.clear();
            loginpassword.sendKeys(loginvo.getPassword());
            loginclick.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void validkirklogin(String email, String password)
            throws Exception {
        try {
            loginid.click();
            loginid.clear();
            loginid.sendKeys(email);
            loginpassword.click();
            loginpassword.clear();
            loginpassword.sendKeys(password);
            loginclick.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void invalidlogin(String email, String password)
            throws Exception {
        try {
            loginid.click();
            loginid.clear();
            loginid.sendKeys(email);
            loginpassword.click();
            loginpassword.clear();
            loginpassword.sendKeys(password);
            loginclick.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void resetpassword(String email)
            throws Exception {
        try {
            loginid.click();
            loginid.clear();
            loginid.sendKeys(email);
            resetpassword.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createacctbttn()
            throws Exception {
        try {
            createAcctBttn.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
