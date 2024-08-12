/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.measurement.zzbs
 */
package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbs;

abstract class zzbh
implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final zzbs zzk;

    zzbh(zzbs zzbs2, boolean bl) {
        this.zzk = zzbs2;
        this.zzh = zzbs2.zza.currentTimeMillis();
        this.zzi = zzbs2.zza.elapsedRealtime();
        this.zzj = bl;
    }

    @Override
    public final void run() {
        if (zzbs.zzK((zzbs)this.zzk)) {
            this.zzb();
            return;
        }
        try {
            this.zza();
            return;
        }
        catch (Exception exception) {
            zzbs.zzL((zzbs)this.zzk, (Exception)exception, (boolean)false, (boolean)this.zzj);
            this.zzb();
            return;
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
