/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.hsh.demo.test;

import com.hsh.demo.utils.SeleniumDatabaseTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testngautomation.azurewebsites.net/");
    }

    @Test
    public void testSearchReturn3WithParameterAO() throws InterruptedException {
        driver.findElement(By.id("menu_search")).sendKeys("Áo");
        Thread.sleep(5000);
        driver.findElement(By.id("scroll_search")).click();
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("san_pham"));
        int expectedValue = 3;
        int actualValue = sanPhams.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testSearchReturn0WithParameterJAVA() throws InterruptedException {
        driver.findElement(By.id("menu_search")).sendKeys("Java");
        Thread.sleep(5000);
        driver.findElement(By.id("scroll_search")).click();
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("san_pham"));
        int expectedValue = 0;
        int actualValue = sanPhams.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testAdd1ProductIntoCart() throws InterruptedException {

        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));
        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(w1).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("cart_cart")).click();
        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));
        int expectedValue = 1;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testAddMutipleProductIntoCart() throws InterruptedException {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));
        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(w1).click().perform();

        WebElement danhSachSanPham2 = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams2 = danhSachSanPham2.findElements(By.className("add_product"));
        Actions actionss = new Actions(driver);
        Thread.sleep(3000);
        WebElement w2 = sanPhams2.get(4);
        actionss.moveToElement(w2).click().perform();

        WebElement danhSachSanPham3 = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams3 = danhSachSanPham3.findElements(By.className("add_product"));
        Actions actionsss = new Actions(driver);
        Thread.sleep(3000);
        WebElement w3 = sanPhams3.get(8);
        actionsss.moveToElement(w3).click().perform();
        Thread.sleep(3000);

        driver.findElement(By.id("cart_cart")).click();
        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));
        int expectedValue = 3;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testEditQuantity5ProductInCartAndReturn5() throws InterruptedException {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));
        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(w1).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("cart_cart")).click();
        driver.findElement(By.className("quantity_product")).clear();
        driver.findElement(By.className("quantity_product")).sendKeys("5");
        Thread.sleep(3000);
        driver.findElement(By.id("save_quantity")).click();

        String actualValueString = driver.findElement(By.className("quantity_product")).getAttribute("value");
        int expectedValue = 5;
        int actualValue = Integer.parseInt(actualValueString);

        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void testRemoveProductInCart() throws InterruptedException {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));
        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(w1).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("cart_cart")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Xoá")).click();

        WebElement danhSachSanPham1 = driver.findElement(By.className("fdemo"));
        List<WebElement> sanPhams1 = danhSachSanPham1.findElements(By.className("quantity_product"));
        int expectedValue = 0;
        int actualValue = sanPhams1.size();

        Assert.assertEquals(actualValue, expectedValue);
    }
    
    
    @Test
    public void testOrderSaveInDB() throws InterruptedException, Exception {
        WebElement danhSachSanPham = driver.findElement(By.id("demoWeb"));
        List<WebElement> sanPhams = danhSachSanPham.findElements(By.className("add_product"));
        WebElement w1 = sanPhams.get(0);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(w1).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("cart_cart")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("payment")).click();
        
        driver.findElement(By.id("name_customer")).sendKeys("hoangsonha");
        driver.findElement(By.id("email_customer")).sendKeys("hoangsonha@gmail.com");
        driver.findElement(By.id("address_customer")).sendKeys("hcm");
        driver.findElement(By.id("phone_customer")).sendKeys("0334386995");
        driver.findElement(By.id("notes_customer")).sendKeys("giao hang nhanh");

        int max = getMaxIdBill();
        
        Thread.sleep(5000);
        
        WebElement web = driver.findElement(By.id("submit_bill"));
        Actions action = new Actions(driver);
        action.moveToElement(web).click().perform();
        
        
        int bill_id = getIdBillSuccess("hcm", "hoangsonha@gmail.com", "hoangsonha", "giao hang nhanh", "0334386995", max);
 
        boolean expectedValue = true;
        boolean actualValue = check(max, bill_id);

        Assert.assertEquals(actualValue, expectedValue);
    }
    
    public boolean check(int max, int bill_id) {
        int minus = bill_id - max;
        if(minus > 0) return true;
        return false;
    }

    public int getIdBillSuccess(String add, String email, String name, String notes, String phone, int max) throws Exception {
        int id_bill = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = SeleniumDatabaseTesting.getCOnnection();
            if (conn != null) {

                String query = "select id from bills where address=? and email=? and name=? and notes=? and phone=? and id > ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, add);
                ps.setString(2, email);
                ps.setString(3, name);
                ps.setString(4, notes);
                ps.setString(5, phone);
                ps.setInt(6, max);
                rs = ps.executeQuery();
                if (rs.next()) {
                    id_bill = rs.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return id_bill;
    }
    
    public int getMaxIdBill() throws Exception {
        int max = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = SeleniumDatabaseTesting.getCOnnection();
            if (conn != null) {

                String query = "select max(id) from bills";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    max = rs.getInt("max(id)");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return max;
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }

}
