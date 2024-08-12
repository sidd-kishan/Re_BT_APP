/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.ArchTaskExecutor
 *  androidx.lifecycle.LiveData
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData<T> {
    final AtomicBoolean mComputing;
    final Executor mExecutor;
    final AtomicBoolean mInvalid = new AtomicBoolean(true);
    final Runnable mInvalidationRunnable;
    final LiveData<T> mLiveData;
    final Runnable mRefreshRunnable;

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    public ComputableLiveData(Executor executor) {
        this.mComputing = new AtomicBoolean(false);
        this.mRefreshRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mInvalidationRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mExecutor = executor;
        this.mLiveData = new /* Unavailable Anonymous Inner Class!! */;
    }

    protected abstract T compute();

    public LiveData<T> getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
    }
}
