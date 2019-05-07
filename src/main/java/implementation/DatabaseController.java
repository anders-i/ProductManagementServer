/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import io.swagger.model.AllCategories;
import io.swagger.model.AllLocations;
import io.swagger.model.Barcode;
import io.swagger.model.Product;
import io.swagger.model.ProductArray;
import io.swagger.model.SearchRequest;
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
        String query = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, product.getName());
        statement.setString(2, product.getCategory());
        statement.setString(3, product.getColor());
        statement.setString(4, product.getLocation());
        statement.setLong(5, product.getBarcode());
        statement.setInt(6, product.getAmount());
        statement.setBoolean(7, product.isCanBeRestock());
        statement.setBoolean(8, product.isMustBeRestock());
        statement.setInt(9, product.getMinAmount());
        statement.executeUpdate();
        statement.close();
    }

    public Product getProduct(Long barcode, Connection con) throws SQLException {
        String query = "SELECT * FROM products WHERE barcode=" + barcode + ";";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        Product product = new Product();
        while (rs.next()) {
            product.setName(rs.getString("name"));
            product.setCategory(rs.getString("category"));
            product.setColor(rs.getString("maincolor"));
            product.setLocation(rs.getString("location"));
            product.setBarcode(rs.getLong("barcode"));
            product.setAmount(rs.getInt("amount"));
            product.setMinAmount(rs.getInt("minamount"));
            product.setMustBeRestock(rs.getBoolean("mustberestocked"));
            product.setCanBeRestock(rs.getBoolean("canberestocked"));
        }
        rs.close();
        statement.close();
        return product;
    }

    public void deleteProduct(Product product, Connection con) throws SQLException {
        String query = "DELETE FROM products WHERE barcode=" + product.getBarcode() + ";";
        PreparedStatement statement = con.prepareStatement(query);
        statement.executeUpdate();
        statement.close();
    }

    public void editProduct(Product product, Connection con) throws SQLException {
        String query = "UPDATE products SET name='" + product.getName() + "', category='" + product.getCategory() + "', maincolor='" + product.getColor() + "', location='" + product.getLocation() + "', barcode='" + product.getBarcode() + "', amount='" + product.getAmount() + "', canberestocked='" + product.isCanBeRestock() + "', mustberestocked='" + product.isMustBeRestock() + "', minamount='" + product.getMinAmount() + "' WHERE barcode=" + product.getBarcode() + ";";
        PreparedStatement statement = con.prepareStatement(query);
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

    public AllCategories getAllCategories(Connection con) throws SQLException {
        AllCategories response = new AllCategories();
        String query = "SELECT * FROM category;";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            response.add(rs.getString("category"));
        }
        rs.close();
        statement.close();
        return response;
    }

    public AllLocations getAllLocations(Connection con) throws SQLException {
        AllLocations response = new AllLocations();
        String query = "SELECT * FROM location;";
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
        response.setBarcodeID(randomNumber.randomProductBarcode().getBarcodeID());
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

    public Barcode generateBarcodeLocation(Connection con) throws SQLException {
        RandomNumber randomNumber = new RandomNumber();
        Barcode response = new Barcode();
        response.setBarcodeID(randomNumber.randomLocationBarcode().getBarcodeID());
        String query = "SELECT * FROM location WHERE locationbarcode ='" + response.getBarcodeID() + "';";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            response.setBarcodeID(generateBarcodeLocation(con).getBarcodeID());
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
        String query = "SELECT * FROM products;";
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
            product.setMinAmount(rs.getInt("minamount"));
            product.setMustBeRestock(rs.getBoolean("mustberestocked"));
            product.setCanBeRestock(rs.getBoolean("canberestocked"));
            response.add(product);
        }
        rs.close();
        statement.close();
        return response;
    }

    public ProductArray searchProducts(String keyWord, Connection con) throws SQLException {
        ProductArray response = new ProductArray();
        String query = "SELECT * FROM products WHERE name LIKE '%" + keyWord + "%' OR category LIKE '%" + keyWord + "%' OR maincolor LIKE '%" + keyWord + "%' OR location LIKE '%" + keyWord + "%' OR CAST(barcode AS text) LIKE '%" + keyWord + "%' OR CAST(amount AS text) LIKE '%" + keyWord + "%' OR CAST(canberestocked AS text) LIKE '%" + keyWord + "%' OR CAST(mustberestocked AS text) LIKE '%" + keyWord + "%' OR CAST(minamount AS text) LIKE '%" + keyWord + "%';";
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
            product.setMinAmount(rs.getInt("minamount"));
            product.setMustBeRestock(rs.getBoolean("mustberestocked"));
            product.setCanBeRestock(rs.getBoolean("canberestocked"));
            response.add(product);
        }

        rs.close();
        statement.close();
        return response;
    }

    public void addLocation(String newLocationName, Connection con) throws SQLException {
        String query = "INSERT INTO location VALUES (?, ?);";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, newLocationName);
        statement.setLong(2, generateBarcodeLocation(con).getBarcodeID());
        statement.executeUpdate();
        statement.close();
    }

    public void deleteLocation(String deleteLocationName, Connection con) throws SQLException {
        String query = "DELETE FROM location WHERE location='" + deleteLocationName + "';";
        PreparedStatement statement = con.prepareStatement(query);
        statement.executeUpdate();
        statement.close();
    }

}
