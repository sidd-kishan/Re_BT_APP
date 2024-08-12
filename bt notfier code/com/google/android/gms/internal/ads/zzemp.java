/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzemn
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemn;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzemp
implements zzery {
    private final zzfsm<String> zza;
    private final Executor zzb;

    public zzemp(zzfsm<String> zzfsm2, Executor executor) {
        this.zza = zzfsm2;
        this.zzb = executor;
    }

    public final zzfsm zza() {
        return zzfsd.zzi(this.zza, (zzfrk)zzemn.zza, (Executor)this.zzb);
    }
}
