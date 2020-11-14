/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbcquizmt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import static javafx.scene.Cursor.cursor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static kbcquizmt.ChooseQuestion.ansRight;

/**
 *
 * @author ASUS
 */
public class questionAnswer extends javax.swing.JFrame implements ActionListener {
   private static Connection conn;

   public static int index=0;
   int count=0;
   int qid=1;

    String ansSelect1;
      String ansSelect2;
        String ansSelect3;
          String ansSelect4;
    String ansRight;
  
    /**
     * Creates new form QuestionAnswer
     */
    public questionAnswer() {
        initComponents();
        setIcon();
        getQuestion(qid);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        
        
       
    }
    
    public void getQuestion(int setid){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
         
           String check = "select * from SetQuestion where Setid=" + setid;
           PreparedStatement pst = conn.prepareStatement(check);
           
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
             
                String q = rs.getString(3);
                String a = rs.getString(5);
                String b = rs.getString(6);
                String c = rs.getString(7);
                String d = rs.getString(8);
                ansRight = rs.getString(9);
                questiona.setText("<html>" +  q + "</html>");
                answera.setText(a);
                answerb.setText(b);
                answerc.setText(c);
                answerd.setText(d);
                namePlayer.setText(ChooseQuestion.enamePlayer.getText());
                categoryQuestion.setText(ChooseQuestion.chooseCategory.getSelectedItem().toString());
               // System.out.println(id);
                
             
             
            }
           
