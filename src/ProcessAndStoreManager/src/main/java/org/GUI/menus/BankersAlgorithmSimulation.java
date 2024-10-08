package org.GUI.menus;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.GUI.Form.OSD2;

import javax.swing.*;
public class BankersAlgorithmSimulation extends javax.swing.JFrame {

    public BankersAlgorithmSimulation() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.setTitle("Banker's Algorithm");
        jPanel1 = new javax.swing.JPanel();
        LTiltle = new javax.swing.JLabel();
        LTotalProcesses = new javax.swing.JLabel();
        TfTotalProcesses = new javax.swing.JTextField();
        LTotalResources = new javax.swing.JLabel();
        TfTotalResources = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setResizable(false);

        LTiltle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        LTiltle.setText("Banker's Algorithm");
        LTiltle.setVerifyInputWhenFocusTarget(false);

        LTotalProcesses.setFont(new java.awt.Font("", 1, 12)); // NOI18N
        LTotalProcesses.setText("总进程数");

        TfTotalProcesses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfTotalProcessesKeyTyped(evt);
            }
        });

        LTotalResources.setFont(new java.awt.Font("", 1, 12)); // NOI18N
        LTotalResources.setText("总资源数");

        TfTotalResources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfTotalResourcesActionPerformed(evt);
            }
        });
        TfTotalResources.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfTotalResourcesKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("", 1, 12)); // NOI18N
        jButton1.setText("确认");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(LTotalProcesses)
                                                        .addComponent(LTotalResources))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(TfTotalProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TfTotalResources, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(LTiltle)
                                                .addGap(55, 55, 55))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(LTiltle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LTotalProcesses)
                                        .addComponent(TfTotalProcesses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TfTotalResources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LTotalResources))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TfTotalResourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfTotalResourcesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfTotalResourcesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if(isValidData()){

            String totalProces = TfTotalProcesses.getText().trim();
            String totalResource = TfTotalResources.getText().trim();
            //System.out.println(totalProces);
            //System.out.println(totalResource);
            if(Integer.parseInt(totalProces) < 2 || Integer.parseInt(totalResource) < 2){

                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "进程数必须大于2");
            }
            else{
                setLocation(0, 180);
                new OSD2(Integer.parseInt(totalProces),Integer.parseInt(totalResource)).setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TfTotalProcessesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfTotalProcessesKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if(!(Character.isDigit(c) || Character.isISOControl(c))){

            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "只允许数字输入");
        }

    }//GEN-LAST:event_TfTotalProcessesKeyTyped

    private void TfTotalResourcesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfTotalResourcesKeyTyped
        // TODO add your handling code here
        char c = evt.getKeyChar();

        if(!(Character.isDigit(c) || Character.isISOControl(c))){

            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "只允许数字输入");
        }
    }//GEN-LAST:event_TfTotalResourcesKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankersAlgorithmSimulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankersAlgorithmSimulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankersAlgorithmSimulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankersAlgorithmSimulation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankersAlgorithmSimulation().setVisible(true);
            }
        });
    }

    public boolean isValidData(){

        if(TfTotalProcesses.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(this, "请先输入数据");
            return false;
        }
        else if(TfTotalResources.getText().trim().isEmpty()){

            JOptionPane.showMessageDialog(this, "请先输入数据");
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTiltle;
    private javax.swing.JLabel LTotalProcesses;
    private javax.swing.JLabel LTotalResources;
    private javax.swing.JTextField TfTotalProcesses;
    private javax.swing.JTextField TfTotalResources;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
