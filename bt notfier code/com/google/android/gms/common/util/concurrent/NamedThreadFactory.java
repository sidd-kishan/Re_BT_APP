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

public class NamedThreadFactory
implements ThreadFactory {
    private final String zza;
    private final ThreadFactory zzb = Executors.defaultThreadFactory();

    public NamedThreadFactory(String string) {
        Preconditions.checkNotNull((Object)string, (Object)"Name must not be null");
        this.zza = string;
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        runnable = this.zzb.newThread((Runnable)new zza(runnable, 0));
        ((Thread)runnable).setName(this.zza);
        return runnable;
    }
}
