/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzdxk
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzdxk;

final class zzdwz
implements Runnable {
    private final zzdxk zza;
    private final zzbrs zzb;

    zzdwz(zzdxk zzdxk2, zzbrs zzbrs2) {
        this.zza = zzdxk2;
        this.zzb = zzbrs2;
    }

    @Override
    public final void run() {
        zzdxk zzdxk2 = this.zza;
        zzbrs zzbrs2 = this.zzb;
        try {
            zzbrs2.zzb(zzdxk2.zzj());
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }
}
