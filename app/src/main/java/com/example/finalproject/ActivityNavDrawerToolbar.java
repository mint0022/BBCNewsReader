package com.example.finalproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

//Class was supposed to be updated as a toolbar and navigation drawer for app. my apologies.
public class ActivityNavDrawerToolbar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer_toolbar);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // NavigationDrawer:
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, myToolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // make a menu
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Select options in toolbar with menu items.

        int id = item.getItemId();
        switch (id) {

            case R.id.item1:
                Toast.makeText(this.getApplicationContext(), "You clicked on item 1",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:

                Toast.makeText(this.getApplicationContext(), "You clicked on item 2",
                        Toast.LENGTH_LONG).show();

                break;

            case R.id.item3:
                Toast.makeText(this.getApplicationContext(), "You clicked on item 3",
                        Toast.LENGTH_LONG).show();

                break;
            case R.id.item4:
                Toast.makeText(this.getApplicationContext(), "You clicked on the settings menu",
                        Toast.LENGTH_LONG).show();
            default:
                break;
        }

        return true;
    }


    // Needed for the OnNavigationItemSelected interface:
    @Override
    public boolean onNavigationItemSelected( MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.chatpage:
                Intent chatIntent = new Intent(this, LoginActivity.class);
                startActivity(chatIntent);
                break;
            case R.id.weather:
                Intent weatherIntent = new Intent(this, MainActivity.class);
                startActivity(weatherIntent);
                break;
            case R.id.backtologin:
                Intent login = new Intent(this, WelcomePage.class);
                startActivity(login);
                // Store request and response values
                break;
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return false;
    }





}