               if(index==0){
                   no.setText("1");
               }
               if(index==1){
                   q1.setForeground(Color.green);
                   no.setText("2");
               }
               if(index==2){
                   q2.setForeground(Color.green);
                   q1.setForeground(Color.black);
                   no.setText("3");

               }
               if(index==3){
                   q3.setForeground(Color.green);
                   q2.setForeground(Color.black);
                   no.setText("4");

               }
               if(index==4){
                   q4.setForeground(Color.green);
                   q3.setForeground(Color.black);
                   no.setText("5");
               }
               if(index==5){
                   q5.setForeground(Color.green);
                   q4.setForeground(Color.black);
                   no.setText("6");
               }
               if(index==6){
                   q6.setForeground(Color.green);
                   q5.setForeground(Color.black);
                   no.setText("7");
               }
               if(index==7){
                   q7.setForeground(Color.green);
                   q6.setForeground(Color.black);
                   no.setText("8");
               }
               if(index==8){
                   q8.setForeground(Color.green);
                   q7.setForeground(Color.black);
                   no.setText("9");
               }
               if(index==9){
                   q9.setForeground(Color.green);
                   q8.setForeground(Color.black);
                   no.setText("10");
               }
               if(index==10){
                   q10.setForeground(Color.green);
                   q9.setForeground(Color.black);
                   no.setText("11");
               }
               if(index==11){
                   q11.setForeground(Color.green);
                   q10.setForeground(Color.black);
                   no.setText("12");
                   new resultForm().setVisible(true);
                   this.setVisible(false);
                   resultForm.namePlayerResult.setText(namePlayer.getText());
                   resultForm.categoryQuestionResult.setText(categoryQuestion.getText());
                   resultForm.anstrue.setText(no.getText());
                   
               }
               if(index==12){
                   q12.setForeground(Color.green);
                   q11.setForeground(Color.black);
                   no.setText("Question:13");
               }
               if(index==13){
                   q13.setForeground(Color.green);
                   q12.setForeground(Color.black);
               }
              
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
    
    }
    public void answerb(){
         ansSelect1 = answerb.getText();
        
        if(ansSelect1.equals(ansRight)){
            JOptionPane.showMessageDialog(this, "right");
          // q1.setBackground(Color.red);
                      index++;
                 qid++;
               
            getQuestion(qid);
                



        }
        else{
           
                   try{
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
                      String insert = "insert into PlayGame(Playername,CategoryQuestion) values(?,?)";
                      PreparedStatement pst = conn.prepareStatement(insert);
                      pst.setString(1,namePlayer.getText());
                      pst.setString(2,categoryQuestion.getText());
                      int rs = pst.executeUpdate();
                      if(rs>0){
                           new resultForm().setVisible(true);
                   this.setVisible(false);
                   resultForm.namePlayerResult.setText(namePlayer.getText());
                   resultForm.categoryQuestionResult.setText(categoryQuestion.getText());
                   resultForm.anstrue.setText(no.getText());
                       if(index==1){ 
                       resultForm.anstrue.setText("1");
                       resultForm.prizemoney.setText("$50");
                   }
                   if(index==2){
                      resultForm.anstrue.setText("2");
                       resultForm.prizemoney.setText("$100");
                  }
                   if(index==3){
                      resultForm.anstrue.setText("3");
                       resultForm.prizemoney.setText("$200");
                  }
                   if(index==4){
                      resultForm.anstrue.setText("4");
                       resultForm.prizemoney.setText("$400");
                  }
                   if(index==5){
                      resultForm.anstrue.setText("5");
                       resultForm.prizemoney.setText("$800");
                  }
                   if(index==6){
                      resultForm.anstrue.setText("6");
                       resultForm.prizemoney.setText("$1,600");
                  }
                   if(index==7){
                      resultForm.anstrue.setText("7");
                       resultForm.prizemoney.setText("$3,200");
                  }
                   if(index==8){
                      resultForm.anstrue.setText("8");
                       resultForm.prizemoney.setText("$6,400");
                  }
                   if(index==9){
                      resultForm.anstrue.setText("9");
                       resultForm.prizemoney.setText("$12,500");
                  }
                   if(index==10){
                      resultForm.anstrue.setText("10");
                       resultForm.prizemoney.setText("$25,000");
                  }
                   if(index==11){
                      resultForm.anstrue.setText("11");
                       resultForm.prizemoney.setText("$50,000");
                  }
                   if(index==12){
                      resultForm.anstrue.setText("12");
                       resultForm.prizemoney.setText("$1,000,000");
                  }
                   if(index==13){
                      resultForm.anstrue.setText("13");
                       resultForm.prizemoney.setText("$5,000,000");
                  }
                      }
                   }
                   catch(Exception e){
                        System.out.println(e.getMessage());

                   }
                
        }
    }
    public void answera(){
         ansSelect2 = answera.getText();
        
        if(ansSelect2.equals(ansRight)){
            JOptionPane.showMessageDialog(this, "right");
            //q1.setBackground(Color.red);
            index++;
           qid++;
               
            getQuestion(qid);
            
        }
        else{
           
                   try{
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
                      String insert = "insert into PlayGame(Playername,CategoryQuestion) values(?,?)";
                      PreparedStatement pst = conn.prepareStatement(insert);
                      pst.setString(1,namePlayer.getText());
                      pst.setString(2,categoryQuestion.getText());
                      int rs = pst.executeUpdate();
                         if(rs>0){
                           new resultForm().setVisible(true);
                   this.setVisible(false);
                   resultForm.namePlayerResult.setText(namePlayer.getText());
                   resultForm.categoryQuestionResult.setText(categoryQuestion.getText());
                   resultForm.anstrue.setText(no.getText());
                  if(index==1){ 
                       resultForm.anstrue.setText("1");
                       resultForm.prizemoney.setText("$50");
                   }
                   if(index==2){
                      resultForm.anstrue.setText("2");
                       resultForm.prizemoney.setText("$100");
                  }
                   if(index==3){
                      resultForm.anstrue.setText("3");
                       resultForm.prizemoney.setText("$200");
                  }
                   if(index==4){
                      resultForm.anstrue.setText("4");
                       resultForm.prizemoney.setText("$400");
                  }
                   if(index==5){
                      resultForm.anstrue.setText("5");
                       resultForm.prizemoney.setText("$800");
                  }
                   if(index==6){
                      resultForm.anstrue.setText("6");
                       resultForm.prizemoney.setText("$1,600");
                  }
                   if(index==7){
                      resultForm.anstrue.setText("7");
                       resultForm.prizemoney.setText("$3,200");
                  }
                   if(index==8){
                      resultForm.anstrue.setText("8");
                       resultForm.prizemoney.setText("$6,400");
                  }
                   if(index==9){
                      resultForm.anstrue.setText("9");
                       resultForm.prizemoney.setText("$12,500");
                  }
                   if(index==10){
                      resultForm.anstrue.setText("10");
                       resultForm.prizemoney.setText("$25,000");
                  }
                   if(index==11){
                      resultForm.anstrue.setText("11");
                       resultForm.prizemoney.setText("$50,000");
                  }
                   if(index==12){
                      resultForm.anstrue.setText("12");
                       resultForm.prizemoney.setText("$1,000,000");
                  }
                   if(index==13){
                      resultForm.anstrue.setText("13");
                       resultForm.prizemoney.setText("$5,000,000");
                  }
                  
                      }
                   }
                   catch(Exception e){
                      System.out.println(e.getMessage());

                   }
                
                }
    }
    public void answerc(){
        ansSelect3 = answerc.getText();
        
        if(ansSelect3.equals(ansRight)){
            JOptionPane.showMessageDialog(this, "right");
            //q1.setBackground(Color.red);
                        index++;
                           qid++;
               
            getQuestion(qid);



        }
        else{
            
                  try{
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
                      String insert = "insert into PlayGame(Playername,CategoryQuestion) values(?,?)";
                      PreparedStatement pst = conn.prepareStatement(insert);
                      pst.setString(1,namePlayer.getText());
                      pst.setString(2,categoryQuestion.getText());
                      int rs = pst.executeUpdate();
                      if(rs>0){
                          new resultForm().setVisible(true);
                   this.setVisible(false);
                   resultForm.namePlayerResult.setText(namePlayer.getText());
                   resultForm.categoryQuestionResult.setText(categoryQuestion.getText());
                   resultForm.anstrue.setText(no.getText());
                      if(index==1){ 
                       resultForm.anstrue.setText("1");
                       resultForm.prizemoney.setText("$50");
                   }
                   if(index==2){
                      resultForm.anstrue.setText("2");
                       resultForm.prizemoney.setText("$100");
                  }
                   if(index==3){
                      resultForm.anstrue.setText("3");
                       resultForm.prizemoney.setText("$200");
                  }
                   if(index==4){
                      resultForm.anstrue.setText("4");
                       resultForm.prizemoney.setText("$400");
                  }
                   if(index==5){
                      resultForm.anstrue.setText("5");
                       resultForm.prizemoney.setText("$800");
                  }
                   if(index==6){
                      resultForm.anstrue.setText("6");
                       resultForm.prizemoney.setText("$1,600");
                  }
                   if(index==7){
                      resultForm.anstrue.setText("7");
                       resultForm.prizemoney.setText("$3,200");
                  }
                   if(index==8){
                      resultForm.anstrue.setText("8");
                       resultForm.prizemoney.setText("$6,400");
                  }
                   if(index==9){
                      resultForm.anstrue.setText("9");
                       resultForm.prizemoney.setText("$12,500");
                  }
                   if(index==10){
                      resultForm.anstrue.setText("10");
                       resultForm.prizemoney.setText("$25,000");
                  }
                   if(index==11){
                      resultForm.anstrue.setText("11");
                       resultForm.prizemoney.setText("$50,000");
                  }
                   if(index==12){
                      resultForm.anstrue.setText("12");
                       resultForm.prizemoney.setText("$1,000,000");
                  }
                   if(index==13){
                      resultForm.anstrue.setText("13");
                       resultForm.prizemoney.setText("$5,000,000");
                  }
                      }
                   }
                   catch(Exception e){
                                              System.out.println(e.getMessage());

                   }
                
        }
    }
    public void answerd(){
         ansSelect4 = answerd.getText();
        
        if(ansSelect4.equals(ansRight)){
            JOptionPane.showMessageDialog(this, "right");
                      index++;

                             qid++;
               
            getQuestion(qid);


        }
        else{
            
                   try{
                       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                     conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" + "databaseName=KBCQuizDatabase", "sa", "sunflower");
                      String insert = "insert into PlayGame(Playername,CategoryQuestion) values(?,?)";
                      PreparedStatement pst = conn.prepareStatement(insert);
                      pst.setString(1,namePlayer.getText());
                      pst.setString(2,categoryQuestion.getText());
                      int rs = pst.executeUpdate();
                      if(rs>0){
                          new resultForm().setVisible(true);
                   this.setVisible(false);
                   resultForm.namePlayerResult.setText(namePlayer.getText());
                   resultForm.categoryQuestionResult.setText(categoryQuestion.getText());
                 
                       if(index==1){ 
                       resultForm.anstrue.setText("1");
                       resultForm.prizemoney.setText("$50");
                   }
                   if(index==2){
                      resultForm.anstrue.setText("2");
                       resultForm.prizemoney.setText("$100");
                  }
                   if(index==3){
                      resultForm.anstrue.setText("3");
                       resultForm.prizemoney.setText("$200");
                  }
                   if(index==4){
                      resultForm.anstrue.setText("4");
                       resultForm.prizemoney.setText("$400");
                  }
                   if(index==5){
                      resultForm.anstrue.setText("5");
                       resultForm.prizemoney.setText("$800");
                  }
                   if(index==6){
                      resultForm.anstrue.setText("6");
                       resultForm.prizemoney.setText("$1,600");
                  }
                   if(index==7){
                      resultForm.anstrue.setText("7");
                       resultForm.prizemoney.setText("$3,200");
                  }
                   if(index==8){
                      resultForm.anstrue.setText("8");
                       resultForm.prizemoney.setText("$6,400");
                  }
                   if(index==9){
                      resultForm.anstrue.setText("9");
                       resultForm.prizemoney.setText("$12,500");
                  }
                   if(index==10){
                      resultForm.anstrue.setText("10");
                       resultForm.prizemoney.setText("$25,000");
                  }
                   if(index==11){
                      resultForm.anstrue.setText("11");
                       resultForm.prizemoney.setText("$50,000");
                  }
                   if(index==12){
                      resultForm.anstrue.setText("12");
                       resultForm.prizemoney.setText("$1,000,000");
                  }
                   if(index==13){
                      resultForm.anstrue.setText("13");
                       resultForm.prizemoney.setText("$5,000,000");
                  }
                      }
                   }
                   catch(Exception e){
                       System.out.println(e.getMessage());
                   }
                
        }
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        help50_50 = new javax.swing.JButton();
        flip = new javax.swing.JButton();
        doubleDip = new javax.swing.JButton();
        stop = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        stopGame = new javax.swing.JButton();
        answera = new javax.swing.JLabel();
        answerb = new javax.swing.JLabel();
        answerc = new javax.swing.JLabel();
        answerd = new javax.swing.JLabel();
        noq = new javax.swing.JLabel();
        no = new javax.swing.JLabel();
        questiona = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namePlayer = new javax.swing.JLabel();
        categoryQuestion = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        q1 = new javax.swing.JLabel();
        q2 = new javax.swing.JLabel();
        q3 = new javax.swing.JLabel();
        q4 = new javax.swing.JLabel();
        q5 = new javax.swing.JLabel();
        q6 = new javax.swing.JLabel();
        q7 = new javax.swing.JLabel();
        q8 = new javax.swing.JLabel();
        q9 = new javax.swing.JLabel();
        q10 = new javax.swing.JLabel();
        q11 = new javax.swing.JLabel();
        q12 = new javax.swing.JLabel();
        q13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jToggleButton1.setText("jToggleButton1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KBC Quiz");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                closeForm(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeF(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255,255,255,150));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Name:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Category of Question:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Quantity of Question:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255,255,255,150));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Help");

        help50_50.setBackground(new java.awt.Color(153, 255, 153));
        help50_50.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        help50_50.setText("50-50");
        help50_50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help50_50ActionPerformed(evt);
            }
        });

        flip.setBackground(new java.awt.Color(153, 255, 153));
        flip.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        flip.setText("Flip");
        flip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flipActionPerformed(evt);
            }
        });

        doubleDip.setBackground(new java.awt.Color(153, 255, 153));
        doubleDip.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doubleDip.setText("Double Dip");
        doubleDip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleDipMouseClicked(evt);
            }
        });
        doubleDip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleDipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(help50_50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flip)))
                .addGap(3, 3, 3)
                .addComponent(doubleDip, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doubleDip)
                    .addComponent(help50_50)
                    .addComponent(flip))
                .addGap(45, 45, 45))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 90));

        stop.setBackground(new java.awt.Color(226,240,240));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("A.");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("B.");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("C.");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("D.");

        stopGame.setBackground(new java.awt.Color(153, 255, 153));
        stopGame.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        stopGame.setText("Stop");
        stopGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopGameActionPerformed(evt);
            }
        });

        answera.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        answera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        answera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answeraMouseClicked(evt);
            }
        });

        answerb.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        answerb.setText("<html>\n\n\n\n</html>");
        answerb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        answerb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerbMouseClicked(evt);
            }
        });

        answerc.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        answerc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        answerc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answercMouseClicked(evt);
            }
        });

        answerd.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        answerd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        answerd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                answerdMouseClicked(evt);
            }
        });

        no.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        questiona.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        questiona.setText("<html>                                                                                               </html>");
        questiona.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        questiona.setMinimumSize(new java.awt.Dimension(0, 50));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setText("Question:");

        javax.swing.GroupLayout stopLayout = new javax.swing.GroupLayout(stop);
        stop.setLayout(stopLayout);
        stopLayout.setHorizontalGroup(
            stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stopLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(answerd, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stopGame, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(stopLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(answerc, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stopLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(answerb, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(stopLayout.createSequentialGroup()
                        .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(stopLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(questiona, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(stopLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answera, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noq, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stopLayout.setVerticalGroup(
            stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stopLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(noq, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questiona, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answera, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stopLayout.createSequentialGroup()
                        .addComponent(answerd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stopGame))
                    .addGroup(stopLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 410));

        namePlayer.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel3.add(namePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 200, 25));

        categoryQuestion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel3.add(categoryQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 142, 22));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel20.setText("13");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jPanel6.setBackground(new java.awt.Color(226,240,240));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 153), new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q1.setText("1     50");
        jPanel6.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 70, -1));

        q2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q2.setText("2     100");
        jPanel6.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        q3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q3.setText("3     200");
        jPanel6.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        q4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q4.setText("4     400 ");
        jPanel6.add(q4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        q5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q5.setText("5     800");
        jPanel6.add(q5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        q6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q6.setText("6     1,600");
        jPanel6.add(q6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        q7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q7.setText("7     3,200");
        jPanel6.add(q7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        q8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q8.setText("8     6,400");
        jPanel6.add(q8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        q9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q9.setText("9     12,500");
        jPanel6.add(q9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 30));

        q10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel6.add(q10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        q11.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q11.setText("11     50,000");
        jPanel6.add(q11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        q12.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q12.setText("12     1,000,000");
        jPanel6.add(q12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        q13.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        q13.setText("13     5,000,000");
        jPanel6.add(q13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel7.setText("10     25,000");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 159, 410));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 890, 510));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Imageforproject\\sky1.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void answeraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answeraMouseClicked
           answera();
    }//GEN-LAST:event_answeraMouseClicked

    private void answerbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerbMouseClicked
       answerb();
    }//GEN-LAST:event_answerbMouseClicked

    private void answercMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answercMouseClicked
        answerc();
        
    }//GEN-LAST:event_answercMouseClicked

    private void answerdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_answerdMouseClicked
      answerd();
    }//GEN-LAST:event_answerdMouseClicked

    private void doubleDipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleDipMouseClicked
         
    }//GEN-LAST:event_doubleDipMouseClicked
  
    private void help50_50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help50_50ActionPerformed
           String ansSelect1 = answera.getText();
        String ansSelect2 = answerb.getText();
        String ansSelect3 = answerc.getText();

        String ansSelect4 = answerd.getText();
        if(ansSelect1.equals(ansRight)){
            answerb.setText("");
            answerc.setText("");
        }
        if(ansSelect2.equals(ansRight)){
            answera.setText("");
            answerd.setText("");
        }
        if(ansSelect3.equals(ansRight)){
            answerb.setText("");
            answerd.setText("");
        }
        if(ansSelect4.equals(ansRight)){
            answera.setText("");
            answerc.setText("");
        }
        help50_50.setEnabled(false);

    }//GEN-LAST:event_help50_50ActionPerformed

    private void flipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flipActionPerformed
        qid++;
        getQuestion(qid);
        flip.setEnabled(false);
    }//GEN-LAST:event_flipActionPerformed

    private void doubleDipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleDipActionPerformed
        
        
    }//GEN-LAST:event_doubleDipActionPerformed

    private void stopGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopGameActionPerformed
        if(index==1 ||index==2||index==3||index==4||index==5||index==6||index==7||index==8||index==9||index==10||index==11||index==12){
            new resultForm().setVisible(true);
            this.setVisible(false);
        }
        if(index==13){
            JOptionPane.showMessageDialog(this, "You have to answer this question!");
        }
        
        
    }//GEN-LAST:event_stopGameActionPerformed
   
    private void closeForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeForm
          
         
        
    }//GEN-LAST:event_closeForm

    private void closeF(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeF
        
    }//GEN-LAST:event_closeF

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
                new questionAnswer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel answera;
    public static javax.swing.JLabel answerb;
    public static javax.swing.JLabel answerc;
    public static javax.swing.JLabel answerd;
    private javax.swing.JLabel categoryQuestion;
    private javax.swing.JButton doubleDip;
    private javax.swing.JButton flip;
    private javax.swing.JButton help50_50;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JLabel namePlayer;
    private javax.swing.JLabel no;
    private javax.swing.JLabel noq;
    private javax.swing.JLabel q1;
    private javax.swing.JLabel q10;
    private javax.swing.JLabel q11;
    private javax.swing.JLabel q12;
    private javax.swing.JLabel q13;
    private javax.swing.JLabel q2;
    private javax.swing.JLabel q3;
    private javax.swing.JLabel q4;
    private javax.swing.JLabel q5;
    private javax.swing.JLabel q6;
    private javax.swing.JLabel q7;
    private javax.swing.JLabel q8;
    private javax.swing.JLabel q9;
    private javax.swing.JLabel questiona;
    private javax.swing.JPanel stop;
    private javax.swing.JButton stopGame;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logokbcquiz2.png")));
    }
   
            
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
       
    }
    
}
