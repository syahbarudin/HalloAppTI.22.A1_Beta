package com.hello;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;

import androidx.annotation.RequiresApi;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(1000);
        }

        RingtonePlayer.playRingtone(context);
    }
    private static class RingtonePlayer {
        static void playRingtone(Context context) {
            Uri ringtoneUri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/ringtone_yoasobi.mp3");
            MediaPlayer mediaPlayer = MediaPlayer.create(context, ringtoneUri);

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    // Reset alarm setelah ringtone selesai diputar
                    resetAlarm(context);
                }
            });

            mediaPlayer.start();
        }

        private static void resetAlarm(Context context) {
            // Dapatkan waktu berikutnya untuk alarm (misalnya, setelah 24 jam)
            Calendar calendar = Calendar.getInstance();
            calendar.add(calendar.DAY_OF_YEAR, 1);

            // Atur alarm berikutnya
            setAlarm(context, calendar.getTimeInMillis());
        }

        private static void setAlarm(Context context, long timeInMillis) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent);
        }
    }}
