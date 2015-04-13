package com.example.brent.jae;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class MainActivity extends ActionBarActivity {

    private int qCount = 0;
    private int aCount = 0;
    private int totalQuestions;
    private int totalKnown;
    private List<Question> questions;
    private TextView myTextView;
    private TextView known;
    private TextView stat;
    // Known/not known buttons
    private Button iknow;
    private Button dontknow;
    private Button mainbutton;
    private DBHelper db;
    private QManager qm;
    private int cat;
    private final String [] categories = {"All", "Core Java", "OOP Concepts", "Exception Handling", "Multithreading"};

    //The onCreate function is called when your app is run and
    // it is expected to create the view and do the whatever the Activity is concerned with.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // selects the XML file to determine the layout
        // ContentView determines what is currently displayed to the screen
        // R is a resource object that links between the java code and resources created as XML files
        setContentView(R.layout.activity_main);

        // Make stats invis at the start of the app
        known = (TextView) findViewById(R.id.known);
        stat = (TextView) findViewById(R.id.stats);
        stat.setVisibility(View.GONE);
        known.setVisibility(View.GONE);

        // Make known button at the start of the app as well
        iknow = (Button) findViewById(R.id.iknow);
        dontknow = (Button) findViewById(R.id.dontknow);
        mainbutton = (Button) findViewById(R.id.button);
        iknow.setVisibility(View.GONE);
        dontknow.setVisibility(View.GONE);

        //Database
        db = new DBHelper(this);
        qm = new QManager(db);
        //db.deleteDb(this);

        questions = new ArrayList<>();
        questions = db.getAllQuestions();
        totalQuestions = questions.size();
        if (questions.isEmpty())
            qm.initData();
        spinner();
        /*
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
        /*
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
        */
    }

    public void buttonOnClick(View v){
        // get rid of the spinner
        //questions = new ArrayList();
        Spinner spinner = (Spinner) findViewById(R.id.mainSpinner);
        spinner.setVisibility(View.GONE);
        // get rid of the textView2
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setVisibility(View.GONE);
        stat.setVisibility(View.VISIBLE);
        known.setVisibility(View.VISIBLE);
        // Update the num here to grab the latest num of known
        updateStats();

        qm = new QManager(db);
        questions = qm.getCat(cat);
        myTextView = (TextView) findViewById(R.id.textView);
        // set object to button v. cast "Button" to object v
        Button button = (Button) v;

        // Make this button invis after initial screen

        // if the list is empty then the database needs to be initialized

        ListIterator it = questions.listIterator(aCount);
        // find the object for the button and call setText
        // change the text of the button to "answer" or "next question"
        if ((qCount & 1) == 0) { // even is if it is a question
            mainbutton.setVisibility(View.INVISIBLE);
            iknow.setVisibility(View.VISIBLE);
            dontknow.setVisibility(View.VISIBLE);
            button.setText("Next Question");
            if (it.hasNext()) { // try to catch IOB exception
                myTextView.setText(questions.get(aCount).getQuestion());
                qCount++;

            }
            else{
                myTextView.setText("That's all the questions for that category. Going home.");
                //button.setText("Go to Categories");
                // SystemClock.sleep(1000);
                mainbutton.setText("Test My Knowledge");
                iknow.setVisibility(View.GONE);
                dontknow.setVisibility(View.GONE);
                setContentView(R.layout.activity_main);
                spinner();
                aCount = 0;
                qCount = 0;
                //spinner.setVisibility(View.VISIBLE);

            }
        }
        else{ // odd is if it is an answer
            button.setText("Next Question");
//            iknow.setVisibility(View.VISIBLE);
//            dontknow.setVisibility(View.VISIBLE);
            if(it.hasNext()) { // try to catch IOB exception
                myTextView.setText(questions.get(aCount).getAnswer());
                qCount++;
                aCount++;
            }
            else{
                myTextView.setText("That's all the questions for that category. Choose another category?");
                mainbutton.setText("Test My Knowledge");
                iknow.setVisibility(View.GONE);
                dontknow.setVisibility(View.GONE);
                //button.setText("Go to Categories");
                setContentView(R.layout.activity_main);
            }
        }

    }

    public void knownClick(View v) {
        ListIterator it = questions.listIterator(aCount);
        // find the object for the button and call setText
        // change the text of the button to "answer" or "next question"
        iknow.setVisibility(View.INVISIBLE);
        dontknow.setVisibility(View.INVISIBLE);
        mainbutton.setVisibility(View.VISIBLE);

        Button thisbutton = (Button) v;
        Log.d("Button", thisbutton.getText().toString());
        if ((qCount & 1) == 0) { // even is if it is a question
//            button.setText("Answer");
            Log.d("Displaying question?", "QUESTION");
            if (it.hasNext()) { // try to catch IOB exception
                myTextView.setText(questions.get(aCount).getQuestion());
                qCount++;

            }
            else{
                myTextView.setText("That's all the questions for that category. Going home.");
                mainbutton.setText("Test My Knowledge");
                iknow.setVisibility(View.GONE);
                dontknow.setVisibility(View.GONE);
                //button.setText("Go to Categories");
                // SystemClock.sleep(1000);
                setContentView(R.layout.activity_main);
                spinner();
                aCount = 0;
                qCount = 0;
                //spinner.setVisibility(View.VISIBLE);

            }
        }
        else{ // odd is if it is an answer
//            button.setText("Next Question");
            Log.d("Displaying answer?", "ANSWER");
            Log.d("Question ID: ", ""+(questions.get(aCount).getId()));
            int id = questions.get(aCount).getId();
            if(it.hasNext()) { // try to catch IOB exception
                myTextView.setText(questions.get(aCount).getAnswer());
                qCount++;
                aCount++;

                // Update database here as well
                if (thisbutton.getText().equals("I Know this question")) {
                    db.setKnown(id);
                    Log.d("Num known", ""+db.getKnownCount());
                    updateStats();
                }
                else {
                    db.setNotKnown(id);
                    Log.d("Num known", ""+db.getKnownCount());
                    updateStats();
                }
            }
            else{
                myTextView.setText("That's all the questions for that category. Choose another category?");
                mainbutton.setText("Test My Knowledge");
                iknow.setVisibility(View.GONE);
                dontknow.setVisibility(View.GONE);
                //button.setText("Go to Categories");
                setContentView(R.layout.activity_main);
            }
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
            case R.id.action_cat:
                return true;
            case R.id.about:
                setContentView(R.layout.about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            setContentView(R.layout.category);
            return true;
        }

        return super.onOptionsItemSelected(item);
        */
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


}
