/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbid
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbic
implements Runnable {
    final zzbid zza;

    zzbic(zzbid zzbid2) {
        this.zza = zzbid2;
    }

    @Override
    public final void run() {
        if (zzbid.zzb((zzbid)this.zza) == null) return;
        try {
            zzbid.zzb((zzbid)this.zza).zzc(1);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not notify onAdFailedToLoad event.", (Throwable)remoteException);
        }
    }
}
