/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.models;

import java.sql.Date;

/**
 *
 * @author gustavo.rodrigues
 */
public class Orders {
    private Integer id;
    private Date orderdate;
    private Date prepareddate;
    private Date deliverydate;
    
    public Integer getId() {
        return id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public Date getPrepareddate() {
        return prepareddate;
    }
    
    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setOrderdate(Date orderdate){
        this.orderdate = orderdate; 
    }

    public void setPrepareddate(Date prepareddate) {
        this.prepareddate = prepareddate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public void setOrderdate(String orderdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrepareddate(String prepareddate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDeliverydate(String deliverydate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

