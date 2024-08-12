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

static final class Transformations.2
implements Observer<X> {
    LiveData<Y> mSource;
    final MediatorLiveData val$result;
    final Function val$switchMapFunction;

    Transformations.2(Function function, MediatorLiveData mediatorLiveData) {
        this.val$switchMapFunction = function;
        this.val$result = mediatorLiveData;
    }

    public void onChanged(X object) {
        object = this.mSource;
        LiveData liveData = (LiveData)this.val$switchMapFunction.apply(object);
        if (object == liveData) {
            return;
        }
        if (object != null) {
            this.val$result.removeSource(object);
        }
        this.mSource = liveData;
        if (liveData == null) return;
        this.val$result.addSource(liveData, (Observer)new /* Unavailable Anonymous Inner Class!! */);
    }
}
