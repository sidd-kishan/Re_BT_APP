/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
 */
package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDelegateImpl;

class AppCompatDelegateImpl.AutoNightModeManager.1
extends BroadcastReceiver {
    final AppCompatDelegateImpl.AutoNightModeManager this$1;

    AppCompatDelegateImpl.AutoNightModeManager.1(AppCompatDelegateImpl.AutoNightModeManager autoNightModeManager) {
        this.this$1 = autoNightModeManager;
    }

    public void onReceive(Context context, Intent intent) {
        this.this$1.onChange();
    }
}
