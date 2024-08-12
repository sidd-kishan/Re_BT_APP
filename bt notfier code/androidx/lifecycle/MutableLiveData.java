/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;

public class MutableLiveData<T>
extends LiveData<T> {
    public MutableLiveData() {
    }

    public MutableLiveData(T t) {
        super(t);
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(T t) {
        super.setValue(t);
    }
}
