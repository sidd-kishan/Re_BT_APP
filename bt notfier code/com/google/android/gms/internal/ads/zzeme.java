/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdlb
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzemd
 *  com.google.android.gms.internal.ads.zzemf
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdlb;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzemd;
import com.google.android.gms.internal.ads.zzemf;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfrz;

final class zzeme
implements zzfrz<zzcxg> {
    final zzelx zza;
    final zzdlb zzb;
    final zzemf zzc;

    zzeme(zzemf zzemf2, zzelx zzelx2, zzdlb zzdlb2) {
        this.zzc = zzemf2;
        this.zza = zzelx2;
        this.zzb = zzdlb2;
    }

    public final void zza(Throwable throwable) {
        zzbcz zzbcz2 = this.zzb.zzR().zzh(throwable);
        this.zzb.zzS().zzbD(zzbcz2);
        zzemf.zzc((zzemf)this.zzc).zze().execute((Runnable)new zzemd(this, zzbcz2));
        zzfbh.zza((int)zzbcz2.zza, (Throwable)throwable, (String)"NativeAdLoader.onFailure");
        this.zza.zza();
    }
}
