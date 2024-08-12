/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcfa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcfa;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcex
implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    zzcex(zzcfa zzcfa2) {
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        int n = this.zza.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(42);
        stringBuilder.append("AdWorker(SCION_TASK_EXECUTOR) #");
        stringBuilder.append(n);
        return new Thread(runnable, stringBuilder.toString());
    }
}
