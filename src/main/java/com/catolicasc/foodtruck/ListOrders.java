/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Orders;
import com.catolicasc.foodtruck.repositories.OrdersRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo.rodrigues
 */
public class ListOrders extends javax.swing.JInternalFrame {

    private OrdersRepository ordersRepository = new OrdersRepository();

    /**
     * Creates new form ListUsers
     */
    public ListOrders() {
        initComponents();
    }

    public void refreshOrderList() {
        DefaultTableModel tableModel = (DefaultTableModel) jtOrders.getModel();
        tableModel.setRowCount(0);

        ArrayList<Orders> orders = ordersRepository.getAllOrders();

        for (Orders order : orders) {
            tableModel.addRow(new Object[] { order.getId(), order.getOrderdate(), order.getPrepareddate(),
                    order.getDeliverydate() });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOrders = new javax.swing.JTable();
        jbRefresh = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(640, 440));
        jInternalFrame1.setVisible(true);

        jtOrders.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } },
                new String[] { "ID", "Orderdate", "Prepareddate", "deliverydate" }));
        jScrollPane1.setViewportView(jtOrders);

        jbRefresh.setText("Atualizar");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        jbAdd.setText("Adicionar");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbUpdate.setText("Alterar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setText("Apagar");
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap().addGroup(jInternalFrame1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout
                                .createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jbDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jbAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbRefresh)))
                        .addContainerGap()));
        jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbDelete).addComponent(jbUpdate).addComponent(jbAdd)
                                .addComponent(jbRefresh))
                        .addContainerGap(23, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbDeleteActionPerformed
        if (jtOrders.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Adicionar");
            return;
        } else {

            Integer rowIndex = jtOrders.getSelectedRow();
            ordersRepository.deleteOrder((Orders) jtOrders.getModel().getValueAt(rowIndex, 0));
        }
    }// GEN-LAST:event_jbDeleteActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbUpdateActionPerformed
        if (jtOrders.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário");
            return;
        }

        Integer rowIndex = jtOrders.getSelectedRow();
        Integer orderId = (Integer) jtOrders.getModel().getValueAt(rowIndex, 0);

        Orders order = ordersRepository.getOrdersById(orderId);

        AddEditOrder addEditOrder = new AddEditOrder();
        addEditOrder.setOrder(order);
        this.getParent().add(addEditOrder);
        addEditOrder.setVisible(true);
    }// GEN-LAST:event_jbUpdateActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbAddActionPerformed
        AddEditOrder addEditOrder = new AddEditOrder();
        this.getParent().add(addEditOrder);
        addEditOrder.setVisible(true);
    }// GEN-LAST:event_jbAddActionPerformed

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbRefreshActionPerformed
        refreshOrderList();
    }// GEN-LAST:event_jbRefreshActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameOpened
        refreshOrderList();
    }// GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JTable jtOrders;
    // End of variables declaration//GEN-END:variables
}