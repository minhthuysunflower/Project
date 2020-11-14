/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbcquizmt;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class questionForm extends javax.swing.JFrame {
    private static Connection conn;
    DefaultTableModel tb = new DefaultTableModel();

    /**
     * Creates new form QuestionForm
     */
    public questionForm() {
        initComponents();
        setIcon();
        load();
       
    }
        public void load(){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=KBCQuizDatabase","sa","sunflower");
           int number;
           Vector row, column;
           column = new Vector();
           Statement st = conn.createStatement();
           ResultSet rs= st.executeQuery("select * from QuestionAnswer");
           ResultSetMetaData metadata= rs.getMetaData();
           number = metadata.getColumnCount();
           for(int i = 1;i<=number;i++){
               column.add(metadata.getColumnName(i));
           }
           tb.setColumnIdentifiers(column);
           while(rs.next()){
               row = new Vector();
               for(int i=1;i<=number;i++){
                  row.addElement(rs.getString(i));
               }
               tb.addRow(row);
               dataquestion.setModel(tb);
           }
           dataquestion.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                   if(dataquestion.getSelectedRow()>=0){                    
                      id.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 0)+ "");
                      qname.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 1)+ "");
                       qcategory.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 2)+ "");
                      qanswera.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 3)+ "");  
                       qanswerb.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 4)+ "");  
                      qanswerc.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 5)+ "");  
                      qanswerd.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 6)+ "");  
                      qanswerright.setText(dataquestion.getValueAt(dataquestion.getSelectedRow(), 7)+ "");  
                     
                      
                   }
               }
           });
            
                
             
                
                
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
   
  
     public void clear(){
         id.setText("");
         qname.setText("");
         qcategory.setText("");
         qanswera.setText("");
         qanswerb.setText("");
         qanswerc.setText("");
         qanswerd.setText("");
         qanswerright.setText("");
     }
  
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        qname = new javax.swing.JTextField();
        qcategory = new javax.swing.JTextField();
        qanswera = new javax.swing.JTextField();
        qanswerb = new javax.swing.JTextField();
        qanswerc = new javax.swing.JTextField();
        qanswerd = new javax.swing.JTextField();
        qanswerright = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        updatequestion = new javax.swing.JButton();
        deletep = new javax.swing.JButton();
        menuq = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataquestion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton4.setText("Insert");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton6.setBackground(new java.awt.Color(153, 255, 153));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton6.setText("Delete");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KBC Quiz");
        setAlwaysOnTop(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(226,240,240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton1.setText("Update");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 15, 120, 30));

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton2.setText("Delete");
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 54, 120, 30));

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton3.setText("Menu");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 132, 120, 30));

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton5.setText("Load Data");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 93, 120, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setText("Questionid");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        id.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 205, 25));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setText("Questionname");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setText("Category");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setText("AnswerA");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel6.setText("AnswerB");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setText("AnswerC");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel8.setText("AnswerD");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel9.setText("AnswerRight");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        qname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        qname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qnameActionPerformed(evt);
            }
        });
        jPanel3.add(qname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 205, 25));

        qcategory.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qcategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 205, 25));

        qanswera.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qanswera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qanswera, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 205, 25));

        qanswerb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qanswerb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qanswerb, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 205, 25));

        qanswerc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qanswerc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qanswerc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 205, 25));

        qanswerd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qanswerd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qanswerd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 205, 25));

        qanswerright.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        qanswerright.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(qanswerright, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 205, 25));

        jPanel4.setBackground(new java.awt.Color(255,255,255,150));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel10.setText("Manage Question");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(383, 383, 383))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        updatequestion.setBackground(new java.awt.Color(153, 255, 153));
        updatequestion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        updatequestion.setText("Update");
        updatequestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatequestionActionPerformed(evt);
            }
        });
        jPanel3.add(updatequestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 100, 25));

        deletep.setBackground(new java.awt.Color(153, 255, 153));
        deletep.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        deletep.setText("Delete ");
        deletep.setBorder(null);
        deletep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletepActionPerformed(evt);
            }
        });
        jPanel3.add(deletep, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, 25));

        menuq.setBackground(new java.awt.Color(153, 255, 153));
        menuq.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        menuq.setText("Menu");
        menuq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuqActionPerformed(evt);
            }
        });
        jPanel3.add(menuq, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 100, 25));

        jPanel5.setBackground(new java.awt.Color(255,255,255,150));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel11.setText("Question List");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel11)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 990, 40));

        dataquestion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dataquestion);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 990, 280));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 990, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Imageforproject\\sky1.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 560));

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

    private void qnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qnameActionPerformed

    private void updatequestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatequestionActionPerformed
         String name = qname.getText();
        if(name.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter name of question!");
        }
         String category = qcategory.getText();
        if(category.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter category of question!");
        }
         String answera = qanswera.getText();
        if(answera.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter answer a of question!");
        }
         String answerb = qanswerb.getText();
        if(answerb.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter answer b of question!");
        }
         String answerc = qanswerc.getText();
        if(answerc.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter answer c of question!");
        }
         String answerd = qanswerd.getText();
        if(answerd.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter answer d of question!");
        }
         String answerright = qanswerright.getText();
        if(answerright.equals("")){
           JOptionPane.showMessageDialog(this, "Please enter answer right of question!");
        }
        if(!name.equals("")&&!category.equals("")&&!answera.equals("")&&!answerb.equals("")&&!answerc.equals("")&&!answerd.equals("")&&!answerright.equals("")){
             try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=KBCQuizDatabase","sa","sunflower");
           

           String update= "update QuestionAnswer set Questionname=?, Category=?,AnswerA=?,AnswerB=?,AnswerC=?,AnswerD=?,AnswerRight=? where Questionid=?";
             PreparedStatement pst = conn.prepareStatement(update);
              pst.setString(8, id.getText());
              pst.setString(1, qname.getText());
              pst.setString(2, qcategory.getText());
              pst.setString(3, qanswera.getText());
              pst.setString(4, qanswerb.getText());
              pst.setString(5, qanswerc.getText());
              pst.setString(6, qanswerd.getText());
              pst.setString(7, qanswerright.getText());
              pst.executeUpdate();
              JOptionPane.showMessageDialog(this, "update Successfully");
              
              tb.setRowCount(0);
              load();
              clear();
              
        }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
        }
         
        
        
    }//GEN-LAST:event_updatequestionActionPerformed

    private void menuqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuqActionPerformed
        new menuAdmin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuqActionPerformed

    private void deletepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletepActionPerformed
       try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
           String delete = "delete QuestionAnswer where Questionid=?";
           PreparedStatement pst = conn.prepareStatement(delete);
           pst.setString(1, id.getText());
           pst.executeUpdate();
           JOptionPane.showMessageDialog(this, "Delete successfully!");
           tb.setRowCount(0);
           load();
       }
       catch(Exception e){
           
       }
    }//GEN-LAST:event_deletepActionPerformed

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
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new questionForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataquestion;
    private javax.swing.JButton deletep;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menuq;
    private javax.swing.JTextField qanswera;
    private javax.swing.JTextField qanswerb;
    private javax.swing.JTextField qanswerc;
    private javax.swing.JTextField qanswerd;
    private javax.swing.JTextField qanswerright;
    private javax.swing.JTextField qcategory;
    private javax.swing.JTextField qname;
    private javax.swing.JButton updatequestion;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logokbcquiz2.png")));
    }
}