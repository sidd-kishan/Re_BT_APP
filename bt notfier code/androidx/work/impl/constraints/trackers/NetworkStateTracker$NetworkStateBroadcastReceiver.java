/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.trackers.NetworkStateTracker
 */
package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;

private class NetworkStateTracker.NetworkStateBroadcastReceiver
extends BroadcastReceiver {
    final NetworkStateTracker this$0;

    NetworkStateTracker.NetworkStateBroadcastReceiver(NetworkStateTracker networkStateTracker) {
        this.this$0 = networkStateTracker;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        if (intent.getAction() == null) return;
        if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) return;
        Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
        context = this.this$0;
        context.setState((Object)context.getActiveNetworkState());
    }
}
