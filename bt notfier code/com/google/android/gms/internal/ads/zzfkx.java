/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfkw
 *  com.google.android.gms.internal.ads.zzfky
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfkw;
import com.google.android.gms.internal.ads.zzfky;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzfkx
implements zzfkw {
    private zzfkx() {
    }

    /* synthetic */ zzfkx(zzfky zzfky2) {
    }

    public final ExecutorService zza(int n, ThreadFactory object, int n2) {
        object = new ThreadPoolExecutor(n, n, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService((ExecutorService)object);
    }

    public final ExecutorService zzb(int n) {
        return this.zza(1, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zzc(ThreadFactory threadFactory, int n) {
        return this.zza(1, threadFactory, 1);
    }
}
