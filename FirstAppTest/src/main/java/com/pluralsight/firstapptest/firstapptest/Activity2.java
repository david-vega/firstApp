package com.pluralsight.firstapptest.firstapptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.pluralsight.firstapptest.firstapptest.LogHelper.*;

public class Activity2 extends Activity {
    static final String button2EnabledState = "button2EnabledState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_2);
        super.onCreate(savedInstanceState);
        setupUiEvents();
        LogCallback(this, "onCreate");

        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
    }

    private void restoreState(Bundle savedInstanceState) {
        boolean isEnabled = savedInstanceState.getBoolean(button2EnabledState, false);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setEnabled(isEnabled);
    }

    void setupUiEvents(){
        Button theButton = (Button) findViewById(R.id.topSectionButton);
        theButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2.this.handleButton1Click((Button) view);  //explicit call
            }
        });

        Button theButton2 = (Button) findViewById(R.id.button2);
        theButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButton2Click((Button) view); //implicit call
            }
        });
    }


    void handleButton1Click(Button button){
        TextView textView = (TextView) findViewById(R.id.firstTopTextView);
        textView.setText("Click 1");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setEnabled(true);
    }

    void handleButton2Click(Button button){
        TextView textView = (TextView) findViewById(R.id.firstTopTextView);
        textView.setText("Click 2");
    }

//<editor-fold desc="lifecycle">

    @Override
    protected void onStart(){
        super.onStart();
        LogCallback(this, "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        LogCallback(this, "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        LogCallback(this, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        LogCallback(this, "onSaveInstanceState");

        Button button2 = (Button) findViewById(R.id.button2);
        outState.putBoolean(button2EnabledState, button2.isEnabled());
    }

    @Override
    protected void onStop(){
        super.onStop();
        LogCallback(this, "onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        LogCallback(this, "onDestroy");
    }
//</editor-fold>

}
