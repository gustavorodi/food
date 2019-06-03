/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.models.Products;
import com.catolicasc.foodtruck.repositories.ProductsRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gustavo.rodrigues
 */
public class ListProducts extends javax.swing.JInternalFrame {

    private ProductsRepository productsRepository = new ProductsRepository();

    /**
     * Creates new form ListProducts
     */
    public ListProducts() {
        initComponents();
    }

    public void refreshProductList() {
        DefaultTableModel tableModel = (DefaultTableModel) jtProducts.getModel();
        tableModel.setRowCount(0);

        ArrayList<Products> products = productsRepository.getAllProduct();

        for (Products product : products) {
            tableModel.addRow(new Object[] { product.getId(), product.getPrice(), product.getDescription() });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtProducts = new javax.swing.JTable();
        jbUpdate = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbRefresh = new javax.swing.JButton();
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

        jtProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null }, { null, null }, { null, null }, { null, null } },
                new String[] { "ID", "Preco" }));
        jScrollPane2.setViewportView(jtProducts);

        jbUpdate.setText("Alterar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbAdd.setText("Adicionar");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbRefresh.setText("Atualizar");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        jbDelete.setText("Apagar");
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jbDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbRefresh)))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jbUpdate)
                        .addComponent(jbRefresh).addComponent(jbAdd).addComponent(jbDelete))
                .addContainerGap(23, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbDeleteActionPerformed
        if (jtProducts.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Adicionar");
            return;
        } else {

            Integer rowIndex = jtProducts.getSelectedRow();
            productsRepository.deleteProduct((Products) jtProducts.getModel().getValueAt(rowIndex, 0));

        }

    }// GEN-LAST:event_jbDeleteActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbUpdateActionPerformed
        if (jtProducts.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário");
            return;
        }

        Integer rowIndex = jtProducts.getSelectedRow();
        Integer productId = (Integer) jtProducts.getModel().getValueAt(rowIndex, 0);

        Products product = productsRepository.getProductById(productId);

        AddEditProduct addEditProduct = new AddEditProduct();
        addEditProduct.setProduct(product);
        this.getParent().add(addEditProduct);
        addEditProduct.setVisible(true);
    }// GEN-LAST:event_jbUpdateActionPerformed

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbAddActionPerformed
        AddEditProduct addEditProduct = new AddEditProduct();
        this.getParent().add(addEditProduct);
        addEditProduct.setVisible(true);
    }// GEN-LAST:event_jbAddActionPerformed

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbRefreshActionPerformed
        refreshProductList();
    }// GEN-LAST:event_jbRefreshActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {// GEN-FIRST:event_formInternalFrameOpened
        refreshProductList();
    }// GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JTable jtProducts;
    // End of variables declaration//GEN-END:variables
}