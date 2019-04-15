/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;


import io.swagger.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Anders
 */
public class DatabaseController {
    
    // Map used to sync with object if same username is being requested access on.
    // Using Collections.synchronizedMap to ensure each thread have an up to date view on the map.
    private final Map<String, Object> objectLock = Collections.synchronizedMap(new HashMap());
    private static DatabaseController instance;
    private static final Object threadLock = new Object();
    
    public static DatabaseController getInstance() throws SQLException {
        if (instance == null) {
            synchronized(threadLock){
                if(instance == null){
                    instance = new DatabaseController();
                }
            }
        }
        return instance;
    }

    public void createProduct(Product product, Connection con) throws SQLException {
        String query = "INSERT INTO products (name, category, maincolor, location, id, amount, restocked) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, product.getName());
        statement.setString(2, product.getCategory());
        statement.setString(3, product.getColor());
        statement.setString(4, product.getLocation());
        statement.setLong(5, product.getBarcode());
        statement.setInt(6, product.getAmount());
        statement.setBoolean(7, product.isRestock());
        statement.executeUpdate();
        statement.close();
    }

    
       
}
