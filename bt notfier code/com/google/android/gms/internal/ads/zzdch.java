/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzdbc
 *  com.google.android.gms.internal.ads.zzdgl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzdbc;
import com.google.android.gms.internal.ads.zzdgl;

final class zzdch
implements zzdgl {
    private final zzcbz zza;
    private final String zzb;
    private final String zzc;

    zzdch(zzcbz zzcbz2, String string, String string2) {
        this.zza = zzcbz2;
        this.zzb = string;
        this.zzc = string2;
    }

    public final void zza(Object object) {
        zzcbz zzcbz2 = this.zza;
        String string = this.zzb;
        String string2 = this.zzc;
        ((zzdbc)object).zzk(zzcbz2, string, string2);
    }
}
