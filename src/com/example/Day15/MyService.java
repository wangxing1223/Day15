package com.example.Day15;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

/**
 * Created by Administrator on 13-8-8.
 */

interface DemoInterface{
    public void show(Context context);
}

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"Bind Service",Toast.LENGTH_LONG).show();
        return demoInterfacelmpl;
    }

    class DemoInterfacelmpl extends Binder implements DemoInterface{

        @Override
        public void show(Context context) {
            Toast.makeText(context,"Show Test",Toast.LENGTH_LONG).show();
        }
    }

    DemoInterfacelmpl demoInterfacelmpl = new DemoInterfacelmpl();

    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"Unbind Service",Toast.LENGTH_LONG).show();
        return true;
    }

    public void onCreate(){
        super.onCreate();
        Toast.makeText(this,"Service creating",Toast.LENGTH_LONG).show();
    }

    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.v("StartService", "service is starting");
        Toast.makeText(this, "Service starting", Toast.LENGTH_LONG).show();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("StopService", "service is stop");
        Toast.makeText(this, "Service destroying", Toast.LENGTH_LONG).show();
    }


}
