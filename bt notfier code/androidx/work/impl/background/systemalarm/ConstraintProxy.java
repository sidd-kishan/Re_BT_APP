/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.NetworkType
 *  androidx.work.impl.background.systemalarm.CommandHandler
 *  androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;
import java.util.List;

abstract class ConstraintProxy
extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix((String)"ConstraintProxy");

    ConstraintProxy() {
    }

    static void updateAll(Context context, List<WorkSpec> constraints) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Iterator<WorkSpec> iterator = constraints.iterator();
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        while (true) {
            bl4 = bl5;
            bl3 = bl6;
            bl2 = bl7;
            bl = bl8;
            if (!iterator.hasNext()) break;
            constraints = iterator.next().constraints;
            bl4 = bl5 | constraints.requiresBatteryNotLow();
            bl3 = bl6 | constraints.requiresCharging();
            bl2 = bl7 | constraints.requiresStorageNotLow();
            boolean bl9 = constraints.getRequiredNetworkType() != NetworkType.NOT_REQUIRED;
            bl = bl8 | bl9;
            bl5 = bl4;
            bl6 = bl3;
            bl7 = bl2;
            bl8 = bl;
            if (!bl4) continue;
            bl5 = bl4;
            bl6 = bl3;
            bl7 = bl2;
            bl8 = bl;
            if (!bl3) continue;
            bl5 = bl4;
            bl6 = bl3;
            bl7 = bl2;
            bl8 = bl;
            if (!bl2) continue;
            bl5 = bl4;
            bl6 = bl3;
            bl7 = bl2;
            bl8 = bl;
            if (bl) break;
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent((Context)context, (boolean)bl4, (boolean)bl3, (boolean)bl2, (boolean)bl));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("onReceive : %s", intent), new Throwable[0]);
        context.startService(CommandHandler.createConstraintsChangedIntent((Context)context));
    }
}
