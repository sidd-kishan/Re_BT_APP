/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 */
package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;

class ShortcutManagerCompat.1
extends BroadcastReceiver {
    final IntentSender val$callback;

    ShortcutManagerCompat.1(IntentSender intentSender) {
        this.val$callback = intentSender;
    }

    /*
     * Enabled force condition propagation
     */
    public void onReceive(Context context, Intent intent) {
        try {
            this.val$callback.sendIntent(context, 0, null, null, null);
            return;
        }
        catch (IntentSender.SendIntentException sendIntentException) {
            return;
        }
    }
}
