/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzccz
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbii
implements Runnable {
    private final zzccz zza;

    zzbii(zzccz zzccz2) {
        this.zza = zzccz2;
    }

    @Override
    public final void run() {
        zzccz zzccz2 = this.zza;
        if (zzccz2 == null) return;
        try {
            zzccz2.zzf(1);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }
}
