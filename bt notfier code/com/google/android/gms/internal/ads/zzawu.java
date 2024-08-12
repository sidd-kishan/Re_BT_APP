/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzawv
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.Iterator;

final class zzawu
implements Runnable {
    final zzawv zza;

    zzawu(zzawv zzawv2) {
        this.zza = zzawv2;
    }

    @Override
    public final void run() {
        Object object = zzawv.zza((zzawv)this.zza);
        synchronized (object) {
            try {
                if (zzawv.zzb((zzawv)this.zza) && zzawv.zzd((zzawv)this.zza)) {
                    zzawv.zzc((zzawv)this.zza, (boolean)false);
                    zze.zzd((String)"App went background");
                    Iterator iterator = zzawv.zze((zzawv)this.zza).iterator();
                    while (iterator.hasNext()) {
                        zzaww zzaww2 = (zzaww)iterator.next();
                        try {
                            zzaww2.zza(false);
                        }
                        catch (Exception exception) {
                            zzcgt.zzg((String)"", (Throwable)exception);
                        }
                    }
                    return;
                }
                zze.zzd((String)"App is still foreground");
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
