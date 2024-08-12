/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdxk
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzfrz;

final class zzdxi
implements zzfrz<String> {
    final zzdxk zza;

    zzdxi(zzdxk zzdxk2) {
        this.zza = zzdxk2;
    }

    public final void zza(Throwable throwable) {
        synchronized (this) {
            zzdxk.zza((zzdxk)this.zza, (boolean)true);
            zzdxk.zzl((zzdxk)this.zza, (String)"com.google.android.gms.ads.MobileAds", (boolean)false, (String)"Internal Error.", (int)((int)(zzt.zzj().elapsedRealtime() - zzdxk.zzb((zzdxk)this.zza))));
            zzchl zzchl2 = zzdxk.zzc((zzdxk)this.zza);
            throwable = new Exception();
            zzchl2.zzd(throwable);
            return;
        }
    }
}
