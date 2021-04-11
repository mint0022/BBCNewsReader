package com.example.finalproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

// Class to get dialogs displayed.
public class ExampleDialog extends AppCompatDialogFragment {

    // method for favouritesDialog in Activity main.
    @Override
            public Dialog onCreateDialog(Bundle savedInstanceState){

        // create object; uses builder pattern.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // set the title.
        builder.setTitle("Favourites")
                .setMessage("Select your favourites on the news feed and view them here!")
                .setPositiveButton("got it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }

    // Favourites



    // LoginActivity




}
