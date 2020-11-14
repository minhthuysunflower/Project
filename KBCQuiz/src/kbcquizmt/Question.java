/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbcquizmt;

/**
 *
 * @author ASUS
 */
class Question {
    private int questionId;
    private String questionName;
    private String category;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private String AnswerRight;

    public Question() {
    }
    
    
    public Question(int questionId, String questionName, String category, String AnswerA, String AnswerB, String AnswerC, String AnswerD, String AnswerRight) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.category = category;
        this.AnswerA = AnswerA;
        this.AnswerB = AnswerB;
        this.AnswerC = AnswerC;
        this.AnswerD = AnswerD;
        this.AnswerRight = AnswerRight;
    }

    public int getQuestionId() {
        
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
      
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String AnswerA) {
        this.AnswerA = AnswerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String AnswerB) {
        this.AnswerB = AnswerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String AnswerC) {
        this.AnswerC = AnswerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String AnswerD) {
        this.AnswerD = AnswerD;
    }

    public String getAnswerRight() {
        return AnswerRight;
    }

    public void setAnswerRight(String AnswerRight) {
        this.AnswerRight = AnswerRight;
    }
    public void showInfo(){
        System.out.println(questionId +questionName );
    }
            
}
