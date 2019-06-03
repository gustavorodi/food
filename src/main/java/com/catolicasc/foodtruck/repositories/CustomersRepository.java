package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Customers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gustavo.rodrigues
 */
public class CustomersRepository {
    private Connection connection;
    
    public CustomersRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public Customers getCustomerById(Integer customersId) {
        try{
            String sql = "SELECT ID, NOME, EMAIL, ADDRESS FROM CUSTOMERS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, customersId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Customers customer = null;
            
            if(resultSet.first()) {
                customer = new Customers();
            
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");

                customer.setId(id);
                customer.setNome(nome);
                customer.setEmail(email);
                customer.setAddress(address);
            }
            
            return customer;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Customers> getAllCustomers() {
        try{
            ArrayList<Customers> customers = new ArrayList<>();
            
            String sql = "SELECT ID, NOME, EMAIL, ADDRESS FROM CUSTOMERS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");
                
                Customers customer = new Customers();
                customer.setId(id);
                customer.setNome(nome);
                customer.setEmail(email);
                customer.setAddress(address);
                
                customers.add(customer);
            }
            
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Customers add(Customers customer) {
        try {
            String sql = "INSERT INTO CUSTOMERS (NOME, EMAIL, ADDRESS) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, customer.getNome());
            insertStmt.setString(2, customer.getEmail());
            insertStmt.setString(3, customer.getAddess());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                customer.setId(id);
            }
            selectStmt.close();
            
            return customer;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Customers deleteCustomer(Customers customer){
       try{
           String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
           PreparedStatement deleteStmt = connection.prepareStatement(sql);
           deleteStmt.setInt(1, customer.getId());
           deleteStmt.execute();
           deleteStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return customer;
   }
    
    public Customers alterCustomer(Customers customer) {
       try{
           String sql = "UPDATE PRODUCTS SET NOME = ?, EMAIL = ?,  ADDRESS = ? WHERE ID = ?";
           PreparedStatement updatetStmt = connection.prepareStatement(sql);
           updatetStmt.setString(1, customer.getName());
           updatetStmt.setString(2, customer.getEmail());
           updatetStmt.setString(3, customer.getAddess());
           updatetStmt.setInt(4, customer.getId());
           updatetStmt.executeUpdate();
           updatetStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return customer;
   }	
}
