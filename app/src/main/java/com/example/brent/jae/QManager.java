package com.example.brent.jae;

/**
 * Created by Brent on 3/29/2015.
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/***'
 *  class that handles the question class
 *  adds all the question to the database
 */
public class QManager {


    private List <Question> questions;
    private DBHelper db;

    public QManager(DBHelper db){
        this.db = db;
    }

    /***
     *  Method to populate the database with initial information and returns a list that is
     *  gathered from the database.
     *
     * @return
     */
    public void initData(){

        //questions = new ArrayList<Question>();
        //                 0,        1,            2,               3,                   4
        // categories = {"All", "Core Java", "OOP Concepts", "Exception Handling", "Multithreading"};

        // this is what the constructor looks like for question objects:
        //      Question(int id, int category, int known, String question, String answer)
        Question q0 = new Question(0, 1, 0, "What is a constructor?", "Constructor is just like a " +
                "method that is used to initialize the state of an object. It is invoked at the time of " +
                "object creation" );

        Question q1 = new Question(1, 1, 0, "What is the purpose of default constructor?", "The default constructor " +
                "provides the values to the objects. The java compiler creates a default constructor only if there is no " +
                "constructor in the class.");
        Question q2 = new Question(2, 1, 0, "Does constructor return any value?", "Yes, it returns the current " +
                "instance(you cannot use return type yet it returns a value)");
        Question q3 = new Question(3, 2, 0, "Is constructor inherited?", "No, constructor is not inherited");
        Question q4 = new Question(4,2,0, "What is static block?", "Is used to initialize the static data member.\n" +
                "It is executed before main method at the time of class loading.");
        Question q5 = new Question(4,3,0, "Can we execute a program without main() method?", "Yes, one of the way is static block.");
        Question q6 = new Question(4,3,0, "What if the static modifier is removed from the signature of the main method?", "Program compiles. But at runtime throws an error \"NoSuchMethodError\".");
        Question q7 = new Question(4,3,0, "What is this in java?", "It is a keyword that that refers to the current object");
        Question q8 = new Question(4,4,0, "What is Inheritance?", "Inheritance is a mechanism in which one object acquires all the properties and behaviour of another " +
                "object of another class. It represents IS-A relationship. It is used for Code Resusability and Method Overriding.");
        Question q9 = new Question(4,4,0, "Which class is the superclass for every class.", "Object class.");
        Question q10 = new Question(4,4,0, "Why multiple inheritance is not supported in java?", "To reduce the complexity and simplify the language, multiple" +
                " inheritance is not supported in java in case of class.");

        db.addQuestion(q0);
        db.addQuestion(q1);
        db.addQuestion(q2);
        db.addQuestion(q3);
        db.addQuestion(q4);
        db.addQuestion(q5);
        db.addQuestion(q6);
        db.addQuestion(q7);
        db.addQuestion(q8);
        db.addQuestion(q9);
        db.addQuestion(q10);

        // return questions = db.getAllQuestions();
    }

    public List<Question> getCat(int cat){
        questions = new ArrayList<Question>();

        return questions = db.getCat(cat);

    }

}
