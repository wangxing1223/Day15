package com.example.Day15;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 13-8-8.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context,intent.getStringExtra("message"),Toast.LENGTH_LONG).show();
//        Toast.makeText(context,"快没电了.....",Toast.LENGTH_LONG).show();\

//        Intent intent1 = new Intent();
//        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent1.setClass(context,Test.class);
//        context.startActivity(intent1);
        String message = intent.getStringExtra("message");
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }




}
