/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klapertart.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kurakuraninja
 */
public class ProductCrud {
    DataConnection dataConnection;

    public ProductCrud(DataConnection pDataConnection) {
        this.dataConnection = pDataConnection;
    }
    
    public void getAllProduct(){
        Statement state;
        ResultSet result;
        
        try{
            state = dataConnection.getConnection().createStatement();
            String query = "SELECT * FROM product";
            
            result = state.executeQuery(query);
            if(result.next()){
                result.beforeFirst();
                while(result.next()){
                    Product product = new Product(result.getInt("id"),
                                            result.getString("name"),
                                            result.getDouble("price"),
                                            result.getInt("stock"));

                    System.out.println(product.toString());
                }            
            }else{
                System.out.println("Data is empty!");
            }
            
            result.close();
            state.close();
            dataConnection.closeConnection();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public void addProduct(Product pProduct){
        Statement state;
        
        try{
            state = dataConnection.getConnection().createStatement();
            String query = "INSERT INTO product (name, price, stock) VALUES ("
                            + "'"+ pProduct.getName() + "',"
                            + pProduct.getPrice() + ","
                            + pProduct.getStock() + ")";
            
            int result = state.executeUpdate(query);
            
            if(result >= 1){
                System.out.println("Data inserted!");
            }else{
                System.out.println("Add data failed!");
            }
            
            state.close();
            dataConnection.closeConnection();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void updateProduct(int pId, double pPrice){
        Statement state;
        
        try{
            state = dataConnection.getConnection().createStatement();
            String query = "UPDATE product SET price = " + pPrice +
                           " WHERE id = " + pId ;
            
            int result = state.executeUpdate(query);            
            if(result >= 1){
                System.out.println("Data updated!");
            }else{
                System.out.println("Update data failed!");
            }
            
            state.close();
            dataConnection.closeConnection();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public void deleteProduct(int pId){
        Statement state;
        
        try{
            state = dataConnection.getConnection().createStatement();
            String query = "DELETE FROM product WHERE id = " + pId ;
            
            int result = state.executeUpdate(query);            
            if(result >= 1){
                System.out.println("Data delete!");
            }else{
                System.out.println("Delete data failed!");
            }
            
            state.close();
            dataConnection.closeConnection();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }    
}
