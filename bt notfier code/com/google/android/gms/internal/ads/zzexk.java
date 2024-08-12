/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbld
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdal
 *  com.google.android.gms.internal.ads.zzeap
 *  com.google.android.gms.internal.ads.zzexf
 *  com.google.android.gms.internal.ads.zzexg
 *  com.google.android.gms.internal.ads.zzexh
 *  com.google.android.gms.internal.ads.zzexj
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcm
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdal;
import com.google.android.gms.internal.ads.zzeap;
import com.google.android.gms.internal.ads.zzexf;
import com.google.android.gms.internal.ads.zzexg;
import com.google.android.gms.internal.ads.zzexh;
import com.google.android.gms.internal.ads.zzexj;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcm;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

final class zzexk<R extends zzdal<? extends zzcxg>> {
    private final zzfcc zza;
    private final R zzb;
    private final Executor zzc;
    private zzexj zzd;

    public zzexk(zzfcc zzfcc2, R r, Executor executor) {
        this.zza = zzfcc2;
        this.zzb = r;
        this.zzc = executor;
    }

    static /* synthetic */ zzexj zza(zzexk zzexk2, zzexj zzexj2) {
        zzexk2.zzd = zzexj2;
        return zzexj2;
    }

    static /* synthetic */ zzexj zzb(zzexk zzexk2) {
        return zzexk2.zzd;
    }

    static /* synthetic */ zzfcm zzd(zzexk zzexk2) {
        return zzexk2.zze();
    }

    @Deprecated
    private final zzfcm zze() {
        zzfar zzfar2 = this.zzb.zzN();
        zzbdg zzbdg2 = zzfar2.zzd;
        String string = zzfar2.zzf;
        zzfar2 = zzfar2.zzj;
        return this.zza.zzd(zzbdg2, string, (zzbdr)zzfar2);
    }

    public final zzfsm<zzexj> zzc() {
        zzexj zzexj2 = this.zzd;
        if (zzexj2 != null) return zzfsd.zza((Object)zzexj2);
        if (!((Boolean)zzbld.zza.zze()).booleanValue()) {
            this.zzd = zzexj2 = new zzexj(null, this.zze(), null);
            zzexj2 = zzfsd.zza((Object)zzexj2);
        } else {
            zzexj2 = zzfsd.zzf((zzfsm)zzfsd.zzj((zzfsm)zzfru.zzw((zzfsm)this.zzb.zzP().zzf(this.zza.zze())), (zzfln)new zzexh(this), (Executor)this.zzc), zzeap.class, (zzfln)new zzexg(this), (Executor)this.zzc);
        }
        return zzfsd.zzj((zzfsm)zzexj2, (zzfln)zzexf.zza, (Executor)this.zzc);
    }
}
