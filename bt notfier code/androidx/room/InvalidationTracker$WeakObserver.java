/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.InvalidationTracker
 *  androidx.room.InvalidationTracker$Observer
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;

static class InvalidationTracker.WeakObserver
extends InvalidationTracker.Observer {
    final WeakReference<InvalidationTracker.Observer> mDelegateRef;
    final InvalidationTracker mTracker;

    InvalidationTracker.WeakObserver(InvalidationTracker invalidationTracker, InvalidationTracker.Observer observer) {
        super(observer.mTables);
        this.mTracker = invalidationTracker;
        this.mDelegateRef = new WeakReference<InvalidationTracker.Observer>(observer);
    }

    public void onInvalidated(Set<String> set) {
        InvalidationTracker.Observer observer = (InvalidationTracker.Observer)this.mDelegateRef.get();
        if (observer == null) {
            this.mTracker.removeObserver((InvalidationTracker.Observer)this);
        } else {
            observer.onInvalidated(set);
        }
    }
}
