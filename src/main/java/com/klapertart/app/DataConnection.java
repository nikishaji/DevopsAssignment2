/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klapertart.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kurakuraninja
 */
public class DataConnection {
    
    String url;
    String user;
    String pass;
    String driver;
    Connection conn;

    public DataConnection() {
        url = "jdbc:mysql://localhost:3306/inventory";
        user = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Connection getConnection() throws SQLException{
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException e){
            System.out.println(e.toString());
        }
        return conn;
    }    
    
    public void closeConnection(){
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }    
}
