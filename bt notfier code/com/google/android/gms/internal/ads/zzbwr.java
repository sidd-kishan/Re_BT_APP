/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbww
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzcgt;

final class zzbwr
implements Runnable {
    final zzbww zza;

    zzbwr(zzbww zzbww2) {
        this.zza = zzbww2;
    }

    @Override
    public final void run() {
        try {
            zzbww.zza((zzbww)this.zza).zzi();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
