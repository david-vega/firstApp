package com.pluralsight.firstapptest.firstapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.pluralsight.firstapptest.firstapptest.LogHelper.LogCallback;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogCallback(this, "onCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean handled = true;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_showActivity2:
                onClickMenuShowActivity2(item);
                break;
            case R.id.action_showActivity3:
                onClickMenuShowActivity3(item);
                break;
            case R.id.action_exit:
                onClickMenuExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    void onClickMenuShowActivity2(MenuItem item){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    void onClickMenuShowActivity3(MenuItem item){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    void onClickMenuExit(MenuItem item){
        finish();
    }

    //<editor-fold desc="lifecycle callbacks">

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
