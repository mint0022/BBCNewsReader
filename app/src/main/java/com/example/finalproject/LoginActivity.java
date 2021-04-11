package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // Create reference tag for methods below.
    String TAG = "activity_login.xml";
    // Declare loginButton and pwdEditText objects.
    Button loginButton;
    EditText pwdEditText;
    EditText userEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // instantiate.
        userEditText = (EditText) findViewById(R.id.editText);
        pwdEditText = (EditText) findViewById(R.id.editText2);
        loginButton = (Button)findViewById(R.id.loginButton);



    // Get login button code to run.
    setupLoginButton();


    }

    // Application life cycle methods
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(TAG, "onStart");
    }

    /* setup a listener that will save info about it being clicked using shared preferences.
     Also will have a toast message saying data is saved. */



    private void setupLoginButton() {
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Log.i(TAG, "clicked the button");
                saveData(v);

            }
        });
    }
// method to save data and navigate to next page.
    public void saveData(View v) {

        //set up shared preferences.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String mapTypeString = preferences.getString("DefaultEmail", "email@domain.com");


        // display msg.
        Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG).show();

        // move to main activity.
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

}