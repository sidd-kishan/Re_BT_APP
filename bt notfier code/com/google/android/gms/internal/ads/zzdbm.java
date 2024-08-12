/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdbs
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdbs;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzfbm;

final class zzdbm
implements zzdgl {
    private final zzdkm zza;

    zzdbm(zzdkm zzdkm2) {
        this.zza = zzdkm2;
    }

    public final void zza(Object object) {
        zzdkm zzdkm2 = this.zza;
        ((zzdbs)object).zzn(zzfbm.zzd((int)12, (String)zzdkm2.getMessage(), null));
    }
}
