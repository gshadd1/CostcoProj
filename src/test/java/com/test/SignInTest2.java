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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
            chromeDriverPath = "C:\\data\\chromedriver.exe";
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
    driver.findElement(By.id("logonId")).sendKeys("gshadd@bademail.com");
    driver.findElement(By.id("logonPassword")).click();
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();  
  //  WebElement textfiled = driver.findElement(By.className("critical-notification"));
  //  Assert.assertEquals("There was a problem with your information. Please try again.", textfiled );
   
      }
}