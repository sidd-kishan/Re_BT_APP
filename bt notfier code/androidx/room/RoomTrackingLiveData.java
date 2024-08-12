/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.room.InvalidationLiveDataContainer
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.RoomDatabase
 */
package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class RoomTrackingLiveData<T>
extends LiveData<T> {
    final Callable<T> mComputeFunction;
    final AtomicBoolean mComputing;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final AtomicBoolean mInvalid = new AtomicBoolean(true);
    final Runnable mInvalidationRunnable;
    final InvalidationTracker.Observer mObserver;
    final Runnable mRefreshRunnable;
    final AtomicBoolean mRegisteredObserver;

    RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean bl, Callable<T> callable, String[] stringArray) {
        this.mComputing = new AtomicBoolean(false);
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mRefreshRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mInvalidationRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mDatabase = roomDatabase;
        this.mInTransaction = bl;
        this.mComputeFunction = callable;
        this.mContainer = invalidationLiveDataContainer;
        this.mObserver = new /* Unavailable Anonymous Inner Class!! */;
    }

    static /* synthetic */ void access$000(RoomTrackingLiveData roomTrackingLiveData, Object object) {
        roomTrackingLiveData.postValue(object);
    }

    Executor getQueryExecutor() {
        if (!this.mInTransaction) return this.mDatabase.getQueryExecutor();
        return this.mDatabase.getTransactionExecutor();
    }

    protected void onActive() {
        super.onActive();
        this.mContainer.onActive((LiveData)this);
        this.getQueryExecutor().execute(this.mRefreshRunnable);
    }

    protected void onInactive() {
        super.onInactive();
        this.mContainer.onInactive((LiveData)this);
    }
}
