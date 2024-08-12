/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzi
 *  com.google.android.gms.internal.measurement.zzj
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzi;
import com.google.android.gms.internal.measurement.zzj;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzk
implements zzi {
    private zzk() {
    }

    /* synthetic */ zzk(zzj zzj2) {
    }

    public static final ExecutorService zzc(int n, ThreadFactory object, int n2) {
        object = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService((ExecutorService)object);
    }

    public final ExecutorService zza(int n) {
        return zzk.zzc(1, Executors.defaultThreadFactory(), 1);
    }

    public final ExecutorService zzb(ThreadFactory threadFactory, int n) {
        return zzk.zzc(1, threadFactory, 1);
    }
}
