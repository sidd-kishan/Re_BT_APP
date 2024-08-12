/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdeb
 *  com.google.android.gms.internal.ads.zzdve
 *  com.google.android.gms.internal.ads.zzdvn
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdeb;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvn;
import com.google.android.gms.internal.ads.zzfal;

public final class zzduv
implements zzddx,
zzdcq,
zzdbf,
zzdeb {
    private final zzdve zza;
    private final zzdvn zzb;

    public zzduv(zzdve zzdve2, zzdvn zzdvn2) {
        this.zza = zzdve2;
        this.zzb = zzdvn2;
    }

    public final void zzbB(boolean bl) {
        zzbjd zzbjd2 = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        this.zza.zzc().put("scar", "true");
    }

    public final void zzbD(zzbcz zzbcz2) {
        this.zza.zzc().put("action", "ftl");
        this.zza.zzc().put("ftl", String.valueOf(zzbcz2.zza));
        this.zza.zzc().put("ed", zzbcz2.zzc);
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzbG(zzcbj zzcbj2) {
        this.zza.zzb(zzcbj2.zza);
    }

    public final void zzf() {
        this.zza.zzc().put("action", "loaded");
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzq(zzfal zzfal2) {
        this.zza.zza(zzfal2);
    }
}
