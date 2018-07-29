package com.example.user.mymedicinereminderapp;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import javax.sql.RowSetListener;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.example.user.mymedicinereminderapp.R.*;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        sendNotification(context);
    }
    private void sendNotification(Context context){

        NotificationCompat.Builder mBuilder = new
                NotificationCompat.Builder(context, "new_notify")
                .setSmallIcon(mipmap.ic_launcher_round)
                .setContentTitle("Medicine Reminder")
                .setContentText("Pls take your Medicine on Time!!");

        Intent intent = new Intent(context,Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        mBuilder.setContentIntent(pendingIntent);

        //    int mNotificationId = 001;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        //   notificationManager.notify(mNotificationId, mBuilder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("new_notify",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        //Uri alarmsound = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.mkmk);
       // NotificationCompat.Builder builder = mBuilder.setSound(alarmsound);

        long[] vibrate = {100,200,300,400,500,600,700,800,900,100,1100,1200,1300};
        mBuilder.setVibrate(vibrate);

        notificationManager.notify(0, mBuilder.build());
    }
}



