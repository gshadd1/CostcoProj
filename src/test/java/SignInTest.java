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
import org.openqa.selenium.JavascriptExecutor;
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
    //  private static LoginVO login = null;

    public SignInTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\QA\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        baseURL = "https://www.costco.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        // driver.close();
    }

//Test  line 14 My Account try invaild  phone#,email format 
//    @Test
//    public void testInvalidPhoneNumber() throws Exception {
//        driver.get(baseURL);
//
//        Thread.sleep(2000);
//        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oracle");
//        // driver.findElement(By.name("site-search")).submit();
//    }
//
//    @Test
//    public void testInvalidEmail() throws Exception {
//        driver.get(baseURL);
//
//    }

    @Test
    public void testValidEmailCorrectPassword() {
        // webscraper.saksham@gmail.com
        // icemountain123
        driver.get(baseURL);
        WebElement signIn = driver.findElement(By.id("header_sign_in"));
        signIn.click();
        WebElement emailAddress = driver.findElement(By.id("logonId"));
        emailAddress.clear();
        driver.findElement(By.id("logonId")).sendKeys("webscraper.saksham@gmail.com");
        //logonPassword
        WebElement passWord = driver.findElement(By.id("logonPassword"));
        passWord.clear();
        driver.findElement(By.id("logonPassword")).sendKeys("icemoumtaim123");

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,250)", "");
    }
}
