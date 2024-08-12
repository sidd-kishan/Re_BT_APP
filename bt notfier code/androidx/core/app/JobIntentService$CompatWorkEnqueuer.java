/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  androidx.core.app.JobIntentService$WorkEnqueuer
 */
package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.core.app.JobIntentService;

static final class JobIntentService.CompatWorkEnqueuer
extends JobIntentService.WorkEnqueuer {
    private final Context mContext;
    private final PowerManager.WakeLock mLaunchWakeLock;
    boolean mLaunchingService;
    private final PowerManager.WakeLock mRunWakeLock;
    boolean mServiceProcessing;

    JobIntentService.CompatWorkEnqueuer(Context context, ComponentName componentName) {
        super(componentName);
        this.mContext = context.getApplicationContext();
        context = (PowerManager)context.getSystemService("power");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(componentName.getClassName());
        stringBuilder.append(":launch");
        stringBuilder = context.newWakeLock(1, stringBuilder.toString());
        this.mLaunchWakeLock = stringBuilder;
        stringBuilder.setReferenceCounted(false);
        stringBuilder = new StringBuilder();
        stringBuilder.append(componentName.getClassName());
        stringBuilder.append(":run");
        context = context.newWakeLock(1, stringBuilder.toString());
        this.mRunWakeLock = context;
        context.setReferenceCounted(false);
    }

    void enqueueWork(Intent intent) {
        intent = new Intent(intent);
        intent.setComponent(this.mComponentName);
        if (this.mContext.startService(intent) == null) return;
        synchronized (this) {
            if (this.mLaunchingService) return;
            this.mLaunchingService = true;
            if (this.mServiceProcessing) return;
            this.mLaunchWakeLock.acquire(60000L);
        }
    }

    public void serviceProcessingFinished() {
        synchronized (this) {
            if (!this.mServiceProcessing) return;
            if (this.mLaunchingService) {
                this.mLaunchWakeLock.acquire(60000L);
            }
            this.mServiceProcessing = false;
            this.mRunWakeLock.release();
            return;
        }
    }

    public void serviceProcessingStarted() {
        synchronized (this) {
            if (this.mServiceProcessing) return;
            this.mServiceProcessing = true;
            this.mRunWakeLock.acquire(600000L);
            this.mLaunchWakeLock.release();
            return;
        }
    }

    public void serviceStartReceived() {
        synchronized (this) {
            this.mLaunchingService = false;
            return;
        }
    }
}
