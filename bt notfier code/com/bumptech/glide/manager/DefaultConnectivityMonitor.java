/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.util.Log
 *  com.bumptech.glide.manager.ConnectivityMonitor
 *  com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor
implements ConnectivityMonitor {
    private static final String TAG = "ConnectivityMonitor";
    private final BroadcastReceiver connectivityReceiver = new /* Unavailable Anonymous Inner Class!! */;
    private final Context context;
    boolean isConnected;
    private boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        if (this.isRegistered) {
            return;
        }
        this.isConnected = this.isConnected(this.context);
        try {
            Context context = this.context;
            BroadcastReceiver broadcastReceiver = this.connectivityReceiver;
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(broadcastReceiver, intentFilter);
            this.isRegistered = true;
        }
        catch (SecurityException securityException) {
            if (!Log.isLoggable((String)TAG, (int)5)) return;
            Log.w((String)TAG, (String)"Failed to register", (Throwable)securityException);
        }
    }

    private void unregister() {
        if (!this.isRegistered) {
            return;
        }
        this.context.unregisterReceiver(this.connectivityReceiver);
        this.isRegistered = false;
    }

    boolean isConnected(Context context) {
        boolean bl;
        block2: {
            context = (ConnectivityManager)Preconditions.checkNotNull((Object)((ConnectivityManager)context.getSystemService("connectivity")));
            bl = true;
            try {
                context = context.getActiveNetworkInfo();
                if (context == null) break block2;
            }
            catch (RuntimeException runtimeException) {
                if (!Log.isLoggable((String)TAG, (int)5)) return true;
                Log.w((String)TAG, (String)"Failed to determine connectivity status when connectivity changed", (Throwable)runtimeException);
                return true;
            }
            if (context.isConnected()) return bl;
        }
        bl = false;
        return bl;
    }

    public void onDestroy() {
    }

    public void onStart() {
        this.register();
    }

    public void onStop() {
        this.unregister();
    }
}
