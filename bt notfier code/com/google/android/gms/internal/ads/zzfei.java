/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfdy
 *  com.google.android.gms.internal.ads.zzfej
 *  com.google.android.gms.internal.ads.zzfek
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfdy;
import com.google.android.gms.internal.ads.zzfej;
import com.google.android.gms.internal.ads.zzfek;
import com.google.android.gms.internal.ads.zzfrz;

final class zzfei
implements zzfrz {
    final zzfdy zza;
    final zzfej zzb;

    zzfei(zzfej zzfej2, zzfdy zzfdy2) {
        this.zzb = zzfej2;
        this.zza = zzfdy2;
    }

    public final void zza(Throwable throwable) {
        zzfek.zzd((zzfek)this.zzb.zza).zzc(this.zza, throwable);
    }

    public final void zzb(Object object) {
        zzfek.zzd((zzfek)this.zzb.zza).zzd(this.zza);
    }
}
