/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.LiveData$ObserverWrapper
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

class LiveData.LifecycleBoundObserver
extends LiveData.ObserverWrapper
implements LifecycleEventObserver {
    final LifecycleOwner mOwner;
    final LiveData this$0;

    LiveData.LifecycleBoundObserver(LiveData liveData, LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        this.this$0 = liveData;
        super(liveData, observer);
        this.mOwner = lifecycleOwner;
    }

    void detachObserver() {
        this.mOwner.getLifecycle().removeObserver((LifecycleObserver)this);
    }

    boolean isAttachedTo(LifecycleOwner lifecycleOwner) {
        boolean bl = this.mOwner == lifecycleOwner;
        return bl;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner = this.mOwner.getLifecycle().getCurrentState();
        if (lifecycleOwner == Lifecycle.State.DESTROYED) {
            this.this$0.removeObserver(this.mObserver);
            return;
        }
        event = null;
        while (event != lifecycleOwner) {
            this.activeStateChanged(this.shouldBeActive());
            Lifecycle.State state = this.mOwner.getLifecycle().getCurrentState();
            event = lifecycleOwner;
            lifecycleOwner = state;
        }
    }

    boolean shouldBeActive() {
        return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }
}
