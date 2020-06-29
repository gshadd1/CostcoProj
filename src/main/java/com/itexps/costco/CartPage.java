/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.costco;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author 16309
 */
public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
   @FindBy(id = "add-to-cart-btn")
   private WebElement addToCart;
   
   @FindBy(xpath = "//div[@id='costcoModalText']/div[2]/div[2]/a/button")
   private WebElement viewCart;
   
   @FindBy(id = "shopCartCheckoutSubmitButton")
   private WebElement checkout;
   
   @FindBy(xpath = "//div[@id='logon']/div/div/div/div")
   private WebElement login;
   
   @FindBy(id="Home_Ancillary_0")
   private WebElement groceryButton;
   
   public void addToCartFunction() throws InterruptedException{
        addToCart.click();
        Thread.sleep(3000);
        viewCart.click();
        Thread.sleep(15000);//page object by shruti
        checkout.click();
        Thread.sleep(3000);
        login.click();
        assertEquals("Sign in to access your Costco.com account.", driver.findElement(By.xpath("//form[@id='LogonForm']/fieldset/div/span")).getText());
   
   }
                               //passing product name here as String in next line
   public void addAnItemTOCart(String productName) throws InterruptedException{
        Thread.sleep(3000);
        groceryButton.click();
        Thread.sleep(5000);
        driver.findElement(By.linkText(productName)).click(); // this function will add two product so made afunction here page object by shruti
        addToCart.click();
        Thread.sleep(3000);
        viewCart.click();//view cart
   }
}
