package com.example.animal_health;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

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
//import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Calendar;

public class MainReminder extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity


    //view objects
    EditText editTextName;
    CalendarView CalenderRemind;
    Button buttonAddReminder, buttonNof;
    ListView listViewCalender;
    String date;
    TextView saving, tvw;
    TimePicker picker;
    String j, notif_dt, notif_nm;
    

    //a list to store all the artist from firebase database
    List<Reminder> reminders;

    //our database reference object
    DatabaseReference databaseReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            j =(String) b.get("name");
        }
        //getting the reference of artists node
        databaseReminder = FirebaseDatabase.getInstance().getReference("Reminder/"+j);

        //getting views
        editTextName = (EditText) findViewById(R.id.editTextName);
        CalenderRemind = (CalendarView) findViewById(R.id.calendarView);
        listViewCalender = (ListView) findViewById(R.id.listViewArtists);
        saving = (TextView) findViewById(R.id.textViesave);
        tvw = (TextView) findViewById(R.id.texttimepick);
        buttonAddReminder = (Button) findViewById(R.id.buttonAddArtist);
        picker=(TimePicker)findViewById(R.id.datePicker1);
       // picker.setIs24HourView(true);

        //list to store artists
        reminders = new ArrayList<>();

        Query mDatabaseHighestPlayer = databaseReminder.orderByChild("reminderDate").limitToFirst(1);
        mDatabaseHighestPlayer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    notif_dt = childSnapshot.child("reminderDate").getValue(String.class);
                    notif_nm = childSnapshot.child("reminderName").getValue(String.class);
                    createNotification(notif_nm +" : "+notif_dt, MainReminder.this);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException(); // don't swallow errors
            }
        });


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
    private NotificationManager notifManager;
    public void createNotification(String aMessage, Context context) {
        final int NOTIFY_ID = 0; // ID of notification
        String id = "Yes"; // default_channel_id
        String title = "yes title"; // Default Channel
        Intent intent;
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder;
        if (notifManager == null) {
            notifManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notifManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, title, importance);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(android.R.drawable.ic_popup_reminder)   // required
                    .setContentText(context.getString(R.string.app_name)) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        }
        else {
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(android.R.drawable.ic_popup_reminder)   // required
                    .setContentText(context.getString(R.string.app_name)) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setPriority(Notification.PRIORITY_HIGH);
        }
        Notification notification = builder.build();
        notifManager.notify(NOTIFY_ID, notification);
    }
//    public void createNotification (View view) {
//        Intent myIntent = new Intent(getApplicationContext() , NotifyService. class ) ;
//        AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE ) ;
//        PendingIntent pendingIntent = PendingIntent. getService ( this, 0 , myIntent , 0 ) ;
//        Calendar calendar = Calendar. getInstance () ;
//        calendar.set(Calendar. SECOND , 0 ) ;
//        calendar.set(Calendar. MINUTE , 0 ) ;
//        calendar.set(Calendar. HOUR , 0 ) ;
//        calendar.set(Calendar. AM_PM , Calendar. AM ) ;
//        calendar.add(Calendar. DAY_OF_MONTH , 1 ) ;
//        alarmManager.setRepeating(AlarmManager. RTC_WAKEUP , calendar.getTimeInMillis() , 1000 * 60 * 60 * 24 , pendingIntent) ;
//    }

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
        int hour, minute;
        String am_pm;
        if (Build.VERSION.SDK_INT >= 23 ){
            hour = picker.getHour();
            minute = picker.getMinute();
        }
        else{
            hour = picker.getCurrentHour();
            minute = picker.getCurrentMinute();
        }
        if(hour > 12) {
            am_pm = "PM";
            hour = hour - 12;
        }
        else
        {
            am_pm="AM";
        }
        tvw.setText(hour +":"+ minute+" "+am_pm);

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseReminder.push().getKey();

            String date = saving.getText().toString();
            String time = tvw.getText().toString();
            //creating an Artist Object
            Reminder artist = new Reminder(id, name, date, time);

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

    private boolean updateArtist(String id, String name, String genre, String time) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Reminder").child(id);

        //updating artist
        Reminder artist = new Reminder(id, name, genre, time);
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
        final TimePicker timepicker = (TimePicker) dialogView.findViewById(R.id.datePicker2);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);
        final TextView saving2 = (TextView) dialogView.findViewById(R.id.textView);
        final TextView tvw2 = (TextView) dialogView.findViewById(R.id.textView2);

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
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = timepicker.getHour();
                    minute = timepicker.getMinute();
                }
                else{
                    hour = timepicker.getCurrentHour();
                    minute = timepicker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                tvw2.setText(hour +":"+ minute+" "+am_pm);
                if (!TextUtils.isEmpty(namee)) {
                    String date2 = saving2.getText().toString();
                    String time2 = tvw2.getText().toString();
                    updateArtist(artistId, namee, date2, time2);
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