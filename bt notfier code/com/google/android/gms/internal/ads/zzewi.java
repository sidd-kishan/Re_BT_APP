/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcvh
 *  com.google.android.gms.internal.ads.zzcwe
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzewh
 *  com.google.android.gms.internal.ads.zzewj
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcvh;
import com.google.android.gms.internal.ads.zzcwe;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzewh;
import com.google.android.gms.internal.ads.zzewj;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.concurrent.Executor;

final class zzewi
implements zzfrz<zzcvh> {
    final zzelx zza;
    final zzcwe zzb;
    final zzewj zzc;

    zzewi(zzewj zzewj2, zzelx zzelx2, zzcwe zzcwe2) {
        this.zzc = zzewj2;
        this.zza = zzelx2;
        this.zzb = zzcwe2;
    }

    public final void zza(Throwable throwable) {
        zzbcz zzbcz2 = this.zzb.zzY().zzh(throwable);
        zzewj zzewj2 = this.zzc;
        synchronized (zzewj2) {
            zzewj.zzh((zzewj)this.zzc, null);
            this.zzb.zzX().zzbD(zzbcz2);
            zzbjd zzbjd2 = zzbjl.zzfO;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
                Executor executor = zzewj.zzc((zzewj)this.zzc);
                zzbjd2 = new zzewh(this, zzbcz2);
                executor.execute((Runnable)zzbjd2);
            }
            zzewj.zzg((zzewj)this.zzc).zzd(60);
            zzfbh.zza((int)zzbcz2.zza, (Throwable)throwable, (String)"BannerAdLoader.onFailure");
            this.zza.zza();
            return;
        }
    }
}
