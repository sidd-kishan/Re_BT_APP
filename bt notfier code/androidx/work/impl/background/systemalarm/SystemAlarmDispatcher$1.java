/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.work.Logger
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher
 *  androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$DequeueAndCheckForCompletion
 *  androidx.work.impl.utils.WakeLocks
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

class SystemAlarmDispatcher.1
implements Runnable {
    final SystemAlarmDispatcher this$0;

    SystemAlarmDispatcher.1(SystemAlarmDispatcher systemAlarmDispatcher) {
        this.this$0 = systemAlarmDispatcher;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        var3_1 = this.this$0.mIntents;
        synchronized (var3_1) {
            this.this$0.mCurrentIntent = (Intent)this.this$0.mIntents.get(0);
        }
        if (this.this$0.mCurrentIntent == null) return;
        var3_1 = this.this$0.mCurrentIntent.getAction();
        var1_2 = this.this$0.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
        Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Processing command %s, %s", new Object[]{this.this$0.mCurrentIntent, var1_2}), new Throwable[0]);
        var4_3 = WakeLocks.newWakeLock((Context)this.this$0.mContext, (String)String.format("%s (%s)", new Object[]{var3_1, var1_2}));
        try {
            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Acquiring operation wake lock (%s) %s", new Object[]{var3_1, var4_3}), new Throwable[0]);
            var4_3.acquire();
            this.this$0.mCommandHandler.onHandleIntent(this.this$0.mCurrentIntent, var1_2, this.this$0);
            ** GOTO lbl24
        }
        catch (Throwable var2_5) {
            try {
                Logger.get().error(SystemAlarmDispatcher.TAG, "Unexpected error in onHandleIntent", new Throwable[]{var2_5});
            }
            catch (Throwable var2_6) {
                Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{var3_1, var4_3}), new Throwable[0]);
                var4_3.release();
                var3_1 = this.this$0;
                var3_1.postOnMainThread((Runnable)new SystemAlarmDispatcher.DequeueAndCheckForCompletion((SystemAlarmDispatcher)var3_1));
                throw var2_6;
            }
lbl24:
            // 1 sources

            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{var3_1, var4_3}), new Throwable[0]);
            var4_3.release();
            var3_1 = this.this$0;
            var2_4 = new SystemAlarmDispatcher.DequeueAndCheckForCompletion((SystemAlarmDispatcher)var3_1);
            Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", new Object[]{var3_1, var4_3}), new Throwable[0]);
            var4_3.release();
            var3_1 = this.this$0;
            var2_4 = new SystemAlarmDispatcher.DequeueAndCheckForCompletion((SystemAlarmDispatcher)var3_1);
        }
        var3_1.postOnMainThread((Runnable)var2_4);
    }
}
