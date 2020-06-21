package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itexps.costco.FileUtil;
import com.itexps.costco.LoginVO;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author gregshadd
 */
public class SignInTest {

    private WebDriver driver;
    private String baseURL;
    private static LoginVO login = null;

    public SignInTest() {
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
        driver.close();
    }

    @Test
    public void test49ValidEmailCorrectPassword() {
        // webscraper.saksham@gmail.com
        // icemountain123
        driver.get(baseURL);
        WebElement signIn = driver.findElement(By.id("header_sign_in"));
        signIn.click();
        WebElement emailAddress = driver.findElement(By.id("logonId"));
        emailAddress.clear();
        driver.findElement(By.id("logonId")).sendKeys(login.getUsername());    ///data driven
        //logonPassword
        WebElement passWord = driver.findElement(By.id("logonPassword"));
        passWord.clear();
        driver.findElement(By.id("logonPassword")).sendKeys(login.getPassword());
        WebElement signINBox = driver.findElement(By.cssSelector("#LogonForm > fieldset > div:nth-child(5) > input"));
        signINBox.click();

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,250)", "");
    }
    @Test
    public void test50ValidEmailInCorrectPassword() {
        // webscraper.saksham@gmail.com
        // icemountain123
        driver.get(baseURL);
        WebElement signIn = driver.findElement(By.id("header_sign_in"));
        signIn.click();
        WebElement emailAddress = driver.findElement(By.id("logonId"));
        emailAddress.clear();
        driver.findElement(By.id("logonId")).sendKeys(login.getUsername());   //data driven
        //logonPassword
        WebElement passWord = driver.findElement(By.id("logonPassword"));
        passWord.clear();
        driver.findElement(By.id("logonPassword")).sendKeys("zicemountain");
        WebElement signINBox = driver.findElement(By.cssSelector("#LogonForm > fieldset > div:nth-child(5) > input"));
        signINBox.click();

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,250)", "");
    }
    
    @Test
    public void test51WrongEmail() {
        driver.get(baseURL);
        //driver.manage().window().maximize();

        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("zbadlogin@gmail.com");
        driver.findElement(By.id("logonPassword")).click();
        driver.findElement(By.id("logonPassword")).clear();
        driver.findElement(By.id("logonPassword")).sendKeys("123###XXX");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();

        String loginfailtext = driver.findElement(By.xpath("//*[@id=\"logon\"]/div/div/div[1]")).getText();
        assertEquals("There was a problem with your information. Please try again.", loginfailtext);
        //String urltitle = driver.getCurrentUrl();
        //assertEquals("https://www.costco.P&ddkey=http%3ALogon", urltitle);

    }

   @Test
    public void test52ResetPassword() {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("zpassxxwdreset@aol.com");
        driver.findElement(By.linkText("Forgot Password?")).click();

        String title = driver.getTitle();
        assertEquals("Forgot Your Password?", title);
    }
    
    @Test
    public void testValidSignIn() throws Exception {
        // Add item and view cart before logging in
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(20,250)");
        driver.get(baseURL); 
        driver.findElement(By.xpath("//a[@id=\"header_sign_in\"]")).click(); //X-path manual add quantity 
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys(login.getUsername());
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys(login.getPassword());
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).submit(); //submit by pressing enter
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Costco Wholesale";
        System.out.println("Page Title: "+actualTitle);
        assertEquals(expectedTitle,actualTitle);

        //driver.findElement(By.xpath("//*[@id=\"LogonForm\"]/fieldset/div[5]/input")).click(); // alternatively by clicking submit button
        //String quantityText = driver.findElement(By.xpath("//*[@id=\"items-quantity-title\"]")).getText(); //view Cart page (# Items)
        //System.out.println("Item Quantity" + quantityText);  // prints items quantity (# Items)
        //assertEquals(" (2 Items)", quantityText);*/
        
    }
    
    
    @Test
    public void testInvalidSignIn() throws Exception {
        // Add item and view cart before logging in
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(20,250)");
        driver.get(baseURL); 
        driver.findElement(By.xpath("//a[@id=\"header_sign_in\"]")).click(); //X-path manual add quantity 
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@id=\"logonId\"]")).sendKeys("zabc@abc.com");
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@id=\"logonPassword\"]")).submit(); //submit by pressing enter
        String signInError = driver.findElement(By.xpath("//div[@class=\"critical-notification form-group\"]")).getText(); //Sign In Error
        System.out.println("Error" + signInError);  // prints items Sign In Error
        assertEquals("There was a problem with your information. Please try again." ,signInError);
        
    }


}

