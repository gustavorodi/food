/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Users;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
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
public class UsersRepository {
   private Connection connection;
  
   public UsersRepository() {
       connection = new ConnectionFactory().getConnection();
   }
  
   public Users getUserById(Integer userId) {
       try{
           String sql = "SELECT ID, NOME, EMAIL FROM USERS WHERE ID = ?";
           PreparedStatement selectStmt = connection.prepareStatement(sql);
           selectStmt.setInt(1, userId);
           ResultSet resultSet = selectStmt.executeQuery();
          
           Users user = null;
          
           if(resultSet.first()) {
               user = new Users();
          
               int id = resultSet.getInt("ID");
               String name = resultSet.getString("NOME");
               String email = resultSet.getString("EMAIL");

               user.setId(id);
               user.setName(name);
               user.setEmail(email);
           }
          
           return user;
          
          
       }catch (SQLException ex) {
           throw new RuntimeException(ex);
       }
   }
  
   public ArrayList<Users> getAllUsers() {
       try{
           ArrayList<Users> users = new ArrayList<>();
          
           String sql = "SELECT ID, NOME, EMAIL FROM USERS";
           Statement selectStmt = connection.createStatement();
           ResultSet resultSet = selectStmt.executeQuery(sql);
           while(resultSet.next()) {
               int id = resultSet.getInt("ID");
               String name = resultSet.getString("NOME");
               String email = resultSet.getString("EMAIL");
              
               Users user = new Users();
               user.setId(id);
               user.setName(name);
               user.setEmail(email);
              
               users.add(user);
           }
          
           return users;
       }catch (SQLException ex) {
           throw new RuntimeException(ex);
       }
   }
  
   public Users add(Users user) {
       try {
           String sql = "INSERT INTO USERS (NOME, EMAIL) VALUES (?, ?)";
           PreparedStatement insertStmt = connection.prepareStatement(sql);
           insertStmt.setString(1, user.getName());
           insertStmt.setString(2, user.getEmail());
           insertStmt.executeUpdate();
           insertStmt.close();
          
           sql = "SELECT LAST_INSERT_ID() AS ID";
           Statement selectStmt = connection.createStatement();
           ResultSet resultSet = selectStmt.executeQuery(sql);
           while(resultSet.next()) {
               Integer id  = resultSet.getInt("ID");
               user.setId(id);
           }
           selectStmt.close();
          
           return user;
       }catch (SQLException ex) {
           throw new RuntimeException(ex);
       }
   }

   public Users deleteUser(Users user){
       try{
           String sql = "DELETE FROM USERS WHERE ID = ?";
           PreparedStatement deleteStmt = connection.prepareStatement(sql);
           deleteStmt.setInt(1, user.getId());
           deleteStmt.execute();
           deleteStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return user;
   }
  
   public Users alterUser(Users user) {
       try{
           String sql = "UPDATE USERS SET NOME = ?, EMAIL = ? WHERE ID = ?";
           PreparedStatement updatetStmt = connection.prepareStatement(sql);
           updatetStmt.setString(1, user.getName());
           updatetStmt.setString(2, user.getEmail());
           updatetStmt.setInt(3, user.getId());
           updatetStmt.executeUpdate();
           updatetStmt.close();
          
       }catch(SQLException ex){
           throw new RuntimeException(ex);
       }
       return user;
   }
  
}
