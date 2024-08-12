/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfrr
 *  com.google.android.gms.internal.ads.zzfsn
 *  com.google.android.gms.internal.ads.zzfso
 *  com.google.android.gms.internal.ads.zzfsp
 *  com.google.android.gms.internal.ads.zzfss
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import com.google.android.gms.internal.ads.zzfrr;
import com.google.android.gms.internal.ads.zzfsn;
import com.google.android.gms.internal.ads.zzfso;
import com.google.android.gms.internal.ads.zzfsp;
import com.google.android.gms.internal.ads.zzfss;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzfst {
    public static Executor zza() {
        return zzfrr.zza;
    }

    public static zzfsn zzb(ExecutorService object) {
        object = object instanceof zzfsn ? (zzfsn)object : (object instanceof ScheduledExecutorService ? new zzfss((ScheduledExecutorService)object) : new zzfsp((ExecutorService)object));
        return object;
    }

    static Executor zzc(Executor executor, zzfqw<?> zzfqw2) {
        if (executor == null) throw null;
        if (executor != zzfrr.zza) return new zzfso(executor, zzfqw2);
        return executor;
    }
}
