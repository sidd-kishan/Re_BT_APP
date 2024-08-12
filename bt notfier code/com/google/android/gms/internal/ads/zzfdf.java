/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzfdf
implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    zzfdf() {
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        int n = this.zza.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append("AdWorker(NG) #");
        stringBuilder.append(n);
        return new Thread(runnable, stringBuilder.toString());
    }
}
