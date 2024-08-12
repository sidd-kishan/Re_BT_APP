/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
 */
package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;

class BroadcastReceiverConstraintTracker.1
extends BroadcastReceiver {
    final BroadcastReceiverConstraintTracker this$0;

    BroadcastReceiverConstraintTracker.1(BroadcastReceiverConstraintTracker broadcastReceiverConstraintTracker) {
        this.this$0 = broadcastReceiverConstraintTracker;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        this.this$0.onBroadcastReceive(context, intent);
    }
}
