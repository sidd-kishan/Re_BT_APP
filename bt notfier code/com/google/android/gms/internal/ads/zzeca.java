/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdcq
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdeb
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdcq;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdeb;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;

public final class zzeca
implements zzddx,
zzdcq,
zzdbf,
zzdeb {
    private final zzffb zza;
    private final zzffc zzb;
    private final zzcgi zzc;

    public zzeca(zzffb zzffb2, zzffc zzffc2, zzcgi zzcgi2) {
        this.zza = zzffb2;
        this.zzb = zzffc2;
        this.zzc = zzcgi2;
    }

    public final void zzbB(boolean bl) {
        zzbjd zzbjd2 = zzbjl.zzfl;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        this.zza.zzc("scar", "true");
    }

    public final void zzbD(zzbcz zzbcz2) {
        zzffb zzffb2 = this.zza;
        zzffb2.zzc("action", "ftl");
        zzffb2.zzc("ftl", String.valueOf(zzbcz2.zza));
        zzffb2.zzc("ed", zzbcz2.zzc);
        this.zzb.zza(this.zza);
    }

    public final void zzbG(zzcbj zzcbj2) {
        this.zza.zzf(zzcbj2.zza);
    }

    public final void zzf() {
        zzffc zzffc2 = this.zzb;
        zzffb zzffb2 = this.zza;
        zzffb2.zzc("action", "loaded");
        zzffc2.zza(zzffb2);
    }

    public final void zzq(zzfal zzfal2) {
        this.zza.zzg(zzfal2, this.zzc);
    }
}
