/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

static final class Transformations.3
implements Observer<X> {
    boolean mFirstTime;
    final MediatorLiveData val$outputLiveData;

    Transformations.3(MediatorLiveData mediatorLiveData) {
        this.val$outputLiveData = mediatorLiveData;
        this.mFirstTime = true;
    }

    public void onChanged(X x) {
        Object object = this.val$outputLiveData.getValue();
        if (!(this.mFirstTime || object == null && x != null)) {
            if (object == null) return;
            if (object.equals(x)) return;
        }
        this.mFirstTime = false;
        this.val$outputLiveData.setValue(x);
    }
}
