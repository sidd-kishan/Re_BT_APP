/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzdsb
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzexm
 *  com.google.android.gms.internal.ads.zzezi
 *  com.google.android.gms.internal.ads.zzezl
 *  com.google.android.gms.internal.ads.zzezm
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzexm;
import com.google.android.gms.internal.ads.zzezi;
import com.google.android.gms.internal.ads.zzezl;
import com.google.android.gms.internal.ads.zzezm;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.concurrent.Executor;

final class zzezj
implements zzfrz<zzdrw> {
    final zzelx zza;
    final zzezl zzb;
    final zzezm zzc;

    zzezj(zzezm zzezm2, zzelx zzelx2, zzezl zzezl2) {
        this.zzc = zzezm2;
        this.zza = zzelx2;
        this.zzb = zzezl2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(Throwable throwable) {
        zzdsb zzdsb2 = (zzdsb)zzezm.zze((zzezm)this.zzc).zzd();
        zzbcz zzbcz2 = zzdsb2 == null ? zzfbm.zzb((Throwable)throwable, null) : zzdsb2.zzP().zzh(throwable);
        zzezm zzezm2 = this.zzc;
        synchronized (zzezm2) {
            if (zzdsb2 != null) {
                zzdsb2.zzT().zzbD(zzbcz2);
                Executor executor = zzezm.zzc((zzezm)this.zzc);
                zzdsb2 = new zzezi(this, zzbcz2);
                executor.execute((Runnable)zzdsb2);
            } else {
                zzezm.zzd((zzezm)this.zzc).zzbD(zzbcz2);
                zzezm.zzf((zzezm)this.zzc, (zzexm)this.zzb).zza().zzP().zze().zzp();
            }
            zzfbh.zza((int)zzbcz2.zza, (Throwable)throwable, (String)"RewardedAdLoader.onFailure");
            this.zza.zza();
            return;
        }
    }
}
