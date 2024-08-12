/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzdqi
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzdqi;

final class zzdqg
implements Runnable {
    private final zzdqi zza;

    zzdqg(zzdqi zzdqi2) {
        this.zza = zzdqi2;
    }

    @Override
    public final void run() {
        zzdqi zzdqi2 = this.zza;
        try {
            zzdqi2.zzc();
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}
