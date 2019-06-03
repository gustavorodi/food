/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gustavo.rodrigues
 */
public class ProductsRepository {
    private Connection connection;
    
    public ProductsRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public Products getProductById(Integer productId) {
        try{
            String sql = "SELECT ID, DESCRIPTION, PRICE FROM PRODUCTS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, productId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Products product = null;
            
            if(resultSet.first()) {
                product = new Products();
            
                int id = resultSet.getInt("ID");
                String description = resultSet.getString("DESCRIPTION");
                Float price = resultSet.getFloat("PRICE");

                product.setId(id);
                product.setDescription(description);
                product.setPrice(price);
            }
            
            return product;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Products> getAllProducts() {
        try{
            ArrayList<Products> products = new ArrayList<>();
            
            String sql = "SELECT ID, DESCRIPTION, PRICE FROM PRODUCTS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String description = resultSet.getString("DESCRIPTION");
                Float price = resultSet.getFloat("PRICE");
                
                Products product = new Products();
                product.setId(id);
                product.setDescription(description);
                product.setPrice(price);
                
                products.add(product);
            }
            
            return products;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Products add(Products product) {
        try {
            String sql = "INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, product.getDescription());
            insertStmt.setFloat(2, product.getPrice());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                product.setId(id);
            }
            selectStmt.close();
            
            return product;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
	public Products deleteProduct(Products product){
       try{
           String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
           PreparedStatement deleteStmt = connection.prepareStatement(sql);
           deleteStmt.setInt(1, product.getId());
           deleteStmt.execute();
           deleteStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return product;
   }
  
   public Products alterProduct(Products product) {
       try{
           String sql = "UPDATE PRODUCTS SET DESCRIPTION = ?, PRICE = ? WHERE ID = ?";
           PreparedStatement updatetStmt = connection.prepareStatement(sql);
           updatetStmt.setString(1, product.getDescription());
           updatetStmt.setFloat(2, product.getPrice());
           updatetStmt.setInt(3,product.getId());
           updatetStmt.executeUpdate();
           updatetStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return product;
   }	

    public ArrayList<Products> getAllProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
