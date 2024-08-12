/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

public class Transformations {
    private Transformations() {
    }

    public static <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, (Observer)new /* Unavailable Anonymous Inner Class!! */);
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> liveData, Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, (Observer)new /* Unavailable Anonymous Inner Class!! */);
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, (Observer)new /* Unavailable Anonymous Inner Class!! */);
        return mediatorLiveData;
    }
}
