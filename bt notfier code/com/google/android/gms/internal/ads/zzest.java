/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  com.google.android.gms.internal.ads.zzcfw
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesr
 *  com.google.android.gms.internal.ads.zzess
 *  com.google.android.gms.internal.ads.zzesu
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesr;
import com.google.android.gms.internal.ads.zzess;
import com.google.android.gms.internal.ads.zzesu;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public final class zzest
implements zzery<zzesu> {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzcfw zzd;

    public zzest(zzcfw zzcfw2, Executor executor, String string, PackageInfo packageInfo, int n, byte[] byArray) {
        this.zzd = zzcfw2;
        this.zza = executor;
        this.zzb = string;
        this.zzc = packageInfo;
    }

    public final zzfsm<zzesu> zza() {
        return zzfsd.zzg((zzfsm)zzfsd.zzj((zzfsm)zzfsd.zza((Object)this.zzb), (zzfln)zzesr.zza, (Executor)this.zza), Throwable.class, (zzfrk)new zzess(this), (Executor)this.zza);
    }

    final /* synthetic */ zzfsm zzb(Throwable throwable) throws Exception {
        return zzfsd.zza((Object)new zzesu(this.zzb));
    }
}
