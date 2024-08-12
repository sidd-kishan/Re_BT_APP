/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.base.zal
 *  com.google.android.gms.internal.base.zam
 */
package com.google.android.gms.internal.base;

import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zan
implements zal {
    private zan() {
    }

    /* synthetic */ zan(zam zam2) {
    }

    public final ExecutorService zaa(int n, int n2) {
        return this.zab(4, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zab(int n, ThreadFactory object, int n2) {
        object = new ThreadPoolExecutor(n, n, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService((ExecutorService)object);
    }

    public final ExecutorService zac(ThreadFactory threadFactory, int n) {
        return this.zab(1, threadFactory, 1);
    }
}
