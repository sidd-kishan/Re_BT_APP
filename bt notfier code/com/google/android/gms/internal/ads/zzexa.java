/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzeww
 *  com.google.android.gms.internal.ads.zzewx
 *  com.google.android.gms.internal.ads.zzewy
 *  com.google.android.gms.internal.ads.zzewz
 *  com.google.android.gms.internal.ads.zzexj
 *  com.google.android.gms.internal.ads.zzexk
 *  com.google.android.gms.internal.ads.zzexn
 *  com.google.android.gms.internal.ads.zzexo
 *  com.google.android.gms.internal.ads.zzexp
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcm
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzeww;
import com.google.android.gms.internal.ads.zzewx;
import com.google.android.gms.internal.ads.zzewy;
import com.google.android.gms.internal.ads.zzewz;
import com.google.android.gms.internal.ads.zzexj;
import com.google.android.gms.internal.ads.zzexk;
import com.google.android.gms.internal.ads.zzexn;
import com.google.android.gms.internal.ads.zzexo;
import com.google.android.gms.internal.ads.zzexp;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcm;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzexa<R extends zzdal<AdT>, AdT extends zzcxg>
implements zzexo<R, zzewz<R, AdT>> {
    private final zzfcc zza;
    private final Executor zzb;
    private final zzfrz<Void> zzc = new zzewy(this);

    public zzexa(zzfcc zzfcc2, Executor executor) {
        this.zza = zzfcc2;
        this.zzb = executor;
    }

    public final zzfsm<zzewz<R, AdT>> zza(zzexp zzexp2, zzexn<R> zzexn2, R r) {
        return zzfsd.zzf((zzfsm)zzfsd.zzi((zzfsm)zzfru.zzw((zzfsm)new zzexk(this.zza, r, this.zzb).zzc()), (zzfrk)new zzeww(this, r), (Executor)this.zzb), Exception.class, (zzfln)new zzewx(this), (Executor)this.zzb);
    }

    final /* synthetic */ zzfsm zzb(zzdal zzdal2, zzexj object) throws Exception {
        zzfcm zzfcm2 = object.zzb;
        zzcbj zzcbj2 = object.zza;
        object = zzfcm2 != null ? this.zza.zza(zzfcm2) : null;
        if (zzfcm2 == null) {
            zzdal2 = zzfsd.zza(null);
        } else {
            if (object != null && zzcbj2 != null) {
                zzfsd.zzp((zzfsm)zzdal2.zzP().zzg(zzcbj2), this.zzc, (Executor)this.zzb);
            }
            zzdal2 = zzfsd.zza((Object)new zzewz(zzfcm2, zzcbj2, (zzfcl)object));
        }
        return zzdal2;
    }
}
