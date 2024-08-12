/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ProcessLifecycleOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.ProcessLifecycleOwner;

class ProcessLifecycleOwner.1
implements Runnable {
    final ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner.1(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    @Override
    public void run() {
        this.this$0.dispatchPauseIfNeeded();
        this.this$0.dispatchStopIfNeeded();
    }
}
