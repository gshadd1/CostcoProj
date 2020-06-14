package com.test;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author gregshadd
 */
public class SearchProductTest {

    private WebDriver driver;
    private String baseURL;

    public SearchProductTest() {
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
        driver.close();
    }

    @Test
    public void test38SearchbyItemnumber() {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("9550010");
        driver.findElement(By.id("formcatsearch")).submit();

        String itemmodeltext = driver.findElement(By.xpath("//*[@id=\"product-body-model-number\"]/span")).getText();
        assertEquals("OLED55CXAUA.AUS", itemmodeltext);
//LG 55" Class - CX Series - 4K UHD OLED TV - $100 SquareTrade Protection Plan Bundle Included
    }

    //@Test
    public void test40SearchbyInvalidProduct() {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("gravemarker");
        driver.findElement(By.id("formcatsearch")).submit();

        String notfoundtext = driver.findElement(By.xpath("//*[@id=\"no-results\"]/h2")).getText();
        assertEquals("We're sorry. We were not able to find a match. ", notfoundtext);
    }

    //@Test
    public void test41SearchbyInvalidtoValidProduct() throws InterruptedException {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("gravemarker");
        driver.findElement(By.id("formcatsearch")).submit();
        driver.findElement(By.id("search-field2")).click();
        driver.findElement(By.id("search-field2")).clear();
        driver.findElement(By.id("search-field2")).sendKeys("bubble gum");
        driver.findElement(By.id("search-field2")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        String prodfoundtext = driver.findElement(By.id("rsltCntMsg")).getText();
        assertEquals("We found 1 results for \"bubble gum\"", prodfoundtext);

    }

    //@Test
    public void test42SelectProductviaText() {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).click();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("dell laptop");
        driver.findElement(By.id("formcatsearch")).submit();
        driver.findElement(By.linkText("Dell XPS 15 Touchscreen Laptop - 9th Gen Intel Core i9-9980HK - GeForce GTX 1650 - 4K UHD")).click();

        String itemmodeltext = driver.findElement(By.xpath("//*[@id=\"product-body-model-number\"]/span")).getText();
        assertEquals("XPS7590-9589SLV-PUS", itemmodeltext);
    }

    // @Test
    public void test43SelectProductviaImage() {
        driver.get(baseURL);
        //driver.manage().window().maximize();
        driver.findElement(By.id("search-field")).clear();
        driver.findElement(By.id("search-field")).sendKeys("dell laptops");
        driver.findElement(By.id("formcatsearch")).submit();
        driver.findElement(By.xpath("//img[@alt='Dell Inspiron 15 3000 Touchscreen Laptop - 10th Gen Intel Core i7-1065G7 - 1080p']")).click();

        String itemmodeltext = driver.findElement(By.xpath("//*[@id=\"product-body-model-number\"]/span")).getText();
        assertEquals("i3593-7098BLK-PUS", itemmodeltext);
    }

    @Test
    public void testContinueShopping8() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div/button")).click();
    }

    @Test
    public void testRemoveItem6() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("webscraper.saksham@gmail.com");
        driver.findElement(By.id("logonPassword")).clear();
        driver.findElement(By.id("logonPassword")).sendKeys("icemountain123");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        driver.findElement(By.xpath("//input[@value='Shop as Non-Member']")).click();
        driver.findElement(By.xpath("//a[@id='cart-d']/div/div")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("Remove")).click();
    }

    @Test
    public void testCheckout7() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div[2]/a/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        driver.findElement(By.xpath("//div[@id='logon']/div/div/div/div")).click();
        assertEquals("Sign in to access your Costco.com account.", driver.findElement(By.xpath("//form[@id='LogonForm']/fieldset/div/span")).getText());
    }

    @Test
    public void testAddMoreItems9() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div/button")).click();
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Heinz Picnic Pack, 4-count")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div[2]/a/button")).click();
        assertEquals("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs", driver.findElement(By.linkText("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs")).getText());
        assertEquals("Heinz Picnic Pack, 4-count", driver.findElement(By.linkText("Heinz Picnic Pack, 4-count")).getText());
    }

    @Test
    public void testDelivery10() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("webscraper.saksham@gmail.com");
        driver.findElement(By.id("logonPassword")).clear();
        driver.findElement(By.id("logonPassword")).sendKeys("icemountain123");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        driver.findElement(By.xpath("//input[@value='Shop as Non-Member']")).click();
        driver.findElement(By.id("cart-d")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        assertEquals("Shipping Address", driver.findElement(By.xpath("//div[@id='shipping']/div/div/div/div/h2")).getText());
    }

    @Test
    public void testRemoveAllProducts11() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("webscraper.saksham@gmail.com");
        driver.findElement(By.id("logonPassword")).clear();
        driver.findElement(By.id("logonPassword")).sendKeys("icemountain123");
        driver.findElement(By.id("LogonForm")).submit();
        driver.findElement(By.xpath("//input[@value='Shop as Non-Member']")).click();
        driver.findElement(By.id("cart-d")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("Remove")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("Remove")).click();
        assertEquals("Your shopping cart is empty. Please add at least one item to your cart before checking out.", driver.findElement(By.id("empty-cart-id")).getText());
    }

    @Test
    public void testNotLoggedInVerifyContinueShopping13() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("header_sign_in")).click();
        driver.findElement(By.id("logonId")).clear();
        driver.findElement(By.id("logonId")).sendKeys("webscraper.saksham@gmail.com");
        driver.findElement(By.id("logonPassword")).clear();
        driver.findElement(By.id("logonPassword")).sendKeys("icemountain123");
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        driver.findElement(By.xpath("//input[@value='Shop as Non-Member']")).click();
        driver.findElement(By.id("cart-d")).click();
        assertEquals("Your shopping cart is empty. Please add at least one item to your cart before checking out.", driver.findElement(By.xpath("//div[@id='empty-cart-id']/div")).getText());
    }

    @Test
    public void testAddItemNotLoggedIn15() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Kirkland Signature 100% Colombian Coffee, Dark Roast, 3 lbs")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        driver.findElement(By.xpath("//div[@id='costcoModalText']/div[2]/div[2]/a/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        assertEquals("Sign in to access your Costco.com account.", driver.findElement(By.xpath("//form[@id='LogonForm']/fieldset/div/span")).getText());
    }

}
