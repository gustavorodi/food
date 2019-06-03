/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Orders;
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
public class OrdersRepository {
    private Connection connection;
    
    public OrdersRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public Orders getOrdersById(Integer ordersId) {
        try{
            String sql = "SELECT ID, ORDERDATE, PREPAREDDATE, DELIVERYDATE FROM ORDERS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, ordersId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Orders orders = null;
            
            if(resultSet.first()) {
                orders = new Orders();
            
                int id = resultSet.getInt("ID");
                Date orderdate = resultSet.getDate("ORDERDATE");
                Date prepareddate = resultSet.getDate("PREPAREDDATE");
                Date deliverydate = resultSet.getDate("DELIVERYDATE");

                orders.setId(id);
                orders.setOrderdate(orderdate);
                orders.setPrepareddate(prepareddate);
                orders.setDeliverydate(deliverydate);
            }
            
            return orders;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Orders> getAllUsers() {
        try{
            ArrayList<Orders> orders = new ArrayList<>();
            
            String sql = "SELECT ID, ORDERDATE, PREPAREDDATE, DELIVERYDATE FROM ORDERS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                Date orderdate = resultSet.getDate("ORDERDATE");
                Date prepareddate = resultSet.getDate("PREPAREDDATE");
                Date deliverydate = resultSet.getDate("DELIVERYDATE");
                
                Orders order = new Orders();
                order.setId(id);
                order.setOrderdate(orderdate);
                order.setPrepareddate(prepareddate);
                order.setDeliverydate(deliverydate);
                
                orders.add(order);
            }
            
            return orders;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Orders add(Orders order) {
        try {
            String sql = "INSERT INTO ORDERS (ORDERDATE, PREPAREDDATE, DELIVERYDATE ) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setDate(1, order.getOrderdate());
            insertStmt.setDate(2, order.getPrepareddate());
            insertStmt.setDate(3, order.getDeliverydate());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                order.setId(id);
            }
            selectStmt.close();
            
            return order;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Orders deleteOrder(Orders order){
       try{
           String sql = "DELETE FROM ORDERS WHERE ID = ?";
           PreparedStatement deleteStmt = connection.prepareStatement(sql);
           deleteStmt.setString(1,order.getId().toString() );
           deleteStmt.execute();
           deleteStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return order;
    }


   public Orders alterOrder(Orders order) {
       try{
           String sql = "UPDATE ORDERS SET ORDERDATE = ?, PREPAREDDATE = ?, DELIVERYDATE = ? WHERE ID = ?";
           PreparedStatement updatetStmt = connection.prepareStatement(sql);
           updatetStmt.setDate(1, order.getOrderdate());
           updatetStmt.setDate(2, order.getPrepareddate());
           updatetStmt.setDate(3, order.getDeliverydate());
           updatetStmt.setInt(4, order.getId());
           updatetStmt.executeUpdate();
           updatetStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return order;
   }

    public ArrayList<Orders> getAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
