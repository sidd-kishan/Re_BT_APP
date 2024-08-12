/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcvk
 *  com.google.android.gms.internal.ads.zzcvq
 *  com.google.android.gms.internal.ads.zzcvr
 *  com.google.android.gms.internal.ads.zzcvs
 *  com.google.android.gms.internal.ads.zzcwc
 *  com.google.android.gms.internal.ads.zzcxe
 *  com.google.android.gms.internal.ads.zzcxf
 *  com.google.android.gms.internal.ads.zzczb
 *  com.google.android.gms.internal.ads.zzdiq
 *  com.google.android.gms.internal.ads.zzdkz
 *  com.google.android.gms.internal.ads.zzdmx
 *  com.google.android.gms.internal.ads.zzekj
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzgku
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcvk;
import com.google.android.gms.internal.ads.zzcvq;
import com.google.android.gms.internal.ads.zzcvr;
import com.google.android.gms.internal.ads.zzcvs;
import com.google.android.gms.internal.ads.zzcwc;
import com.google.android.gms.internal.ads.zzcxe;
import com.google.android.gms.internal.ads.zzcxf;
import com.google.android.gms.internal.ads.zzczb;
import com.google.android.gms.internal.ads.zzdiq;
import com.google.android.gms.internal.ads.zzdkz;
import com.google.android.gms.internal.ads.zzdmx;
import com.google.android.gms.internal.ads.zzekj;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzgku;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.concurrent.Executor;

public final class zzcvl
implements zzgla<zzcvk> {
    private final zzgln<zzcxf> zza;
    private final zzgln<Context> zzb;
    private final zzgln<zzfaa> zzc;
    private final zzgln<View> zzd;
    private final zzgln<zzcml> zze;
    private final zzgln<zzcxe> zzf;
    private final zzgln<zzdmx> zzg;
    private final zzgln<zzdiq> zzh;
    private final zzgln<zzekj> zzi;
    private final zzgln<Executor> zzj;

    public zzcvl(zzgln<zzcxf> zzgln2, zzgln<Context> zzgln3, zzgln<zzfaa> zzgln4, zzgln<View> zzgln5, zzgln<zzcml> zzgln6, zzgln<zzcxe> zzgln7, zzgln<zzdmx> zzgln8, zzgln<zzdiq> zzgln9, zzgln<zzekj> zzgln10, zzgln<Executor> zzgln11) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
        this.zzf = zzgln7;
        this.zzg = zzgln8;
        this.zzh = zzgln9;
        this.zzi = zzgln10;
        this.zzj = zzgln11;
    }

    public static zzcvk zzc(zzcxf zzcxf2, Context context, zzfaa zzfaa2, View view, zzcml zzcml2, zzcxe zzcxe2, zzdmx zzdmx2, zzdiq zzdiq2, zzgku<zzekj> zzgku2, Executor executor) {
        return new zzcvk(zzcxf2, context, zzfaa2, view, zzcml2, zzcxe2, zzdmx2, zzdiq2, zzgku2, executor);
    }

    public final zzcvk zza() {
        return new zzcvk(((zzczb)this.zza).zza(), (Context)this.zzb.zzb(), ((zzcvr)this.zzc).zza(), ((zzcvq)this.zzd).zza(), ((zzcwc)this.zze).zza(), ((zzcvs)this.zzf).zza(), ((zzdkz)this.zzg).zza(), (zzdiq)this.zzh.zzb(), zzgkz.zzc(this.zzi), (Executor)this.zzj.zzb());
    }
}
