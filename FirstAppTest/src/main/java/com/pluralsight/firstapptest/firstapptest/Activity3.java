package com.pluralsight.firstapptest.firstapptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.pluralsight.firstapptest.firstapptest.LogHelper.LogCallback;

public class Activity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_3);
        super.onCreate(savedInstanceState);
        LogCallback(this, "onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean handled = true;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_showToast:
                onClickMenuShowToast(item);
                break;
            case R.id.action_close:
                onClickMenuClose(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    void onClickMenuShowToast(MenuItem item){
        Toast toast = Toast.makeText(this, getString(R.string.thisIsAToast), Toast.LENGTH_LONG);
        toast.show();
    }

    void onClickMenuClose(MenuItem item){
       finish();
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
