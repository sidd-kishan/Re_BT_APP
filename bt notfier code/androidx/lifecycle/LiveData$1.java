/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 */
package androidx.lifecycle;

import androidx.lifecycle.LiveData;

class LiveData.1
implements Runnable {
    final LiveData this$0;

    LiveData.1(LiveData liveData) {
        this.this$0 = liveData;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Object object;
        Object object2 = this.this$0.mDataLock;
        synchronized (object2) {
            object = this.this$0.mPendingData;
            this.this$0.mPendingData = LiveData.NOT_SET;
        }
        this.this$0.setValue(object);
    }
}
