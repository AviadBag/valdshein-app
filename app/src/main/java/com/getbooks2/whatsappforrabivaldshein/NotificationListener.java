package com.getbooks2.whatsappforrabivaldshein;

import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class NotificationListener extends NotificationListenerService {

    private static final String TAG = "NotificationListener";
    private static final String WA_PACKAGE = "com.whatsapp";

    @Override
    public void onListenerConnected() {
        Log.i(TAG, "Notification Listener connected");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (!statusBarNotification.getPackageName().equals(WA_PACKAGE)) return;

        Notification notification = statusBarNotification.getNotification();
        Bundle bundle = notification.extras;

        String from = bundle.getString(NotificationCompat.EXTRA_TITLE);
        String message = bundle.getString(NotificationCompat.EXTRA_TEXT);

        Log.i(TAG, from);
    }
}