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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
