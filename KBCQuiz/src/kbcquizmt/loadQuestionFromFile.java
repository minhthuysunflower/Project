/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbcquizmt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class loadQuestionFromFile {
    private static Connection conn;
     public static ArrayList<Question> loadListQuestion( String filePath) {
        FileInputStream fis = null;
        InputStreamReader isr=null;
        BufferedReader bReader=null;
        ArrayList<Question> listQuestion = new ArrayList<Question>();
        try{
            fis = new FileInputStream(filePath);
            isr = new InputStreamReader(fis);
            bReader = new BufferedReader(isr);
            String line=null;//save line get from file txt
            String[] strQuestion = null; //Array save Question
            //Loop and get all data in txt file
            while(true){
                line = bReader.readLine();//get 1 line
                //check  line empty, exit loop
                if(line==null){
                    break;
                }
                else{
                    strQuestion =line.split(",");
                    listQuestion.add(new Question (Integer.parseInt(strQuestion[0]),strQuestion[1],strQuestion[2],strQuestion[3],strQuestion[4],strQuestion[5],strQuestion[6],strQuestion[7]));
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
            bReader.close();
            fis.close();
            isr.close();
            }
            catch(IOException e){
              e.printStackTrace();
             
            }
        }
        return listQuestion;
        
    }
     public static void main(String[] args) {
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"databaseName=KBCQuizDatabase","sa","sunflower");
              String load = "insert into QuestionAnswer(Questionid,Questionname,Category,AnswerA,AnswerB,AnswerC,AnswerD,AnswerRight) values(?,?,?,?,?,?,?,?)";
              PreparedStatement pst = conn.prepareStatement(load);
              //get list question from txt file
              ArrayList<Question> listQuestion = loadListQuestion("D:\\project_java\\question_answer.txt" );
              //insert list to sql
              for(int i=0;i<listQuestion.size();i++){
                  pst.setInt(1,listQuestion.get(i).getQuestionId());
                  pst.setString(2, listQuestion.get(i).getQuestionName());
                  pst.setString(3, listQuestion.get(i).getCategory());
                  pst.setString(4, listQuestion.get(i).getAnswerA());
                  pst.setString(5, listQuestion.get(i).getAnswerB());
                  pst.setString(6, listQuestion.get(i).getAnswerC());
                  pst.setString(7, listQuestion.get(i).getAnswerD());
                  pst.setString(8, listQuestion.get(i).getAnswerRight());
                  pst.executeUpdate();
                  System.out.println("insert successful");
              }
         }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
     }
    
}
