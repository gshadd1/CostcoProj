package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itexps.costco.FileUtil;
import com.itexps.costco.HomePage;
import com.itexps.costco.LoginVO;
import com.itexps.costco.SignInPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author gregshadd
 */
public class SignUpTest {

    private WebDriver driver;
    private String baseURL;
    private static LoginVO login = null;

    public SignUpTest() {
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
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test36CreateAccount() {
        driver.get(baseURL);
        WebElement register = driver.findElement(By.id("header_sign_in"));
        register.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"LogonForm\"]/fieldset/div[8]/a"));
        createAccount.click();
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement why = driver.findElement(By.className("tooltip-without-question-icon"));
        why.click();
    }
    
    @Test
    public void test53UpdateAccountInfo() throws Exception {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        //driver.findElement(By.id("header_sign_in")).click();

        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.signinbttn();

//        driver.findElement(By.id("logonId")).click();
//        driver.findElement(By.id("logonId")).clear();
//        driver.findElement(By.id("logonId")).sendKeys("ktastrophe@wowway.com");
//        driver.findElement(By.id("logonPassword")).click();
//        driver.findElement(By.id("logonPassword")).clear();
//        driver.findElement(By.id("logonPassword")).sendKeys("29costcosux!!");
//        driver.findElement(By.xpath("//input[@value='Sign In']")).click();

        SignInPage signinpage = PageFactory.initElements(driver, SignInPage.class);
        signinpage.validkirklogin("k@wowway.com", "costco");

        driver.findElement(By.xpath("//a[@id='myaccount-d']/i")).click();
        driver.findElement(By.linkText("Account Details")).click();
        driver.findElement(By.id("edit-mobile-phone")).click();
        driver.findElement(By.id("update-mobile")).clear();
        driver.findElement(By.id("update-mobile")).sendKeys("6309951266");
        driver.findElement(By.id("update-mobile")).submit();
        //driver.findElement(By.id("update-mobile")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("edit-mobile-phone")).click();
        driver.findElement(By.id("update-primary-mobile-phone-btn")).click();

        String mobileudatetext1 = driver.findElement(By.id("mobile-phone-value")).getText();
        String mobileudatetext = driver.findElement(By.xpath("//*[@id=\"notification-message\"]/p")).getText();
        System.out.println("MOBILE IS NOW: " + mobileudatetext1);
        assertEquals("Information Updated", mobileudatetext);

    }
 
}
