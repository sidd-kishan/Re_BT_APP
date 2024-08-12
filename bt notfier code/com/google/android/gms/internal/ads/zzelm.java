/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzdio
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzdio;

public final class zzelm
implements zzbcv,
zzdio {
    private zzbex zza;

    public final void onAdClicked() {
        synchronized (this) {
            zzbex zzbex2 = this.zza;
            if (zzbex2 == null) return;
            try {
                zzbex2.zzb();
                return;
            }
            catch (RemoteException remoteException) {
                zze.zzj((String)"Remote Exception at onAdClicked.", (Throwable)remoteException);
                return;
            }
        }
    }

    public final void zza(zzbex zzbex2) {
        synchronized (this) {
            this.zza = zzbex2;
            return;
        }
    }

    public final void zzb() {
        synchronized (this) {
            zzbex zzbex2 = this.zza;
            if (zzbex2 == null) return;
            try {
                zzbex2.zzb();
                return;
            }
            catch (RemoteException remoteException) {
                zze.zzj((String)"Remote Exception at onPhysicalClick.", (Throwable)remoteException);
                return;
            }
        }
    }
}
