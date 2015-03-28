package com.example.brent.jae;

/**
 * Created by Test on 3/28/2015.
 */
public class Question {

    private int id;
    private String question;
    private String answer;

    public Question() {
        this.id = 0;
        question = "";
        answer = "";
    }

    public Question(int id) {
        this.id = id;
    }

    public Question(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String q) {
        question = q;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
