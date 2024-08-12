/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 */
package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

private static final class LocalBroadcastManager.ReceiverRecord {
    boolean broadcasting;
    boolean dead;
    final IntentFilter filter;
    final BroadcastReceiver receiver;

    LocalBroadcastManager.ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.receiver = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.receiver);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.filter);
        if (this.dead) {
            stringBuilder.append(" DEAD");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
