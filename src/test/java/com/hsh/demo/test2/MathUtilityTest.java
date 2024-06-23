/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.hsh.demo.test2;

import static org.testng.Assert.*;

import com.hsh.demo.core.Function;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author ASUS
 */
public class MathUtilityTest {

    // 0 1 1 2 3 5 8 13 21
    @BeforeMethod
    public void testBeforeMethod(){
        System.out.println("beforeMethod");
    }
    @Test(groups = "returnswell", priority = 2)
    public void testFibonacciGivenRightArg0ReturnsWell() {
        System.out.println("Arg0");
        int n = 0;
        long expectedValue = 0;
        long actualValue = Function.getFibonacci(n);
        assertEquals(actualValue, expectedValue);
    }
    @Test(groups = "returnswell", priority = 1)
    public void testFibonacciGivenRightArg8ReturnsWell(){
        System.out.println("Arg8");
        int n = 8;
        long expectedValue = 21;
        long actualValue = Function.getFibonacci(n);
        assertEquals(actualValue, expectedValue);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class, groups = "returnexception")
    public void testFibonacciGivenWrongArg_1ThrowException(){
        System.out.println("Exception_1");
        Function.getFibonacci(-1);
    }
//    @BeforeTest
//    public void testBeforeTest(){
//        System.out.println("Run before test methods in class");
//    }
//    @AfterTest
//    public void testAfterTest(){
//        System.out.println("Run after all test methods have run");
//    }
//    @BeforeClass
//    public void testBeforeClass(){
//        System.out.println("BeforeClass");
//    }
}
