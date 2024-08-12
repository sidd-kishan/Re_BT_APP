/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcup
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzevb
 *  com.google.android.gms.internal.ads.zzevd
 *  com.google.android.gms.internal.ads.zzevf
 *  com.google.android.gms.internal.ads.zzexm
 *  com.google.android.gms.internal.ads.zzfbh
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcup;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzevb;
import com.google.android.gms.internal.ads.zzevd;
import com.google.android.gms.internal.ads.zzevf;
import com.google.android.gms.internal.ads.zzexm;
import com.google.android.gms.internal.ads.zzfbh;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;

final class zzevc
implements zzfrz {
    final zzelx zza;
    final zzevd zzb;
    final zzevf zzc;

    zzevc(zzevf zzevf2, zzelx zzelx2, zzevd zzevd2) {
        this.zzc = zzevf2;
        this.zza = zzelx2;
        this.zzb = zzevd2;
    }

    public final void zza(Throwable throwable) {
        Object object = (zzcup)zzevf.zzf((zzevf)this.zzc).zzd();
        zzbcz zzbcz2 = object == null ? zzfbm.zzb((Throwable)throwable, null) : object.zzP().zzh(throwable);
        zzevf zzevf2 = this.zzc;
        synchronized (zzevf2) {
            zzevf.zzg((zzevf)this.zzc, null);
            if (object != null) {
                object.zzO().zzbD(zzbcz2);
                object = zzbjl.zzfP;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                    object = zzevf.zzd((zzevf)this.zzc);
                    zzevb zzevb2 = new zzevb(this, zzbcz2);
                    object.execute((Runnable)zzevb2);
                }
            } else {
                zzevf.zze((zzevf)this.zzc).zzbD(zzbcz2);
                ((zzcup)zzevf.zzh((zzevf)this.zzc, (zzexm)this.zzb).zzf()).zzP().zze().zzp();
            }
            zzfbh.zza((int)zzbcz2.zza, (Throwable)throwable, (String)"AppOpenAdLoader.onFailure");
            this.zza.zza();
            return;
        }
    }
}
