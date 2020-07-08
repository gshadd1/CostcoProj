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
 
 
 @FindBy(xpath = "//div[@id='costcoModalText']/div/div/a/button")
   private WebElement returnMyOrder;
 
 @FindBy(xpath = "//div[@id='costcoModalText']/div/div[1]/a/button")
   private WebElement cancelMyOrder;
 
 @FindBy(xpath = "//div[@id='costcoModalText']/div/div[2]/a/button")
   private WebElement requestPriceAdjustment;
 
 //Column 2
 @FindBy(xpath = "//div[@id='costcoModalText']/div[2]/div/a/button")
   private WebElement verifyMyMembership;
 
 @FindBy(xpath = "//div[@id='costcoModalText']/div[2]/div[1]/a/button")
   private WebElement setupAutomaticrenewal;
 
 @FindBy(xpath = "//div[@id='costcoModalText']/div[2]/div[2]/a/button")
   private WebElement updateMembershipInfo;


 
 
   // updateMembershipInfo(

 
    public void updateMembershipInfo() {
        
        updateMembershipInfo.click();
        
    }

    public void setupAutomaticRenewal() 
         throws Exception {
        try {
        setupAutomaticrenewal.click();
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    
    public void returnMyOrder(){
    returnMyOrder.click();
    
    }

   public void cancelMyOrder(){
   cancelMyOrder.click();
   }
   
   public void requestPriceAdjustment(){
   requestPriceAdjustment.click();
   }
   
   public void verifyMyMembership(){
   verifyMyMembership.click();
   
   }
  
}
