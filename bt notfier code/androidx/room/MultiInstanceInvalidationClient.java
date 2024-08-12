/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.IMultiInstanceInvalidationService
 *  androidx.room.InvalidationTracker
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.MultiInstanceInvalidationService
 */
package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationService;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MultiInstanceInvalidationClient {
    final Context mAppContext;
    final IMultiInstanceInvalidationCallback mCallback = new /* Unavailable Anonymous Inner Class!! */;
    int mClientId;
    final Executor mExecutor;
    final InvalidationTracker mInvalidationTracker;
    final String mName;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRemoveObserverRunnable;
    IMultiInstanceInvalidationService mService;
    final ServiceConnection mServiceConnection;
    final Runnable mSetUpRunnable;
    final AtomicBoolean mStopped = new AtomicBoolean(false);
    private final Runnable mTearDownRunnable;

    MultiInstanceInvalidationClient(Context context, String string, InvalidationTracker invalidationTracker, Executor executor) {
        this.mServiceConnection = new /* Unavailable Anonymous Inner Class!! */;
        this.mSetUpRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mRemoveObserverRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mTearDownRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mAppContext = context.getApplicationContext();
        this.mName = string;
        this.mInvalidationTracker = invalidationTracker;
        this.mExecutor = executor;
        this.mObserver = new /* Unavailable Anonymous Inner Class!! */;
        context = new Intent(this.mAppContext, MultiInstanceInvalidationService.class);
        this.mAppContext.bindService((Intent)context, this.mServiceConnection, 1);
    }

    void stop() {
        if (!this.mStopped.compareAndSet(false, true)) return;
        this.mExecutor.execute(this.mTearDownRunnable);
    }
}
