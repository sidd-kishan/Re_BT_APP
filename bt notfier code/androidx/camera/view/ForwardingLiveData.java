/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view._$$Lambda$BwtBFZHv5zE9FaMhvKx7fn8E4Eo
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.camera.view;

import androidx.camera.view._$;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

final class ForwardingLiveData<T>
extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    ForwardingLiveData() {
    }

    public T getValue() {
        Object object = this.mLiveDataSource;
        object = object == null ? null : object.getValue();
        return (T)object;
    }

    void setSource(LiveData<T> liveData) {
        LiveData<T> liveData2 = this.mLiveDataSource;
        if (liveData2 != null) {
            super.removeSource(liveData2);
        }
        this.mLiveDataSource = liveData;
        super.addSource(liveData, (Observer)new _$.Lambda.BwtBFZHv5zE9FaMhvKx7fn8E4Eo(this));
    }
}
