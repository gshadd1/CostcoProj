package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itexps.costco.FileUtil;
import com.itexps.costco.LoginVO;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author gregshadd
 */
public class SignInTest2 {

    private WebDriver driver;
    private String baseURL;
    private String chromeDriverPath;
    private static LoginVO login = null;

    public SignInTest2() {
    }

    @BeforeClass
    public static void setUpClass() {
         login=FileUtil.getLoginData();
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
    }

//Test  line 14 My Account try invaild  phone#,email format 
    //  @Test
    public void testInvalidPhoneNumber() throws Exception {
        driver.get(baseURL);

        Thread.sleep(2000);
        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oracle");
        // driver.findElement(By.name("site-search")).submit();
    }

    @Test  

      public void testInvalidEmail() throws Exception{
          
      
    driver.get(baseURL);
   // driver.get("https://www.costco.com/");
    driver.findElement(By.id("header_sign_in")).click();
    driver.findElement(By.id("logonPassword")).click();
    driver.findElement(By.id("logonPassword")).clear();
    driver.findElement(By.id("logonPassword")).sendKeys("7520513Co!");
    driver.findElement(By.id("logonId")).click();
    driver.findElement(By.id("logonId")).clear();
    driver.findElement(By.id("logonId")).sendKeys("zgshadd@bademail.com");
    driver.findElement(By.id("logonPassword")).click();
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();  
  //  WebElement textfiled = driver.findElement(By.className("critical-notification"));
  //  Assert.assertEquals("There was a problem with your information. Please try again.", textfiled );
   
  //*****************************
 }
      
  @Test
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
   act= new Actions(driver);
   act.moveToElement(ele2).perform(); 
   driver.switchTo().activeElement().findElement(By.xpath("//input[@value='Find a Warehouse']")).click();
   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   
 //  String loc = driver.findElement(By.className("warehouse-name")).getText();
     String loc = driver.findElement(By.className("col-xx-12")).getText();
     assertEquals("Find a Warehouse",loc);
 
  // assertEquals("Bloomingdale", loc);
  }
    
    //////////
     //@Test
  public void test22bCustomerservice() throws Exception {
    driver.get(baseURL);
    WebElement ele = driver.findElement(By.id("customer-service-link"));
    ele.click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   String ele2 = driver.findElement(By.id("cs_SubTitle")).getText();
   assertEquals("Welcome to Costco Customer Service.", ele2);
  }
  
  //@Test
  public void test22cEmailOffer() throws Exception{
  driver.get(baseURL);
  WebElement ele = driver.findElement(By.id("email-signup-link"));
  ele.click();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  String ele2 = driver.findElement(By.xpath("//div[@class='headingContainer']")).getText();
  assertEquals("Be the first to know - subscribe to receive Costco emails.", ele2);
   }
  
  //@Test
  public void test27InValidZipAccepted(){
  driver.get(baseURL);
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  WebElement ele = driver.findElement(By.id("delivery-postal-change"));
  Actions act = new Actions(driver);
  act.moveToElement(ele).perform();
  
   driver.findElement(By.id("postal-code-input")).click();
   driver.findElement(By.id("postal-code-input")).clear();
   driver.findElement(By.id("postal-code-input")).sendKeys("6013A");
  
  }
  
  //@Test
  public void test26ValidZipAccepted() throws InterruptedException{
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
   
    String ele2 = driver.findElement(By.xpath("//*[@id='delivery-postal-label']")).getText();
     
     driver.navigate().refresh();
      String ele3 = driver.findElement(By.xpath("//*[@id='delivery-postal-label']")).getText();
   
    //  Thread.sleep(2000);
    //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    assertEquals("Delivery ZIP Code: 70001", ele3);
  //  driver.findElement(By.xpath("(//button[@type='button'])[53]")).click();
  //  driver.findElement(By.id("delivery-postal-change")).click();
  
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

  //private String  closeAlertAndGetItsText() {
   // try {
    //  Alert alert = driver.switchTo().alert();
    //  String alertText = alert.getText();
    //  if (acceptNextAlert) {
     //   alert.accept();
    //  }
    //else {
       // alert.dismiss();
     // }
     // return alertText;
    //} finally {
     // acceptNextAlert = true;
   // }
 //  return "not working";
 // }


}