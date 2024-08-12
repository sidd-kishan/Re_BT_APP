/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 *  androidx.appcompat.app.AppCompatDelegateImpl
 */
package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatDelegateImpl;

abstract class AppCompatDelegateImpl.AutoNightModeManager {
    private BroadcastReceiver mReceiver;
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.AutoNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    /*
     * Unable to fully structure code
     */
    void cleanup() {
        if (this.mReceiver == null) return;
        try {
            this.this$0.mContext.unregisterReceiver(this.mReceiver);
lbl4:
            // 2 sources

            while (true) {
                this.mReceiver = null;
                break;
            }
        }
        catch (IllegalArgumentException var1_1) {
            ** continue;
        }
    }

    abstract IntentFilter createIntentFilterForBroadcastReceiver();

    abstract int getApplyableNightMode();

    boolean isListening() {
        boolean bl = this.mReceiver != null;
        return bl;
    }

    abstract void onChange();

    void setup() {
        this.cleanup();
        IntentFilter intentFilter = this.createIntentFilterForBroadcastReceiver();
        if (intentFilter == null) return;
        if (intentFilter.countActions() == 0) return;
        if (this.mReceiver == null) {
            this.mReceiver = new /* Unavailable Anonymous Inner Class!! */;
        }
        this.this$0.mContext.registerReceiver(this.mReceiver, intentFilter);
    }
}
