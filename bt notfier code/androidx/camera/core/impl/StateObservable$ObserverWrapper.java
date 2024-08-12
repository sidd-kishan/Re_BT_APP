/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl.StateObservable$ErrorWrapper
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

private static final class StateObservable.ObserverWrapper<T>
implements Runnable {
    private static final Object NOT_SET = new Object();
    private static final int NO_VERSION = -1;
    private final AtomicBoolean mActive = new AtomicBoolean(true);
    private final Executor mExecutor;
    private Object mLastState = NOT_SET;
    private int mLatestSignalledVersion = -1;
    private final Observable.Observer<? super T> mObserver;
    private final AtomicReference<Object> mStateRef;
    private boolean mWrapperUpdating = false;

    StateObservable.ObserverWrapper(AtomicReference<Object> atomicReference, Executor executor, Observable.Observer<? super T> observer) {
        this.mStateRef = atomicReference;
        this.mExecutor = executor;
        this.mObserver = observer;
    }

    void close() {
        this.mActive.set(false);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        int n;
        Object object;
        synchronized (this) {
            if (!this.mActive.get()) {
                this.mWrapperUpdating = false;
                return;
            }
            object = this.mStateRef.get();
            n = this.mLatestSignalledVersion;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            if (!Objects.equals(this.mLastState, object)) {
                this.mLastState = object;
                if (object instanceof StateObservable.ErrorWrapper) {
                    this.mObserver.onError(((StateObservable.ErrorWrapper)object).getError());
                } else {
                    this.mObserver.onNewData(object);
                }
            }
            synchronized (this) {
                if (n == this.mLatestSignalledVersion || !this.mActive.get()) break;
                object = this.mStateRef.get();
                n = this.mLatestSignalledVersion;
            }
        }
        {
            this.mWrapperUpdating = false;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    void update(int n) {
        // MONITORENTER : this
        if (!this.mActive.get()) {
            // MONITOREXIT : this
            return;
        }
        if (n <= this.mLatestSignalledVersion) {
            // MONITOREXIT : this
            return;
        }
        this.mLatestSignalledVersion = n;
        if (this.mWrapperUpdating) {
            // MONITOREXIT : this
            return;
        }
        this.mWrapperUpdating = true;
        // MONITOREXIT : this
        try {
            this.mExecutor.execute(this);
            return;
        }
        catch (Throwable throwable) {
            // MONITORENTER : this
            this.mWrapperUpdating = false;
            // MONITOREXIT : this
        }
    }
}
