/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ComputableLiveData
 *  androidx.lifecycle.LiveData
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;

class ComputableLiveData.1
extends LiveData<T> {
    final ComputableLiveData this$0;

    ComputableLiveData.1(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    protected void onActive() {
        this.this$0.mExecutor.execute(this.this$0.mRefreshRunnable);
    }
}
