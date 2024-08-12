/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdym
 *  com.google.android.gms.internal.ads.zzeeg
 *  com.google.android.gms.internal.ads.zzehe
 *  com.google.android.gms.internal.ads.zzehp
 *  com.google.android.gms.internal.ads.zzehq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdym;
import com.google.android.gms.internal.ads.zzeeg;
import com.google.android.gms.internal.ads.zzehe;
import com.google.android.gms.internal.ads.zzehp;
import com.google.android.gms.internal.ads.zzehq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfrz;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzeho
implements zzfrz {
    final long zza;
    final String zzb;
    final zzezz zzc;
    final zzfac zzd;
    final zzehp zze;

    zzeho(zzehp zzehp2, long l, String string, zzezz zzezz2, zzfac zzfac2) {
        this.zze = zzehp2;
        this.zza = l;
        this.zzb = string;
        this.zzc = zzezz2;
        this.zzd = zzfac2;
    }

    public final void zza(Throwable throwable) {
        long l;
        block7: {
            Object object;
            zzezz zzezz2;
            block6: {
                l = zzehp.zza((zzehp)this.zze).elapsedRealtime() - this.zza;
                int n = throwable instanceof TimeoutException ? 2 : (throwable instanceof zzehe ? 3 : (throwable instanceof CancellationException ? 4 : (throwable instanceof zzfaw ? 5 : (throwable instanceof zzdym && zzfbm.zza((Throwable)throwable).zza == 3 ? 1 : 6))));
                zzehp.zzf((zzehp)this.zze, (String)this.zzb, (int)n, (long)l, (String)this.zzc.zzac);
                if (zzehp.zzc((zzehp)this.zze)) {
                    zzehq zzehq2 = zzehp.zzb((zzehp)this.zze);
                    zzfac zzfac2 = this.zzd;
                    zzezz2 = this.zzc;
                    object = throwable instanceof zzeeg ? (zzeeg)throwable : null;
                    zzehq2.zza(zzfac2, zzezz2, n, (zzeeg)object, l);
                }
                object = zzbjl.zzfX;
                if ((Boolean)zzbet.zzc().zzc(object) == false) return;
                object = zzfbm.zza((Throwable)throwable);
                n = object.zza;
                if (n == 3) break block6;
                throwable = object;
                if (n != 0) break block7;
            }
            zzezz2 = object.zzd;
            throwable = object;
            if (zzezz2 != null) {
                throwable = object;
                if (!zzezz2.zzc.equals("com.google.android.gms.ads")) {
                    throwable = zzfbm.zza((Throwable)new zzeeg(13, object.zzd));
                }
            }
        }
        zzehp.zzd((zzehp)this.zze).zzc(this.zzc, l, (zzbcz)throwable);
    }

    public final void zzb(Object object) {
        long l = zzehp.zza((zzehp)this.zze).elapsedRealtime() - this.zza;
        zzehp.zzf((zzehp)this.zze, (String)this.zzb, (int)0, (long)l, (String)this.zzc.zzac);
        if (zzehp.zzc((zzehp)this.zze)) {
            zzehp.zzb((zzehp)this.zze).zza(this.zzd, this.zzc, 0, null, l);
        }
        object = zzbjl.zzfX;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        zzehp.zzd((zzehp)this.zze).zzc(this.zzc, l, null);
    }
}
