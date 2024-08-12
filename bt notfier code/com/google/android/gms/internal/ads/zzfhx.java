/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfhw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfhw;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzfhx {
    private final BlockingQueue<Runnable> zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque<zzfhw> zzc = new ArrayDeque();
    private zzfhw zzd = null;

    public zzfhx() {
        this.zza = new LinkedBlockingQueue<Runnable>();
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.zza);
    }

    private final void zzc() {
        zzfhw zzfhw2;
        this.zzd = zzfhw2 = this.zzc.poll();
        if (zzfhw2 == null) return;
        zzfhw2.executeOnExecutor((Executor)this.zzb, new Object[0]);
    }

    public final void zza(zzfhw zzfhw2) {
        zzfhw2.zzb(this);
        this.zzc.add(zzfhw2);
        if (this.zzd != null) return;
        this.zzc();
    }

    public final void zzb(zzfhw zzfhw2) {
        this.zzd = null;
        this.zzc();
    }
}
