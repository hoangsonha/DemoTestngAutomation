/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

package com.hsh.demo.test2;

import static org.testng.Assert.*;

import com.hsh.demo.core.Function;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author ASUS
 */
// 0 1 1 2 3 5 8 13 21 34 
public class MathUtilityDDTTest {
    
    @DataProvider(name = "source")
    public static Object[][] initData() {
        return new Object[][]{
            {0, 0},
            {1, 1},
            {2, 1},
            {3, 2},
            {4, 3},
            {5, 5},
            {6, 8},
            {7, 13},
            {8, 21},
            {9, 34}
        };
    }
    
    @Test(dataProvider = "source")
    public void testGetFibonacciReturnsWell(int n, long expected){
        assertEquals(Function.getFibonacci(n), expected);
    }
}
