/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.LiveDataUtils$1
 */
package androidx.work.impl.utils;

import androidx.work.impl.utils.LiveDataUtils;

class LiveDataUtils.1
implements Runnable {
    final LiveDataUtils.1 this$0;
    final Object val$input;

    LiveDataUtils.1(LiveDataUtils.1 var1_1, Object object) {
        this.this$0 = var1_1;
        this.val$input = object;
    }

    @Override
    public void run() {
        Object object = this.this$0.val$lock;
        synchronized (object) {
            Object object2 = this.this$0.val$mappingMethod.apply(this.val$input);
            if (this.this$0.mCurrentOutput == null && object2 != null) {
                this.this$0.mCurrentOutput = object2;
                this.this$0.val$outputLiveData.postValue(object2);
            } else {
                if (this.this$0.mCurrentOutput == null) return;
                if (this.this$0.mCurrentOutput.equals(object2)) return;
                this.this$0.mCurrentOutput = object2;
                this.this$0.val$outputLiveData.postValue(object2);
            }
            return;
        }
    }
}
