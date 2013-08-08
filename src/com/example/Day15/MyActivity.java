package com.example.Day15;

import android.app.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b10;
    private AlarmManager alarmManager;
//    private MyService myService;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("conneciton", "conneciton testing");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("shut ","shut conneciton testing");
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        b1 = (Button) findViewById(R.id.start);
        b2 = (Button) findViewById(R.id.bind);
        b3 = (Button) findViewById(R.id.unbind);
        b4 = (Button) findViewById(R.id.destroy);
        b5 = (Button) findViewById(R.id.start1);
        b6 = (Button) findViewById(R.id.stop2);
        b7 = (Button) findViewById(R.id.send);
        b8 = (Button) findViewById(R.id.notify);
        b9 = (Button) findViewById(R.id.set);
        b10 = (Button) findViewById(R.id.cancel1);

        this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(MyActivity.this,MyBroadcastReceiver.class);
        intent.putExtra("message","你该出发啦！！！！快迟到啦！！！！");
        final  PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        final long time = System.currentTimeMillis();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this,MyService.class);
                startService(intent);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,time,8*1000,pendingIntent);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager.cancel(pendingIntent);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Notification n = new Notification(R.drawable.ic_launcher,"ticker test....",System.currentTimeMillis());
                Intent intent = new Intent(MyActivity.this,MyActivity.class);
                PendingIntent pendingIntent =  PendingIntent.getActivity(MyActivity.this,0,intent,0);
                n.setLatestEventInfo(MyActivity.this,"My Title","My Context",pendingIntent);
                nm.notify(1,n);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this,MyService.class);
                MyActivity.this.bindService(intent, connection,
                        Service.BIND_AUTO_CREATE);
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this,MyService.class);
                unbindService(connection);

            }

        });
        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this,MyService.class);
                stopService(intent);
            }

        });

        b5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this,MP3.class);
                startService(intent);
            }

        });

        b6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this,MP3.class);
                stopService(intent);
            }

        });
        b7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this,MyBroadcastReceiver.class);
                intent.putExtra("message", "some  message......");
                sendBroadcast(intent);
            }

        });
    }
}
