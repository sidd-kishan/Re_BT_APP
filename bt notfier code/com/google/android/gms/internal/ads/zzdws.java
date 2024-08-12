/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbez
 *  com.google.android.gms.internal.ads.zzdwm
 *  com.google.android.gms.internal.ads.zzdwt
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbez;
import com.google.android.gms.internal.ads.zzdwm;
import com.google.android.gms.internal.ads.zzdwt;

final class zzdws
extends zzbez {
    final zzdwm zza;
    final zzdwt zzb;

    zzdws(zzdwt zzdwt2, zzdwm zzdwm2) {
        this.zzb = zzdwt2;
        this.zza = zzdwm2;
    }

    public final void zzb() throws RemoteException {
        this.zza.zzi(zzdwt.zzd((zzdwt)this.zzb));
    }

    public final void zzc(int n) throws RemoteException {
        this.zza.zzf(zzdwt.zzd((zzdwt)this.zzb), n);
    }

    public final void zzd(zzbcz zzbcz2) throws RemoteException {
        this.zza.zzf(zzdwt.zzd((zzdwt)this.zzb), zzbcz2.zza);
    }

    public final void zze() {
    }

    public final void zzf() throws RemoteException {
        this.zza.zze(zzdwt.zzd((zzdwt)this.zzb));
    }

    public final void zzg() throws RemoteException {
        this.zza.zzg(zzdwt.zzd((zzdwt)this.zzb));
    }

    public final void zzh() throws RemoteException {
        this.zza.zzh(zzdwt.zzd((zzdwt)this.zzb));
    }

    public final void zzi() {
    }
}
