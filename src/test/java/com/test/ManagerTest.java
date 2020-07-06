/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.itexps.costco.CustomerServicePage;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gregshadd
 */
public class ManagerTest {

    private WebDriver driver;
    private String baseURL;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public ManagerTest() {
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
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1600, 900));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

 //   @Test
    public void test22FindAWarehouse() throws Exception {
        //Finding warehouse by a given zip code
        driver.get(baseURL);
        WebElement ele = driver.findElement(By.id("warehouse-locations-dropdown"));
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
        driver.findElement(By.id("warehouse-search-field-desktop")).click();
        driver.findElement(By.id("warehouse-search-field-desktop")).clear();
        driver.findElement(By.id("warehouse-search-field-desktop")).sendKeys("60133");
        WebElement ele2 = driver.findElement(By.xpath("//input[@value='Find a Warehouse']"));
        act = new Actions(driver);
        act.moveToElement(ele2).perform();
        driver.switchTo().activeElement().findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        String loc = driver.findElement(By.className("col-xx-12")).getText();
        assertEquals("Find a Warehouse", loc);

        // assertEquals("Bloomingdale", loc);
    }

    @Test
    //Working last tested on 6-23
    public void test22bCustomerservice() throws Exception {
        driver.get(baseURL);
        WebElement ele = driver.findElement(By.id("customer-service-link"));
        ele.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String ele2 = driver.findElement(By.id("cs_SubTitle")).getText();
        assertEquals("Welcome to Costco Customer Service.", ele2);
    }

    @Test
    public void test22cEmailOffer() throws Exception {
        driver.get(baseURL);
        WebElement ele = driver.findElement(By.id("email-signup-link"));
        ele.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String ele2 = driver.findElement(By.xpath("//div[@class='headingContainer']")).getText();
        assertEquals("Be the first to know - subscribe to receive Costco emails.", ele2);
    }

//    @Test
    //Note Postal code some sometimes do not show on website
    public void test27InValidZipNotAccepted() {
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//img[@alt='Costco US homepage']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("delivery-postal-change")).click();
        driver.findElement(By.id("postal-code-input")).click();
        driver.findElement(By.id("postal-code-input")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("postal-code-input")).sendKeys("7000A");
        driver.findElement(By.id("postal-code-submit")).click();
        WebElement element = driver.findElement(By.className("en"));
        String r1 = (element.getText().toString());
        boolean r2 = element.getText().contains("Enter A Valid Zip Code");
        System.out.println("r2 value is " + r2);
        // assertEquals("Delivery ZIP Code: 70001", cl);
        //    System.out.println(r1); 
        //  String expectedMessage = "Enter A Valid Zip Code";
        // String message = driver.findElement(By.xpath("//div[contains(@class,'en')]")).getText();
        // System.out.println(message);
        //assertEquals(expectedMessage, r1.contains(expectedMessage));
        //  String text = "Enter A Valid Zip Code";
        // Select select = new Select(element);
        //   System.out.println("select Greg " + select);
        //  select.selectByVisibleText(text);
        //  WebElement newSelectedOption = select.getFirstSelectedOption();

        // assertEquals(text, newSelectedOption.getText().trim());
    }

    @Test
    public void test26ValidZipAccepted() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.findElement(By.xpath("//img[@alt='Costco US homepage']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("delivery-postal-change")).click();
        driver.findElement(By.id("postal-code-input")).click();
        driver.findElement(By.id("postal-code-input")).clear();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("postal-code-input")).sendKeys("70001");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("postal-code-submit")).click();
        driver.findElement(By.id("costcoModalBtn2")).click();
        driver.navigate().refresh();
        String ele3 = driver.findElement(By.xpath("//*[@id='delivery-postal-label']")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='delivery-postal-label']")));
        System.out.println(ele3);
        assertEquals("Delivery ZIP Code: 70001", ele3);
    }

 //   @Test
    public void test30CostcotravelForm() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.xpath("//img[@alt='Costco US homepage']")).click();
        driver.findElement(By.id("Home_Ancillary_6")).click();
        driver.findElement(By.linkText("Jamaica Vacations")).click();
        driver.findElement(By.id("packageSearchWidget_search")).click();
        driver.findElement(By.xpath("//div[@id='custompath_search_results']/div/div/div/div/p")).click();

    }
    
    
       // @Test
    public void testUpdateMembershipInfo() throws Exception{
    
      driver.manage().window().maximize();
        CustomerServicePage csp = PageFactory.initElements(driver, CustomerServicePage.class);
      driver.get( "https://customerservice.costco.com/");
       csp.updateMembershipInfo();             
      String parent = driver.getWindowHandle();
      Set<String> allWindows= driver.getWindowHandles();
       for(String child:allWindows){
       
       if(!parent.equalsIgnoreCase(child))
       {
              driver.switchTo().window(child);
       }  
       }
       assertEquals("How can I make changes to my membership account?", driver.getTitle());
    }
  
    //@Test
        public void testSetupAutomaticRenewal() throws Exception{
    
       driver.manage().window().maximize();
        CustomerServicePage csp = PageFactory.initElements(driver, CustomerServicePage.class);
      driver.get( "https://customerservice.costco.com/");
       csp.setupAutomaticRenewal();           
      String parent = driver.getWindowHandle();
      Set<String> allWindows= driver.getWindowHandles();
       for(String child:allWindows){
       
       if(!parent.equalsIgnoreCase(child))
       {
              driver.switchTo().window(child);
       }  
       }
       assertEquals("How can I manage membership Auto Renewal online?", driver.getTitle());
    }

    

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
