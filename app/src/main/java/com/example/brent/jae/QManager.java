
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
                "ArrayList is not a legacy class. Vector is a legacy class. " +
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

        // Adding "Core Java" category questions. Category #1
        db.addQuestion(new Question(1,0,"What is difference between JDK,JRE and JVM?","JVM\n" +
                "\n" +
                "JVM is an acronym for Java Virtual Machine, it is an abstract machine which provides the runtime environment in which java bytecode can be executed.\n" +
                "\n" +
                "JVMs are available for many hardware and software platforms (so JVM is plateform dependent).\n" +
                "JRE\n" +
                "\n" +
                "JRE stands for Java Runtime Environment. It is the implementation of JVM and physically exists.\n" +
                "JDK\n" +
                "\n" +
                "JDK is an acronym for Java Development Kit. It physically exists. It contains JRE + development tools."));
        db.addQuestion(new Question(1,0,"How many types of memory areas are allocated by JVM?","Many types:\n" +
                "\n" +
                "    Class(Method) Area\n" +
                "    Heap\n" +
                "    Stack\n" +
                "    Program Counter Register\n" +
                "    Native Method Stack\n"));
        db.addQuestion(new Question(1,0,"What is JIT compiler?","Just-In-Time(JIT) compiler:It is used to improve the performance. JIT compiles parts of the byte code that have similar functionality at the same time, and hence reduces the amount of time needed for compilation.Here the term “compiler” refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU."));
        db.addQuestion(new Question(1,0,"What gives Java its 'write once and run anywhere' nature?","The bytecode. Java is compiled to be a byte code which is the intermediate language between source code and machine code. This byte code is not platform specific and hence can be fed to any platform."));
        db.addQuestion(new Question(1,0,"What is constructor?","Constructor is just like a method that is used to initialize the state of an object. It is invoked at the time of object creation."));
        db.addQuestion(new Question(1,0,"Does constructor return any value?","yes, that is current instance (You cannot use return type yet it returns a value)."));
        db.addQuestion(new Question(1,0,"Is constructor inherited?","No, constructor can't be final."));
        db.addQuestion(new Question(1,0,"What is static method?","\n" +
                "    A static method belongs to the class rather than object of a class.\n" +
                "    A static method can be invoked without the need for creating an instance of a class.\n" +
                "    static method can access static data member and can change the value of it.\n"));
        db.addQuestion(new Question(1,0,"Why main method is static?","because object is not required to call static method if It were non-static method,jvm creats object first then call main() method that will lead to the problem of extra memory allocation."));
        db.addQuestion(new Question(1,0,"Can we execute a program without main() method?","Yes, one of the way is static block."));
        db.addQuestion(new Question(1,0,"What is difference between static (class) method and instance method?","A method i.e. declared as static is known as static method whereas a method i.e. not declared as static is known as instance method." +
                "Object is not required to call static method whereas Object is required to call instance methods." +
                "Non-static (instance) members cannot be accessed in static context (static method, static block and static nested class) directly whereas static and non-static variables both can be accessed in instance methods."));
        db.addQuestion(new Question(1,0,"What is this in java?","It is a keyword that that refers to the current object."));
        db.addQuestion(new Question(1,0,"What is Inheritance?","Inheritance is a mechanism in which one object acquires all the properties and behaviour of another object of another class. It represents IS-A relationship. It is used for Code Resusability and Method Overriding."));
        db.addQuestion(new Question(1,0,"Which class is the superclass for every class. ","Object class."));
        db.addQuestion(new Question(1,0,"What is super in java?","It is a keyword that refers to the immediate parent class object."));
        db.addQuestion(new Question(1,0,"What is object cloning?","The object cloning is used to create the exact copy of an object."));
        db.addQuestion(new Question(1,0,"What is method overloading?","If a class have multiple methods by same name but different parameters, it is known as Method Overloading. It increases the readability of the program."));
        db.addQuestion(new Question(1,0,"Can we overload main() method?","Yes, You can have many main() methods in a class by overloading the main method."));
        db.addQuestion(new Question(1,0, "Do I need to import java.lang package any time? Why ?", "No. It is by default loaded internally by the JVM."));
        // Adding "OOP Concets" category questions. Category #2
        db.addQuestion(new Question(2,0,"What is difference between object oriented programming language and object based programming language?"," Object based programming languages follow all the features of OOPs except Inheritance. Examples of object based programming languages are JavaScript, VBScript etc. "));
        db.addQuestion(new Question(2,0,"What is method overriding:","If a subclass provides a specific implementation of a method that is already provided by its parent class, it is known as Method Overriding. It is used for runtime polymorphism and to provide the specific implementation of the method"));
        db.addQuestion(new Question(2,0,"Can we override static method?","No, you can't override the static method because they are the part of class not object. "));
        db.addQuestion(new Question(2,0,"Why we cannot override static method?","It is because the static method is the part of class and it is bound with class whereas instance method is bound with object and static gets memory in class area and instance gets memory in heap. "));
        db.addQuestion(new Question(2,0,"Can we override the overloaded method?","Yes. "));
        db.addQuestion(new Question(2,0,"Can you have virtual functions in Java? ","Yes, all functions in Java are virtual by default. "));
        db.addQuestion(new Question(2,0,"What is covariant return type? ","Now, since java5, it is possible to override any method by changing the return type if the return type of the subclass overriding method is subclass type. It is known as covariant return type."));
        db.addQuestion(new Question(2,0,"What is final variable?","If you make any variable as final, you cannot change the value of final variable(It will be constant).more details..."));
        db.addQuestion(new Question(2,0,"What is final method?","Final methods can't be overriden."));
        db.addQuestion(new Question(2,0,"What is final class?","Final class can't be inherited"));
        db.addQuestion(new Question(2,0,"What is blank final variable?","A final variable, not initalized at the time of declaration, is known as blank final variable."));
        db.addQuestion(new Question(2,0,"Can we intialize blank final variable?","Yes, only in constructor if it is non-static. If it is static blank final variable, it can be initialized only in the static block."));
        db.addQuestion(new Question(2,0,"Can you declare the main method as final? ","Yes, such as, public static final void main(String[] args){}."));
        db.addQuestion(new Question(2,0,"What is Runtime Polymorphism?","Runtime polymorphism or dynamic method dispatch is a process in which a call to an overridden method is resolved at runtime rather than at compile-time.\n" +
                "\n" +
                "In this process, an overridden method is called through the reference variable of a super class. The determination of the method to be called is based on the object being referred to by the reference variable."));
        db.addQuestion(new Question(2,0,"Can you achieve Runtime Polymorphism by data members?","No."));
        db.addQuestion(new Question(2,0,"What is the difference between static binding and dynamic binding?","In case of static binding type of object is determined at compile time whereas in dynamic binding type of object is determined at runtime."));
        db.addQuestion(new Question(2,0,"What is abstraction?"," Abstraction is a process of hiding the implementation details and showing only functionality to the user.  Abstraction lets you focus on what the object does instead of how it does it."));
        db.addQuestion(new Question(2,0,"What is the difference between abstraction and encapsulation?","Abstraction hides the implementation details whereas encapsulation wraps code and data into a single unit."));
        db.addQuestion(new Question(2,0,"What is abstract class?","A class that is declared as abstract is known as abstract class. It needs to be extended and its method implemented. It cannot be instantiated."));
        db.addQuestion(new Question(2,0,"Can there be any abstract method without abstract class?","No, if there is any abstract method in a class, that class must be abstract."));
        db.addQuestion(new Question(2,0,"Can you use abstract and final both with a method?","No, because abstract method needs to be overridden whereas you can't override final method."));
        db.addQuestion(new Question(2,0,"Is it possible to instantiate the abstract class?","No, abstract class can never be instantiated."));
        db.addQuestion(new Question(2,0,"What is interface?","Interface is a blueprint of a class that have static constants and abstract methods.It can be used to achieve fully abstraction and multiple inheritance."));
        db.addQuestion(new Question(2,0,"Can you declare an interface method static?","No, because methods of an interface is abstract by default, and static and abstract keywords can't be used together. "));
        db.addQuestion(new Question(2,0,"Can an Interface be final?","No, because its implementation is provided by another class."));
        db.addQuestion(new Question(2,0,"What is marker interface?","An interface that have no data member and method is known as a marker interface.For example Serializable, Cloneable etc. "));
        db.addQuestion(new Question(2,0,"What is package?","A package is a group of similar type of classes interfaces and sub-packages. It provides access protection and removes naming collision."));
        db.addQuestion(new Question(2,0,"Can I import same package/class twice? Will the JVM load the package twice at runtime?","One can import the same package or same class multiple times. Neither compiler nor JVM complains about it.But the JVM will internally load the class only once no matter how many times you import the same class."));
        db.addQuestion(new Question(2,0,"When can an object reference be cast to an interface reference? ","An object reference can be cast to an interface reference when the object implements the referenced interface."));
        db.addQuestion(new Question(2,0,"What is static import ?","By static import, we can access the static members of a class directly, there is no to qualify it with the class name."));
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

