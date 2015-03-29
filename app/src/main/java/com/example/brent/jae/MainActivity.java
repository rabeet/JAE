package com.example.brent.jae;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    
    private String q1 = "Question 1";
    private String a1 = "Answer 1";
    private int qCount = 0;
    private int aCount = 0;

    //The onCreate function is called when your app is run and
    // it is expected to create the view and do the whatever the Activity is concerned with.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // selects the XML file to determine the layout
        // ContentView determines what is currently displayed to the screen
        // R is a resource object that links between the java code and resources created as XML files
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v){
        // TODO handle the button click
        // set object to button v. cast "Button" to object v
        Button button = (Button) v;
        // find the object for the button and call setText
        TextView myTextView = (TextView) findViewById(R.id.textView);
        // change the text of the button to "answer" or "next question"
        if ((qCount & 1) == 0) { // even
            button.setText("Answer");
            qCount++;
        }
        else{ // odd
            button.setText("Next Question");
            qCount++;
        }

        if ((aCount & 1) == 0) { // question
            myTextView.setText(q1);
            aCount++;
        }
        else { // or answer
            myTextView.setText(a1);
            aCount++;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
