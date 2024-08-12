/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

private abstract class LiveData.ObserverWrapper {
    boolean mActive;
    int mLastVersion;
    final Observer<? super T> mObserver;
    final LiveData this$0;

    LiveData.ObserverWrapper(LiveData liveData, Observer<? super T> observer) {
        this.this$0 = liveData;
        this.mLastVersion = -1;
        this.mObserver = observer;
    }

    void activeStateChanged(boolean bl) {
        if (bl == this.mActive) {
            return;
        }
        this.mActive = bl;
        LiveData liveData = this.this$0;
        int n = bl ? 1 : -1;
        liveData.changeActiveCounter(n);
        if (!this.mActive) return;
        this.this$0.dispatchingValue(this);
    }

    void detachObserver() {
    }

    boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        return false;
    }

    abstract boolean shouldBeActive();
}
