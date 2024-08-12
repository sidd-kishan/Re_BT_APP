/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.LiveData$ObserverWrapper
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

private class LiveData.AlwaysActiveObserver
extends LiveData.ObserverWrapper {
    final LiveData this$0;

    LiveData.AlwaysActiveObserver(LiveData liveData, Observer<? super T> observer) {
        this.this$0 = liveData;
        super(liveData, observer);
    }

    boolean shouldBeActive() {
        return true;
    }
}
