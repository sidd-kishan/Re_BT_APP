/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.SavedStateHandle
 */
package androidx.lifecycle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

static class SavedStateHandle.SavingStateLiveData<T>
extends MutableLiveData<T> {
    private SavedStateHandle mHandle;
    private String mKey;

    SavedStateHandle.SavingStateLiveData(SavedStateHandle savedStateHandle, String string) {
        this.mKey = string;
        this.mHandle = savedStateHandle;
    }

    SavedStateHandle.SavingStateLiveData(SavedStateHandle savedStateHandle, String string, T t) {
        super(t);
        this.mKey = string;
        this.mHandle = savedStateHandle;
    }

    void detach() {
        this.mHandle = null;
    }

    public void setValue(T t) {
        SavedStateHandle savedStateHandle = this.mHandle;
        if (savedStateHandle != null) {
            savedStateHandle.mRegular.put(this.mKey, t);
        }
        super.setValue(t);
    }
}
