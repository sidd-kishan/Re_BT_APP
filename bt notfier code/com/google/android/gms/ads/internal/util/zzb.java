/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zza
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzfsm;

public abstract class zzb {
    private final Runnable zza = new zza(this);
    private volatile Thread zzb;

    static /* synthetic */ Thread zzb(zzb zzb2, Thread thread) {
        zzb2.zzb = thread;
        return thread;
    }

    public abstract void zza();

    public zzfsm<?> zzc() {
        return zzchg.zza.zza(this.zza);
    }
}
