package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomePage extends AppCompatActivity {

// How long the welcome page will show for.
private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        // Handles the Handle page navigation to the login page. Delayed navigation as well.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create intent object. Specify the next Activity to be LoginActivity.
                Intent loginIntent = new Intent(WelcomePage.this, LoginActivity.class );
                //start the activity.
                        startActivity(loginIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}