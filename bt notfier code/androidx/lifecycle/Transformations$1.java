/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.lifecycle.MediatorLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

static final class Transformations.1
implements Observer<X> {
    final Function val$mapFunction;
    final MediatorLiveData val$result;

    Transformations.1(MediatorLiveData mediatorLiveData, Function function) {
        this.val$result = mediatorLiveData;
        this.val$mapFunction = function;
    }

    public void onChanged(X x) {
        this.val$result.setValue(this.val$mapFunction.apply(x));
    }
}
