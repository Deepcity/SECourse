package org.GUI.Form;

import org.GUI.Components.RequestWindow;
import org.algorithm.dialog.BankersAlgorithm;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OSD2 extends javax.swing.JFrame {
    Integer maxMatrix[][];
    Integer allocationMatrix[][];
    Integer available[];
    Integer rows[][];
    String columnNames[];
    static int i = 0, columnSize,rowSize;

    NeedMatrix nM;

    public OSD2() {

        initComponents();
    }

    public OSD2(int x, int y) {

        this();
        rowSize = x;
        columnSize = y;

        rows = new Integer[rowSize][columnSize];

        for(int i = 0; i < rows.length; i++){

            rows[i][0] = i;
        }

        /*for(int i = 0; i < rowSize;i++){

            for(int j = 0; j < columnSize; j++){


            }
        }*/

        columnNames = new String[columnSize * 3 + 1];
        columnNames[0] = "P.NO";

        for(i = 1; i < columnSize + 1; i++){

            columnNames[i] = "A.R[" + (i - 1) +"]";
        }

        for(int f = 0; i < columnSize * 2 + 1 ;f++,i++){

            columnNames[i] = "M.R[" + f +"]";
        }

        for(int f = 0; i < columnSize * 3 + 1;f++, i++){

            columnNames[i] = "AV.R[" + f +"]";
        }

        DefaultTableModel tableModel = new DefaultTableModel(rows, columnNames){

            @Override
            public boolean isCellEditable(int row, int column)
            {
                // make read only fields except column 0,13,14
                if(column == 0){

                    return false;
                }

                return true;
                //return column == 0 || column == 13 || column == 14;
            }
        };
        TGetData.setModel(tableModel);
        /*for(int z = 0; z < columnNames.length; z++ ){

            System.out.println(columnNames[z]+" ");
        }*/

        //TGetData.setModel(new javax.swing.table.DefaultTableModel(rows,columnNames));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.setTitle("资源设定");
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TGetData = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TGetData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TGetData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TGetData.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
                }
        ));
        TGetData.setGridColor(new java.awt.Color(0, 51, 51));
        TGetData.setInheritsPopupMenu(true);
        TGetData.setIntercellSpacing(new java.awt.Dimension(1, 10));
        TGetData.setRowHeight(30);
        TGetData.setShowGrid(true);
        TGetData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TGetDataKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(TGetData);

        jButton1.setText("确认");
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
                                .addContainerGap()
                                .addComponent(jScrollPane3)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addGap(303, 303, 303))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("*A.R[x] = 资源x的Allocation矩阵");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*M.R[x] = 资源x的Max矩阵");
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*AV.R[x] = 资源x的Availability矩阵");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        getDataFromTable();
        BankersAlgorithm b;


        for(int i=0;i<rowSize;i++){
            for(int j=0;j<columnSize;j++){
                if(allocationMatrix[i][j] > maxMatrix[i][j]){
                    System.out.println("Alication矩阵大于Max矩阵");
                    JOptionPane.showMessageDialog(this,"数据不合法，Alication矩阵必须小于Max矩阵，需要请重新输入数据");
                    return ;
                }
            }
        }

        b = new BankersAlgorithm(allocationMatrix, maxMatrix, available, columnSize, rowSize);

        b.needMatrix = b.computeNeedMatrix();
        Object x[] = b.isSafe();

        System.out.println("\n---------------------------");
        System.out.println((String)x[1]);

        nM = new NeedMatrix((Object[][])x[2],columnSize);
        nM.setVisible(true);

        JOptionPane.showMessageDialog(this, (String)x[1],"RESULT",1);
        //new Conclusion((String)x[1]).setVisible(true);
//        nM .setVisible(false);

        int isYes;

        isYes = JOptionPane.showConfirmDialog(this,"进程需要做出更多请求吗？","确认进程需求", JOptionPane.YES_NO_OPTION);

        if(isYes == JOptionPane.YES_OPTION){
            getDataFromTable();
            new RequestWindow(columnSize,rowSize, allocationMatrix, available, maxMatrix).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TGetDataKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TGetDataKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if(!(Character.isDigit(c) || evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE)){

            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "输入数据不合法");
        }
        // A > M
    }//GEN-LAST:event_TGetDataKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(OSD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OSD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OSD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OSD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OSD2().setVisible(true);
            }
        });
    }
    void getDataFromTable(){

        maxMatrix = new Integer[rowSize][columnSize];
        allocationMatrix = new Integer[rowSize][columnSize];;
        available = new Integer[columnSize];
        DefaultTableModel d = (DefaultTableModel) TGetData.getModel();

        int j = 0;
        //columnSize,rowSize
        for(i = 0; i < rowSize; i++){
            for(j = 1; j < columnSize + 1; j++){

                if(d.getValueAt(i, j) == null){
                    allocationMatrix[i][j - 1] = 0;
                } else allocationMatrix[i][j - 1] = Integer.parseInt(d.getValueAt(i, j)  + "");
            }

            for(int x = 0; j < columnSize * 2 + 1; j++, x++){

                if(d.getValueAt(i, j) == null){
                    maxMatrix[i][x] = 0;
                }else maxMatrix[i][x] = Integer.parseInt(d.getValueAt(i, j)  + "");
            }
        }

        j = columnSize * 2 + 1;
        System.out.println(j);

        for(int x = 0; j < columnSize * 3 + 1; x++,j++){

            if(d.getValueAt(0, j) == null){
                available[x] = 0;
            }else available[x] = Integer.parseInt(d.getValueAt(0, j)  + "");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TGetData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
