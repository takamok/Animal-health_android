package com.example.animal_health;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainReminder extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity


    //view objects
    EditText editTextName;
    CalendarView CalenderRemind;
    Button buttonAddReminder;
    ListView listViewCalender;
    String date;
    TextView saving;

    //a list to store all the artist from firebase database
    List<Reminder> reminders;

    //our database reference object
    DatabaseReference databaseReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        //getting the reference of artists node
        databaseReminder = FirebaseDatabase.getInstance().getReference("Reminder");

        //getting views
        editTextName = (EditText) findViewById(R.id.editTextName);
        CalenderRemind = (CalendarView) findViewById(R.id.calendarView);
        listViewCalender = (ListView) findViewById(R.id.listViewArtists);
        saving = (TextView) findViewById(R.id.textViesave);
        buttonAddReminder = (Button) findViewById(R.id.buttonAddArtist);

        //list to store artists
        reminders = new ArrayList<>();


        //adding an onclicklistener to button
        buttonAddReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addReminder();
            }
        });

        listViewCalender.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Reminder artist = reminders.get(i);
                showUpdateDeleteDialog(artist.getreminderId(), artist.getreminderName());
                return true;
            }
        });
    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addReminder() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        CalenderRemind.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
//                date = year + "/" + month + "/"+ dayOfMonth ;
//                Log.d("TAGG", "onSelectedDayChange: yyyy/mm/dd:" + date);
//                System.out.println("dateeee "+date);
                saving.setText( year +" / " + (month+1) + " / " + dayOfMonth);
            }
        });

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseReminder.push().getKey();

            String date = saving.getText().toString();
            //creating an Artist Object
            Reminder artist = new Reminder(id, name, date);

            //Saving the Artist
            databaseReminder.child(id).setValue(artist);

            //setting edittext to blank again
            editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Reminder added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseReminder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                reminders.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Reminder artist = postSnapshot.getValue(Reminder.class);
                    //adding artist to the list
                    reminders.add(artist);
                }

                //creating adapter
                ReminderList artistAdapter = new ReminderList(MainReminder.this, reminders);
                //attaching adapter to the listview
                listViewCalender.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private boolean updateArtist(String id, String name, String genre) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Reminder").child(id);

        //updating artist
        Reminder artist = new Reminder(id, name, genre);
        dR.setValue(artist);
        Toast.makeText(getApplicationContext(), "Event Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void showUpdateDeleteDialog(final String artistId, String artistName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final CalendarView calendarRemind = (CalendarView) dialogView.findViewById(R.id.calendarView);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);
        final TextView saving2 = (TextView) dialogView.findViewById(R.id.textView);
        dialogBuilder.setTitle(artistName);
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namee = editTextName.getText().toString().trim();
                calendarRemind.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
//                date = year + "/" + month + "/"+ dayOfMonth ;
//                Log.d("TAGG", "onSelectedDayChange: yyyy/mm/dd:" + date);
//                System.out.println("dateeee "+date);
                        saving2.setText( year +" / " + (month+1) + " / " + dayOfMonth);
                    }
                });
                if (!TextUtils.isEmpty(namee)) {
                    String date2 = saving2.getText().toString();
                    updateArtist(artistId, namee, date2);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                 * we will code this method to delete the artist
                 * */
                deleteArtist(artistId);
                b.dismiss();
            }
        });
    }

    private boolean deleteArtist(String id) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Reminder").child(id);

        //removing artist
        dR.removeValue();

        //getting the tracks reference for the specified artist
        DatabaseReference drTracks = FirebaseDatabase.getInstance().getReference("tracks").child(id);

        //removing all tracks
        drTracks.removeValue();
        Toast.makeText(getApplicationContext(), "Artist Deleted", Toast.LENGTH_LONG).show();

        return true;
    }

}