package com.example.common.pms;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

/**
 * Created by JigarSoni on 10/26/2016.
 */
public class MyNotification  extends Service{

    private NotificationManager notificationManager;
    AddDriveActivity not;

    public MyNotification() {
        not=new AddDriveActivity();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // code to execute when the service is first created
        super.onCreate();
        Log.i("MyService", "Service Started.");
        showNotification();
    }

    public void showNotification(){
        not.createNotification(null);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid)
    {
        return START_STICKY;
    }

}
