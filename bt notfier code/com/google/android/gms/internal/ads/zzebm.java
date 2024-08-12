/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zzbc
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcbf
 *  com.google.android.gms.internal.ads.zzebq
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzebq;
import com.google.android.gms.internal.ads.zzfrz;

final class zzebm
implements zzfrz<ParcelFileDescriptor> {
    final zzcbf zza;

    zzebm(zzebq zzebq2, zzcbf zzcbf2) {
        this.zza = zzcbf2;
    }

    public final void zza(Throwable throwable) {
        try {
            this.zza.zzf(zzbc.zza((Throwable)throwable));
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzb((String)"Service can't call client", (Throwable)remoteException);
            return;
        }
    }
}
