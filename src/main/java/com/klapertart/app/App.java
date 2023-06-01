package com.klapertart.app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        DataConnection dataConnection = new DataConnection();        
        
        ProductCrud productCrud = new ProductCrud(dataConnection);

        // get all product
        productCrud.getAllProduct();    
        // add product
        productCrud.addProduct(new Product(0, "Penghapus", 8000, 7));
        // update product
        productCrud.updateProduct(5, 15000);
        // delete product
        productCrud.deleteProduct(5);            
    }    
}
