/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsh.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class SeleniumDatabaseTesting {
    public static String DB_URL = "jdbc:mysql://diamondshop.mysql.database.azure.com/web_ban_hang";

    public static String DB_USER = "diamondshop";

    public static String DB_PASSWORD = "Group6123456789";
    
    public static Connection getCOnnection() throws Exception {
        Connection conn = null;
        String dbClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(dbClass).newInstance();
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return conn;
    }

}
