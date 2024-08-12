/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ComputableLiveData
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;

class ComputableLiveData.3
implements Runnable {
    final ComputableLiveData this$0;

    ComputableLiveData.3(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    @Override
    public void run() {
        boolean bl = this.this$0.mLiveData.hasActiveObservers();
        if (!this.this$0.mInvalid.compareAndSet(false, true)) return;
        if (!bl) return;
        this.this$0.mExecutor.execute(this.this$0.mRefreshRunnable);
    }
}
