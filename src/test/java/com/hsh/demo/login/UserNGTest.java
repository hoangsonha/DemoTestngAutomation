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
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testngautomation.azurewebsites.net/");
    }
    
    @Test
    public void testLoginWithUserAndPasswordIsCorrect() throws InterruptedException {
       driver.findElement(By.linkText("Login")).click();
       driver.findElement(By.id("email")).sendKeys("hoangsonha492@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1"); 
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();   
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "Login Successfully!!!";    
       Assert.assertEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testLoginWithUserAndPasswordNotCorrect() throws InterruptedException {
       driver.findElement(By.linkText("Login")).click();
       driver.findElement(By.id("email")).sendKeys("hoangsonha492@gmail.com");
       driver.findElement(By.id("password")).sendKeys("123"); 
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();   
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "Login Successfully!!!";      
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testLoginWithUserNotCorrectAndPasswordNotCorrect() throws InterruptedException {
       driver.findElement(By.linkText("Login")).click();
       driver.findElement(By.id("email")).sendKeys("@gmail.com");
       driver.findElement(By.id("password")).sendKeys("123"); 
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();   
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "Login Successfully!!!";      
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testLoginWithNoData() throws InterruptedException {
       driver.findElement(By.linkText("Login")).click();
       driver.findElement(By.id("email")).sendKeys("");
       driver.findElement(By.id("password")).sendKeys(""); 
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();   
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "Login Successfully!!!";      
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    
    
    @Test
    public void testRegisterWithNoDataOfEmail() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click(); 
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testRegisterWithNoDataOfPassword() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click(); 
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testRegisterWithNoDataOfFirstName() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click(); 
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testRegisterWithNoDataOfLastName() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();  
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testRegisterWithNoDataOfPhone() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click(); 
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    @Test
    public void testRegisterWithNoDataOfAddress() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();  
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertNotEquals(actualValue, expectedValue);
    }
    
    
    @Test
    public void testRegisterWithFullData() throws InterruptedException {
       driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("email")).sendKeys("nguoisaohoa@gmail.com");
       driver.findElement(By.id("password")).sendKeys("1");  
       driver.findElement(By.id("firstName")).sendKeys("Hoang");
       driver.findElement(By.id("lastName")).sendKeys("Ha");
       driver.findElement(By.id("phone")).sendKeys("0334386995");
       driver.findElement(By.id("address")).sendKeys("Da Lat");
       Thread.sleep(5000);
       driver.findElement(By.id("b_submit")).click();   
       
       String actualValue = driver.findElement(By.id("message")).getText();    
       String expectedValue = "User registered successfully!!!";  
       Assert.assertEquals(actualValue, expectedValue);
    }
    
    
    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
    
}
