/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzcda
 *  com.google.android.gms.internal.ads.zzcdj
 *  com.google.android.gms.internal.ads.zzexb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzcda;
import com.google.android.gms.internal.ads.zzcdj;
import com.google.android.gms.internal.ads.zzexb;

final class zzeyk
implements zzexb {
    private final zzcbz zza;
    private final String zzb;
    private final String zzc;

    zzeyk(zzcbz zzcbz2, String string, String string2) {
        this.zza = zzcbz2;
        this.zzb = string;
        this.zzc = string2;
    }

    public final void zza(Object object) {
        zzcbz zzcbz2 = this.zza;
        String string = this.zzb;
        String string2 = this.zzc;
        ((zzcda)object).zze((zzccp)new zzcdj(zzcbz2.zzb(), zzcbz2.zzc()), string, string2);
    }
}
