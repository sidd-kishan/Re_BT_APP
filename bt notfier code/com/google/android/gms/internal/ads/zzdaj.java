/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcox
 *  com.google.android.gms.internal.ads.zzdai
 *  com.google.android.gms.internal.ads.zzdyy
 *  com.google.android.gms.internal.ads.zzdze
 *  com.google.android.gms.internal.ads.zzesb
 *  com.google.android.gms.internal.ads.zzesc
 *  com.google.android.gms.internal.ads.zzfbu
 *  com.google.android.gms.internal.ads.zzfes
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzgkz
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcox;
import com.google.android.gms.internal.ads.zzdai;
import com.google.android.gms.internal.ads.zzdyy;
import com.google.android.gms.internal.ads.zzdze;
import com.google.android.gms.internal.ads.zzesb;
import com.google.android.gms.internal.ads.zzesc;
import com.google.android.gms.internal.ads.zzfbu;
import com.google.android.gms.internal.ads.zzfes;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzgkz;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.List;

public final class zzdaj
implements zzgla<zzdai> {
    private final zzgln<zzfes> zza;
    private final zzgln<zzcgz> zzb;
    private final zzgln<ApplicationInfo> zzc;
    private final zzgln<String> zzd;
    private final zzgln<List<String>> zze;
    private final zzgln<PackageInfo> zzf;
    private final zzgln<zzfsm<String>> zzg;
    private final zzgln<zzg> zzh;
    private final zzgln<String> zzi;
    private final zzgln<zzesb<Bundle>> zzj;

    public zzdaj(zzgln<zzfes> zzgln2, zzgln<zzcgz> zzgln3, zzgln<ApplicationInfo> zzgln4, zzgln<String> zzgln5, zzgln<List<String>> zzgln6, zzgln<PackageInfo> zzgln7, zzgln<zzfsm<String>> zzgln8, zzgln<zzg> zzgln9, zzgln<String> zzgln10, zzgln<zzesb<Bundle>> zzgln11) {
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

    public final zzdai zza() {
        return new zzdai((zzfes)this.zza.zzb(), ((zzcox)this.zzb).zza(), ((zzdyy)this.zzc).zza(), ((zzdze)this.zzd).zza(), zzbjl.zzc(), (PackageInfo)this.zzf.zzb(), zzgkz.zzc(this.zzg), ((zzfbu)this.zzh).zza(), (String)this.zzi.zzb(), ((zzesc)this.zzj).zza());
    }
}
