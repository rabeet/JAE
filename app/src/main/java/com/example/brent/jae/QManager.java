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
    private List<Question> newQuest;
    private DBHelper db;
    private final int numQuestions = 100;

    public QManager(DBHelper db){
        this.db = db;
    }

    /***
     *  Method to populate the database with initial information and returns a list that is
     *  gathered from the database.
     *
     */
    public void initData(){


        //                 0,        1,            2,               3,                   4                  5
        // categories = {"All", "Core Java", "OOP Concepts", "Exception Handling", "Multithreading", "Collections"};


           // Adding Collection category question. Category #5
        // Constructor: (int category, int known, String question, String answer)
        Question q0 = new Question(5, 0, "What is the difference between a ArrayList and a Vector", "ArrayList is not " +
                "synchronized. Vector is synchronized." +
                "ArrayList is not a legacy class. Vector is a legacy class " +
                "ArrayList increases its size by 50% of the array size. Vector increases its size by doubling the array size" );
        Question q1 = new Question(5, 0, "What is the difference between ArrayList and LinkedList?", "ArrayList uses a " +
                "dynamic array. LinkedList uses a doubly linked list. " +
                "ArrayList is better to store and fetch data. LinkedList is better to manipulate data." );
        Question q47 = new Question(5, 0, "What is an iterator?", "Iterator interface provides methods to iterate over any Collection."  );
        Question q2 = new Question(5, 0, "What is the difference between iterator and ListIterator", "Iterator traverses the " +
                "elements in a forward direction only. ListIterator traverses the elements in backward and forward directions" +
                "Iterator can be used in List, Set and Queue. ListIterator can be used in List only."  );
        Question q4 = new Question(5, 0, "What is the difference between Iterator and Enumeration", "Iterator can traverse " +
                "legacy and non-legacy elements. Enumeration can traverse only legacy elements. Iterator is fail-fast. Enumeration is " +
                "not fail-fast. Iterator is slower than Enumeration. Enumeration is faster than Iterator" );
        Question q5 = new Question(5, 0, "What is the difference between List and Set?", "List can contain duplicate elements" +
                "whereas Set contains only unique elements."  );
        Question q6 = new Question(5, 0, "What is the difference between HashSet and TreeSet?", "HashSet maintains" +
                "no order whereas TreeSet maintains ascending order."  );
        Question q7 = new Question(5, 0, "What is the difference between Set and Map", "Set contains values only whereas Map contains key and values both" );
        Question q8 = new Question(5, 0, "What is the difference between HashSet and HashMap?", "HashMap maintains NO ORDER, but TreeMap " +
                "maintains ASCENDING ORDER." );
        Question q9 = new Question(5, 0, "What is the difference between HashMap and HashTable?", "HashMap is not" +
                " synchronized. Hashtable is synchronized. HashMap can contain one null key and multiple null values." +
                " A HashTable cannot contain any null key or null value" );
        Question q10 = new Question(5, 0, "What is the difference between Collection and Collections?", "Collections" +
                "is an interface whereas Collections is a class. Collection interface provides normal functionality" +
                "of data structure to List, Set, and Queue. Collections class is to sort and synchronize Collection elements."  );
        Question q11 = new Question(5, 0, "What is the advantage of generic collection?", "If we use generic class, we don't need " +
                "typecasting. It is typesafe and checked at compile time."  );
        Question q12 = new Question(5, 0, "what is hash-collision in HashTable and how is it handled in Java?", "" +
                "Two different keys with the same hash values is known as hash-collision. Two different entries will be" +
                "kept in a single hash bucket to avoid the collision."  );
        Question q13 = new Question(5, 0, "What is the default size of load factor in a hashing based collection?",
                "The default size of load factor is 0.75. The default capacity is computed as: initial capacity * " +
                        "load factor." );
        Question q14 = new Question(5, 0, "What is the Dictionary class?", "The Dictionary class provides" +
                "the capability to store key-value pairs."  );
        Question q15 = new Question(5, 0, "What is the advantage of the hashCode() method?", "The hashCode() method returns" +
                "hash code value (integer number). The hashCode() method returns the same integer number if two keys are the same, but " +
                "it is possible that two has code numbers can have different or same keys."  );
        Question q48 = new Question(5, 0, "How to decide between HashMap and TreeMap?", "For inserting, deleting, and locating elements " +
                "in a Map, the HashMap offers the best alternative. If you need to traverse the keys in a sorted order, then TreeMap is " +
                "your better alternative. Depending on the size of your collection, it may be faster to add elements to a HashMap, then" +
                " convert the map to a TreeMap for sorted key traversal."  );


        // Adding "Exception Handling" category question. Category # 3
        Question q16 = new Question(3, 0, "What is Exception Handling?", "Exception Handling is a mechanism to handle runtime errors.It is" +
                " mainly used to handle checked exceptions."  );
        Question q17 = new Question(3, 0, "What is difference between Checked Exception and Unchecked Exception?", "Checked Exception: Classes that" +
                "extend Throwable class except RuntimeException and error are checked exceptions. Unchecked Exception: " +
                "Classes that extend RuntimeException are known as unchecked exception."  );
        Question q18 = new Question(3, 0, "What is the base class for Error and Exception?", "Throwable."  );
        Question q19 = new Question(3, 0, " Is it necessary that each try block must be followed by a catch block?", "It is not necessary" +
                " that each try block must be followed by a catch block, but it should be followed by either a catch block OR a finally block." +
                " And whatever exceptions are likely to be thrown should be declared in the throws clause of the method."  );
        Question q20 = new Question(3, 0, "What is the finally block?", "The finally block is a block that is always executed."  );
        Question q21 = new Question(3, 0, "Can finally block be used without catch?", "Yes, by try block. finally must be preceded by either try or catch."  );
        Question q22 = new Question(3, 0, " Is there any case when finally will not be executed?", "Finally block will not be executed if program exits(either by " +
                "calling System.exit() or by causing a fatal error that causes the process to abort)."  );
        Question q23 = new Question(3, 0, "Can an exception be rethrown?", "Yes."  );
        Question q24 = new Question(3, 0, "Can subclass overriding method declare an exception if parent class method doesn't throw an exception ?", "Yes," +
                "but only unchecked exception, not checked."  );
        Question q25 = new Question(3, 0, "What is exception propagation ?", "Forwarding the exception object to the invoking method is known as " +
                "exception propagation."  );
        Question q41 = new Question(3, 0, "What is use of throws keyword?", "If the function is not capable of handling the excpetion" +
                " then it can ask the calling method to handle it by simply putting the throws clause at the function declaration."  );
        Question q43 = new Question(3, 0, "How to create a custom Exception?", "To create your own exception, extend the Exception class or any" +
                "of its subclasses. i.e. 'class New1Exception extends Exception{}' creates a checked exception."  );
        Question q42 = new Question(3, 0, "When to make a custom checked Exception or a custom unchecked Exception?", "If an application" +
                "can reasonably be expected to recover from an exception, make it a checked exception. If an application cannot do anything " +
                "to recover from an exception, make it an unchecked exception."  );
        Question q44 = new Question(3, 0, "What is a StackOverFlowError?", "The StackOverFlowError is an Error Object thrown by the runtime" +
                " system when it encounters that your application/code has ran out of memory."  );
        Question q45 = new Question(3, 0, "Once the control switches to the catch block does it return back to the try block to execute" +
                "the balance of code?", "No. Once the control jumps to the catch block it never returns to the try block but it goes to " +
                "finally block(if present)."  );
        Question q46 = new Question(3, 0, "Is an empty catch block legal?", "Yes you can leave the catch block without writing any actual code" +
                " to handle the exception caught. "  );


        // Adding "Multithreading" category questions. Category #4
        Question q26 = new Question(4, 0, "What is multithreading?", "Multithreading is a process of executing multiple threads simultaneously." +
                "Its main advantages are: Threads share the same address space, a thread is lightweight, and the cost of communication" +
                "between process is low."  );
        Question q49 = new Question(4, 0, "What do we understand about the term concurrency?", "Concurrency is the ability of a program to execute " +
                "several computations simultaneously. This can be achieved by distributing the computations over the available CPU cores of a" +
                " machine or even over different machines within the same network."  );
        Question q50 = new Question(4, 0, "How many threads does a java program have at least?", "Each Java program is executed within" +
                " the main thread; hence each Java application has at least one thread."  );
        Question q27 = new Question(4, 0, "What is a thread?", "A thread is a lightweight subprocess. It is a separate path of execution. It is called separate" +
                " path of execution because each thread runs in a separate stack frame."  );
        Question q28 = new Question(4, 0, "What is the difference between preemptive scheduling and time slicing?", "Under preemptive scheduling," +
                " the highest priority task executes until it enterx the waiting or dead states or a higher priority task comes into existence. " +
                "Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler" +
                "then determines which task should execute next, based on priority and other factors."  );
        Question q29 = new Question(4, 0, "What does join() method do?", "The join() method waits for a thread to die. In other words, it causes the currently" +
                "running threads to stop executing until the thread it joins with completes its task."  );
        Question q30 = new Question(4, 0, "What is the difference between wait() and sleep() methods?", "The wait() method is defined in Object class." +
                " The sleep() method is defined in the Thread class. The wait() method releases the lock. The sleep() method doesn't release the lock."  );
        Question q31 = new Question(4, 0, "Is it possible to start a thread twice?", "Yes, but it will not work as a thread - rather it will work" +
                "as a normal object so there will not be context-switching between the threads."  );
        Question q32 = new Question(4, 0, "What about daemon threads?", "The daemon threads are basically the low priority threads that provides the" +
                "background support to the user threads. It provides services to the user threads."  );
        Question q33 = new Question(4, 0, "Can we make the user thread a daemon thread if the thread is started?", "No, if you do so, it will throw" +
                "IllegalThreadSateException."  );
        Question q34 = new Question(4, 0, "What is a shutdown hook?", "The shutdown hook is basically a thread i.e. invoked implicitly before" +
                "JVM shuts down so we can use it to perform clean up on resources."  );
        Question q35 = new Question(4, 0, "When should we interrupt a thread?", "We should interrupt a thread if we want to break out" +
                "the sleep or wait state of a thread."  );
        Question q36 = new Question(4, 0, "What is synchronization?", "Synchronization is the capability to control the access of multiple" +
                "threads to any shared resource. It is used to prevent thread interference and to prevent a consistency problem in data."  );
        Question q37 = new Question(4, 0, "What is the purpose of a Synchronized block?", "Synchronized block is used to lock an object for any" +
                "shared resource. The scope of the synchronize3d block is smaller than the method."  );
        Question q38 = new Question(4, 0, "What is static synchronization?", "If you make any static method as synchronized, the lock will be" +
                " on the class, not the object. "  );
        Question q39 = new Question(4, 0, "What is the difference between notify() and notifyAll()?", "The notify() is used to unblock one waiting " +
                "thread whereas notifyAll() is used to unblock all the threads in a waiting state."  );
        Question q40 = new Question(4, 0, "What is a deadlock?", "Deadlock is a situation when two threads are waiting on each other to release" +
                "a resource. Each thread is waiting for a resource that is held by the other waiting thread causing the system to 'freeze'."  );
        Question q3 = new Question(4, 0, "Why should a thread not be stopped by calling its method stop()", "A thread should not be stopped" +
                " by using the deprecated method stop() because this method causes the thread to unlock all monitors it has acquired. If any object " +
                "protected by one of the released locks was in an inconsistent state, this state gets visible to all other threads.");
        // Adding "" category questions. Category #

        // adding the questions to the database.
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
        db.addQuestion(q11);
        db.addQuestion(q12);
        db.addQuestion(q13);
        db.addQuestion(q14);
        db.addQuestion(q15);
        db.addQuestion(q16);
        db.addQuestion(q17);
        db.addQuestion(q18);
        db.addQuestion(q19);
        db.addQuestion(q20);
        db.addQuestion(q21);
        db.addQuestion(q22);
        db.addQuestion(q23);
        db.addQuestion(q24);
        db.addQuestion(q25);
        db.addQuestion(q26);
        db.addQuestion(q27);
        db.addQuestion(q28);
        db.addQuestion(q29);
        db.addQuestion(q30);
        db.addQuestion(q31);
        db.addQuestion(q32);
        db.addQuestion(q33);
        db.addQuestion(q34);
        db.addQuestion(q35);
        db.addQuestion(q36);
        db.addQuestion(q37);
        db.addQuestion(q38);
        db.addQuestion(q39);
        db.addQuestion(q40);
        db.addQuestion(q41);
        db.addQuestion(q42);
        db.addQuestion(q43);
        db.addQuestion(q44);
        db.addQuestion(q45);
        db.addQuestion(q46);
        db.addQuestion(q47);
        db.addQuestion(q48);
        db.addQuestion(q49);
        db.addQuestion(q50);
    }

    public List<Question> getCat(int cat){
        questions = new ArrayList<Question>();

        return questions = db.getCat(cat);

    }

}
