package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // set up ListView
    ListView listView;

    // Create ArrayLists to hold separate values parsed from RSS.
    ArrayList<String> titles;
    ArrayList<String> descriptions;
    ArrayList<String> links;
    ArrayList<String> dates;

    String titleResource;



    // button for favourites and help
    Button btnFav;
    Button btnHelp;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate listView
        listView = (ListView) findViewById(R.id.listView);

        // instantiate buttons
         btnFav = (Button) findViewById(R.id.nav_favourites);
         btnHelp = (Button) findViewById(R.id.helpBtn);

        // instantiate ArrayLists
        titles = new ArrayList<String>();
        descriptions = new ArrayList<String>();
        links = new ArrayList<String>();
        dates = new ArrayList<String>();



         // onclick listener for fav btn.
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToFavourites();
            }
        });

        // onclick listener for help btn.

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        //set up on click listener to take to specific website.
        listView.setOnItemClickListener((parent, view, position, id) -> {

            // Open up a webpage when you click on the link.
            Uri uri = Uri.parse(links.get(position));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        // execute the background process.
        new BackgroundProcess().execute();



    }

    // method that gives favourites nav button functionality.
    private void navToFavourites() {
        Intent intentBtn = new Intent(MainActivity.this, Favourites.class);
        startActivity(intentBtn);
    }

    // method to open dialog box. gives info about app.
    public void openDialog() {
        FavDialog exampleDialog = new FavDialog();
        exampleDialog.show(getSupportFragmentManager(), "help dialog");
    }

// rest of listview code
    // create input stream. integral part of making the connection.
    public InputStream getInputStream(URL url) {

        // try a connection
        try {
            return url.openConnection().getInputStream();

        }
        catch (IOException e) {
            return null;
        }

    }
// Handles background processes.
    public class BackgroundProcess extends AsyncTask<Integer, ProgressBar, Exception> {

        // dialog object showing progress.
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        // create progress bar.
        ProgressBar progressBar = new ProgressBar(MainActivity.this);

        //create exception object for doInBackground
        Exception exception = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("RSS Feed loading. Please wait.");
            progressDialog.show();

            //show the progress.
            progressBar.setVisibility(ProgressBar.VISIBLE);

        }

        @Override
        protected Exception doInBackground(Integer... integers) {
           try {

            // specify URL you are  navigating to
               URL url = new URL("http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml");

               // Object aids in pulling xml data
               XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                // parameter to ensure data is pulled properly.
               factory.setNamespaceAware(false);

               XmlPullParser xmlPullParser = factory.newPullParser();

               // get input, set encoding.
               xmlPullParser.setInput(getInputStream(url), "UTF_8");

               // boolean variable will tell you if you're inside xml tag
               boolean insideItem = false;

               int eventType = xmlPullParser.getEventType();

               while (eventType != XmlPullParser.END_DOCUMENT)
               {
                   if (eventType == XmlPullParser.START_TAG)
                   {
                       if (xmlPullParser.getName().equalsIgnoreCase("item"))
                       {
                           insideItem = true;
                       }
                       // Pull specific data from XML file online. starting with title.
                       else if (xmlPullParser.getName().equalsIgnoreCase("title"))
                       {
                           if (insideItem)
                           {
                               titles.add(xmlPullParser.nextText());

                           }
                       }

                       else if (xmlPullParser.getName().equalsIgnoreCase("description")) {
                           if (insideItem)
                           {
                               descriptions.add(xmlPullParser.nextText());
                           }
                       }

                       else if (xmlPullParser.getName().equalsIgnoreCase("link"))
                       {
                           if (insideItem)
                           {
                               links.add(xmlPullParser.nextText());
                           }
                       }

                       else if (xmlPullParser.getName().equalsIgnoreCase("pubDate"))
                       {
                           if (insideItem)
                           {
                               dates.add(xmlPullParser.nextText());
                           }
                       }


                   }

                   else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item"))
                   {
                       insideItem = false;
                   }
                   // increments through tags in the XML file.
                   eventType = xmlPullParser.next();

               }

           }
           catch (MalformedURLException e)
           {
               exception = e;

           }

           catch (XmlPullParserException e)
           {
               exception = e;
           }
           catch (IOException e)
           {
               e.printStackTrace();
           }

            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, titles);

            listView.setAdapter(adapter);



            progressDialog.dismiss();
        }
    }

}