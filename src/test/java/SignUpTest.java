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
public class SignUpTest {

    private WebDriver driver;
    private String baseURL;

    public SignUpTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
