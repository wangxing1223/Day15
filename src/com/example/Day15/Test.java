package com.example.Day15;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 13-8-8.
 */
public class Test extends Activity {


    private Button cancel;
    private NotificationManager notificationManager;
    private Notification notification;
    private static final int ID = 1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,MyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this ,0,intent,0);
        notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker("Ticker Text...")
                .setContentTitle("Content Title...")
                .setContentText("Content Text...")
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(ID, notification);

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(ID);
            }
        });

    }
}
