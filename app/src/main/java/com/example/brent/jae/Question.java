package com.example.brent.jae;

/**
 * Created by Brent on 3/29/2015.
 */
public class Question {

    private int id;
    private int category;
    private int known; // 0 is not known; 1 is known
    private String answer;
    private String question;

    public Question(){

    }
    public Question(int id, int category, int known, String question, String answer){
        this.id = id;
        this.category = category;
        this.known = known;
        this.answer = answer;
        this.question = question;
    }


    public int getId() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getKnown() {
        return known;
    }

    public void setKnown(int known){
        this.known = known;
    }

    public String getAnswer(){
        return this.answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getQuestion(){
        return this.question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

}
