/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzefw
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzefw;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfrz;

final class zzefv
implements zzfrz<zzcvh> {
    final zzefw zza;

    zzefv(zzefw zzefw2) {
        this.zza = zzefw2;
    }

    public final void zza(Throwable throwable) {
        zzbcz zzbcz2 = zzefw.zzc((zzefw)this.zza).zzY().zzh(throwable);
        zzefw.zzd((zzefw)this.zza).zzbD(zzbcz2);
        zzfbh.zza((int)zzbcz2.zza, (Throwable)throwable, (String)"DelayedBannerAd.onFailure");
    }
}
