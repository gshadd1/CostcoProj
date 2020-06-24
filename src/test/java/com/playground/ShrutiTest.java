/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author gregshadd
 */
public class ShrutiTest {

    private WebDriver driver;
    private String baseURL;

    public ShrutiTest() {
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
        //driver.close();
    }
    
       // @Test
    public void testAddItemNotLoggedIn15() throws Exception {
        driver.get("https://www.costco.com/");
        driver.findElement(By.id("Home_Ancillary_0")).click();
        driver.findElement(By.linkText("Frito Lay Classic Mix, Variety Pack, 30-count")).click();
        driver.findElement(By.id("add-to-cart-btn")).click();
        driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("shopCartCheckoutSubmitButton")).click();
        assertEquals("Sign in to access your Costco.com account.", driver.findElement(By.xpath("//form[@id='LogonForm']/fieldset/div/span")).getText());
    }

    

}
