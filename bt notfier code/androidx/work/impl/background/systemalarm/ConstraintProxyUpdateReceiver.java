/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.WorkManagerImpl
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

public class ConstraintProxyUpdateReceiver
extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG = Logger.tagWithPrefix((String)"ConstrntProxyUpdtRecvr");

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra(KEY_BATTERY_NOT_LOW_PROXY_ENABLED, bl).putExtra(KEY_BATTERY_CHARGING_PROXY_ENABLED, bl2).putExtra(KEY_STORAGE_NOT_LOW_PROXY_ENABLED, bl3).putExtra(KEY_NETWORK_STATE_PROXY_ENABLED, bl4);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String string = intent != null ? intent.getAction() : null;
        if (!ACTION.equals(string)) {
            Logger.get().debug(TAG, String.format("Ignoring unknown action %s", string), new Throwable[0]);
        } else {
            string = this.goAsync();
            WorkManagerImpl.getInstance((Context)context).getWorkTaskExecutor().executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
    }
}
