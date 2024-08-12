/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccy
 *  com.google.android.gms.internal.ads.zzdwx
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccy;
import com.google.android.gms.internal.ads.zzdwx;

final class zzdwv
extends zzccy {
    final zzdwx zza;

    zzdwv(zzdwx zzdwx2) {
        this.zza = zzdwx2;
    }

    public final void zze() throws RemoteException {
        zzdwx.zze((zzdwx)this.zza).zzk(zzdwx.zzd((zzdwx)this.zza));
    }

    public final void zzf(int n) throws RemoteException {
        zzdwx.zze((zzdwx)this.zza).zzl(zzdwx.zzd((zzdwx)this.zza), n);
    }

    public final void zzg(zzbcz zzbcz2) throws RemoteException {
        zzdwx.zze((zzdwx)this.zza).zzl(zzdwx.zzd((zzdwx)this.zza), zzbcz2.zza);
    }
}
