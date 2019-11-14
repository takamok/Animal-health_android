package com.example.animal_health;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class Reminder {
    private String reminderId;
    private String reminderName;
    private String reminderDate;
    private String reminderTime;

    public Reminder(){
        //this constructor is required
    }

    public Reminder(String reminderId, String reminderName, String reminderDate, String reminderTime) {
        this.reminderId = reminderId;
        this.reminderName = reminderName;
        this.reminderDate = reminderDate;
        this.reminderTime = reminderTime;
    }

    public String getreminderId() {
        return reminderId;
    }

    public String getreminderName() {
        return reminderName;
    }

    public String getreminderDate() {
        return reminderDate;
    }

    public String getreminderTime() {
        return reminderTime;
    }
}