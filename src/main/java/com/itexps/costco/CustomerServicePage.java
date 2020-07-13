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
 //"//div[@id='selfServiceColumns']/ul/a/li"
 
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul/a/li")
   private WebElement returnMyOrder;
 
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul/a[2]/li")
   private WebElement cancelMyOrder;
 
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul/a[3]/li")
   private WebElement requestPriceAdjustment;
 
 //Column 2
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul[2]/a/li")
   private WebElement verifyMyMembership;
 
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul[2]/a[2]/li")
   private WebElement setupAutomaticrenewal;
 
 @FindBy(xpath = "//div[@id='selfServiceColumns']/ul[2]/a[3]/li")
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
