/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import io.swagger.model.AllCategoriesRequest;
import io.swagger.model.AllLocationsRequest;
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            synchronized (threadLock) {
                if (instance == null) {
                    instance = new DatabaseController();
                }
            }
        }
        return instance;
    }

    public void createProduct(Product product, Connection con) throws SQLException {
        // todo update query when database and swagger is updated
        // String query = "INSERT INTO products (name, category, maincolor, location, id or barcode remeber to set barcode/id to bigint, amount, canBeRestocked, mustBeRestocked, minAmount) VALUES (?, ?, ?, ?, ?, ?, ?);";
        // also update statements
        String query = "INSERT INTO products (name, category, maincolor, location, barcode, amount, restocked) VALUES (?, ?, ?, ?, ?, ?, ?);";
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

    public void addNewCategory(String newCategory, Connection con) throws SQLException {
        newCategory = newCategory.replace("\"", "");
        String query = "INSERT INTO category (category) VALUES (?);";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, newCategory);
        statement.executeUpdate();
        statement.close();
    }

    public AllCategoriesRequest getAllCategories(Connection con) throws SQLException {
        AllCategoriesRequest response = new AllCategoriesRequest();
        String query = "SELECT * FROM category";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            response.add(rs.getString("category"));
        }
        rs.close();
        statement.close();
        return response;
    }

    public AllLocationsRequest getAllLocations(Connection con) throws SQLException {
        AllLocationsRequest response = new AllLocationsRequest();
        String query = "SELECT * FROM location";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            response.add(rs.getString("location"));
        }
        rs.close();
        statement.close();
        return response;
    }

    public Barcode generateBarcodeProduct(Connection con) throws SQLException {
        RandomNumber randomNumber = new RandomNumber();
        Barcode response = new Barcode();
        response.setBarcodeID(randomNumber.randomBarcode().getBarcodeID());
        String query = "SELECT * FROM products WHERE barcode ='" + response.getBarcodeID() + "';";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            response.setBarcodeID(generateBarcodeProduct(con).getBarcodeID());
        } else {
            rs.close();
            statement.close();
            return response;
        }
        rs.close();
        statement.close();
        return response;
    }

    public ProductArray getAllProducts(Connection con) throws SQLException {
        ProductArray response = new ProductArray();
        String query = "SELECT * FROM products";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Product product = new Product();
            product.setName(rs.getString("name"));
            product.setCategory(rs.getString("category"));
            product.setColor(rs.getString("maincolor"));
            product.setLocation(rs.getString("location"));
            product.setBarcode(rs.getLong("barcode"));
            product.setAmount(rs.getInt("amount"));
            product.setRestock(rs.getBoolean("restocked"));
            response.add(product);
        }
        rs.close();
        statement.close();
        return response;
    }
}
