/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzchc
implements ThreadFactory {
    final String zza;
    private final AtomicInteger zzb;

    zzchc(String string) {
        this.zza = string;
        this.zzb = new AtomicInteger(1);
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        String string = this.zza;
        int n = this.zzb.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 23);
        stringBuilder.append("AdWorker(");
        stringBuilder.append(string);
        stringBuilder.append(") #");
        stringBuilder.append(n);
        return new Thread(runnable, stringBuilder.toString());
    }
}
