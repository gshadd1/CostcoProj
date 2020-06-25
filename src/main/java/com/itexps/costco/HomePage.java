/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.costco;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author 16309
 */
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Search Box
    @FindBy(id = "search-field")
    private WebElement searchBox;

    //SignIn - Register click select
    @FindBy(id = "header_sign_in")
    private WebElement signInclick;

    //Cart - Register click select
    @FindBy(id = "cart-d")
    private WebElement cartclick;

    public void search(String text)
            throws Exception {
        try {
            searchBox.click();
            searchBox.clear();
            searchBox.sendKeys(text);
            searchBox.sendKeys(Keys.ENTER);

            //   LoginPage login = new LoginPage(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void signinbttn()
            throws Exception {
        try {
            signInclick.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cartbttn()
            throws Exception {
        try {
            cartclick.click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
