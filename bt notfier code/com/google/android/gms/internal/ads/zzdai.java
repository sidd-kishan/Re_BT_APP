/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdah
 *  com.google.android.gms.internal.ads.zzesb
 *  com.google.android.gms.internal.ads.zzfed
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzgku
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdah;
import com.google.android.gms.internal.ads.zzesb;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzgku;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzdai {
    private final zzfes zza;
    private final zzcgz zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List<String> zze;
    private final PackageInfo zzf;
    private final zzgku<zzfsm<String>> zzg;
    private final String zzh;
    private final zzesb<Bundle> zzi;

    public zzdai(zzfes zzfes2, zzcgz zzcgz2, ApplicationInfo applicationInfo, String string, List<String> list, PackageInfo packageInfo, zzgku<zzfsm<String>> zzgku2, zzg zzg2, String string2, zzesb<Bundle> zzesb2) {
        this.zza = zzfes2;
        this.zzb = zzcgz2;
        this.zzc = applicationInfo;
        this.zzd = string;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgku2;
        this.zzh = string2;
        this.zzi = zzesb2;
    }

    public final zzfsm<Bundle> zza() {
        zzfes zzfes2 = this.zza;
        zzfem zzfem2 = zzfem.zza;
        return zzfed.zza((zzfsm)this.zzi.zza((Object)new Bundle()), (Object)zzfem2, (zzfek)zzfes2).zzi();
    }

    public final zzfsm<zzcbj> zzb() {
        zzfsm<Bundle> zzfsm2 = this.zza();
        return this.zza.zzf((Object)zzfem.zzb, new zzfsm[]{zzfsm2, (zzfsm)this.zzg.zzb()}).zza((Callable)new zzdah(this, zzfsm2)).zzi();
    }

    final /* synthetic */ zzcbj zzc(zzfsm zzfsm2) throws Exception {
        return new zzcbj((Bundle)zzfsm2.get(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (String)((zzfsm)this.zzg.zzb()).get(), this.zzh, null, null);
    }
}
