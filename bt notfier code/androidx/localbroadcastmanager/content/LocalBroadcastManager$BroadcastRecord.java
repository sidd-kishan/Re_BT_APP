/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord
 */
package androidx.localbroadcastmanager.content;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;

private static final class LocalBroadcastManager.BroadcastRecord {
    final Intent intent;
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;

    LocalBroadcastManager.BroadcastRecord(Intent intent, ArrayList<LocalBroadcastManager.ReceiverRecord> arrayList) {
        this.intent = intent;
        this.receivers = arrayList;
    }
}
