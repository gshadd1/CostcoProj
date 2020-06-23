package com.playground;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author gregshadd
 */
public class GregTest {
    private WebDriver driver;
  private String baseURL;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
    
    public GregTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         String chromeDriverPath;
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        if (os.equals("Mac OS X")) {
            chromeDriverPath = "/Users/gregshadd/Downloads/chromedriver 3";
        } else {
            chromeDriverPath = "C:\\QA\\Drivers\\chromedriver.exe";
           
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        baseURL = "https://www.costco.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
       driver.quit();
    }

     @Test
  public void test22FindSpecificPage() throws Exception {
    driver.get("https://www.costco.com/");
   // driver.findElement(By.id("warehouse-search-field-desktop")).click();
   // driver.findElement(By.id("warehouse-search-field-desktop")).clear();
  //  driver.switchTo().alert().sendKeys("hanover park, il 60133");
    //driver.findElement(By.id("warehouse-search-field-desktop")).sendKeys("hanover park, il 60133");
    
  
  
 // driver.get("http://seleniumpratise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html");
 
 WebElement ele = driver.findElement(By.id("warehouse-locations-dropdown"));
  Actions act = new Actions(driver);
  act.moveToElement(ele).perform();
 
    driver.findElement(By.id("warehouse-search-field-desktop")).click();
    driver.findElement(By.id("warehouse-search-field-desktop")).clear();
    driver.findElement(By.id("warehouse-search-field-desktop")).sendKeys("60133");
   //  driver.findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
  
   WebElement ele2 = driver.findElement(By.xpath("//input[@value='Find a Warehouse']"));
  
   act= new Actions(driver);
   act.moveToElement(ele2).perform();
  // driver.findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
   
  driver.switchTo().activeElement().findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
  
  
   // driver.switchTo().alert().sendKeys("hanover park, il 60133");
    //driver.findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
   // driver.findElement(By.xpath("(//img[@alt='Costco US homepage'])[2]")).click();
   // driver.findElement(By.id("warehouse-savings")).click();
   // driver.findElement(By.xpath("//img[@alt='Costco US homepage']")).click();
   // driver.findElement(By.id("customer-service-link")).click();
   // driver.findElement(By.id("yui_3_18_1_6_1592166786155_6")).click();
  }
  
     @Test
  public void test30CostcotravelForm() throws Exception {
    driver.get("https://www.costco.com/");
    driver.findElement(By.xpath("//img[@alt='Costco US homepage']")).click();
    driver.findElement(By.id("Home_Ancillary_6")).click();
    driver.findElement(By.linkText("Jamaica Vacations")).click();
    driver.findElement(By.id("packageSearchWidget_search")).click();
    driver.findElement(By.xpath("//div[@id='custompath_search_results']/div/div/div/div/p")).click();
  }
  
  

}
