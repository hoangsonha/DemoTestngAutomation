/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsh.demo.core;

/**
 *
 * @author ADMIN
 */
public class Function {

    public static long getFibonacci(int n ){

        if(n < 0){
            throw new IllegalArgumentException("Invalid n. n must be larger than 0");
        }else if( n == 0 || n == 1){
            return n;
        }else{
            return getFibonacci(n - 2) + getFibonacci(n - 1);
        }
    }


    
    public static int countDayInYear(int year, int month, int day) {
        if(year <= 0) {
            throw new IllegalArgumentException("invalid year, year must be larger 0");
        } else if(month <= 0 || month > 12) {
            throw new IllegalArgumentException("invalid month, month must be between [01-12]");
        } else if(day <= 0 || day > 31) {
            throw new IllegalArgumentException("invalid day, year must be between [01-31]");
        }
        int count = 0;
        for(int i = 1; i < month; i++) {
            count += countDayInMonth(year, i);
        }
        count += day;
        return count;
    }
    

    public static int countDayInMonth(int year, int month) {
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if(year % 4 == 0 && year % 100 != 0) {
            if(month == 2) {
                return 29;
            }
        }
        return 28;
    }

    

    public static int countDayIn1Year(int year) {
        if(year % 4 == 0 && year % 100 != 0) {
            return 366;
        }
        return 365;
    }
}
