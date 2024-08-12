/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  com.bumptech.glide.manager.DefaultConnectivityMonitor
 */
package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bumptech.glide.manager.DefaultConnectivityMonitor;

class DefaultConnectivityMonitor.1
extends BroadcastReceiver {
    final DefaultConnectivityMonitor this$0;

    DefaultConnectivityMonitor.1(DefaultConnectivityMonitor defaultConnectivityMonitor) {
        this.this$0 = defaultConnectivityMonitor;
    }

    public void onReceive(Context object, Intent intent) {
        boolean bl = this.this$0.isConnected;
        intent = this.this$0;
        intent.isConnected = intent.isConnected((Context)object);
        if (bl == this.this$0.isConnected) return;
        if (Log.isLoggable((String)"ConnectivityMonitor", (int)3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("connectivity changed, isConnected: ");
            ((StringBuilder)object).append(this.this$0.isConnected);
            Log.d((String)"ConnectivityMonitor", (String)((StringBuilder)object).toString());
        }
        this.this$0.listener.onConnectivityChanged(this.this$0.isConnected);
    }
}
