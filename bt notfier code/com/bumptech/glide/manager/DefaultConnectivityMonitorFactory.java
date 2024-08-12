/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  androidx.core.content.ContextCompat
 *  com.bumptech.glide.manager.ConnectivityMonitor
 *  com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
 *  com.bumptech.glide.manager.ConnectivityMonitorFactory
 *  com.bumptech.glide.manager.DefaultConnectivityMonitor
 *  com.bumptech.glide.manager.NullConnectivityMonitor
 */
package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitor;
import com.bumptech.glide.manager.NullConnectivityMonitor;

public class DefaultConnectivityMonitorFactory
implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    public ConnectivityMonitor build(Context object, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean bl = ContextCompat.checkSelfPermission((Context)object, (String)NETWORK_PERMISSION) == 0;
        if (Log.isLoggable((String)TAG, (int)3)) {
            String string = bl ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Log.d((String)TAG, (String)string);
        }
        object = bl ? new DefaultConnectivityMonitor(object, connectivityListener) : new NullConnectivityMonitor();
        return object;
    }
}
