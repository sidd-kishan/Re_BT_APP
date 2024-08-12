/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.android.internal.MainThreadDisposable
 */
package com.uber.autodispose.android.internal;

import com.uber.autodispose.android.internal.MainThreadDisposable;

public final class _$$Lambda$pq2v3zuHA6BURGVoG6CvPmpdahY
implements Runnable {
    private final MainThreadDisposable f$0;

    public /* synthetic */ _$$Lambda$pq2v3zuHA6BURGVoG6CvPmpdahY(MainThreadDisposable mainThreadDisposable) {
        this.f$0 = mainThreadDisposable;
    }

    @Override
    public final void run() {
        this.f$0.onDispose();
    }
}
