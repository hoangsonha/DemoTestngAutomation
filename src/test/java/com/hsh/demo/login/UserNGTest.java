/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.hsh.demo.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void testLoginWithUserAndPasswordIsCorrect() {
       driver.findElement(By.linkText("Login")).click();
       driver.findElement(By.id("email")).sendKeys("hoangsonha492@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1"); 
       driver.findElement(By.id("b_submit")).click();   
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "Login Successfully !!!";      
       Assert.assertEquals(actualValue, expectedValue);
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
}
