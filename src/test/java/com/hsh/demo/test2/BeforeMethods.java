/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hsh.demo.test2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 *
 * @author ASUS
 */
public class BeforeMethods {

    @BeforeClass
    public void beforeClass() {
        System.out.println("in beforeClass");
    }
    @BeforeTest
    public void beforeTest2(){
        System.out.println("in beforeTest2");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("in beforeTest");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }
    
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
