/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.hsh.demo.test;

import com.hsh.demo.core.Function;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author ADMIN
 */
public class DayNGTest {
    
    int year = 0;
    int month = 0;
    int day = 0;
    
    @BeforeClass
    public void setup() {
        year = 2024;
        month = 6;
        day = 15;
    }
    
    
    
    @Test
    public void TestCountDayInYearInPutTodayAndReturnWell() {
        setup();
        int expectedValue = 167;
        int actualValue = Function.countDayInYear(year, month, day);
        
        assertEquals(actualValue, expectedValue);
    }
    
    @Test
    public void TestCountDayInYearInPutTodayAndReturnWell2() {
        
        int expectedValue = 167;
        int actualValue = Function.countDayInYear(year, month, day);
        
        assertEquals(actualValue, expectedValue);
    }
    
    @Test
    public void TestCountDayInYearInPutTodayAndReturnWell3() {
        
        int expectedValue = 167;
        int actualValue = Function.countDayInYear(0, 0, 0);
        
        assertEquals(actualValue, expectedValue);
    }
    
//    @Test
//    public void TestCountDayInYearInPutYearNotValidAndReturnWell() {
//        
//        assertThrows(IllegalArgumentException.class, () -> {
//                    Function.countDayInYear(-2024, 5, 15);
//                } );
//    }
//    
//    @Test
//    public void TestCountDayInYearInPutMonthNotValidAndReturnWell() {
//        
//        assertThrows(IllegalArgumentException.class, () -> {
//                    Function.countDayInYear(2024, -5, 15);
//                } );
//    }
//    
//    @Test
//    public void TestCountDayInYearInPutDayNotValidAndReturnWell() {
//        
//        assertThrows(IllegalArgumentException.class, () -> {
//                    Function.countDayInYear(2024, 5, -15);
//                } );
//    }
    
    
}
