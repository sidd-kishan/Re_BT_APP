/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy
 *  androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy
 *  androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy
 *  androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy
 *  androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver
 *  androidx.work.impl.utils.PackageManagerHelper
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.utils.PackageManagerHelper;

class ConstraintProxyUpdateReceiver.1
implements Runnable {
    final ConstraintProxyUpdateReceiver this$0;
    final Context val$context;
    final Intent val$intent;
    final BroadcastReceiver.PendingResult val$pendingResult;

    ConstraintProxyUpdateReceiver.1(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
        this.this$0 = constraintProxyUpdateReceiver;
        this.val$intent = intent;
        this.val$context = context;
        this.val$pendingResult = pendingResult;
    }

    @Override
    public void run() {
        try {
            boolean bl = this.val$intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
            boolean bl2 = this.val$intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
            boolean bl3 = this.val$intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
            boolean bl4 = this.val$intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
            Logger.get().debug(ConstraintProxyUpdateReceiver.TAG, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", bl, bl2, bl3, bl4), new Throwable[0]);
            PackageManagerHelper.setComponentEnabled((Context)this.val$context, ConstraintProxy.BatteryNotLowProxy.class, (boolean)bl);
            PackageManagerHelper.setComponentEnabled((Context)this.val$context, ConstraintProxy.BatteryChargingProxy.class, (boolean)bl2);
            PackageManagerHelper.setComponentEnabled((Context)this.val$context, ConstraintProxy.StorageNotLowProxy.class, (boolean)bl3);
            PackageManagerHelper.setComponentEnabled((Context)this.val$context, ConstraintProxy.NetworkStateProxy.class, (boolean)bl4);
            return;
        }
        finally {
            this.val$pendingResult.finish();
        }
    }
}
