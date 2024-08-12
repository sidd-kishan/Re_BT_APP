/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.PublisherAdViewOptions
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfg
 *  com.google.android.gms.internal.ads.zzbfi
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbnf
 *  com.google.android.gms.internal.ads.zzbni
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzbns
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzbsg
 *  com.google.android.gms.internal.ads.zzcoj
 *  com.google.android.gms.internal.ads.zzdmv
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzekm
 *  com.google.android.gms.internal.ads.zzfap
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzcoj;
import com.google.android.gms.internal.ads.zzdmv;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzekm;
import com.google.android.gms.internal.ads.zzfap;

public final class zzekl
extends zzbfi {
    final zzfap zza = new zzfap();
    final zzdmv zzb = new zzdmv();
    private final Context zzc;
    private final zzcoj zzd;
    private zzbfa zze;

    public zzekl(zzcoj zzcoj2, Context context, String string) {
        this.zzd = zzcoj2;
        this.zza.zzw(string);
        this.zzc = context;
    }

    public final zzbfg zze() {
        zzdmx zzdmx2 = this.zzb.zzg();
        this.zza.zzC(zzdmx2.zzh());
        this.zza.zzD(zzdmx2.zzi());
        zzfap zzfap2 = this.zza;
        if (zzfap2.zzv() != null) return new zzekm(this.zzc, this.zzd, this.zza, zzdmx2, this.zze);
        zzfap2.zzt(zzbdl.zzb());
        return new zzekm(this.zzc, this.zzd, this.zza, zzdmx2, this.zze);
    }

    public final void zzf(zzbfa zzbfa2) {
        this.zze = zzbfa2;
    }

    public final void zzg(zzbnf zzbnf2) {
        this.zzb.zzb(zzbnf2);
    }

    public final void zzh(zzbni zzbni2) {
        this.zzb.zza(zzbni2);
    }

    public final void zzi(String string, zzbno zzbno2, zzbnl zzbnl2) {
        this.zzb.zzf(string, zzbno2, zzbnl2);
    }

    public final void zzj(zzblv zzblv2) {
        this.zza.zzE(zzblv2);
    }

    public final void zzk(zzbns zzbns2, zzbdl zzbdl2) {
        this.zzb.zzd(zzbns2);
        this.zza.zzt(zzbdl2);
    }

    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzH(publisherAdViewOptions);
    }

    public final void zzm(zzbnv zzbnv2) {
        this.zzb.zzc(zzbnv2);
    }

    public final void zzn(zzbrx zzbrx2) {
        this.zza.zzG(zzbrx2);
    }

    public final void zzo(zzbsg zzbsg2) {
        this.zzb.zze(zzbsg2);
    }

    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzI(adManagerAdViewOptions);
    }

    public final void zzq(zzbfy zzbfy2) {
        this.zza.zzO(zzbfy2);
    }
}
