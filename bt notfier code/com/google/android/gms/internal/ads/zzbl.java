/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzcz
 *  com.google.android.gms.internal.ads.zzda
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzcz;
import com.google.android.gms.internal.ads.zzda;

final class zzbl
implements zzalj {
    private final zzcz zza;
    private final zzafv zzb;
    private final zzba zzc;

    zzbl(zzcz zzcz2, zzafv zzafv2, zzba zzba2) {
        this.zza = zzcz2;
        this.zzb = zzafv2;
        this.zzc = zzba2;
    }

    public final void zza(Object object) {
        zzcz zzcz2 = this.zza;
        zzafv zzafv2 = this.zzb;
        zzba zzba2 = this.zzc;
        ((zzda)object).zzi(zzcz2, zzafv2, zzba2);
    }
}
