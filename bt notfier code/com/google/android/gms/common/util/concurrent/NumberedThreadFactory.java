/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.util.concurrent.zza
 */
package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.zza;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberedThreadFactory
implements ThreadFactory {
    private final String zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final ThreadFactory zzc = Executors.defaultThreadFactory();

    public NumberedThreadFactory(String string) {
        Preconditions.checkNotNull((Object)string, (Object)"Name must not be null");
        this.zza = string;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        runnable = this.zzc.newThread((Runnable)new zza(runnable, 0));
        String string = this.zza;
        int n = this.zzb.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 13);
        stringBuilder.append(string);
        stringBuilder.append("[");
        stringBuilder.append(n);
        stringBuilder.append("]");
        ((Thread)runnable).setName(stringBuilder.toString());
        return runnable;
    }
}
