/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ComputableLiveData
 */
package androidx.lifecycle;

import androidx.lifecycle.ComputableLiveData;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData.2
implements Runnable {
    final ComputableLiveData this$0;

    ComputableLiveData.2(ComputableLiveData computableLiveData) {
        this.this$0 = computableLiveData;
    }

    @Override
    public void run() {
        do {
            Object object = this.this$0.mComputing;
            boolean bl = false;
            if (((AtomicBoolean)object).compareAndSet(false, true)) {
                object = null;
                bl = false;
                try {
                    while (this.this$0.mInvalid.compareAndSet(true, false)) {
                        object = this.this$0.compute();
                        bl = true;
                    }
                    if (bl) {
                        this.this$0.mLiveData.postValue(object);
                    }
                }
                finally {
                    this.this$0.mComputing.set(false);
                }
            }
            if (!bl) return;
        } while (this.this$0.mInvalid.get());
    }
}
