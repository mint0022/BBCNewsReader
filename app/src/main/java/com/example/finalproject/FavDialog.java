package com.example.finalproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class FavDialog extends AppCompatDialogFragment {

    // method for alertdialog in Activity main.
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // create object; uses builder pattern.
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // set the title.
        builder.setTitle("Help")
                .setMessage("Scroll through the following page to see updated BBC news articles!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }

}
