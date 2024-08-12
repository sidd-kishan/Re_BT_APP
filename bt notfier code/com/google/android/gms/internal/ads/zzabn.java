/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzabn
implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzabn() {
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        runnable = this.zza.newThread(runnable);
        int n = this.zzb.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("gads-");
        stringBuilder.append(n);
        ((Thread)runnable).setName(stringBuilder.toString());
        return runnable;
    }
}
