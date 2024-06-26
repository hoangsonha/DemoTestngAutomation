/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.hsh.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ADMIN
 */
public class UserNGTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // driverManager quản lí driver của chúng ta (trong th này là chromedriver())

//        ChromeOptions op = new ChromeOptions();
//        op.addArguments("--incognito");         // set tab an danh
//        op.addArguments("--lang=ja-JP");          // set language
//        WebDriver driver = new ChromeDriver(op);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://localhost:8080/");
    }

    @Test
    public void testLoginWithUserNameAndPasswordCorrectWithRoleUserReturnWell() {

        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
        driver.findElement(By.id("email")).sendKeys("hoangha@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("b_submit")).click();

        String actualValue = driver.findElement(By.xpath("//div[@class='h5']")).getText();
        String expectedValue = "Hello : ha";

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testLoginWithUserNameAndPasswordCorrectWithRoleAdminReturnWell() {

        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
        driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("b_submit")).click();

        String actualValue = driver.findElement(By.xpath("//div[@class='h3']")).getText();
        String expectedValue = "Hello : admin@gmail.com";

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testLoginWithUserNameAndPasswordIncorrectReturnWell() {

        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();
        driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
        driver.findElement(By.id("password")).sendKeys("quenmatkhau");
        driver.findElement(By.id("b_submit")).click();

        String actualValue = driver.findElement(By.xpath("//div[@class='h4 alert-light text-center']")).getText();
        String expectedValue = "Thông tin email hoặc mật khẩu không chính xác";

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testSearchWithParameterAOReturnWell() {
        driver.findElement(By.id("menu_search")).sendKeys("Áo");
        driver.findElement(By.id("scroll_search")).click();

        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("san_pham"));

        int expectedValue = 3;
        int actualValue = sanPhams.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testSearchWithParameterJAVAReturnWell() {
        driver.findElement(By.id("menu_search")).sendKeys("Java");
        driver.findElement(By.id("scroll_search")).click();

        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("san_pham"));

        int expectedValue = 0;
        int actualValue = sanPhams.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testAdd1ProductIntoCartReturnWell() {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));

        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();

        driver.findElement(By.id("cart_cart")).click();
        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));

        int expectedValue = 1;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testAddMultipleProductIntoCartReturnWell() {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));

        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();

        WebElement danhSachSanPham2 = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams2 = danhSachSanPham2.findElements(By.className("add_product"));

        Actions actionss = new Actions(driver);
        WebElement w2 = sanPhams2.get(4);
        actionss.moveToElement(w2).click().perform();

        WebElement danhSachSanPham3 = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams3 = danhSachSanPham3.findElements(By.className("add_product"));

        Actions actionsss = new Actions(driver);
        WebElement w3 = sanPhams3.get(8);
        actionsss.moveToElement(w3).click().perform();

        driver.findElement(By.id("cart_cart")).click();
        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));

        int expectedValue = 3;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testEditQuantityWithParameter5ProductInCartAndReturnWell() {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));

        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();

        driver.findElement(By.id("cart_cart")).click();
        driver.findElement(By.className("quantity_product")).clear();
        driver.findElement(By.className("quantity_product")).sendKeys("5");
        driver.findElement(By.id("save_quantity")).click();

        String actualValueString = driver.findElement(By.className("quantity_product")).getAttribute("value");
        int expectedValue = 5;
        int actualValue = Integer.parseInt(actualValueString);

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testRemoveProductInCartReturnWell() {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));

        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();

        driver.findElement(By.id("cart_cart")).click();
        driver.findElement(By.linkText("Xoá")).click();

        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));

        int expectedValue = 0;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }
    
    
    @Test
    public void testOrderSaveWhenUserCreateOrderSuccessfullyReturnWell() {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));

        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();

        driver.findElement(By.id("cart_cart")).click();
        driver.findElement(By.id("payment")).click();
        driver.findElement(By.id("name_customer")).sendKeys("hoangsonha");
        driver.findElement(By.id("email_customer")).sendKeys("hoangsonha@gmail.com");
        driver.findElement(By.id("address_customer")).sendKeys("hcm");
        driver.findElement(By.id("phone_customer")).sendKeys("0334386995");
        driver.findElement(By.id("notes_customer")).sendKeys("giao hang nhanh");

        WebElement web = driver.findElement(By.id("submit_bill"));
        Actions action = new Actions(driver);
        action.moveToElement(web).click().perform();

        WebElement web_message = driver.findElement(By.id("message"));

        String expectedValue = "Đã ghi nhập đơn hàng của bạn";
        String actualValue = web_message.getText();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
