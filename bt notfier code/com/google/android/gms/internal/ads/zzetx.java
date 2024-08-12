/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  com.google.android.gms.internal.ads.zzcbj
 */
package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzcbj;
import java.util.List;

public final class zzetx {
    private final zzcbj zza;
    private final int zzb;

    public zzetx(zzcbj zzcbj2, int n) {
        this.zza = zzcbj2;
        this.zzb = n;
    }

    public final String zza() {
        return this.zza.zzd;
    }

    public final String zzb() {
        return this.zza.zza.getString("ms");
    }

    public final PackageInfo zzc() {
        return this.zza.zzf;
    }

    public final List<String> zzd() {
        return this.zza.zze;
    }

    public final String zze() {
        return this.zza.zzh;
    }

    public final int zzf() {
        return this.zzb;
    }

    final boolean zzg() {
        return this.zza.zza.getBoolean("is_gbid");
    }
}
