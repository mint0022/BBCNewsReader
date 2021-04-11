package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class Favourites extends AppCompatActivity {

    // prepare layout and button.
    private CoordinatorLayout coordinatorLayout;
    private Button button;
    Button favBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        //instantiate.
        coordinatorLayout = findViewById(R.id.coordinatelayout);
        button = findViewById(R.id.infoBtn);
        favBtn = findViewById(R.id.favBtn);

        // onClickListener to show snackbar message. Give instructions on how to save favourites.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
// lets user know they can save as many favourites.
    public void navigate() {


        Snackbar snackbar = Snackbar.make(coordinatorLayout, "You can save as many favourites as you like.", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", view -> {
//                    Snackbar snackbar2 = Snackbar.make(coordinatorLayout, "Closed.", Snackbar.LENGTH_SHORT);
//                    snackbar2.show();
                });

        snackbar.show();


    }

    // method to open dialog box. gives info about app.
    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "help dialog");
    }
}

