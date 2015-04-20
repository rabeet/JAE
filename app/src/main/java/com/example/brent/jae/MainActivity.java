package com.example.brent.jae;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends ActionBarActivity {


    private int currentQ = 0;
    private int totalQuestions;
    private int totalKnown;
    private List<Question> questions;
    private TextView myTextView;
    private TextView known;
    private TextView stat;

    private Button nextQ;
    private DBHelper db;
    private QManager qm;
    private int cat;
    private final String [] categories = {"All", "Core Java", "OOP Concepts", "Exception Handling", "Multithreading", "Collections"};

    //The onCreate function is called when your app is run and
    // it is expected to create the view and do the whatever the Activity is concerned with.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // selects the XML file to determine the layout
        // ContentView determines what is currently displayed to the screen
        // R is a resource object that links between the java code and resources created as XML files
        setContentView(R.layout.activity_main);

        //Database
        db = new DBHelper(this);
        qm = new QManager(db);
        db.deleteDb(this);

        questions = new ArrayList<>();
        questions = db.getAllQuestions();
        totalQuestions = questions.size();
        if (questions.isEmpty())
            qm.initData();
        spinner();

    }

    public void buttonOnClick(View v){

        qm = new QManager(db);
        questions = qm.getCat(cat);

        // change the view to the new question.XML file
        setContentView(R.layout.question);
        myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(questions.get(currentQ).getQuestion());
        nextQ = (Button) findViewById(R.id.nextQ);
        nextQ.setVisibility(View.INVISIBLE);
        known = (TextView) findViewById(R.id.known);
        updateStats();

    }

    public void knownClick(View v) {
        Button iKnow;
        Button dontKnow;
        // lets try initializing all the vars when button is pressed
        known = (TextView) findViewById(R.id.known);
        // myTextView is used to show both the question and the answer
        TextView tv = (TextView) findViewById(R.id.textView);
        iKnow = (Button) findViewById(R.id.iknow);
        dontKnow = (Button) findViewById(R.id.dontknow);
        nextQ = (Button) findViewById(R.id.nextQ);
        ListIterator it = questions.listIterator(currentQ+1);
        // find the object for the button and call setText
        // change the text of the button to "answer" or "next question"
        iKnow.setVisibility(View.INVISIBLE);
        dontKnow.setVisibility(View.INVISIBLE);
        nextQ.setVisibility(View.VISIBLE);

        // try to use a scroller...
        //ScrollView scroller = new ScrollView(this);
        //TextView tv = (TextView) findViewById(R.id.textView);
        //scroller.addView(tv);

        // set scroller?
        tv.setMovementMethod(new ScrollingMovementMethod());

        Button thisButton = (Button) v;
        int id = questions.get(currentQ).getId();

        switch(v.getId()){
            case R.id.iknow:
                db.setKnown(id);
                updateStats();
                currentQ++;
                if (it.hasNext()) {
                    tv.setText(questions.get(currentQ).getQuestion());

                }
                else
                    goHome();
                iKnow.setVisibility(View.VISIBLE);
                dontKnow.setVisibility(View.VISIBLE);
                nextQ.setVisibility(View.INVISIBLE);
                break;
            case R.id.dontknow:
                db.setNotKnown(id);
                updateStats();
                if (it.hasNext()) {
                    tv.setText(questions.get(currentQ).getAnswer());
                    //tv.setMovementMethod(new ScrollingMovementMethod());
                    currentQ++;
                }
                else
                    goHome();
                break;
            case R.id.nextQ:
                tv.setText(questions.get(currentQ).getQuestion());
                //tv.setMovementMethod(new ScrollingMovementMethod());
                iKnow.setVisibility(View.VISIBLE);
                dontKnow.setVisibility(View.VISIBLE);
                nextQ.setVisibility(View.INVISIBLE);
                break;

        }

    }

    public void updateStats() {
        int count = db.getKnownCount();
        int totalcount = db.getTotalCount();
        known.setText(" " + count + " of the " + totalcount + " questions.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // inflater.inflate(R.menu.game_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.exit:
                exit(); // exit the program
                return true;
            case R.id.home:
                goHome();
                return true;
            case R.id.about:
                setContentView(R.layout.about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void spinner(){
        // spinner listener
        AdapterView.OnItemSelectedListener onSpinner = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = position;

                /* // testing the output of item selected
                TextView myTextView = (TextView) findViewById(R.id.textView2);
                // position is the index of the string array
                myTextView.setText(Integer.toString(position));
                */

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, categories);
        Spinner spinner = (Spinner) findViewById(R.id.mainSpinner);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(onSpinner);
    }
    // method to exit app when exit is called from the settings
    public void exit(){
        finish();
        System.exit(0);
    }

    // method that takes user to homescreen
    public void goHome(){
        setContentView(R.layout.activity_main);
        spinner();
        updateStats();
        currentQ = 0;


    }


}
