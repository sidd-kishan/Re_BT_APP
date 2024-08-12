/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  androidx.localbroadcastmanager.content.LocalBroadcastManager
 */
package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

class LocalBroadcastManager.1
extends Handler {
    final LocalBroadcastManager this$0;

    LocalBroadcastManager.1(LocalBroadcastManager localBroadcastManager, Looper looper) {
        this.this$0 = localBroadcastManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            this.this$0.executePendingBroadcasts();
        }
    }
}
