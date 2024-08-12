/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.lifecycle.LifecycleService
 *  androidx.work.Logger
 *  androidx.work.impl.foreground.SystemForegroundDispatcher
 *  androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
 */
package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

public class SystemForegroundService
extends LifecycleService
implements SystemForegroundDispatcher.Callback {
    private static final String TAG = Logger.tagWithPrefix((String)"SystemFgService");
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    private void initializeDispatcher() {
        SystemForegroundDispatcher systemForegroundDispatcher;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager)this.getApplicationContext().getSystemService("notification");
        this.mDispatcher = systemForegroundDispatcher = new SystemForegroundDispatcher(this.getApplicationContext());
        systemForegroundDispatcher.setCallback((SystemForegroundDispatcher.Callback)this);
    }

    public void cancelNotification(int n) {
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void notify(int n, Notification notification) {
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        this.initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(Intent intent, int n, int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            this.initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) return 3;
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    public void startForeground(int n, int n2, Notification notification) {
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            this.stopForeground(true);
        }
        sForegroundService = null;
        this.stopSelf();
    }
}
