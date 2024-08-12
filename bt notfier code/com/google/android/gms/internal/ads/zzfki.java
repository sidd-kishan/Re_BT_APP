/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzfkj
 *  com.google.android.gms.internal.ads.zzfkk
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.ads.zzfkj;
import com.google.android.gms.internal.ads.zzfkk;

public final class zzfki {
    final zzfkk zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfki(zzfkk zzfkk2, byte[] byArray, zzfkj zzfkj2) {
        this.zza = zzfkk2;
        this.zzb = byArray;
    }

    public final void zza() {
        synchronized (this) {
            try {
                try {
                    zzfkk zzfkk2 = this.zza;
                    if (!zzfkk2.zza) return;
                    zzfkk2.zzb.zzg(this.zzb);
                    this.zza.zzb.zzh(this.zzc);
                    this.zza.zzb.zzi(this.zzd);
                    this.zza.zzb.zzf(null);
                    this.zza.zzb.zze();
                    return;
                }
                catch (RemoteException remoteException) {
                    Log.d((String)"GASS", (String)"Clearcut log failed", (Throwable)remoteException);
                    return;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final zzfki zzb(int n) {
        this.zzc = n;
        return this;
    }

    public final zzfki zzc(int n) {
        this.zzd = n;
        return this;
    }
}
