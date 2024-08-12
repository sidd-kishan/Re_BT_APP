/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzkb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzkb;

final class zzim {
    public final long zza;
    public final long zzb;
    public boolean zzc;
    public zzkb zzd;
    public zzim zze;

    public zzim(long l, int n) {
        this.zza = l;
        this.zzb = l + 65536L;
    }

    public final int zza(long l) {
        long l2 = this.zza;
        int n = this.zzd.zzb;
        return (int)(l - l2);
    }

    public final zzim zzb() {
        this.zzd = null;
        zzim zzim2 = this.zze;
        this.zze = null;
        return zzim2;
    }
}
