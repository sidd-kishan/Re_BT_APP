/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbia
 *  com.google.android.gms.internal.ads.zzbib
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbhz
implements Runnable {
    final zzbia zza;

    zzbhz(zzbia zzbia2) {
        this.zza = zzbia2;
    }

    @Override
    public final void run() {
        if (zzbib.zzb((zzbib)this.zza.zza) == null) return;
        try {
            zzbib.zzb((zzbib)this.zza.zza).zzc(1);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not notify onAdFailedToLoad event.", (Throwable)remoteException);
        }
    }
}
