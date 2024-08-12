/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

private static class MediatorLiveData.Source<V>
implements Observer<V> {
    final LiveData<V> mLiveData;
    final Observer<? super V> mObserver;
    int mVersion = -1;

    MediatorLiveData.Source(LiveData<V> liveData, Observer<? super V> observer) {
        this.mLiveData = liveData;
        this.mObserver = observer;
    }

    public void onChanged(V v) {
        if (this.mVersion == this.mLiveData.getVersion()) return;
        this.mVersion = this.mLiveData.getVersion();
        this.mObserver.onChanged(v);
    }

    void plug() {
        this.mLiveData.observeForever((Observer)this);
    }

    void unplug() {
        this.mLiveData.removeObserver((Observer)this);
    }
}
