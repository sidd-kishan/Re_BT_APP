/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.utils.PreferenceUtils
 *  androidx.work.impl.utils.futures.SettableFuture
 */
package androidx.work.impl;

import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.futures.SettableFuture;

class WorkManagerImpl.1
implements Runnable {
    final WorkManagerImpl this$0;
    final SettableFuture val$future;
    final PreferenceUtils val$preferenceUtils;

    WorkManagerImpl.1(WorkManagerImpl workManagerImpl, SettableFuture settableFuture, PreferenceUtils preferenceUtils) {
        this.this$0 = workManagerImpl;
        this.val$future = settableFuture;
        this.val$preferenceUtils = preferenceUtils;
    }

    @Override
    public void run() {
        try {
            this.val$future.set((Object)this.val$preferenceUtils.getLastCancelAllTimeMillis());
        }
        catch (Throwable throwable) {
            this.val$future.setException(throwable);
        }
    }
}
