/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsh.demo.test2;

import org.testng.annotations.Test;

/**
 *
 * @author ASUS
 */
@Test(groups = "second")
public class SecondMethod extends BeforeMethods{

    @Test
    public void testCase1() {
        System.out.println("in test case 1 of NewTestngClass");
    }

    @Test
    public void testCase2() {
        System.out.println("in test case 2 of NewTestngClass");
    }
}
