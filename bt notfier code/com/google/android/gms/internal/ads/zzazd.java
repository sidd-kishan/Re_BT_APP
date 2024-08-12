/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzaze
 *  com.google.android.gms.internal.ads.zzazf
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzazf;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzazd {
    final zzazf zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzazd(zzazf zzazf2, byte[] byArray, zzaze zzaze2) {
        this.zza = zzazf2;
        this.zzb = byArray;
    }

    public final void zza() {
        synchronized (this) {
            try {
                try {
                    zzazf zzazf2 = this.zza;
                    if (!zzazf2.zzb) return;
                    zzazf2.zza.zzh(this.zzb);
                    this.zza.zza.zzi(0);
                    this.zza.zza.zzj(this.zzc);
                    this.zza.zza.zzg(null);
                    this.zza.zza.zzf();
                    return;
                }
                catch (RemoteException remoteException) {
                    zzcgt.zze((String)"Clearcut log failed", (Throwable)remoteException);
                    return;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final zzazd zzb(int n) {
        this.zzc = n;
        return this;
    }
}
