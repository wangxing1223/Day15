package com.example.Day15;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Administrator on 13-8-8.
 */
public class MP3 extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private MediaPlayer player = null;
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.zuihouyici);
        Toast.makeText(this, "MP3Test....onCreate", Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}
