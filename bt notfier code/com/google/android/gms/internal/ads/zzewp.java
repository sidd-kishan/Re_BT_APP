/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcyj
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzewn
 *  com.google.android.gms.internal.ads.zzewo
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzexu
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfst
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcyj;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzewn;
import com.google.android.gms.internal.ads.zzewo;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzexu;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfst;
import java.util.concurrent.Executor;

public final class zzewp<R extends zzdal<AdT>, AdT extends zzcxg>
implements zzexo<R, zzfcl<R, AdT>> {
    private R zza;
    private final Executor zzb = zzfst.zza();

    public final R zza() {
        return this.zza;
    }

    public final zzfsm<zzfcl<R, AdT>> zzb(zzexp zzexp2, zzexn<R> zzfcl2, R r) {
        zzexp2 = zzfcl2.zza(zzexp2.zzb);
        zzexp2.zzh(new zzexu(true));
        zzexp2 = (zzdal)zzexp2.zzf();
        this.zza = zzexp2;
        zzexp2 = zzexp2.zzP();
        zzfcl2 = new zzfcl();
        return zzfsd.zzj((zzfsm)zzfsd.zzi((zzfsm)zzfru.zzw((zzfsm)zzexp2.zzc()), (zzfrk)new zzewn(this, zzfcl2, (zzcyj)zzexp2), (Executor)this.zzb), (zzfln)new zzewo(zzfcl2), (Executor)this.zzb);
    }
}
